package net.news.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.news.db.NewsDAO;
import net.action.Action;
import net.action.ActionForward;
import net.news.db.NewsBean;

 public class NewsDetailAction implements Action {
	 public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{ 
		request.setCharacterEncoding("euc-kr");
   		
		NewsDAO newsdao=new NewsDAO();
	   	NewsBean newsdata=new NewsBean();
	   	
		int num=Integer.parseInt(request.getParameter("num"));
		newsdao.setReadCountUpdate(num);
		newsdata=newsdao.getDetail(num);
	   	
	   	if(newsdata==null){
	   		System.out.println("상세보기 실패");
	   		newsdao.conClose();
	   		return null;
	   	}
	   	System.out.println("상세보기 성공");
	   	
	   	request.setAttribute("newsdata", newsdata);
	   	ActionForward forward = new ActionForward();
	   	forward.setRedirect(false);
   		forward.setPath("./news/news_view.jsp");
   		newsdao.conClose();
   		return forward;

	 }
}