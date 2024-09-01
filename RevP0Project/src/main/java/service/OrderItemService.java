package service;

import java.sql.SQLException;
import java.util.List;

import dao.OrderItemDAOClass;
import dto.OrderItemRequest;
import dto.OrderItemResponse;
import exceptions.OrderItemCreateException;
import exceptions.OrderItemDeleteException;
import exceptions.OrderItemNotFoundException;
import exceptions.OrderItemUpdateException;

public class OrderItemService {
	
	private final OrderItemDAOClass orderItemDao;
	
	public OrderItemService() {
		orderItemDao=new OrderItemDAOClass();
	}
	
	public OrderItemResponse getOrderItemById(long id) throws SQLException, OrderItemNotFoundException {
		return orderItemDao.getOrderItemById(id);
	}
	
	public boolean CreateOrderItem(OrderItemRequest orderItemRequest) throws SQLException, OrderItemCreateException {
		return orderItemDao.CreateOrderItem(orderItemRequest);
	}
	
	public boolean UpdateOrderItem(OrderItemRequest orderItemRequest) throws SQLException, OrderItemUpdateException {
		return orderItemDao.UpdateOrderItem(orderItemRequest);
	}
	
	public boolean DeleteOrderItem(long id) throws SQLException, OrderItemDeleteException {
		return orderItemDao.DeleteOrderItem(id);
	}
	
	public List<OrderItemResponse> getAllOrderItems() throws SQLException, OrderItemNotFoundException {
		return orderItemDao.getAllOrderItems();
	}
	
	public static void main(String[] args) throws SQLException, OrderItemCreateException, OrderItemNotFoundException {
		OrderItemService OrderItem=new OrderItemService();
		
	
		//System.out.println(OrderItem.CreateOrderItem(new OrderItemRequest(9, 2, 0, 0, 0)));
		
		List<OrderItemResponse> OrderList=OrderItem.getAllOrderItems();
		
		for(OrderItemResponse Orders : OrderList) {
			System.out.println(Orders.toString());
		}
		
	}



}
