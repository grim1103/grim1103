package net.Delivery.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.javafx.collections.SetAdapterChange;

import net.action.Action;
import net.action.ActionForward;
import net.Delivery.db.DeliveryBean;
import net.Delivery.db.DeliveryDAO;
import net.Order.db.*;


public class DeliveryAddAction implements Action{
	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{
		HttpSession session = request.getSession();
		OrderBean orderbean = new OrderBean();
		System.out.println("3");

		DeliveryBean deliverybean=new DeliveryBean();
		DeliveryDAO deliverydao=new DeliveryDAO();
		
		deliverybean.setDelivery_product(request.getParameter("delivery_name"));;
		deliverybean.setDelivery_address(request.getParameter("delivery_address"));
		deliverybean.setDelivery_name(request.getParameter("delivery_name"));
		deliverybean.setDelivery_phone(request.getParameter("delivery_phone"));
		deliverybean.setDelivery_memo(request.getParameter("delivery_memo"));
		
		if(!deliverydao.insertDelivery(deliverybean)) {
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('Register is failed try again')");
			out.print("</script>");
			out.close();
			return null;
		}
		System.out.println("4");

		session.setAttribute("deliverybean", deliverybean);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/OrderListAction.oo");
		return forward;
		
	}
}
