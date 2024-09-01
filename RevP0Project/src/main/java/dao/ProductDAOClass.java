package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dto.ProductRequest;
import dto.ProductResponse;
import exceptions.ProductCreationException;
import exceptions.ProductDeletionException;
import exceptions.ProductNotFoundException;
import exceptions.ProductUpdateException;
import utils.ConnectionFactory;

public class ProductDAOClass implements ProductDAO{
	
	private static final Logger logger=LoggerFactory.getLogger(ProductDAOClass.class);
	@Override
	public ProductResponse getProductById(long id) throws SQLException, ProductNotFoundException {
		logger.debug("Entering into getProductById method with Seller ID: {}",id);

		String query="SELECT * FROM Product WHERE ProductID=?";
		
		logger.info("Fetching Product ID:{}",id);
		
		try(Connection con=ConnectionFactory.getConnectionFactory().getConnection()){
		PreparedStatement stmt=con.prepareStatement(query);
		
		stmt.setLong(1, id);
		
		logger.debug("Product Retrieved");
		
		try(ResultSet rs=stmt.executeQuery()){
			if(rs.next()) {
				ProductResponse productResponse=new ProductResponse(
						rs.getInt("ProductID"),
						rs.getString("ProductName"),
						rs.getDouble("ProductPrice"),
						rs.getInt("SellerID"),
						rs.getInt("CategoryID"));
				
				return productResponse;
			}
			else {
				throw new ProductNotFoundException("Product Not Found with ID: "+id);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		    logger.error("Database Error: ", e);
		}
		return null;
	}
	}

	@Override
	public boolean CreateProduct(ProductRequest productRequest) throws SQLException, ProductCreationException {
		String query="INSERT INTO Product(ProductName, ProductPrice, SellerID, CategoryId) VALUES(?,?,?,?)";
		
		logger.info("Adding Product:{}",productRequest.getProductName());
		
		try(Connection con=ConnectionFactory.getConnectionFactory().getConnection()){
			PreparedStatement stmt=con.prepareStatement(query);
			
			stmt.setString(1, productRequest.getProductName());
			stmt.setDouble(2, productRequest.getProductPrice());
			stmt.setInt(3, productRequest.getSellerID());
			stmt.setInt(4, productRequest.getCategoryID());
			
			logger.info("Product Added Successfully");
			
			int result=stmt.executeUpdate();
			con.close();
			if(result>0) {
				return true;
			}
			else {
				throw new ProductCreationException("Product Not Inserted with ID: "+productRequest.getProductName());
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		    logger.error("Database Error: ", e);
		}
		
		return false;
	}

	@Override
	public boolean UpdateProductById(ProductRequest productRequest) throws SQLException, ProductUpdateException {
		
		String query="UPDATE Product SET ProductName=?, ProductPrice=?, CategoryId=? WHERE SellerID=?";
		
		logger.info("Updating the Product with Seller ID{}:{}",productRequest.getProductName());
		
		try(Connection con=ConnectionFactory.getConnectionFactory().getConnection()){
			
			PreparedStatement stmt=con.prepareStatement(query);
			
			stmt.setString(1, productRequest.getProductName());
			stmt.setDouble(2, productRequest.getProductPrice());
			stmt.setInt(3, productRequest.getCategoryID());
			stmt.setInt(4, productRequest.getSellerID());
			
			logger.trace("Product Updated Successfully");
			
			int result=stmt.executeUpdate();
			
			if(result>0) {
				return true;
			}
			else throw new ProductUpdateException("Product Not Updated with Seller ID: "+productRequest.getProductName());

		}
		catch(SQLException e) {
			e.printStackTrace();
		    logger.error("Database Error: ", e);
		}
		return false;
	}

	@Override
	public boolean DeleteProductById(long id) throws SQLException, ProductDeletionException {
		
		String query="DELETE FROM Product WHERE ProductID=?";
		
		logger.info("Deleting the Product with ID : {}",id);
		try(Connection con=ConnectionFactory.getConnectionFactory().getConnection()){
			PreparedStatement stmt=con.prepareStatement(query);
			
			stmt.setLong(1, id);
			logger.info("Product Deleted");
			
			int result=stmt.executeUpdate();
			System.out.println("Rows Affected "+result);
			
			if(result>0) {
				return true;
			}
			else throw new ProductDeletionException("Product Not Deleted with ID: "+id);
		}
		catch(SQLException e) {
			e.printStackTrace();
			logger.error("Error while deleting the Product with ID:{}",id,e);
		}
		
		return false;
	}

	@Override
	public List<ProductResponse> getAllProducts() {
	    String query = "SELECT * FROM Product";
	    logger.info("Fetching all products");

	    List<ProductResponse> productResponseList = new ArrayList<>();
	    try (Connection con = ConnectionFactory.getConnectionFactory().getConnection()) {
	        PreparedStatement stmt = con.prepareStatement(query);
	        ResultSet rs = stmt.executeQuery();

	        while (rs.next()) {
	            int productID = rs.getInt("ProductID");
	            String productName = rs.getString("ProductName");
	            double productPrice = rs.getDouble("ProductPrice");
	            int sellerID = rs.getInt("SellerID");
	            int categoryID = rs.getInt("CategoryID");

	            ProductResponse product = new ProductResponse(productID, productName, productPrice, sellerID, categoryID);
	            productResponseList.add(product);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        logger.error("Error while fetching products", e);
	    }
	    return productResponseList;
	}

	
	@Override
	public boolean addProduct(ProductRequest productRequest) throws SQLException, ProductCreationException {
	    String query = "INSERT INTO Product(ProductName, ProductPrice, SellerID, CategoryId) VALUES(?,?,?,?)";
	    
	    logger.info("Adding Product: {}", productRequest.getProductName());
	    
	    try (Connection con = ConnectionFactory.getConnectionFactory().getConnection()) {
	        PreparedStatement stmt = con.prepareStatement(query);
	        
	        stmt.setString(1, productRequest.getProductName());
	        stmt.setDouble(2, productRequest.getProductPrice());
	        stmt.setInt(3,productRequest.getSellerID());
	        stmt.setInt(4, productRequest.getCategoryID());
	        
	        int result = stmt.executeUpdate();
	        
	        if (result > 0) {
	            logger.info("Product Added Successfully with ID: {}", productRequest.getProductName());
	            return true;
	        } else {
	            throw new ProductCreationException("Product Not Inserted with ID: " + productRequest.getProductName());
	        }
	    } catch (SQLException e) {
	        logger.error("Database Error while adding product: ", e);
	        throw new ProductCreationException("Error occurred while adding product with ID: " + productRequest.getProductName(), e);
	    }
	}


}
