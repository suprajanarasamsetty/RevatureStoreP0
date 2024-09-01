package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dto.SellerRequest;
import dto.SellerResponse;
import exceptions.SellerCreateException;
import exceptions.SellerDeleteException;
import exceptions.SellerNotFoundException;
import exceptions.SellerUpdateException;
import utils.ConnectionFactory;

public class SellerDAOClass implements SellerDAO{
    private static final Logger logger = LoggerFactory.getLogger(SellerDAOClass.class);

    @Override
    public SellerResponse getSellerById(long id) throws SQLException, SellerNotFoundException {
        logger.debug("Entering into getSellerById method with ID: {}", id);
        String query = "SELECT * FROM seller WHERE SellerID=?";
        
        try (Connection con = ConnectionFactory.getConnectionFactory().getConnection()) {
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setLong(1, id);
            
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) { 
                    logger.info("Retrieving Seller with ID: {}", id);
                    SellerResponse sellerResponse = new SellerResponse(
                        rs.getLong("SellerID"),
                        rs.getString("SellerEmail"),
                        rs.getString("SellerPassword"),
                        rs.getString("BusinessName"),
                        rs.getString("BusinessDetails"),
                        rs.getLong("user_id")
                    );
                    logger.info("Seller Retrieved successfully with ID: {}", id);
                    
                    return sellerResponse;
                } else {
                    logger.warn("Seller Not Found with ID: {}", id);
                    throw new SellerNotFoundException("Seller Not Found with ID: " + id);
                }
            } catch (SQLException e) {
                logger.error("SQL Error occurred while fetching Seller with ID: {}", id);
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public boolean CreateSeller(SellerRequest sellerRequest) throws SQLException, SellerCreateException {
        logger.debug("Entering into CreateSeller method with Email: {}", sellerRequest.getSellerEmail());
        String query = "INSERT INTO seller (SellerName, SellerEmail, SellerPassword, BusinessName, BusinessDetails, user_id) values (?, ?, ?, ?, ?, ?)";
        
        try (Connection con = ConnectionFactory.getConnectionFactory().getConnection()) {
            PreparedStatement stmt = con.prepareStatement(query);
            logger.info("Inserting Seller with Email: {}", sellerRequest.getSellerEmail());

            stmt.setString(1, sellerRequest.getSellerName());
            stmt.setString(2, sellerRequest.getSellerEmail());
            stmt.setString(3, sellerRequest.getSellerPassword());
            stmt.setString(4, sellerRequest.getBusinessName());
            stmt.setString(5, sellerRequest.getBusinessDetails());
            stmt.setLong(6, sellerRequest.getUserId());
            
            int result = stmt.executeUpdate();
            
            if (result > 0) {
                logger.info("Seller inserted successfully with Email: {}", sellerRequest.getSellerEmail());
                return true;
            } else {
                logger.warn("Seller Not inserted with Email: {}", sellerRequest.getSellerEmail());
                throw new SellerCreateException("Seller not inserted with Email: " + sellerRequest.getSellerEmail());
            }
        } catch (SQLException e) {
            logger.error("SQL Error occurred while inserting Seller with Email: {}", sellerRequest.getSellerEmail());
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean UpdateSeller(SellerRequest sellerRequest) throws SQLException, SellerUpdateException {
        logger.debug("Entering into UpdateSeller method with Email: {}", sellerRequest.getSellerEmail());
        String query = "UPDATE seller SET SellerName=?, SellerEmail=?, SellerPassword=?, BusinessName=?, BusinessDetails=? WHERE SellerID=?";
        
        try (Connection con = ConnectionFactory.getConnectionFactory().getConnection()) {
            PreparedStatement stmt = con.prepareStatement(query);
            logger.info("Updating Seller...");
            stmt.setString(1, sellerRequest.getSellerName());
            stmt.setString(2, sellerRequest.getSellerEmail());
            stmt.setString(3, sellerRequest.getSellerPassword());
            stmt.setString(4, sellerRequest.getBusinessName());
            stmt.setString(5, sellerRequest.getBusinessDetails());
            stmt.setLong(6, sellerRequest.getUserId()); // Updated for correct ID

            int result = stmt.executeUpdate();
            if (result > 0) {
                logger.info("Seller Updated with Email: {}", sellerRequest.getSellerEmail());
                return true;
            } else {
                logger.info("Seller Not found with Email: {}", sellerRequest.getSellerEmail());
                throw new SellerUpdateException("Seller Not Updated with Email: " + sellerRequest.getSellerEmail());
            }
        } catch (SQLException e) {
            logger.error("SQL Error occurred while Updating Seller with Email: {}", sellerRequest.getSellerEmail());
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean DeleteSeller(long id) throws SQLException, SellerDeleteException {
        logger.debug("Entering into DeleteSeller method with ID: {}", id);
        String query = "DELETE FROM seller WHERE SellerID=?";
        try (Connection con = ConnectionFactory.getConnectionFactory().getConnection()) {
            PreparedStatement stmt = con.prepareStatement(query);
            logger.info("Deleting Seller with ID: {}", id);
            stmt.setLong(1, id);
            
            int result = stmt.executeUpdate();
            if (result > 0) {
                logger.info("Seller Deleted with ID: {}", id);
                return true;
            } else {
                logger.warn("Seller Not found with ID: {}", id);
                throw new SellerDeleteException("Seller Not Deleted with ID: " + id);
            }
        } catch (SQLException e) {
            logger.error("SQL Error occurred while Deleting Seller with ID: {}", id);
            e.printStackTrace();
        }
        return false;
    }
    
    @Override
    public List<SellerResponse> getAllSellers() throws SQLException {
        logger.debug("Entering into getAllSellers method");
        List<SellerResponse> sellerList = new ArrayList<>();
        String query = "SELECT * FROM seller";
        
        try (Connection con = ConnectionFactory.getConnectionFactory().getConnection()) {
            PreparedStatement stmt = con.prepareStatement(query);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    SellerResponse sellerResponse = new SellerResponse(
                        rs.getLong("SellerID"),
                        rs.getString("SellerEmail"),
                        rs.getString("SellerPassword"),
                        rs.getString("BusinessName"),
                        rs.getString("BusinessDetails"),
                        rs.getLong("user_id")
                    );
                    sellerList.add(sellerResponse);
                }
            }
        } catch (SQLException e) {
            logger.error("SQL Error occurred while fetching all Sellers");
            e.printStackTrace();
        }
        return sellerList;
    }
}
