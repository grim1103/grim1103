package net.product.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.action.Action;
import net.action.ActionForward;
import net.product.db.ProductBean;
import net.product.db.ProductDAO;

public class ProductInfoAction implements Action{
   public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{
      HttpSession session = request.getSession();
      ProductDAO productdao = new ProductDAO();
      String category=request.getParameter("category");
      
      if(session.getAttribute("id") == null) {
    	  PrintWriter out = response.getWriter();
          out.println("<script>");
          out.println("alert('You have to login then you can')");
          out.println("location.href = 'MemberLoginForm.mo'");
          out.print("</script>");
          out.close();
          return null;
      }else {
    	  if(productdao.researchProduct(category) == null) {
    		  PrintWriter out = response.getWriter();
    	      out.println("<script>");
    	      out.println("alert('Somethig is wrong')");
    	      out.print("</script>");
    	      out.close();
    	      return null;
    	  }
    	  session.setAttribute("infoproduct", productdao.researchProduct(category));
    	  List<ProductBean> beans = (List<ProductBean>)session.getAttribute("infoproduct"); 
    	   
    	  ActionForward forward = new ActionForward();
    	  forward.setRedirect(false);
    	  forward.setPath("product/Product_ORIGINAL.jsp");
    	  productdao.conClose();
    	  return forward;
      } 
   }
}