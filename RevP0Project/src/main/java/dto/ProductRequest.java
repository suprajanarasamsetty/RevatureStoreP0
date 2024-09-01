package dto;

public class ProductRequest {
	
//	private int ProductID;
	private String ProductName;
	private double ProductPrice;
	private int SellerID;
	private int CategoryID;
	
	public ProductRequest(String productName, double productPrice, int sellerID, int categoryID) {
		super();
		ProductName = productName;
		ProductPrice = productPrice;
		SellerID = sellerID;
		CategoryID = categoryID;
	}
	
	public String getProductName() {
		return ProductName;
	}
	public void setProductName(String productName) {
		ProductName = productName;
	}
	public double getProductPrice() {
		return ProductPrice;
	}
	public void setProductPrice(double productPrice) {
		ProductPrice = productPrice;
	}
	public int getSellerID() {
		return SellerID;
	}
	public void setSellerID(int sellerID) {
		SellerID = sellerID;
	}
	public int getCategoryID() {
		return CategoryID;
	}
	public void setCategoryID(int categoryID) {
		CategoryID = categoryID;
	}
	
	
}
