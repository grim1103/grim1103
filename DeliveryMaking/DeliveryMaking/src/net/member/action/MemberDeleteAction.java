package net.member.action;

import java.io.PrintWriter;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.action.Action;
import net.action.ActionForward;
import net.member.db.MemberBean;
import net.member.db.MemberDAO;

public class MemberDeleteAction implements Action {
	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{
		HttpSession session = request.getSession();
		MemberDAO memberdao = new MemberDAO();
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("euc-kr");
		if((session.getAttribute("id")==null) || (!((String)session.getAttribute("id")).equals("admin"))){
			out.println("<script>");
			out.println("location.href='MemberLoginForm.mo'");
			out.println("</script>");
			out.close();
			return null;
		}
		String id = request.getParameter("id");
		memberdao.memberDelete(id);
		ActionForward forward = new ActionForward();
		forward.setRedirect(true);
		forward.setPath("MemberListViewAction.mo");
		memberdao.connClose();
		System.out.println("das");
		return forward;		
		
	}
}
