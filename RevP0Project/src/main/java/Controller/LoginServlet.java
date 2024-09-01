package Controller;

import dao.UserRegistrationDAOClass;
import dto.Role;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


	@WebServlet("/login/*")
	public class LoginServlet extends HttpServlet {	    
	    @Override
	    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	        String user_email = req.getParameter("user_email");
	        String user_password = req.getParameter("user_password");

	        if (user_email == null || user_password == null || user_email.isEmpty() || user_password.isEmpty()) {
	            resp.sendRedirect("login.jsp?error=Both fields are required");
	            return;
	        }

	        UserRegistrationDAOClass userDAO = new UserRegistrationDAOClass();
	        Role userRole = userDAO.authenticateRole(user_email, user_password);

	        if (userRole != null) {
	            HttpSession session = req.getSession();
	            session.setAttribute("user_email", user_email); 
	            session.setAttribute("user_role", userRole); 

	            if (userRole == Role.BUYER) {
	                resp.sendRedirect("BuyerDashboard.jsp?success=Successfully Logged in");
	            } else if (userRole == Role.SELLER) {
	                resp.sendRedirect("SellerdashBoard.jsp?success=Successfully Logged in");
	            } else {
	                resp.sendRedirect("login.jsp?error=Unknown role");
	            }
	        } else {
	            resp.sendRedirect("login.jsp?error=Invalid email or password");
	        }
	    }
}
