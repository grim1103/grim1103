package net.Delivery.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.action.Action;
import net.action.ActionForward;
import net.Delivery.db.*;
import net.Order.db.OrderBean;
import net.Order.db.OrderDAO;


public class DeliveryListAction implements Action{
	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{
		HttpSession session = request.getSession();
		DeliveryDAO deliverydao = new DeliveryDAO();
		OrderDAO od=new OrderDAO();
		String a=(String)session.getAttribute("delivery_num");
		int num=Integer.parseInt(a);
		
		System.out.println(a);
				System.out.println(num);
	
	
		System.out.println(num);
		if(deliverydao.getListDelivery(num) == null) {
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('There is no data please try again')");
			out.print("</script>");
			out.close();
			return null;
		}
		
		session.setAttribute("deliverybean", deliverydao.getListDelivery(num));
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./delivery/delivery_List.jsp");
		deliverydao.conClose();
		return forward;
		
	}
}
