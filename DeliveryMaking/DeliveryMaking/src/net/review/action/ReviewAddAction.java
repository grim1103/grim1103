package net.review.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import net.action.Action;
import net.action.ActionForward;
import net.review.db.ReviewBean;

import net.review.db.ReviewDAO;

public class ReviewAddAction implements Action {
	 public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{
		ReviewDAO reviewdao=new ReviewDAO();
		ReviewBean reviewdata=new ReviewBean();
	   	ActionForward forward=new ActionForward();
	   	
   		boolean result=false;
   		
   		try{
   			
   			reviewdata.setREVIEW_NAME(request.getParameter("REVIEW_NAME"));
   			reviewdata.setREVIEW_PASS(request.getParameter("REVIEW_PASS"));
   			reviewdata.setREVIEW_SUBJECT(request.getParameter("REVIEW_SUBJECT"));
   			reviewdata.setREVIEW_CONTENTS(request.getParameter("REVIEW_CONTENTS"));
   			
	   		result=reviewdao.reviewInsert(reviewdata);
	   		
	   		if(result==false){
	   			System.out.println("리뷰 등록 실패");
	   			reviewdao.connClose();
	   			return null;
	   		}
	   		System.out.println("리뷰 등록 완료");
	   		
	   		forward.setRedirect(true);
	   		forward.setPath("./ReviewList.re");
	   		reviewdao.connClose();
	   		return forward;
	   		
  		}catch(Exception ex){
   			ex.printStackTrace();
   		}
   		reviewdao.connClose();
  		return null;
	}  	
}