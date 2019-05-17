package net.member.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.action.Action;
import net.action.ActionForward;

public class MemberFrontController extends HttpServlet 
implements javax.servlet.Servlet {
	 protected void doProcess(HttpServletRequest request, HttpServletResponse response) 
			 	throws ServletException, IOException {
		String RequestURI=request.getRequestURI();
		String contextPath=request.getContextPath();
		String command=RequestURI.substring(contextPath.length());
		request.setCharacterEncoding("euc-kr");
		ActionForward forward=null;
		Action action=null;
		
		System.out.println(RequestURI);
		System.out.println(contextPath);
		System.out.println(command);
		
		if(command.equals("/MemberLoginForm.mo")){
			forward=new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./Sagyou/loginForm.jsp");
		}else if(command.equals("/MemberLoginAction.mo")) {
			action = new MemberLoginAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/MemberAddView.mo")) {
			forward=new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./Sagyou/joinForm.jsp");
			
		}else if(command.equals("/MemberAddAction.mo")) {
			action = new MemberAddAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/MemberListView.mo")) {
			forward=new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./Sagyou/Member_list.jsp");
		}else if(command.equals("/MemberInfoView.mo")) {
			forward=new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./Sagyou/Member_info.jsp");
		}else if(command.equals("/MemberInfoAction.mo")) {
			action = new MemberInfoAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/MemberListViewAction.mo")) {
			action = new MemberListViewAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/MemberDeleteAction.mo")) {
			action = new MemberDeleteAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/AdminPage.mo")) {
			forward=new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./Admin_page.jsp");
		}else if(command.equals("/product/AdminPage.mo")) {
			forward=new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./Admin_page.jsp");
		}else if(command.equals("/MemberLogoutAction.mo")) {
			action = new MemberLogoutAction();
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
