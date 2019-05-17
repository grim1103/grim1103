package net.review.action;

import java.io.IOException;import java.util.concurrent.ExecutionException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.action.Action;
import net.action.ActionForward;
import net.board.action.BoardReplyAction;

 public class ReviewFrontController 
 	extends javax.servlet.http.HttpServlet 
 	implements javax.servlet.Servlet {
	 protected void doProcess(HttpServletRequest request, HttpServletResponse response) 
	 	throws ServletException, IOException {
		 
		 String RequestURI=request.getRequestURI();
		 String contextPath=request.getContextPath();
		 String command=RequestURI.substring(contextPath.length());
		 ActionForward forward=null;
		 Action action=null;
		   
		   if(command.equals("/ReviewWrite.re")){
			   forward=new ActionForward();
			   forward.setRedirect(false);
			   forward.setPath("./review/review_write.jsp");
		   }else if(command.equals("/ReviewModify.re")){
			   action = new ReviewModifyView();
			   try{
				   forward=action.execute(request, response);
			   }catch(Exception e){
				   e.printStackTrace();
			   }
	 	   }else if(command.equals("/ReviewAddAction.re")){
			   action  = new ReviewAddAction();
			   try {
				   forward=action.execute(request, response );
			   } catch (Exception e) {
				   e.printStackTrace();
			   }
		   }else if(command.equals("/ReviewModifyAction.re")){
			   action = new ReviewModifyAction();
			   try{
				   forward=action.execute(request, response);
			   }catch(Exception e){
				   e.printStackTrace();
			   }
		   }else if(command.equals("/ReviewList.re")){
			   action = new ReviewListAction();
			   try{
				   forward=action.execute(request, response);
			   }catch(Exception e){
				   e.printStackTrace();
			   }
		   }else if(command.equals("/ReviewDetailAction.re")){
			   action = new ReviewDetailAction();
			   try{
				   forward=action.execute(request, response);
			   }catch(Exception e){
				   e.printStackTrace();
			   }
		   }else if(command.equals("/ReviewDeleteAction.re")) {
			   action = new ReviewDetailAction();
			   try {
				   forward= action.execute(request, response);
			   } catch(Exception e) {
				   e.printStackTrace();
			   }
		   }else if(command.equals("/ReviewDelete.re")) {
			   forward = new ActionForward();
			   forward.setRedirect(false);
			   forward.setPath("./review/review_delete.jsp");
		   }else if(command.equals("/ReviewReplyView.re")){
			   action = new ReviewReplyAction();
			   try{
				   forward=action.execute(request, response);
			   }catch(Exception e){
				   e.printStackTrace();
			   }
		   }else if(command.equals("/ReviewReplyAction.re")) {
			   action = new ReviewReplyView();
			   try {
				   forward = action.execute(request, response);
			   } catch(Exception e) {
				   e.printStackTrace();
			   }
		   }
		   
		   
		   
		   if(forward.isRedirect()){
			   response.sendRedirect(forward.getPath());
		   }else{
			   RequestDispatcher dispatcher=
				   request.getRequestDispatcher(forward.getPath());
			   dispatcher.forward(request, response);
		   }
	 }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		doProcess(request,response);
	}  	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		doProcess(request,response);
	}   	  	    
}