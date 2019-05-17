package net.review.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.review.db.ReviewDAO;
import net.action.Action;
import net.action.ActionForward;
import net.review.db.ReviewBean;

public class ReviewReplyView implements Action {
	 public ActionForward execute(HttpServletRequest request,HttpServletResponse response) 
	 	throws Exception{
		 	ActionForward forward = new ActionForward();
		 	
			ReviewDAO reviewdao=new ReviewDAO();
	   		ReviewBean reviewdata=new ReviewBean();
	   		
	   		int num=Integer.parseInt(request.getParameter("num"));
	   		
	   		reviewdata=reviewdao.getDetail(num);
	   		
	   		if(reviewdata==null){
	   			System.out.println("답장 페이지 이동 실패");
	   			reviewdao.connClose();
	   			return null;
	   		}
	   		System.out.println("답장 페이지 이동 완료");
	   		
	   		request.setAttribute("reviewdata", reviewdata);
	   		
	   		forward.setRedirect(false);
	   		forward.setPath("./review/review_reply.jsp");
	   		reviewdao.connClose();
	   		return forward;
	}
}