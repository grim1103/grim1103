package net.Order.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.action.Action;
import net.action.ActionForward;
import net.Order.db.*;

public class OrderDeleteAction implements Action{
	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{
		HttpSession session = request.getSession();
		OrderDAO orderdao = new OrderDAO();
		OrderBean orderbean = new OrderBean();
		
		orderbean.setOrder_num(Integer.parseInt(request.getParameter("num")));
		
		
		if(!orderdao.deleteOrder(orderbean.getOrder_num())) {
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('Deletion is failed try again')");
				out.print("</script>");
				out.close();
				return null;
		}

		ActionForward forward = new ActionForward();
		forward.setRedirect(true);

		forward.setPath("OrderListAction.oo");
		orderdao.conClose();
		return forward;
		
	}
}
