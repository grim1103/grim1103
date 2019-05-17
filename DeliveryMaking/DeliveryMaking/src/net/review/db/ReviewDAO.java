package net.review.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import net.board.db.BoardBean;

public class ReviewDAO {
	Connection conn = null;
	PreparedStatement pt = null;
	ResultSet re = null;

	
	public ReviewDAO() { //디비연결
		try{
			Context init = new InitialContext();
	  		DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
	  		conn = ds.getConnection();
		}catch(Exception ex){
			System.out.println("DB 연결 실패 : " + ex);
			return;
		}
	}
	
	public int getListCount() {
		int x= 0;
		
		try{
			pt=conn.prepareStatement("select count(*) from review");
			re = pt.executeQuery();
			
			if(re.next()){
				x=re.getInt(1);
			}
		}catch(Exception ex){
			System.out.println("getListCount ����: " + ex);			
		}finally{
			if(re!=null) try{re.close();}catch(SQLException ex){}
			if(pt!=null) try{pt.close();}catch(SQLException ex){}
		}
		return x;
	}
	
	//�� ��� ����.	
	public List getReviewList(int page,int limit){
		String review_list_sql="select * from "+
		"(select rownum rnum,REVIEW_NUM,REVIEW_SUBJECT,REVIEW_NAME,"+
		"REVIEW_CONTENTS, REVIEW_RE_REF, REVIEW_RE_LEV, REVIEW_RE_SEQ,REVIEW_DATE, REVIEW_READCOUNT from "+
		"(select * from review order by REVIEW_RE_REF desc, REVIEW_RE_SEQ asc)) "+
		"where rnum>=? and rnum<=?";
		
		List list = new ArrayList();
		
		int startrow=(page-1)*10+1; //�б� ������ row ��ȣ.
		int endrow=startrow+limit-1; //���� ������ row ��ȣ.		
		try{
			pt = conn.prepareStatement(review_list_sql);
			pt.setInt(1, startrow);
			pt.setInt(2, endrow);
			re = pt.executeQuery();
			
			while(re.next()){
				ReviewBean review = new ReviewBean();
				review.setREVIEW_NUM(re.getInt("REVIEW_NUM"));
				review.setREVIEW_SUBJECT(re.getString("REVIEW_SUBJECT"));
				review.setREVIEW_NAME(re.getString("REVIEW_NAME"));
				review.setREVIEW_CONTENTS(re.getString("REVIEW_CONTENTS"));
				review.setREVIEW_RE_REF(re.getInt("REVIEW_RE_REF"));
				review.setREVIEW_RE_LEV(re.getInt("REVIEW_RE_LEV"));
				review.setREVIEW_RE_SEQ(re.getInt("REVIEW_RE_SEQ"));
				review.setREVIEW_DATE(re.getDate("REVIEW_DATE"));
				review.setREVIEW_READCOUNT(re.getInt("REVIEW_READCOUNT"));
				list.add(review);
			}
			
			return list;
		}catch(Exception ex){
			System.out.println("getReviewList ���� : " + ex);
		}finally{
			if(re!=null) try{re.close();}catch(SQLException ex){}
			if(pt!=null) try{pt.close();}catch(SQLException ex){}
		}
		return null;
	}
	
	//�� ���� ����.
	public ReviewBean getDetail(int num) throws Exception{
		ReviewBean review = null;
		try{
			pt = conn.prepareStatement(
					"select * from review where REVIEW_NUM = ?");
			pt.setInt(1, num);
			
			re= pt.executeQuery();
			
			if(re.next()){
				review = new ReviewBean();
				review.setREVIEW_NUM(re.getInt("REVIEW_NUM"));
				review.setREVIEW_SUBJECT(re.getString("REVIEW_SUBJECT"));
				review.setREVIEW_NAME(re.getString("REVIEW_NAME"));
				review.setREVIEW_CONTENTS(re.getString("REVIEW_CONTENTS"));
				review.setREVIEW_DATE(re.getDate("REVIEW_DATE"));
				review.setREVIEW_READCOUNT(re.getInt("REVIEW_READCOUNT"));
			}
			return review;
		}catch(Exception ex){
			System.out.println("getDetail ���� : " + ex);
		}finally{
			if(re!=null)try{re.close();}catch(SQLException ex){}
			if(pt !=null)try{pt.close();}catch(SQLException ex){}
		}
		return null;
	}
	
	//�� ���.
	public boolean reviewInsert(ReviewBean review){
		int num =0;
		String sql="";
		
		int result=0;
		
		int re_ref=review.getREVIEW_RE_REF();
		int re_lev=review.getREVIEW_RE_LEV();
		int re_seq=review.getREVIEW_RE_SEQ();
		
		try{
			pt=conn.prepareStatement("select max(REVIEW_NUM) from review");
			re = pt.executeQuery();
			
			if(re.next())
				num =re.getInt(1)+1;
			else
				num=1;
			
			sql="insert into review (REVIEW_NUM,REVIEW_SUBJECT,REVIEW_NAME,REVIEW_PASS,"
					+ "REVIEW_CONTENTS, REVIEW_RE_REF, REVIEW_RE_LEV, "
					+ "REVIEW_RE_SEQ, REVIEW_DATE, REVIEW_READCOUNT"+
				") values(?,?,?,?,?,?,?,?,sysdate,?)";

			pt = conn.prepareStatement(sql);
			pt.setInt(1, num);
			pt.setString(2, review.getREVIEW_SUBJECT());
			pt.setString(3, review.getREVIEW_NAME());
			pt.setString(4, review.getREVIEW_PASS());
			pt.setString(5, review.getREVIEW_CONTENTS());
			pt.setInt(6, re_ref);
			pt.setInt(7, re_lev);
			pt.setInt(8, re_seq);
			pt.setInt(9, num);
			result=pt.executeUpdate();
			if(result==0)return false;
			
			return true;
		}catch(Exception ex){
			System.out.println("reviewInsert ���� : "+ex);
		}finally{
			if(re!=null) try{re.close();}catch(SQLException ex){}
			if(pt!=null) try{pt.close();}catch(SQLException ex){}
		}
		return false;
	}
	
