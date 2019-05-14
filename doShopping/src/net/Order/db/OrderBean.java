package net.Order.db;

public class OrderBean {
	private int Order_code; // 주문코드
	private String Order_id; // 주문자아이디
	private String Order_date; // 주문일
	private String Order_image; // 주문상품이미지
	private int Order_price; // 주문 상품가격
	private int Order_count; // 주문 갯수
	private String Order_result;// 주문처리상태
	private double Order_point;//주문 포인트
	private String Order_name;//주문 상품이름
	private int Order_num;
	
	public double getOrder_point() {
		return Order_point;
	}

	public void setOrder_point(double order_point) {
		Order_point = order_point;
	}

	public String getOrder_name() {
		return Order_name;
	}

	public void setOrder_name(String order_name) {
		Order_name = order_name;
	}

	public int getOrder_code() {
		return Order_code;
	}

	public void setOrder_code(int order_code) {
		Order_code = order_code;
	}

	public String getOrder_id() {
		return Order_id;
	}

	public void setOrder_id(String order_id) {
		Order_id = order_id;
	}

	public String getOrder_date() {
		return Order_date;
	}

	public void setOrder_date(String order_date) {
		Order_date = order_date;
	}

	public String getOrder_image() {
		return Order_image;
	}

	public void setOrder_image(String order_image) {
		Order_image = order_image;
	}

	public int getOrder_price() {
		return Order_price;
	}

	public void setOrder_price(int order_price) {
		Order_price = order_price;
	}

	public int getOrder_count() {
		return Order_count;
	}

	public void setOrder_count(int order_count) {
		Order_count = order_count;
	}

	public String getOrder_result() {
		return Order_result;
	}

	public void setOrder_result(String order_result) {
		Order_result = order_result;
	}

	public int getOrder_num() {
		return Order_num;
	}

	public void setOrder_num(int order_num) {
		Order_num = order_num;
	}
}
