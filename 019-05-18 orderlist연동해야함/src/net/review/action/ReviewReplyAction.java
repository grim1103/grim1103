package net.review.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.review.db.ReviewDAO;
import net.action.Action;
import net.action.ActionForward;
import net.review.db.ReviewBean;

public class ReviewReplyAction implements Action {
	 public ActionForward execute(HttpServletRequest request,HttpServletResponse response) 
	 throws Exception{
		 	request.setCharacterEncoding("euc-kr");
		 	ActionForward forward = new ActionForward();
		 	
			ReviewDAO reviewdao=new ReviewDAO();
	   		ReviewBean reviewdata=new ReviewBean();
	   		int result=0;
	   		
	   		reviewdata.setREVIEW_NUM(Integer.parseInt(request.getParameter("REVIEW_NUM")));
	   		reviewdata.setREVIEW_SUBJECT(request.getParameter("REVIEW_SUBJECT"));
	   		reviewdata.setREVIEW_NAME(request.getParameter("REVIEW_NAME"));
	   		reviewdata.setREVIEW_PASS(request.getParameter("REVIEW_PASS"));
	   		reviewdata.setREVIEW_CONTENTS(request.getParameter("REVIEW_CONTENTS"));
	   		reviewdata.setREVIEW_RE_REF(Integer.parseInt(request.getParameter("REVIEW_RE_REF")));
	   		reviewdata.setREVIEW_RE_LEV(Integer.parseInt(request.getParameter("REVIEW_RE_LEV")));
	   		reviewdata.setREVIEW_RE_SEQ(Integer.parseInt(request.getParameter("REVIEW_RE_SEQ")));
	   		
	   		result=reviewdao.reviewReply(reviewdata);
	   		if(result==0){
	   			System.out.println("답글 실패");
	   			reviewdao.connClose();
	   			return null;
	   		}
	   		System.out.println("답장 완료");
	   		
	   		forward.setRedirect(true);
	   		forward.setPath("./ReviewDetailAction.re?num="+result);
	   		reviewdao.connClose();
	   		return forward;
	}  	
}