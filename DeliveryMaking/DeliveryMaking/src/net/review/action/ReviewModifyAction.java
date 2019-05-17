package net.review.action;

import java.io.PrintWriter;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.action.Action;
import net.action.ActionForward;
import net.review.db.*;

 public class ReviewModifyAction implements Action {
	 public ActionForward execute(HttpServletRequest request,HttpServletResponse response) 
	 	throws Exception{
		 request.setCharacterEncoding("euc-kr");
		 ActionForward forward = new ActionForward();
		 boolean result = false;
		 
		 int num=Integer.parseInt(request.getParameter("REVIEW_NUM"));
		 
		 ReviewDAO reviewdao=new ReviewDAO();
		 ReviewBean reviewdata=new ReviewBean();
		 
		 boolean usercheck=reviewdao.isReviewWriter(num, request.getParameter("REVIEW_PASS"));
		 if(usercheck==false){
		   		response.setContentType("text/html;charset=euc-kr");
		   		PrintWriter out=response.getWriter();
		   		out.println("<script>");
		   		out.println("alert('수정할권한이 없습니다.');");
		   		out.println("location.href='./ReviewList.re';");
		   		out.println("</script>");
		   		out.close();
		   		reviewdao.connClose();
		   		return null;
		 }
		 
		 try{
			 reviewdata.setREVIEW_NUM(num);
			 reviewdata.setREVIEW_SUBJECT(request.getParameter("REVIEW_SUBJECT"));
			 reviewdata.setREVIEW_CONTENTS(request.getParameter("REVIEW_CONTENTS"));
			 
			 result = reviewdao.reviewModify(reviewdata);
			 if(result==false){
		   		System.out.println("�Խ��� ���� ����");
		   		reviewdao.connClose();
		   		return null;
		   	 }
		   	 System.out.println("�Խ��� ���� �Ϸ�");
		   	 
		   	 forward.setRedirect(true);
		   	 forward.setPath("./ReviewDetailAction.re?num="+reviewdata.getREVIEW_NUM());
		   	reviewdao.connClose();
		   	 return forward;
	   	 }catch(Exception ex){
	   			ex.printStackTrace();	 
		 }
		 reviewdao.connClose();
		 return null;
	 }
}