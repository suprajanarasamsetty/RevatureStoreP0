package service;

import java.sql.SQLException;
import java.util.List;

import dao.OrdersDAOClass;
import dto.OrdersRequest;
import dto.OrdersResponse;
import exceptions.OrderCreateException;
import exceptions.OrderDeleteException;
import exceptions.OrderNotFoundException;

public class OrdersService {
	
	private final OrdersDAOClass ordersDao;
	
	public OrdersService() {
		ordersDao =new OrdersDAOClass();
	}
	
	public OrdersResponse getOrderById(long id) throws SQLException, OrderNotFoundException {
		return ordersDao.getOrderById(id);
	}
	
	public boolean CreateOrder(OrdersRequest orderRequest) throws SQLException, OrderCreateException {
		return ordersDao.CreateOrder(orderRequest);
	}
	
	public boolean UpateOrder(OrdersRequest orderRequest) throws SQLException {
		return ordersDao.UpateOrder(orderRequest);
	}
	
	public boolean DeleteOrder(long id) throws SQLException, OrderDeleteException {
		return ordersDao.DeleteOrder(id);
	}
	
	public List<OrdersResponse> getAllOrders() throws SQLException, OrderNotFoundException {
		return ordersDao.getAllOrders();
	}
	
	public static void main(String[] args) throws SQLException, OrderNotFoundException {
		OrdersService os=new OrdersService();
		
		//for updating the order

		
		//for deleting the order
		//System.out.println(os.DeleteOrder(1));
		
		//for inserting values in order
		//System.out.println(os.CreateOrder(new OrdersRequest(1, 1, "123 Elm St, Springfield, IL, 62704", "123 Elm St, Springfield, IL, 62704", LocalDateTime.now(), "Processing")));
		
		//System.out.println(os.CreateOrder(new OrdersRequest(2, 2, "456 Maple Ave, Austin, TX, 73301", "789 Oak St, Dallas, TX, 75001", LocalDateTime.now(), "Shipped")));
		//System.out.println(os.CreateOrder(new OrdersRequest(3, 3, "101 Pine St, Denver, CO, 80201", "202 Birch St, Boulder, CO, 80301", LocalDateTime.now(), "Cancelled")));
		
		//System.out.println(os.CreateOrder(new OrdersRequest(4, 4, "202 Birch St, Miami, FL, 33101", "202 Birch St, Miami, FL, 33101", LocalDateTime.now(), "Processing\r\n"
		//		+ "")));
		//System.out.println(os.CreateOrder(new OrdersRequest(5, 1, "404 Willow St, San Francisco, CA, 94101", "505 Aspen Rd, Oakland, CA, 94601", LocalDateTime.now(), "Delivered")));
		//System.out.println(os.CreateOrder(new OrdersRequest(6, 3, "606 Fir St, Boston, MA, 02101", "606 Fir St, Boston, MA, 02101", LocalDateTime.now(), "Processing")));
		//System.out.println(os.CreateOrder(new OrdersRequest(7, 5, "707 Redwood Blvd, Los Angeles, CA, 90001", "808 Redwood Blvd, Los Angeles, CA, 90001", LocalDateTime.now(), "Shipped")));
		//System.out.println(os.CreateOrder(new OrdersRequest(8, 6, "9-398, Konthamuru, Rajahmundry, 533102", "9-398, Konthamuru, Rajahmundry, 533102", LocalDateTime.now(), "Delivered")));
		
		List<OrdersResponse> Order= os.getAllOrders();
		
		for(OrdersResponse order : Order) {
			System.out.println(order.toString());
		}
	}


}
