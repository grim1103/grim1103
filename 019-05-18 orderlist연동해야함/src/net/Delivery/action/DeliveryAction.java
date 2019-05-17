package net.Delivery.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.javafx.collections.SetAdapterChange;

import net.action.Action;
import net.action.ActionForward;
import net.Order.db.*;


public class DeliveryAction implements Action{
	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{
		HttpSession session = request.getSession();
		OrderBean orderbean = new OrderBean();

		
		orderbean.setOrder_id(request.getParameter("id"));
		orderbean.setOrder_code(Integer.parseInt(request.getParameter("code")));
		orderbean.setOrder_address(request.getParameter("address"));
		orderbean.setOrder_name(request.getParameter("name"));
		orderbean.setOrder_image(request.getParameter("image"));
		orderbean.setOrder_price(Integer.parseInt(request.getParameter("price")));
		orderbean.setOrder_count(Integer.parseInt(request.getParameter("count")));
		orderbean.setOrder_hap(Integer.parseInt(request.getParameter("hap")));
		orderbean.setOrder_result(request.getParameter("result"));
		orderbean.setOrder_date(request.getParameter("date"));
		orderbean.setOrder_point(Double.parseDouble(request.getParameter("point")));
		
		session.setAttribute("orderbean", orderbean);	
		ActionForward forward = new ActionForward();
		forward.setRedirect(true);
		forward.setPath("delivery/Delivery_Add.jsp");
		return forward;
		
	}
}
