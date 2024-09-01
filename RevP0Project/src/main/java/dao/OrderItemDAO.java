package dao;

import java.sql.SQLException;
import java.util.List;

import dto.OrderItemRequest;
import dto.OrderItemResponse;
import exceptions.OrderItemCreateException;
import exceptions.OrderItemDeleteException;
import exceptions.OrderItemNotFoundException;
import exceptions.OrderItemUpdateException;

public interface OrderItemDAO {
	
	OrderItemResponse getOrderItemById(long id) throws SQLException, OrderItemNotFoundException;
	boolean CreateOrderItem(OrderItemRequest orderItemRequest) throws SQLException, OrderItemCreateException;
	boolean UpdateOrderItem(OrderItemRequest orderItemRequest) throws SQLException, OrderItemUpdateException;
	boolean DeleteOrderItem(long id) throws SQLException, OrderItemDeleteException;
	List<OrderItemResponse> getAllOrderItems() throws SQLException, OrderItemNotFoundException;

}
