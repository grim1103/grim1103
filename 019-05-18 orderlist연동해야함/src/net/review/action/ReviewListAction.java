 package net.review.action;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.action.Action;
import net.action.ActionForward;
import net.review.db.ReviewDAO;

 public class ReviewListAction implements Action {
	 public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{
		
		ReviewDAO reviewdao=new ReviewDAO();//DB ����
		List reviewlist=new ArrayList();
		
	  	int page=1;
		int limit=10;
		
		if(request.getParameter("page")!=null){
			page=Integer.parseInt(request.getParameter("page"));
		}
		
		int listcount=reviewdao.getListCount(); //�� ����Ʈ ���� �޾ƿ�.
		reviewlist = reviewdao.getReviewList(page,limit); //����Ʈ�� �޾ƿ�.
		
		//�� ������ ��.
   		int maxpage=(int)((double)listcount/limit+0.95); //0.95�� ���ؼ� �ø� ó��.
   		//���� �������� ������ ���� ������ ��(1, 11, 21 ��...)
   		int startpage = (((int) ((double)page / 10 + 0.9)) - 1) * 10 + 1;
   		//���� �������� ������ ������ ������ ��.(10, 20, 30 ��...)
   		int endpage = maxpage;
   		
   		if (endpage>startpage+10-1) endpage=startpage+10-1;
   		
   		request.setAttribute("page", page);		  
   		request.setAttribute("maxpage", maxpage); 
   		request.setAttribute("startpage", startpage); 
   		request.setAttribute("endpage", endpage);     
		request.setAttribute("listcount",listcount); 
		request.setAttribute("reviewlist", reviewlist);
		
		ActionForward forward= new ActionForward();
	   	forward.setRedirect(false);
   		forward.setPath("./review/review_list.jsp");
   		reviewdao.connClose();
   		return forward;
	 }
 }