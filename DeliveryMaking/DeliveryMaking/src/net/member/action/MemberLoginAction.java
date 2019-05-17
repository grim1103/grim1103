package net.member.action;

import java.io.PrintWriter;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.action.Action;
import net.action.ActionForward;
import net.member.db.MemberBean;
import net.member.db.MemberDAO;

public class MemberLoginAction implements Action {
	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{
		HttpSession session = request.getSession();
		MemberDAO memberdao = new MemberDAO();
		MemberBean memberbean = new MemberBean();
		request.setCharacterEncoding("euc-kr");
		
	
		memberbean.setMember_id(request.getParameter("id"));
		memberbean.setMember_pw(request.getParameter("pw"));

		if(!memberdao.idCheck(memberbean.getMember_id(), memberbean.getMember_pw())) {
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('아이디 또는 비밀번호가 잘못되었습니다.')");
			out.println("location.href='./MemberLoginForm.mo'");
			out.println("</script>");
			out.close();
			return null;
		}
		
		session.setAttribute("id", memberbean.getMember_id());
		ActionForward forward= new ActionForward();
		forward.setRedirect(true);
	   	forward.setPath("main.po");
	   	memberdao.connClose();
		return forward;

		
	 }
}
