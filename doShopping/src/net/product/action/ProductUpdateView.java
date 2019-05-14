package net.product.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.action.Action;
import net.action.ActionForward;
import net.product.db.ProductBean;
import net.product.db.ProductDAO;

public class ProductUpdateView implements Action{
	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{
		ProductDAO productdao = new ProductDAO();
		ProductBean productbean = new ProductBean();
		
		productbean.setProduct_code(Integer.parseInt(request.getParameter("code")));
		
		if(productdao.detailProduct(productbean.getProduct_code()) ==null) {
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('View is failed try again')");
			out.print("</script>");
			out.close();
			return null;
		}
//		PrintWriter out = response.getWriter();
//		out.println("<script>");
//		out.println("alert('Go to the Modifypage')");
//		out.println("location.href ='./product/Product_modify.jsp'");
//		out.print("</script>");
//		out.close();
		ActionForward forward = new ActionForward();
		forward.setRedirect(true);
		forward.setPath("ProductModify.po");		
		productdao.conClose();
		return forward;
		
	}
}
