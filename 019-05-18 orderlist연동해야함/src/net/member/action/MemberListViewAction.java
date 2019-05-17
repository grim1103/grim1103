package net.member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.action.Action;
import net.action.ActionForward;
import net.member.db.MemberBean;
import net.member.db.MemberDAO;

public class MemberListViewAction implements Action{
	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		MemberDAO memberdao = new MemberDAO();
		request.setCharacterEncoding("UTF-8");

		if((session.getAttribute("id")==null) || (!((String)session.getAttribute("id")).equals("admin"))){
			out.println("<script>");
			out.println("location.href='MemberLoginForm.mo'");
			out.println("</script>");
		}
		
		session.setAttribute("memberbean", memberdao.getMemberList());
		ActionForward forward = new ActionForward();
		forward.setRedirect(true);
		forward.setPath("MemberListView.mo");
		memberdao.connClose();
		return forward;
	}
}
