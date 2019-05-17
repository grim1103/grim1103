package net.product.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.action.Action;
import net.action.ActionForward;
import net.product.db.ProductBean;
import net.product.db.ProductDAO;

public class ProductAddAction implements Action{
	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{
		ProductDAO productdao = new ProductDAO();
		ProductBean productbean = new ProductBean();
		
		productbean.setProduct_category(request.getParameter("category"));
		productbean.setProduct_name(request.getParameter("name"));
		productbean.setProduct_count(Integer.parseInt(request.getParameter("count")));
		productbean.setProduct_image(request.getParameter("image"));
		productbean.setProduct_cost(Integer.parseInt(request.getParameter("cost")));
		productbean.setProduct_price(Integer.parseInt(request.getParameter("price")));
		productbean.setProduct_detail(request.getParameter("detail"));
		productbean.setProduct_date(request.getParameter("date"));
		
		if(!productdao.insertProduct(productbean)) {
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('Register is failed try again')");
			out.print("</script>");
			out.close();
			return null;
		}

		ActionForward forward = new ActionForward();
		forward.setRedirect(true);
		forward.setPath("ProductListAction.po");
		productdao.conClose();
		return forward;
		
	}
}
