package net.Order.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.action.Action;
import net.action.ActionForward;
import net.member.db.MemberDAO;
import net.Delivery.db.DeliveryBean;
import net.Delivery.db.DeliveryDAO;
import net.Order.db.*;

public class OrderListAction implements Action{
	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{
		HttpSession session = request.getSession();
		OrderDAO orderdao = new OrderDAO();
		DeliveryDAO dd=new DeliveryDAO();

		String id=(String) session.getAttribute("id");
		System.out.println(id);
		
		if(orderdao.getListOrder(id) == null) {
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('There is no data please try again')");
			out.print("</script>");
			out.close();
			return null;
		}
		session.setAttribute("orderbean", orderdao.getListOrder(id));
		
		//주문하면 배달원이 정해짐
		
				DeliveryBean deliveryBean=new DeliveryBean();
				MemberDAO md=new MemberDAO();
				String member_adderss=md.getMemDetail(id).getMember_address();
				
				int delivery_num=orderdao.getOrder(id).getOrder_num();
				
				
				deliveryBean.setDelivery_num(delivery_num);
				deliveryBean.setDelivery_address(member_adderss);
				deliveryBean.setDelivery_name("김상훈");
				deliveryBean.setDelivery_phone("010-5093-4313");
				
				if(!dd.insertDelivery(deliveryBean)) {
					PrintWriter out = response.getWriter();
					out.println("<script>");
					out.println("alert('Register is failed try again')");
					out.print("</script>");
					out.close();
					return null;
				}
			
				session.setAttribute("deliveryList", orderdao.getListOrder(id));
		
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./order/Order_List.jsp");
		orderdao.conClose();
		return forward;
		
	}
}
