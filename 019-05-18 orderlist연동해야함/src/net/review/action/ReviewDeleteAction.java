 package net.review.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.action.Action;
import net.action.ActionForward;
import net.review.db.*;

public class ReviewDeleteAction implements Action {
	 public ActionForward execute(HttpServletRequest request,HttpServletResponse response) 
	 	throws Exception{
		 
		ActionForward forward = new ActionForward();
		request.setCharacterEncoding("euc-kr");
		
	   	boolean result=false;
	   	boolean usercheck=false;
	   	int num=Integer.parseInt(request.getParameter("num"));
	   	
	   	ReviewDAO reviewdao=new ReviewDAO();
	   	usercheck=reviewdao.isReviewWriter(num, request.getParameter("REVIEW_PASS"));
	   	
	   	if(usercheck==false){
	   		response.setContentType("text/html;charset=utf-8");
	   		PrintWriter out=response.getWriter();
	   		out.println("<script>");
	   		out.println("alert('삭제할 권한이 없습니다.');");
	   		out.println("location.href='./ReviewList.re';");
	   		out.println("</script>");
	   		out.close();
	   		reviewdao.connClose();
	   		return null;
	   	}
	   	
	   	result=reviewdao.reviewDelete(num);
	   	if(result==false){
	   		System.out.println("리뷰 삭제 실패");
	   		reviewdao.connClose();
	   		return null;
	   	}
	   	
	   	System.out.println("리뷰 삭제 성공");
	   	forward.setRedirect(true);
   		forward.setPath("./ReviewList.re");
   		reviewdao.connClose();
   		return forward;
	 }
}