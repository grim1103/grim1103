package net.Order.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.Order.db.OrderDAO;
import net.action.Action;
import net.action.ActionForward;

public class OrderDetailView implements Action{
	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{
		HttpSession session = request.getSession();
		OrderDAO orderdao = new OrderDAO();	
		
		int code = Integer.parseInt(request.getParameter("code"));
		
		if(orderdao.detailOrder(code) == null) {
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('Register is failed try again')");
			out.print("</script>");
			out.close();
			return null;
		}

		session.setAttribute("detailOrder", orderdao.detailOrder(code));
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(true);
		forward.setPath("ProductSaleView.po");
		return forward;
		
	}
}