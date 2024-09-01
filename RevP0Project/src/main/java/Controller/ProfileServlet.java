package Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import dao.UserRegistrationDAOClass;
import dto.UserRegistrationResponse;
import dto.Role;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String userEmail = req.getParameter("user_email");
        
        if (userEmail == null || userEmail.isEmpty()) {
            resp.sendRedirect("login.jsp?error=User email is missing");
            return;
        }

        try {
            UserRegistrationDAOClass userDAO = new UserRegistrationDAOClass();
            UserRegistrationResponse user = userDAO.getUserByEmail(userEmail);
            
            Role role = user.getRole(); // Assuming there's a getRole method
            if ("SELLER".equals(role)) {
                req.setAttribute("user", user);
                req.getRequestDispatcher("SellerProfile.jsp").forward(req, resp);
            } else {
                req.setAttribute("user", user);
                req.getRequestDispatcher("BuyerProfile.jsp").forward(req, resp);
            }

        } catch (Exception e) {
            e.printStackTrace();
            resp.sendRedirect("login.jsp?error=Unable to retrieve user details");
        }
    }
}