package net.member.action;

import java.io.PrintWriter;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.action.Action;
import net.action.ActionForward;
import net.member.db.MemberDAO;

public class MemberInfoAction implements Action {
	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{
		HttpSession session = request.getSession();
		MemberDAO memberdao = new MemberDAO();
		request.setCharacterEncoding("UTF-8");
		
		if((session.getAttribute("id")==null) || (!((String)session.getAttribute("id")).equals("admin"))){
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("location.href='MemberLoginForm.mo'");
			out.println("</script>");
			out.close();
			return null;
		}
		
		String id=request.getParameter("id");
		session.setAttribute("memberDetail", memberdao.getMemDetail(id));
		ActionForward forward = new ActionForward();
		forward.setRedirect(true);
		forward.setPath("MemberInfoView.mo");
		memberdao.connClose();
		return forward;
		
	}
}
