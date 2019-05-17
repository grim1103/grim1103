package net.product.action;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.action.Action;
import net.action.ActionForward;

public class ProductFrontController extends HttpServlet implements javax.servlet.Servlet{
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) 
			 	throws ServletException, IOException {
		String RequestURI=request.getRequestURI();
		String contextPath=request.getContextPath();
		String command=RequestURI.substring(contextPath.length());
		ActionForward forward=null;
		Action action=null;
		
		System.out.println(RequestURI);
		System.out.println(contextPath);
		System.out.println(command);
		
		if(command.equals("/ProductAddAction.po")) {
			action = new ProductAddAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/ProductAddForm.po")) {
			forward=new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./product/Product_add.jsp");
		}else if(command.equals("/product/ProductAddForm.po")) {
			forward=new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./Product_add.jsp");
		}else if(command.equals("/main.po")) {
			forward=new ActionForward();
			forward.setRedirect(false);
			forward.setPath("main.jsp");
		}else if(command.equals("/ProductOrder.po")) {
			forward=new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./product/Product_order.jsp");
		}else if(command.equals("/ProductListAction.po")) {
			action = new ProductListAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/product/ProductListAction.po")) {
			action = new ProductListAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/ProductList.po")) {
			forward=new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./product/Product_list.jsp");
		}else if(command.equals("/product/ProductList.po")) {
			forward=new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./Product_list.jsp");
		}else if(command.equals("/ProductInfoAction.po")) {
	         action = new ProductInfoAction();
	         try {
	            forward = action.execute(request, response);
	         }catch(Exception e) {
	            e.printStackTrace();
	         }
	    }else if(command.equals("/ProductDetailAction.po")) {
		     action = new ProductDetailAction();
		     try {
		        forward = action.execute(request, response);
		     }catch(Exception e) {
		        e.printStackTrace();
		     }
	    }else if(command.equals("/ProductDetail.po")) {
			forward=new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./product/Product_detail.jsp");
		}else if(command.equals("/ProductUpdateView.po")) {
			 action = new ProductUpdateView();
			 try {
			    forward = action.execute(request, response);
			  }catch(Exception e) {
			      e.printStackTrace();
			  }
		}else if(command.equals("/ProductUpdateAction.po")) {
			 action = new ProductUpdateAction();
			 try {
			    forward = action.execute(request, response);
			  }catch(Exception e) {
			      e.printStackTrace();
			  }
		}else if(command.equals("/ProductDeleteAction.po")) {
			action = new ProductDeleteAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/product/ProductDetailAction.po")) {
			action = new ProductDetailAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/ProductSaleView.po")) {
			forward=new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./product/Product_sale.jsp");
		}else if(command.equals("/image.po")) {
			forward=new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./product/image.jsp");
		}else if(command.equals("/imageAdd.po")) {
			forward=new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./product/imageAdd.jsp");
		}else if(command.equals("/imageDetail.po")) {
			forward=new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./product/imageDetail.jsp");
		}else if(command.equals("/ProductModify.po")) {
			forward=new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./product/Product_modify.jsp");
		}else if(command.equals("/ProductModifyView.po")) {
			action = new ProductModifyView();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}

		
		
		if(forward.isRedirect()){
			System.out.println("for " + forward.getPath());
			response.sendRedirect(forward.getPath());
			return;
		}else{
			RequestDispatcher dispatcher=
					request.getRequestDispatcher(forward.getPath());
			dispatcher.forward(request, response);
			return;
		}

	}
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
}