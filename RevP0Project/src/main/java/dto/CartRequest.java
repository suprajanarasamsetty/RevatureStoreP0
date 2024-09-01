package dto;

public class CartRequest {
	
	private int user_id;
	private int ProductID;
	private double TotalPrice;
	private int Quantity;
	private String DiscountCoupon;
	
	public CartRequest(int user_id, int productID, double totalPrice, int quantity, String discountCoupon) {
		super();
		this.user_id = user_id;
		ProductID = productID;
		TotalPrice = totalPrice;
		Quantity = quantity;
		DiscountCoupon = discountCoupon;
	}
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getProductID() {
		return ProductID;
	}
	public void setProductID(int productID) {
		ProductID = productID;
	}
	public double getTotalPrice() {
		return TotalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		TotalPrice = totalPrice;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	public String getDiscountCoupon() {
		return DiscountCoupon;
	}
	public void setDiscountCoupon(String discountCoupon) {
		DiscountCoupon = discountCoupon;
	}


}
