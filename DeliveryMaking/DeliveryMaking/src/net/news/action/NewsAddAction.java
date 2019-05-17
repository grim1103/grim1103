package net.news.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import net.action.Action;
import net.action.ActionForward;
import net.news.db.NewsBean;

import net.news.db.NewsDAO;

public class NewsAddAction implements Action {
	 public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{
		NewsDAO newsdao=new NewsDAO();
		NewsBean newsdata=new NewsBean();
	   	ActionForward forward=new ActionForward();
	   	
   		boolean result=false;
   		
   		try{
   			
   			
   			newsdata.setNEWS_SUBJECT(request.getParameter("NEWS_SUBJECT"));
   			newsdata.setNEWS_CONTENTS(request.getParameter("NEWS_CONTENTS"));
   			
   			System.out.println(request.getParameter("NEWS_SUBJECT"));

   			System.out.println(request.getParameter("NEWS_CONTENTS"));
	   		result=newsdao.newsInsert(newsdata);
	   		
	   		if(result==false){
	   			System.out.println("뉴스 등록 실패");
	   			newsdao.conClose();
	   			return null;
	   		}
	   		System.out.println("뉴스 등록 완료");
	   		
	   		forward.setRedirect(true);
	   		forward.setPath("./NewsListAction.ne");
	   		newsdao.conClose();
	   		return forward;
	   		
  		}catch(Exception ex){
   			ex.printStackTrace();
   		}
   		newsdao.conClose();
  		return null;
	}  	
}