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

public class MemberAddAction implements Action{
	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{
		HttpSession session = request.getSession();
		MemberDAO memberdao = new MemberDAO();
		MemberBean memberbean = new MemberBean();
		request.setCharacterEncoding("UTF-8");
		
		
		
		memberbean.setMember_id(request.getParameter("id"));
		memberbean.setMember_pw(request.getParameter("pw"));
		memberbean.setMember_email(request.getParameter("email"));
		memberbean.setMember_name(request.getParameter("name"));
		memberbean.setMember_jumin(request.getParameter("jumin")+"-"+request.getParameter("jumin2"));
		memberbean.setMember_address(request.getParameter("postcode")+"/"+request.getParameter("address1")+"/"+request.getParameter("address2"));
		memberbean.setMember_phone(request.getParameter("phone"));
		memberbean.setMember_postcode(request.getParameter("postcode"));
		memberbean.setMember_birth(request.getParameter("year")+"/"+request.getParameter("month")+"/"+request.getParameter("day"));
		memberbean.setMember_date(request.getParameter("date"));
		memberbean.setMember_point(Integer.parseInt(request.getParameter("point")));
		
		if(!memberdao.memberInsert(memberbean)) {
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('Join is failed try again')");
			out.print("</script>");
			out.close();
			return null;
		}	
//		PrintWriter out = response.getWriter();
//		out.println("<script>");
//		out.println("alert('Congratulation Join is complited')");
//		out.println("location.href='main.po'");
//		out.print("</script>");
//		out.close();
		ActionForward forward= new ActionForward();
		forward.setRedirect(true);
	   	forward.setPath("main.po");
		memberdao.connClose();
		return forward;
	 }
}

