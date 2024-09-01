package dao;

import java.sql.SQLException;
import java.util.List;

import dto.OrdersRequest;
import dto.OrdersResponse;
import exceptions.OrderCreateException;
import exceptions.OrderDeleteException;
import exceptions.OrderNotFoundException;

public interface OrdersDAO {
	
	OrdersResponse getOrderById(long id) throws SQLException, OrderNotFoundException;
	boolean CreateOrder(OrdersRequest orderRequest) throws SQLException, OrderCreateException;
	boolean UpateOrder(OrdersRequest orderRequest) throws SQLException;
	boolean DeleteOrder(long id) throws SQLException, OrderDeleteException;
	List<OrdersResponse> getAllOrders() throws SQLException, OrderNotFoundException;

}
