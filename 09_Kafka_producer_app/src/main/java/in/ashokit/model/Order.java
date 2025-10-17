package in.ashokit.model;

public class Order {
	
	private String orderId;
	private Double orderPrice;
	private String customerEmail;
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public Double getOrderPrice() {
		return orderPrice;
	}
	public void setOrderPrice(Double orderPrice) {
		this.orderPrice = orderPrice;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderPrice=" + orderPrice + ", customerEmail=" + customerEmail + "]";
	}

	
	
}