	//�� �亯.
	public int reviewReply(ReviewBean review){
		String review_max_sql="select max(review_num) from review";
		String sql="";
		int num=0;
		int result=0;
		
		int re_ref=review.getREVIEW_RE_REF();
		int re_lev=review.getREVIEW_RE_LEV();
		int re_seq=review.getREVIEW_RE_SEQ();
		
		try{
			pt=conn.prepareStatement(review_max_sql);
			re = pt.executeQuery();
			if(re.next())num =re.getInt(1)+1;
			else num=1;
			
			sql="update review set REVIEW_RE_SEQ=REVIEW_RE_SEQ+1 where REVIEW_RE_REF=? ";
			sql+="and REVIEW_RE_SEQ>?";
			
			pt = conn.prepareStatement(sql);
			pt.setInt(1,re_ref);
			pt.setInt(2,re_seq);
			result=pt.executeUpdate();
			
			re_seq = re_seq + 1;
			re_lev = re_lev+1;
			
			sql="insert into review (REVIEW_NUM,REVIEW_NAME,REVIEW_PASS,REVIEW_SUBJECT,";
			sql+="REVIEW_CONTENTS, REVIEW_RE_REF,REVIEW_RE_LEV,REVIEW_RE_SEQ,";
			sql+="REVIEW_READCOUNT,REVIEW_DATE) values(?,?,?,?,?,?,?,?,?,sysdate)";
			
			pt = conn.prepareStatement(sql);
			pt.setInt(1, num);
			pt.setString(2, review.getREVIEW_NAME());
			pt.setString(3, review.getREVIEW_PASS());
			pt.setString(4, review.getREVIEW_SUBJECT());
			pt.setString(5, review.getREVIEW_CONTENTS());
			pt.setInt(6, re_ref);
			pt.setInt(7, re_lev);
			pt.setInt(8, re_seq);
			pt.setInt(9, 0);
			pt.executeUpdate();
			return num;
		}catch(SQLException ex){
			System.out.println("reviewReply ���� : "+ex);
		}finally{
			if(re!=null)try{re.close();}catch(SQLException ex){}
			if(pt!=null)try{pt.close();}catch(SQLException ex){}
		}
		return 0;
	}
	
	//�� ����.
	public boolean reviewModify(ReviewBean modifyreview) throws Exception{
		String sql="update review set REVIEW_SUBJECT=?,REVIEW_CONTENTS=? where REVIEW_NUM=?";
		
		try{
			pt = conn.prepareStatement(sql);
			pt.setString(1, modifyreview.getREVIEW_SUBJECT());
			pt.setString(2, modifyreview.getREVIEW_CONTENTS());
			pt.setInt(3, modifyreview.getREVIEW_NUM());
			pt.executeUpdate();
			return true;
		}catch(Exception ex){
			System.out.println("reviewModify ���� : " + ex);
		}finally{
			if(re!=null)try{re.close();}catch(SQLException ex){}
			if(pt!=null)try{pt.close();}catch(SQLException ex){}
			}
		return false;
	}
	
	//�� ����.
	public boolean reviewDelete(int num){
		String review_delete_sql="delete from review where REVIEW_NUM=?";
		
		int result=0;
		
		try{
			pt=conn.prepareStatement(review_delete_sql);
			pt.setInt(1, num);
			result=pt.executeUpdate();
			if(result==0)return false;
			
			return true;
		}catch(Exception ex){
			System.out.println("reviewDelete ���� : "+ex);
		}finally{
			try{
				if(pt!=null)pt.close();
			}catch(Exception ex) {}
		}
		
		return false;
	}
	
	//��ȸ�� ������Ʈ.
	public void setReadCountUpdate(int num) throws Exception{
		String sql="update review set REVIEW_READCOUNT = "+
			"REVIEW_READCOUNT+1 where REVIEW_NUM = "+num;
		
		try{
			pt=conn.prepareStatement(sql);
			pt.executeUpdate();
		}catch(SQLException ex){
			System.out.println("setReadCountUpdate ���� : "+ex);
		}
	}
	
	//�۾������� Ȯ��.
	public boolean isReviewWriter(int num,String pass){
		String review_sql="select * from review where REVIEW_NUM=?";
		
		try{
			pt=conn.prepareStatement(review_sql);
			pt.setInt(1, num);
			re=pt.executeQuery();
			re.next();
			
			if(pass.equals(re.getString("REVIEW_PASS"))){
				return true;
			}
		}catch(SQLException ex){
			System.out.println("isReviewWriter ���� : "+ex);
		}
		return false;
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


