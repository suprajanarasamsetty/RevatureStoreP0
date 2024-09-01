package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import dto.Role;
import dto.UserRegistrationRequest;
import dto.UserRegistrationResponse;
import exceptions.UserCreationException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.UserRegistrationService;

@WebServlet("/Users/*")
public class UserController extends HttpServlet {
    private UserRegistrationService userService;

    public void init() {
        System.out.println("init");
        this.userService = new UserRegistrationService();
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        try {
            String path = req.getRequestURI();
            String action = path.substring("/RevP0Project/Users/".length());

            out.println("<H1>Users Controller</H1>");

            if ("all".equals(action)) {
                try {
                    List<UserRegistrationResponse> users = userService.getAllUsers();

                    for (UserRegistrationResponse user : users) {
                        out.printf("<p>ID: %d</p>", user.getUser_id());
                        out.printf("<p>First Name: %s</p>", user.getUser_first_name());
                        out.printf("<p>Last Name: %s</p>", user.getUser_last_name());
                        out.printf("<p>Email: %s</p>", user.getUser_email());
                        out.printf("<p>Password: %s</p>", user.getUser_password());
                        out.printf("<p>Phone Number: %d</p>", user.getUser_phonenumber());
                        out.printf("<p>Address: %s</p>", user.getUser_address());
                        out.printf("<p>Role: %s</p>", user.getRole()); // Display role
                        out.println("<hr>");
                    }
                } catch (Exception e) {
                    resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                    out.println("<p>An error occurred while retrieving users.</p>");
                    e.printStackTrace();
                }
            } else {
                Long id;
                try {
                    id = Long.parseLong(action);
                } catch (NumberFormatException e) {
                    resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                    out.println("<p>Invalid user ID format.</p>");
                    return;
                }

                try {
                    UserRegistrationResponse user = userService.getUserById(id);

                    out.printf("<p>ID: %d</p>", user.getUser_id());
                    out.printf("<p>First Name: %s</p>", user.getUser_first_name());
                    out.printf("<p>Last Name: %s</p>", user.getUser_last_name());
                    out.printf("<p>Email: %s</p>", user.getUser_email());
                    out.printf("<p>Password: %s</p>", user.getUser_password());
                    out.printf("<p>Phone Number: %d</p>", user.getUser_phonenumber());
                    out.printf("<p>Address: %s</p>", user.getUser_address());
                    out.printf("<p>Role: %s</p>", user.getRole()); // Display role
                } catch (Exception e) {
                    resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                    out.println("<p>An error occurred while retrieving the user.</p>");
                    e.printStackTrace();
                }
            }
        } finally {
            out.close();
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String user_first_name = req.getParameter("user_first_name");
        String user_last_name = req.getParameter("user_last_name");
        String user_email = req.getParameter("user_email");
        String user_password = req.getParameter("user_password");
        Long user_phonenumber = Long.parseLong(req.getParameter("user_phonenumber"));
        String user_address = req.getParameter("user_address");
        String roleStr = req.getParameter("role");

        if (roleStr == null) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.getWriter().println("Role must be specified.");
            return;
        }

        Role role;
        try {
            role = Role.valueOf(roleStr.toUpperCase());
        } catch (IllegalArgumentException e) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.getWriter().println("Invalid role specified.");
            return;
        }

        UserRegistrationRequest user = new UserRegistrationRequest(
            user_first_name,
            user_last_name,
            user_email,
            user_password,
            user_phonenumber,
            user_address,
            role
        );

        try {
            boolean response = userService.CreateUser(user);
            if (response) {
                resp.setStatus(HttpServletResponse.SC_OK);
                resp.getWriter().println("User with " + user.getUser_email() + " is Created Successfully...");
            } else {
                resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                resp.getWriter().println("User with " + user.getUser_email() + " is Not Created... please check and try again.");
            }
        } catch (SQLException e) {
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            resp.getWriter().println("Database error occurred while creating user.");
            e.printStackTrace();
        } catch (UserCreationException e) {
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            resp.getWriter().println("User creation error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
