package net.member.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {
	Connection conn = null;
	PreparedStatement pt = null;
	ResultSet re = null;

	
	public MemberDAO() { //디비연결
		try{
			Context init = new InitialContext();
	  		DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
	  		conn = ds.getConnection();
		}catch(Exception ex){
			System.out.println("DB 연결 실패 : " + ex);
			return;
		}
	}
	
	//로그인시 아이디와 비번이 맞는지 확인
	public boolean idCheck(String id, String pw) {
		String sql = "select member_pw from member where member_id = ?"; 
		try {
			pt = conn.prepareStatement(sql);
			pt.setString(1, id);
			re = pt.executeQuery();
			if(re.next()) {
				if(re.getString("member_pw").equals(pw)) {
					return true;
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(re!=null){re.close(); re = null;}
				if(pt!=null){pt.close(); pt = null;}  //닫아줌
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return false;
	}
	//회원가입 시 디비에 데이터 넣기
	public boolean memberInsert(MemberBean memberbean) throws SQLException {

		String sql = "insert into member values(?,?,?,?,?,?,?,?,?,?,?)";
		java.sql.Timestamp date = java.sql.Timestamp.valueOf(memberbean.getMember_date());
	    try{
	    	 pt = conn.prepareStatement(sql); //생성한 쿼리 입력
	    	   
		       pt.setString(1, memberbean.getMember_id());
		       pt.setString(2, memberbean.getMember_pw());
		       pt.setString(3, memberbean.getMember_name());
		       pt.setString(4, memberbean.getMember_jumin());
		       pt.setString(5, memberbean.getMember_birth());
		       pt.setString(6, memberbean.getMember_email());
		       pt.setString(7, memberbean.getMember_postcode());
		       pt.setString(8, memberbean.getMember_address());
		       pt.setString(9, memberbean.getMember_phone());	       
		       pt.setTimestamp(10, date);
		       pt.setInt(11, memberbean.getMember_point());
		       pt.executeUpdate(); //쿼리 실행

		       return true;
	      
	       
	       
	    }catch(RuntimeException er){
	    	er.printStackTrace();
			conn.rollback(); //오류시 롤백
		}finally{
			try{
				if(pt!=null){pt.close(); pt = null;}  //닫아줌
			}catch(Exception e){
				e.printStackTrace();
			}
		}

	    return false;
	}
	//회원정보 삭제
	public boolean memberDelete(String id) {
		String sql = "delete from member where member_id=?";
		try{
			pt=conn.prepareStatement(sql);
			pt.setString(1, id);
			pt.executeUpdate();
			return true;
		}catch(Exception e){
		    e.printStackTrace();
		}finally{
			try{
				if(pt!=null){pt.close(); pt = null;}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return false;
	}
	
	//회원상세정보 가져오기 
	public MemberBean getMemDetail(String id) throws SQLException {
		String sql = "select * from member where member_id = ?";
		try{	   
	  		pt = conn.prepareStatement(sql);
	  		pt.setString(1, id);
	  		re = pt.executeQuery();
	  		
	  		if(!re.next()) {return null;}
	  		
	  		
		  	MemberBean memberbean = new MemberBean();
	  		memberbean.setMember_id(re.getString("member_id"));
	  		memberbean.setMember_pw(re.getString("member_pw"));
	  		memberbean.setMember_name(re.getString("member_name"));
	  		memberbean.setMember_jumin(re.getString("member_jumin"));
	  		memberbean.setMember_birth(re.getString("member_birth"));
	  		memberbean.setMember_email(re.getString("member_email"));
	  		memberbean.setMember_postcode(re.getString("member_postcode"));
	  		memberbean.setMember_address(re.getString("member_address"));
	  		memberbean.setMember_phone(re.getString("member_phone"));
	  		String date = String.valueOf(re.getTimestamp("member_date"));
	  		memberbean.setMember_date(date);
	  		memberbean.setMember_point(re.getInt("member_point"));
	  	
	  		
	  		return memberbean;
	  		
	  		
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			try{
				if(re!=null){re.close(); re = null;}
				if(pt!=null){pt.close(); pt = null;}  //닫아줌
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return null;
	}
	
	//회원정보 리스트용
		public List getMemberList() throws SQLException {
			String sql = "select * from member where member_id != 'admin'";
			List list = new ArrayList();
			try{	   
		  		pt = conn.prepareStatement(sql);
		  		re = pt.executeQuery();
		  		while(re.next()) {
			  		MemberBean memberbean = new MemberBean();
			  		memberbean.setMember_id(re.getString("member_id"));
			  		memberbean.setMember_pw(re.getString("member_pw"));
			  		memberbean.setMember_name(re.getString("member_name"));
			  		memberbean.setMember_jumin(re.getString("member_jumin"));
			  		memberbean.setMember_birth(re.getString("member_birth"));
			  		memberbean.setMember_email(re.getString("member_email"));
			  		memberbean.setMember_postcode(re.getString("member_postcode"));
			  		memberbean.setMember_address(re.getString("member_address"));
			  		memberbean.setMember_phone(re.getString("member_phone"));
			  		String date = String.valueOf(re.getTimestamp("member_date"));
			  		memberbean.setMember_date(date);
			  		memberbean.setMember_point(re.getInt("member_point"));
		  			list.add(memberbean);
		  		}
		  		
		  		return list;
		  		
			}finally{
				try{
					if(re!=null){re.close(); re = null;}
					if(pt!=null){pt.close(); pt = null;}  //닫아줌
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
	
	//커넥션을 닫는다
	public void connClose() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}


