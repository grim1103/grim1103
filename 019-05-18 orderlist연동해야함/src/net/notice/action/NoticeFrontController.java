package net.notice.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.action.Action;
import net.action.ActionForward;

 public class NoticeFrontController 
    extends javax.servlet.http.HttpServlet 
    implements javax.servlet.Servlet {
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) 
       throws ServletException, IOException {
       
       String RequestURI=request.getRequestURI();
       String contextPath=request.getContextPath();
       String command=RequestURI.substring(contextPath.length());
       ActionForward forward=null;
       Action action=null;
         
         if(command.equals("/NoticeWrite.no")){
            forward=new ActionForward();
            forward.setRedirect(false);
            forward.setPath("./notice/notice_write.jsp");
         }/*else if(command.equals("/BoardModify.bo")){
            action = new BoardModifyView();
            try{
               forward=action.execute(request, response);
            }catch(Exception e){
               e.printStackTrace();
            }
          }*/else if(command.equals("/NoticeAddAction.no")){
            action  = new NoticeAddAction();
            try {
               forward=action.execute(request, response );
            } catch (Exception e) {
               e.printStackTrace();
            }
         }/*else if(command.equals("/BoardModifyAction.bo")){
            action = new BoardModifyAction();
            try{
               forward=action.execute(request, response);
            }catch(Exception e){
               e.printStackTrace();
            }
         }*/else if(command.equals("/NoticeList.ne")){
            action = new NoticeListAction();
            try{
               forward=action.execute(request, response);
            }catch(Exception e){
               e.printStackTrace();
            }
         }else if(command.equals("/NoticeDetailAction.ne")){
            action = new NoticeDetailAction();
            try{
               forward=action.execute(request, response);
            }catch(Exception e){
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