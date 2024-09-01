package dto;

public class WishlistRequest {
	
	private int WishlistID;
	private int user_id;
	private int ProductID;
	public WishlistRequest(int wishlistID, int user_id, int productID) {
		super();
		WishlistID = wishlistID;
		this.user_id = user_id;
		ProductID = productID;
	}
	public int getWishlistID() {
		return WishlistID;
	}
	public void setWishlistID(int wishlistID) {
		WishlistID = wishlistID;
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
	
	

}
