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
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;

	public void conClose() {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public MemberDAO() {
		try {
			Context init = new InitialContext();
			DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
			con = ds.getConnection();
		} catch (Exception ex) {
			System.out.println("DB 연결 실패 : " + ex);
			return;
		}
	}

	public boolean joinMember(MemberBean bean) {
		String[] inter = bean.getMember_hobby();
		int temp = inter.length;
		String hobby = "";
		for (int i = 0; i < temp; i++) {
			hobby = hobby + inter[i] + ",";
		}

		String sql = "insert into member values (?,?,?,?,?,?,?,?)";
		int result = 0;

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bean.getMember_id());
			pstmt.setString(2, bean.getMember_pw());
			pstmt.setString(3, bean.getMember_email());
			pstmt.setString(4, bean.getMember_name());
			pstmt.setString(5, hobby);
			pstmt.setString(6, bean.getMember_mempr());
			pstmt.setString(7, bean.getMember_jumin());
			pstmt.setString(8, bean.getMember_birth());
			result = pstmt.executeUpdate();

			if (result != 0) {
				return true;
			}
		} catch (Exception ex) {
			System.out.println("joinMember 에러: " + ex);
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
		}

		return false;
	}

	public int memberLogin(MemberBean bean) {
		String sql = "select member_pw from member where member_id=?";
		int result = -1;

		try {
		
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bean.getMember_id());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				if (rs.getString("member_pw").equals(bean.getMember_pw())) {
					result = 1; // 일치
				} else {
					result = 0; // 불일치
				}
			} else {
				result = -1;
			}
		} catch (Exception ex) {
			System.out.println("memberLogin 에러 : " + ex);
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
		}
		System.out.println(result);
		return result;
	}

	public List listMember() {
		String sql = "select member_id from member where member_id != 'admin'";
		List memberlist = new ArrayList();
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				MemberBean bean = new MemberBean();
				bean.setMember_id(rs.getString("member_id"));
				memberlist.add(bean);
			}
			return memberlist;
		} catch (Exception ex) {
			System.out.println("listMember 에러 : " + ex);
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
		}
		return null;
	}

	public MemberBean infoMember(String id) {
		String sql = "select * from member where member_id=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				MemberBean bean = new MemberBean();
				bean.setMember_id("member_id");
				bean.setMember_pw("member_pw");
				bean.setMember_email("member_email");
				bean.setMember_name("member_name");
				bean.setMember_mempr("member_mempr");
				bean.setMember_hobby(bean.getMember_hobby());
				bean.setMember_jumin(bean.getMember_jumin());
				bean.setMember_birth(bean.getMember_birth());
				System.out.println("만약??");
				return bean;
			}
		} catch (Exception ex) {
			System.out.println("infoMember 에러 : " + ex);
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
		}
		return null;
	}

	public MemberBean detailMember(String id) {
		String sql = "select * from member where member_id =?";
	
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			rs.next();

			MemberBean bean = new MemberBean();
			bean.setMember_id(rs.getString("member_id"));
			bean.setMember_pw(rs.getString("member_pw"));
			bean.setMember_email(rs.getString("member_email"));
			bean.setMember_name(rs.getString("member_name"));
			bean.setMember_mempr(rs.getString("member_mempr"));
			bean.setMember_hobby(bean.getMember_hobby());
			bean.setMember_jumin(bean.getMember_jumin());
			bean.setMember_birth(bean.getMember_birth());
			return bean;
			
		} catch (Exception ex) {
			System.out.println("DetailMember 에러: " + ex);
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
		}

		return null;
	}

	public boolean deleteMember(String id) {
		String sql = "delete from member where member_id=?";
		int result = 0;

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);

			result = pstmt.executeUpdate();

			if (result != 0) {
				System.out.println(result);
				return true;
			}
		} catch (Exception ex) {
			System.out.println("deleteMember 에러: " + ex);
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
		}
		System.out.println(result+"1");
		return false;
	}
}
