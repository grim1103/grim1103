package net.member.action;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.action.Action;
import net.action.ActionForward;
import net.member.db.MemberBean;
import net.member.db.MemberDAO;

public class MemberLogoutAction implements Action{
	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");
		
		if(session == null) {
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('You can't logout try again')");
			out.print("</script>");
			out.close();
			return null;
		}	
		session.invalidate();
//		PrintWriter out = response.getWriter();
//		out.println("<script>");
//		out.println("alert('You are logouted')");
//		out.println("location.href='main.po'");
//		out.print("</script>");
//		out.close();
		ActionForward forward= new ActionForward();
		forward.setRedirect(true);
	   	forward.setPath("main.po");
		
		return forward;
	 }
}

