package net.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import net.member.db.MemberBean;
import net.member.db.MemberDAO;

public class MemberJoinAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.getParameter("euc-kr");
		MemberDAO memberdao = new MemberDAO();
		MemberBean bean = new MemberBean();
		ActionForward forward = new ActionForward();
		
		boolean result = false;
		try {
			String jumin = request.getParameter("member_num1")+"-"+request.getParameter("member_num2");
			String birth = request.getParameter("year")+"-"+request.getParameter("month")+"-"+request.getParameter("day");
			bean.setMember_id(request.getParameter("member_id"));
			bean.setMember_pw(request.getParameter("member_pw"));
			bean.setMember_email(request.getParameter("member_email"));
			bean.setMember_name(request.getParameter("member_name"));
			bean.setMember_hobby(request.getParameterValues("member_hobby"));
			bean.setMember_jumin(jumin);
			bean.setMember_birth(birth);
			System.out.println("ㄴㄴ");
			result = memberdao.joinMember(bean);
			
			if(result == false) {
				System.out.println("회원가입 실패");
				memberdao.conClose();
				return null;
			}
			System.out.println("회원가입 성공");
			
			forward.setRedirect(true);
			forward.setPath("./MemberLogin.me");
			memberdao.conClose();
			return forward;
			
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		memberdao.conClose();
		return null;
	}

}
