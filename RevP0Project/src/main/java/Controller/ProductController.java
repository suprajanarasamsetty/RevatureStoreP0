package Controller;

import service.ProductService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import dto.ProductRequest;
import dto.ProductResponse;

@WebServlet("/Product")
public class ProductController extends HttpServlet {

    private ProductService productService;

    @Override
    public void init() throws ServletException {
        productService = new ProductService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if ("viewProducts".equalsIgnoreCase(action)) {
            try {
                List<ProductResponse> products = productService.getAllProducts();

                // Debugging
                System.out.println("Products fetched: " + (products != null ? products.size() : "null"));
                
                req.setAttribute("products", products);
                req.getRequestDispatcher("Buyerproducts.jsp").forward(req, resp);
            } catch (Exception e) {
                e.printStackTrace();
                resp.getWriter().println("Error fetching products: " + e.getMessage());
            }
        } else if ("add".equalsIgnoreCase(action)) {
            req.getRequestDispatcher("addProduct.jsp").forward(req, resp);
        } else {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }
    
   
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String productName = req.getParameter("productName");
            double productPrice = Double.parseDouble(req.getParameter("productPrice"));
            int sellerId = Integer.parseInt(req.getParameter("sellerId"));
            int categoryId = Integer.parseInt(req.getParameter("categoryId"));

            ProductRequest productRequest = new ProductRequest(productName, productPrice, sellerId, categoryId);
            boolean response = productService.addProduct(productRequest);

            if (response) {
                resp.sendRedirect("SellerdashBoard.jsp?success=true");
            } else {
                resp.getWriter().println("Product " + productRequest.getProductName() + " creation failed.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().println("Error: " + e.getMessage());
        }
    }
    
}
