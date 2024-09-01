package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import dto.CartRequest;
import dto.CartResponse;
import exceptions.CartCreateException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.CartService;

@WebServlet("/Carts/*")
public class CartController extends HttpServlet {
    private CartService cartService;

    public void init() {
        System.out.println("init");
        this.cartService = new CartService();
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();

        System.out.println("Get method invoked for Carts");

		System.out.println(req.getRequestURI().substring("/RevP0Project/Carts/".length()+1));

        if (req.getRequestURI().substring("/RevP0Project/Carts/".length()+1).equals("all")) {
            try {
                List<CartResponse> carts = cartService.getAllCart();

                out.println("<H1>Carts Controller</H1>");

                for (CartResponse cart : carts) {
                    out.printf("<p>ID: %d</p>", cart.getCartID());
                    out.printf("<p>User ID: %d</p>", cart.getUserId());
                    out.printf("<p>Product ID: %d</p>", cart.getProductID());
                    out.printf("<p>Total Price: %.2f</p>", cart.getTotalPrice());
                    out.printf("<p>Quantity: %d</p>", cart.getQuantity());
                    out.printf("<p>Discount Coupon: %s</p>", cart.getDiscountCoupon());
                    }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
    		Long id=Long.parseLong(req.getRequestURI().substring("/RevP0Project/Carts/".length()));

            try {
                CartResponse cart = cartService.getCartById(id);

                out.println("<H1>Carts Controller</H1>");

                out.printf("<p>ID: %d</p>", cart.getCartID());
                out.printf("<p>User ID: %d</p>", cart.getUserId());
                out.printf("<p>Product ID: %d</p>", cart.getProductID());
                out.printf("<p>Total Price: %.2f</p>", cart.getTotalPrice());
                out.printf("<p>Quantity: %d</p>", cart.getQuantity());
                out.printf("<p>Discount Coupon: %s</p>", cart.getDiscountCoupon());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException 
    {
        int user_id = Integer.parseInt(req.getParameter("user_id"));
        int product_id = Integer.parseInt(req.getParameter("product_id"));
        double total_price = Double.parseDouble(req.getParameter("total_price"));
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        String discount_coupon = req.getParameter("discount_coupon");

        CartRequest cart = new CartRequest(user_id,product_id,total_price,quantity,discount_coupon);
        try {
            boolean response = cartService.CreateCart(cart);
            if (response)
                resp.getWriter().println("Cart with Product ID " + product_id + " is Created Successfully...");
            else
                resp.getWriter().println("Cart with Product ID " + product_id + " is Not Created...please check and try again");

        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        } 
        catch (CartCreateException e) 
        {
            e.printStackTrace();
        }
    }
    }