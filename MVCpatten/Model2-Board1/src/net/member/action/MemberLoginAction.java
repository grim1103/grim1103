package net.member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.member.db.MemberBean;
import net.member.db.MemberDAO;

public class MemberLoginAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MemberDAO memberdao = new MemberDAO();
		HttpSession session = request.getSession();
		MemberBean bean = new MemberBean();
		ActionForward forward = new ActionForward();
		int result = -1;
	
		
		bean.setMember_id(request.getParameter("member_id"));
		bean.setMember_pw(request.getParameter("member_pw"));
		result = memberdao.memberLogin(bean);
        if(result==0){ //비밀번호 틀리다는 결과값 나오면 얼럿창 띄우고 다시 로그인창 
            response.setContentType("text/html;charset=euc-kr"); 
            PrintWriter out = response.getWriter(); 
            out.println("<script>"); 
            out.println("alert('비밀번호가 일치하지 않습니다.');"); 
            out.println("location.href='./MemberLogin.me';"); 
            out.println("</script>"); 
            out.close(); 
            return null; 
        }else if(result==-1){ //아이디가 존재하지 않으면 경고얼럿창 후 다시 로그인창 
            response.setContentType("text/html;charset=euc-kr"); 
            PrintWriter out = response.getWriter(); 
            out.println("<script>"); 
            out.println("alert('아이디가 존재하지 않습니다.');"); 
            out.println("location.href='./MemberLogin.me';"); 
            out.println("</script>"); 
            out.close(); 
            return null; 
        }         
		session.setAttribute("member_id", bean.getMember_id());
		forward.setRedirect(true);
		forward.setPath("./BoardList.bo");
		return forward;
	}
}