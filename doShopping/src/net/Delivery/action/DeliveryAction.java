package net.Delivery.action;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.action.Action;
import net.action.ActionForward;
import net.Order.db.*;


public class DeliveryAction implements Action{
	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{
		OrderDAO orderdao = new OrderDAO();
		OrderBean orderbean = new OrderBean();
		System.out.println(request.getParameter("point"));
		
		orderbean.setOrder_id(request.getParameter("id"));
		orderbean.setOrder_code(Integer.parseInt(request.getParameter("code")));
		orderbean.setOrder_image(request.getParameter("image"));
		orderbean.setOrder_date(request.getParameter("date"));
		orderbean.setOrder_count(Integer.parseInt(request.getParameter("count")));
		orderbean.setOrder_price(Integer.parseInt(request.getParameter("price")));
		orderbean.setOrder_result(request.getParameter("result"));
		orderbean.setOrder_point(Double.parseDouble(request.getParameter("point")));
		orderbean.setOrder_name(request.getParameter("name"));
	
		System.out.println(request.getParameter("name"));
		System.out.println(request.getParameter("id"));
		
		if(!orderdao.insertOrder(orderbean)) {
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('Register is failed try again')");
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
