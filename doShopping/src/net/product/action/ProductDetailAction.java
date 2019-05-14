package net.product.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.action.Action;
import net.action.ActionForward;
import net.product.db.ProductBean;
import net.product.db.ProductDAO;

public class ProductDetailAction implements Action{
	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{
		HttpSession session = request.getSession();
		ProductDAO productdao = new ProductDAO();	
		
		int code = Integer.parseInt(request.getParameter("code"));
		
		if(productdao.detailProduct(code) == null) {
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('Register is failed try again')");
			out.print("</script>");
			out.close();
			return null;
		}

		session.setAttribute("detailProduct", productdao.detailProduct(code));
		ActionForward forward = new ActionForward();
		forward.setRedirect(true);
		forward.setPath("ProductDetail.po");

		productdao.conClose();
		return forward;
		
	}
}
