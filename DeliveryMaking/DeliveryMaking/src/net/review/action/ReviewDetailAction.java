package net.review.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.review.db.ReviewDAO;
import net.action.Action;
import net.action.ActionForward;
import net.review.db.ReviewBean;

 public class ReviewDetailAction implements Action {
	 public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{ 
		request.setCharacterEncoding("euc-kr");
   		
		ReviewDAO reviewdao=new ReviewDAO();
	   	ReviewBean reviewdata=new ReviewBean();
	   	
		int num=Integer.parseInt(request.getParameter("num"));
		reviewdao.setReadCountUpdate(num);
		reviewdata=reviewdao.getDetail(num);
	   	
	   	if(reviewdata==null){
	   		System.out.println("상세보기 실패");
	   		reviewdao.connClose();
	   		return null;
	   	}
	   	System.out.println("상세보기 성공");
	   	
	   	request.setAttribute("reviewdata", reviewdata);
	   	ActionForward forward = new ActionForward();
	   	forward.setRedirect(false);
   		forward.setPath("./review/review_view.jsp");
   		reviewdao.connClose();
   		return forward;

	 }
}