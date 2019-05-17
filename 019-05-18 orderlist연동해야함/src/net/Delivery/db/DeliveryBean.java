package net.Delivery.db;

public class DeliveryBean {
	private int delivery_num;
	private String delivery_product;
	private String delivery_address;
	private String delivery_name;
	private String delivery_phone;
	private String delivery_memo;
	
	public int getDelivery_num() {
		return delivery_num;
	}
	public void setDelivery_num(int delivery_num) {
		this.delivery_num = delivery_num;
	}
	public String getDelivery_address() {
		return delivery_address;
	}
	public void setDelivery_address(String delivery_address) {
		this.delivery_address = delivery_address;
	}
	public String getDelivery_name() {
		return delivery_name;
	}
	public void setDelivery_name(String delivery_name) {
		this.delivery_name = delivery_name;
	}
	public String getDelivery_phone() {
		return delivery_phone;
	}
	public void setDelivery_phone(String delivery_phone) {
		this.delivery_phone = delivery_phone;
	}
	public String getDelivery_product() {
		return delivery_product;
	}
	public void setDelivery_product(String delivery_product) {
		this.delivery_product = delivery_product;
	}
	public String getDelivery_memo() {
		return delivery_memo;
	}
	public void setDelivery_memo(String delivery_memo) {
		this.delivery_memo = delivery_memo;
	}
}
