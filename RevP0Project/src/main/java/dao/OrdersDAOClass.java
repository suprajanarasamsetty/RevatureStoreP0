package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import dto.OrdersRequest;
import dto.OrdersResponse;
import exceptions.OrderCreateException;
import exceptions.OrderDeleteException;
import exceptions.OrderNotFoundException;
import utils.ConnectionFactory;


public class OrdersDAOClass implements OrdersDAO{
	
	private static final Logger logger=LoggerFactory.getLogger(OrdersDAOClass.class);

	@Override
	public OrdersResponse getOrderById(long id) throws SQLException, OrderNotFoundException {
		logger.debug("Enter into getOrderById method with ID: {}",id);
				
		String query="SELECT *FROM Orders WHERE Order_id=?";
		try(Connection con=ConnectionFactory.getConnectionFactory().getConnection()){
		PreparedStatement stmt=con.prepareStatement(query);
		
		try(ResultSet rs=stmt.executeQuery()){
			if(rs.next()) {
				Timestamp timestamp = rs.getTimestamp("Order_Date");
				LocalDateTime orderDate = timestamp != null ? timestamp.toLocalDateTime() : null;
				OrdersResponse ordersResponse=new OrdersResponse(
						rs.getInt("Order_id"),
						rs.getInt("user_id"),
						rs.getString("ShippingAddress"),
						rs.getString("BillingAddress"),
						orderDate,
						rs.getString("Order_Status"));
				
				logger.info("Order Retrieved successfully with ID: {}",id);
				
				return ordersResponse;
			}
			else {
				logger.warn("Order not found with ID: {}",id);
				throw new OrderNotFoundException("Order Not Found with ID: "+id);
			}
		}
		catch(SQLException e) {
			logger.error("SQL Error occurred while fetching Order with ID: {}",id);
			e.printStackTrace();
		}
		}
		
		return null;
	}

	@Override
	public boolean CreateOrder(OrdersRequest orderRequest) throws SQLException, OrderCreateException {
		logger.debug("Entering into CreateOrder method with ID: {}",orderRequest.getOrder_id());
		String query="INSERT INTO Orders(Order_id, user_id, ShippingAddress, BillingAddress, Order_Date, Order_Status) VALUES(?,?,?,?,?,?)";
		
		try(Connection con=ConnectionFactory.getConnectionFactory().getConnection()){
			PreparedStatement stmt=con.prepareStatement(query);
			
			stmt.setInt(1, orderRequest.getOrder_id());
			stmt.setInt(2, orderRequest.getUser_id());
			stmt.setString(3, orderRequest.getShippingAddress());
			stmt.setString(4, orderRequest.getBillingAddress());
			
            Timestamp timestamp = Timestamp.valueOf(orderRequest.getOrder_Date());
 
            stmt.setTimestamp(5, timestamp);
            
            stmt.setString(6, orderRequest.getOrder_Status());
            
            int result=stmt.executeUpdate();
            if(result>0) {
            	logger.info("Order Created successfully with ID: {}",orderRequest.getOrder_id());
            	return true;
            }
            else {
            	logger.warn("Order Not Created with ID: {}", orderRequest.getOrder_id());
            	throw new OrderCreateException("Order Not Inserted with ID: "+orderRequest.getOrder_id());
            }
		}
		catch(SQLException e) {
			logger.error("SQL Error occurred while Creating Order with ID: {}", orderRequest.getOrder_id());
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean UpateOrder(OrdersRequest orderRequest) throws SQLException {
		logger.debug("Entering into UdpateOrder method with ID: {}",orderRequest.getOrder_id());
		String query="UPDATE Orders SET user_id=?, ShippingAddress=?, BillingAddress=?, Order_Date=?, Order_Status=? WHERE Order_id=?";
		try(Connection con=ConnectionFactory.getConnectionFactory().getConnection()){
			PreparedStatement stmt=con.prepareStatement(query);
			
			stmt.setInt(1, orderRequest.getUser_id());
			stmt.setString(2, orderRequest.getShippingAddress());
			stmt.setString(3, orderRequest.getBillingAddress());
			Timestamp timestamp = Timestamp.valueOf(orderRequest.getOrder_Date());
            stmt.setTimestamp(4, timestamp);
            stmt.setString(5, orderRequest.getOrder_Status());
            stmt.setInt(6, orderRequest.getOrder_id());
            
            int result=stmt.executeUpdate();
            if(result>0) {
            	logger.info("Order Updated successfully with ID: {}",orderRequest.getOrder_id());
            	return true;
            }
		}
		catch(SQLException e) {
			logger.error("SQL Error occurred while updating order with ID: {}",orderRequest.getOrder_id());
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean DeleteOrder(long id) throws SQLException, OrderDeleteException {
		logger.debug("Entering into DeleteOrder method with ID: {}",id);
		String query="DELETE FROM Orders WHERE Order_id=?";
		
		try(Connection con=ConnectionFactory.getConnectionFactory().getConnection()){
			
			PreparedStatement stmt=con.prepareStatement(query);
			stmt.setLong(1, id);
			
			int result=stmt.executeUpdate();
			if(result>0) {
				logger.info("Order Deleted successfully with ID: {}",id);
				return true;
			}
			else {
				logger.warn("Order Not deleted with ID: {}",id);
				throw new OrderDeleteException("Order Not Deleted with ID: "+id);
			}
		}
		catch(SQLException e) {
			logger.error("SQL Error occurred while deleting Order with ID: {}",id);
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<OrdersResponse> getAllOrders() throws SQLException, OrderNotFoundException {
		logger.debug("Entering into getAllOrders method");
		String query="SELECT * FROM Orders";
		List<OrdersResponse> ordersResponse=new ArrayList<>();
		
		try(Connection con=ConnectionFactory.getConnectionFactory().getConnection()){
			PreparedStatement stmt=con.prepareStatement(query);
			
			try(ResultSet rs=stmt.executeQuery()){
				logger.info("Fetching Orders...");
				while(rs.next()) {
						int Order_id=rs.getInt("Order_id");
						int user_id=rs.getInt("user_id");
						String ShippingAddress=rs.getString("ShippingAddress");
						String BillingAddress=rs.getString("BillingAddress");
						
						Timestamp timestamp=rs.getTimestamp("Order_Date");
		                LocalDateTime orderDate = timestamp != null ? timestamp.toLocalDateTime() : null;
		                
						String Order_Status=rs.getString("Order_Status");
						
						OrdersResponse Orders =new OrdersResponse(Order_id, user_id, ShippingAddress, BillingAddress, orderDate, Order_Status);
						ordersResponse.add(Orders);
			}
				logger.info("Orders Retrieved {} Successfully",ordersResponse.size());
				return ordersResponse;
		}
			catch(SQLException e) {
				logger.error("SQL Error occurred while fetching all Orders");
				e.printStackTrace();
				throw new OrderNotFoundException("Order Not Found Exception");
			}
		}
	}

}
