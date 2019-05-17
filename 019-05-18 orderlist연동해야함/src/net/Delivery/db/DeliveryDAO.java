package net.Delivery.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import net.Order.db.OrderBean;

public class DeliveryDAO {
	Connection conn = null;
	PreparedStatement pt = null;
	ResultSet re = null;

	public DeliveryDAO() { // 디비 연결
		try {
			Context init = new InitialContext();
			DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
			conn = ds.getConnection();
		} catch (Exception ex) {
			System.out.println("DB 연결 실패 : " + ex);
			return;
		}
	}
	// 디비에 배달상품 등록하기
	public boolean insertDelivery(DeliveryBean deliveryBean) throws SQLException {

		String sql = "insert into delivery values(sqe_delivery_code.nextval,?,?,?,?,?)";
		
		try {
			pt = conn.prepareStatement(sql);
			
			pt.setString(1, deliveryBean.getDelivery_product());
			pt.setString(2,deliveryBean.getDelivery_address());
			pt.setString(3, deliveryBean.getDelivery_name());
			pt.setString(4, deliveryBean.getDelivery_phone());
			pt.setString(5, deliveryBean.getDelivery_memo());
			pt.executeUpdate();
			
			return true;

		} catch (RuntimeException er) {
			er.printStackTrace();
		} finally {
			try {
				if (pt != null) {
					pt.close();
					pt = null;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	// 주문상품 리스트
	public List getListDelivery (int num) throws SQLException {
		String sql = "select * from delivery where delivery_num = ?";
		List list = new ArrayList();

		try {
			pt = conn.prepareStatement(sql);
			pt.setInt(1, num);
			
			re = pt.executeQuery();
			
			while (re.next()) {
				DeliveryBean deliverybean = new DeliveryBean();
				deliverybean.setDelivery_num(re.getInt("delivery_num"));
				deliverybean.setDelivery_address(re.getString("delivery_address"));
				deliverybean.setDelivery_name(re.getString("delivery_name"));
				deliverybean.setDelivery_phone(re.getString("delivery_phone"));
				
				list.add(deliverybean);
			}

			return list;

		} catch (RuntimeException er) {
			er.printStackTrace();
		} finally {
			try {
				if (re != null) {
					re.close();
					re = null;
				}
				if (pt != null) {
					pt.close();
					pt = null;
				} // 닫아줌
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	
	//커넥트 닫기
	public void conClose() {
		try {
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
