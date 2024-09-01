package dto;

public class SellerRequest {
    private String SellerName;
    private String SellerEmail;
    private String SellerPassword;
    private String BusinessName;
    private String BusinessDetails;
    private long userId; // Added field for user_id
    
    public SellerRequest(String sellerName, String sellerEmail, String sellerPassword, String businessName, String businessDetails, long userId) {
        this.SellerName = sellerName;
        this.SellerEmail = sellerEmail;
        this.SellerPassword = sellerPassword;
        this.BusinessName = businessName;
        this.BusinessDetails = businessDetails;
        this.userId = userId;
    }

    // Getters and Setters
    public String getSellerName() {
        return SellerName;
    }

    public void setSellerName(String sellerName) {
        SellerName = sellerName;
    }

    public String getSellerEmail() {
        return SellerEmail;
    }

    public void setSellerEmail(String sellerEmail) {
        SellerEmail = sellerEmail;
    }

    public String getSellerPassword() {
        return SellerPassword;
    }

    public void setSellerPassword(String sellerPassword) {
        SellerPassword = sellerPassword;
    }

    public String getBusinessName() {
        return BusinessName;
    }

    public void setBusinessName(String businessName) {
        BusinessName = businessName;
    }

    public String getBusinessDetails() {
        return BusinessDetails;
    }

    public void setBusinessDetails(String businessDetails) {
        BusinessDetails = businessDetails;
    }
    
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
