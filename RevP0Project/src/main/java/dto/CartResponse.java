package dto;

public class CartResponse {
    private int cartID;
    private int userId;
    private int productID;
    private double totalPrice;
    private int quantity;
    private String discountCoupon;

    public CartResponse(int cartID, int userId, int productID, double totalPrice, int quantity, String discountCoupon) {
        this.cartID = cartID;
        this.userId = userId;
        this.productID = productID;
        this.totalPrice = totalPrice;
        this.quantity = quantity;
        this.discountCoupon = discountCoupon;
    }

    public int getCartID() {
        return cartID;
    }

    public void setCartID(int cartID) {
        this.cartID = cartID;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDiscountCoupon() {
        return discountCoupon;
    }

    public void setDiscountCoupon(String discountCoupon) {
        this.discountCoupon = discountCoupon;
    }

    @Override
    public String toString() {
        return "CartResponse [cartID=" + cartID + ", userId=" + userId + ", productID=" + productID + ", totalPrice="
                + totalPrice + ", quantity=" + quantity + ", discountCoupon=" + discountCoupon + "]";
    }
}
