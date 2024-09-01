package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import dto.SellerRequest;
import dto.SellerResponse;
import exceptions.SellerCreateException;
import exceptions.SellerNotFoundException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.SellerService;

@WebServlet("/Sellers/*")
public class SellerController extends HttpServlet {
	
	private SellerService sellerservice;
	
	public void init() {
		System.out.println("init");
		this.sellerservice = new SellerService();
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		resp.setContentType("text/html");
		
		
		PrintWriter out = resp.getWriter();
		
		System.out.println("get method is Invoked");
		
		System.out.println(req.getRequestURI().substring("RevP0Project/Sellers".length()+1));
		
		if(req.getRequestURI().substring("/RevP0Project/Sellers/".length()+1).equals("all")) {
			try {
				List<SellerResponse> sellers = sellerservice.getAllSellers();
				
				out.print("<h1>Seller Controller</h1>");
				
				for(SellerResponse s : sellers) {
					out.printf("<p>SellerID %d:</p>",s.getSellerID());
					out.printf("<p>SellerEmail %s:</p>",s.getSellerEmail());
					out.printf("<p>SellerPassword %s:</p>", s.getSellerPassword());
					out.printf("<p>Bussiness Name %s:</p>", s.getBusinessName());
					out.printf("<p>Seller BussinessDetails %s:</p>", s.getBusinessDetails());
					out.printf("<p>UserID: %d</p>",s.getUserId());

				}
			}
			catch (SQLException e) {
				e.printStackTrace();
			} catch (SellerNotFoundException e) {
				e.printStackTrace();
			}
		}
		else {
			
			Long id = Long.parseLong(req.getRequestURI().substring("/RevP0Project/Sellers/".length()));
			try {
				SellerResponse seller=sellerservice.getSellerById(id);
				
				out.println("<H1>Seller Controller</H1>");
				
				out.printf("<p>Seller ID: %d</p>", seller.getSellerID());
				out.printf("<p>Seller Email: %s</p>", seller.getSellerEmail());
				out.printf("<p>Seller Password: %s</p>", seller.getSellerPassword());
				out.printf("<p>Business Name: %s</p>", seller.getBusinessName());
				out.printf("<p>Seller Business Details: %s</p>", seller.getBusinessDetails());
				out.printf("<p>UserID : %d</p>",seller.getUserId());

			}
			catch(Exception e) {
				e.printStackTrace();
			}		
		}
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		String sellerName = req.getParameter("seller_name");
	    String sellerEmail = req.getParameter("seller_email");
	    String sellerPassword = req.getParameter("seller_password");
	    String sellerBusinessName = req.getParameter("seller_businessName");
	    String sellerBusinessDetails = req.getParameter("seller_businessDetails");
	    long userId = Long.parseLong(req.getParameter("user_id")); 

	    SellerRequest seller = new SellerRequest(sellerName, sellerEmail, sellerPassword, sellerBusinessName, sellerBusinessDetails, userId);
	    
	    try {
	        boolean response = sellerservice.CreateSeller(seller);
	        if (response) {
	            resp.getWriter().println("Seller with " + seller.getSellerEmail() + " is Created Successfully...");
	        } else {
	            resp.getWriter().println("Seller with " + seller.getSellerEmail() + " is Not Created...please check and try again");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } catch (SellerCreateException e) {
	        e.printStackTrace();
	    }
	}

}



