package net.product.action;

import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.action.Action;
import net.action.ActionForward;
import net.product.db.ProductDAO;

/**
 * Servlet implementation class ProductDeleteAction
 */
@WebServlet("/ProductDeleteAction")
public class ProductDeleteAction extends HttpServlet implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("hi");
		ProductDAO productdao = new ProductDAO();
		ActionForward forward = new ActionForward();
		
		int code = Integer.parseInt(request.getParameter("code"));
		System.out.println(request.getParameter("code"));
		if(!productdao.deleteProduct(code)) {
			PrintWriter out = response.getWriter();
			out.print("<script>");
			out.print("alert('Deletion is not work Please try again')");
			out.print("<script>");
			out.close();
			forward.setResult(false);
			
		}
		forward.setResult(true);
		
		return forward; 
		
	}
}
