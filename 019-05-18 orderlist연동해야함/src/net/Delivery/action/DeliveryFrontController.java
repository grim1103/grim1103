package net.Delivery.action;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.action.Action;
import net.action.ActionForward;

public class DeliveryFrontController extends HttpServlet implements javax.servlet.Servlet{
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
		
		if(command.equals("/DeliveryListAction.do")) {
			action = new DeliveryListAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/DeliveryAction.do")) {
			action = new DeliveryAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/delivery/DeliveryAddAction.do")) {
			
			action = new DeliveryAddAction();
			System.out.println("2");
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		
//		else if(command.equals("OrderListAction.oo")) {
//			forward=new ActionForward();
//			forward.setRedirect(false);
//			forward.setPath("./order/Order_add.jsp");
//		}

		
		
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