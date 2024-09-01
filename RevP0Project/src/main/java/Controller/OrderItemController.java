package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import dto.OrderItemRequest;
import dto.OrderItemResponse;
import dto.UserRegistrationResponse;
import exceptions.OrderItemCreateException;
import exceptions.OrderItemNotFoundException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.OrderItemService;

@WebServlet("/OrderItems/*")
public class OrderItemController extends HttpServlet {
    private OrderItemService orderItemService;

    public void init() {
        System.out.println("init");
        this.orderItemService = new OrderItemService();
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        System.out.println("GET method invoked for OrderItems");
        
        System.out.println(req.getRequestURI().substring("/RevP0Project/OrderItems/".length()+1));
        
        if (req.getRequestURI().substring("/RevP0Project/OrderItems/".length()+1).equals("all")) {
            try {
                List<OrderItemResponse> orderItems = orderItemService.getAllOrderItems();
                
                out.println("<H1>Order Items Controller</H1>");
                
                for (OrderItemResponse orderItem : orderItems) {
                    out.printf("<p>ID: %d</p>", orderItem.getOrderItemID());
                    out.printf("<p>Order ID: %d</p>", orderItem.getOrder_id());
                    out.printf("<p>Product ID: %d</p>", orderItem.getProductID());
                    out.printf("<p>Quantity: %d</p>", orderItem.getQuantity());
                    out.printf("<p>Price: %f</p>", orderItem.getPrice());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
        	
    		Long id=Long.parseLong(req.getRequestURI().substring("/RevP0Project/OrderItems/".length()));

            try {
                OrderItemResponse orderItem = orderItemService.getOrderItemById(id);

                out.println("<H1>Order Item Details</H1>");
                
                out.printf("<p>ID: %d</p>", orderItem.getOrderItemID());
                out.printf("<p>Order ID: %d</p>", orderItem.getOrder_id());
                out.printf("<p>Product ID: %d</p>", orderItem.getProductID());
                out.printf("<p>Quantity: %d</p>", orderItem.getQuantity());
                out.printf("<p>Price: %f</p>", orderItem.getPrice());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException 
    {
    	int orderItemID = Integer.parseInt(req.getParameter("orderItemId"));
        int order_id = Integer.parseInt(req.getParameter("order_id"));
        int productId = Integer.parseInt(req.getParameter("product_id"));
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        double price = Double.parseDouble(req.getParameter("price"));

        OrderItemRequest orderItemRequest = new OrderItemRequest(orderItemID, order_id, productId, quantity, price);

        try {
            boolean response = orderItemService.CreateOrderItem(orderItemRequest);
            if (response) {
                resp.getWriter().println("Order Item created successfully.");
            } else {
                resp.getWriter().println("Failed to create Order Item.");
            }
        } catch (SQLException | OrderItemCreateException e) {
            e.printStackTrace();
        }
    }
}
