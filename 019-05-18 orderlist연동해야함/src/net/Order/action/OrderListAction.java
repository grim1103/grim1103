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
		System.out.println("6");
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
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(true);
		forward.setPath("./order/Order_List.jsp");
		orderdao.conClose();
		return forward;
		
	}
}
