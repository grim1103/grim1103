package net.Order.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.action.Action;
import net.action.ActionForward;
import net.member.db.MemberDAO;
import net.Order.db.*;
import net.Delivery.db.*;



public class OrderAddAction implements Action{
	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{
		HttpSession session = request.getSession();
		OrderDAO orderdao = new OrderDAO();
		OrderBean orderbean = new OrderBean();
	
		
		orderbean.setOrder_id(request.getParameter("delivery_id"));
		orderbean.setOrder_code(Integer.parseInt(request.getParameter("delivery_code")));
		orderbean.setOrder_address(request.getParameter("delivery_address"));
		orderbean.setOrder_name(request.getParameter("delivery_name"));
		orderbean.setOrder_image(request.getParameter("delivery_image"));
		orderbean.setOrder_count(Integer.parseInt(request.getParameter("delivery_count")));
		orderbean.setOrder_hap(Integer.parseInt(request.getParameter("delivery_hap")));
		orderbean.setOrder_result(request.getParameter("delivery_result"));
		orderbean.setOrder_date(request.getParameter("delivery_date"));
		orderbean.setOrder_point(Double.parseDouble(request.getParameter("delivery_point")));
		
		
		if(!orderdao.insertOrder(orderbean)) {
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('Register is failed try again')");
			out.print("</script>");
			out.close();
			return null;
		}

		System.out.println("1");
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("DeliveryAddAction.do");
		orderdao.conClose();
		return forward;
		
	}
}
