package net.news.db;

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

public class NewsDAO {
	Connection conn = null;
	PreparedStatement pt = null;
	ResultSet re = null;

	
	public NewsDAO() { //디비연결
		try{
			Context init = new InitialContext();
	  		DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
	  		conn = ds.getConnection();
		}catch(Exception ex){
			System.out.println("DB 연결 실패 : " + ex);
			return;
		}
	}
	public void conClose() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public int getListCount() {
		int x= 0;
		
		try{
			pt=conn.prepareStatement("select count(*) from news");
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
	public List getNewsList(int page,int limit){
		String news_list_sql="select * from "+
		"(select rownum rnum,NEWS_NUM,NEWS_SUBJECT,NEWS_CONTENTS,"+
		"NEWS_DATE,NEWS_READCOUNT from "+
		"(select * from news order by NEWS_NUM desc))"+
		"where rnum>=? and rnum<=?";
		
		List list = new ArrayList();
		
		int startrow=(page-1)*10+1; //�б� ������ row ��ȣ.
		int endrow=startrow+limit-1; //���� ������ row ��ȣ.		
		try{
			pt = conn.prepareStatement(news_list_sql);
			pt.setInt(1, startrow);
			pt.setInt(2, endrow);
			re = pt.executeQuery();
			
			while(re.next()){
				NewsBean news = new NewsBean();
				news.setNEWS_NUM(re.getInt("NEWS_NUM"));
				news.setNEWS_SUBJECT(re.getString("NEWS_SUBJECT"));
				news.setNEWS_CONTENTS(re.getString("NEWS_CONTENTS"));
				news.setNEWS_DATE(re.getDate("NEWS_DATE"));
				news.setNEWS_READCOUNT(re.getInt("NEWS_READCOUNT"));

				list.add(news);
			}
			
			return list;
		}catch(Exception ex){
			System.out.println("getNewsList ���� : " + ex);
		}finally{
			if(re!=null) try{re.close();}catch(SQLException ex){}
			if(pt!=null) try{pt.close();}catch(SQLException ex){}
		}
		return null;
	}
	
	public boolean newsInsert(NewsBean news){
		int num =0;
		String sql="";
		
		int result=0;
		
		try{
			pt=conn.prepareStatement("select max(NEWS_NUM) from news");
			re = pt.executeQuery();
			
			if(re.next())
				num =re.getInt(1)+1;
			else
				num=1;
			
			sql="insert into news values(?,?,?,sysdate,?)";
			
			pt = conn.prepareStatement(sql);
			pt.setInt(1, num);
			pt.setString(2, news.getNEWS_SUBJECT());
			pt.setString(3, news.getNEWS_CONTENTS());
			pt.setInt(4, num);

			result=pt.executeUpdate();
			if(result==0)return false;
			
			return true;
		}catch(Exception ex){
			System.out.println("boardInsert ���� : "+ex);
		}finally{
			if(re!=null) try{re.close();}catch(SQLException ex){}
			if(pt!=null) try{pt.close();}catch(SQLException ex){}
		}
		return false;
	}
	
	public NewsBean getDetail(int num) throws Exception{
		NewsBean news = null;
		try{
			pt = conn.prepareStatement(
					"select * from news where NEWS_NUM = ?");
			pt.setInt(1, num);
			
			re= pt.executeQuery();
			
			if(re.next()){
				news = new NewsBean();
				news.setNEWS_NUM(re.getInt("NEWS_NUM"));
				news.setNEWS_SUBJECT(re.getString("NEWS_SUBJECT"));
				news.setNEWS_CONTENTS(re.getString("NEWS_CONTENTS"));
				news.setNEWS_DATE(re.getDate("NEWS_DATE"));
				news.setNEWS_READCOUNT(re.getInt("NEWS_READCOUNT"));

			}
			return news;
		}catch(Exception ex){
			System.out.println("getDetail ���� : " + ex);
		}finally{
			if(re!=null)try{re.close();}catch(SQLException ex){}
			if(pt !=null)try{pt.close();}catch(SQLException ex){}
		}
		return null;
	}
	
	public void setReadCountUpdate(int num) throws Exception{
		String sql="update news set NEWS_READCOUNT = "+
			"NEWS_READCOUNT+1 where NEWS_NUM = "+num;
		
		try{
			pt=conn.prepareStatement(sql);
			pt.executeUpdate();
		}catch(SQLException ex){
			System.out.println("setReadCountUpdate ���� : "+ex);
		}
	}
}
