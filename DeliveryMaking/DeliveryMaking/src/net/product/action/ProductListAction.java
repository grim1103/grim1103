package net.product.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.action.Action;
import net.action.ActionForward;
import net.product.db.ProductBean;
import net.product.db.ProductDAO;

public class ProductListAction implements Action{
	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{
		HttpSession session = request.getSession();
		ProductDAO productdao = new ProductDAO();
		
		if(productdao.getListProduct() == null) {
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('There is no data please try again')");
			out.print("</script>");
			out.close();
			return null;
		}
		session.setAttribute("productcate", productdao.getCategory());
		session.setAttribute("productbean", productdao.getListProduct());
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./product/Product_list.jsp");
		productdao.conClose();
		return forward;
		
	}
}
