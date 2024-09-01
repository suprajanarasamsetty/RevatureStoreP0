package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

import dto.OrdersRequest;
import dto.OrdersResponse;
import exceptions.OrderCreateException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.OrdersService;

@WebServlet("/Orders/*")
public class OrdersController {
	
	private OrdersService orderService;
	
	public void init() {
		System.out.println("init");
		this.orderService=new OrdersService();
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		resp.setContentType("text/html");
		
		PrintWriter out=resp.getWriter();
		
		System.out.println("Get method invoked");
		
		System.out.println(req.getRequestURI().substring("/RevP0Project/Orders/".length()+1));
		
		if(req.getRequestURI().substring("/RevP0Project/Orders/".length()).equals("all")) {
			try {
				List<OrdersResponse> orders=orderService.getAllOrders();
				
				out.println("<H1> Orders Controller </H1>");
				
				for(OrdersResponse order:orders) {
					out.printf("<p>Order ID: %d</p>", order.getOrder_id());
                    out.printf("<p>User ID: %d</p>", order.getUser_id());
                    out.printf("<p>Shipping Address: %s</p>", order.getShippingAddress());
                    out.printf("<p>Billing Address: %s</p>", order.getBillingAddress());
                    out.printf("<p>Order Date: %s</p>", order.getOrder_Date());
                    out.printf("<p>Order Status: %s</p>", order.getOrder_Status());
					
				}
				
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		else {
			Long id=Long.parseLong(req.getRequestURI().substring("/RevP0Project/Orders/".length()));
			
			try {
				
				OrdersResponse Order=orderService.getOrderById(id);
				
				out.println("<H1> Orders Controller<H1>");
				
					out.printf("<p>Order ID: %d</p>", Order.getOrder_id());
                    out.printf("<p>User ID: %d</p>", Order.getUser_id());
                    out.printf("<p>Shipping Address: %s</p>", Order.getShippingAddress());
                    out.printf("<p>Billing Address: %s</p>", Order.getBillingAddress());
                    out.printf("<p>Order Date: %s</p>", Order.getOrder_Date());
                    out.printf("<p>Order Status: %s</p>", Order.getOrder_Status());
					
				}
			catch(Exception e) {
				e.printStackTrace();
				
			}
		}

	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, OrderCreateException {
		
		int Order_id=Integer.parseInt(req.getParameter("Order_id"));
		int user_id=Integer.parseInt(req.getParameter("user_id"));
		String ShippingAddress=req.getParameter("ShippingAddress");
		String BillingAddress=req.getParameter("BillingAddress");
		
		 String Order_Date = req.getParameter("Order_Date");
         LocalDateTime orderDate = LocalDateTime.parse(Order_Date);
         
		String Order_Status=req.getParameter("Order_Status");
		
		OrdersRequest orderRequest=new OrdersRequest(Order_id, user_id, ShippingAddress, BillingAddress, orderDate, Order_Status);
		
		try {
			boolean response=orderService.CreateOrder(orderRequest);
			if(response)
			resp.getWriter().println("Order "+orderRequest.getOrder_id()+" Created Successfully..");
			else
			resp.getWriter().println("Order "+orderRequest.getOrder_id()+" is not Created please check and try again..");

		}
		
		catch (SQLException e) {
			e.printStackTrace();
		} 
		catch (OrderCreateException e) {
			e.printStackTrace();
		}
	}

}
