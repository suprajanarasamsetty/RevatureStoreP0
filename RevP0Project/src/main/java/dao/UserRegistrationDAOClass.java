package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import ch.qos.logback.classic.Logger;
import dto.Role;
import dto.UserRegistrationRequest;
import dto.UserRegistrationResponse;
import exceptions.UserCreationException;
import exceptions.UserDeleteException;
import exceptions.UserNotFoundException;
import exceptions.UserUpdateException;
import utils.ConnectionFactory;

public class UserRegistrationDAOClass implements UserRegistrationDAO {

    private static final Logger logger = (Logger) LoggerFactory.getLogger(UserRegistrationDAOClass.class);

    @Override
    public UserRegistrationResponse getUserById(long id) throws SQLException, UserNotFoundException {
        logger.debug("Enter getUserById method with id: {}", id);

        MDC.put("user_id", String.valueOf(id));

        String query = "SELECT * FROM user_registration WHERE user_id=?";
        try (Connection con = ConnectionFactory.getConnectionFactory().getConnection()) {
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setLong(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Role role = Role.valueOf(rs.getString("role")); // Fetch role
                    UserRegistrationResponse userRegistrationResponse = new UserRegistrationResponse(
                            rs.getInt("user_id"),
                            rs.getString("user_first_name"),
                            rs.getString("user_last_name"),
                            rs.getString("user_email"),
                            rs.getString("user_password"),
                            rs.getLong("user_phonenumber"),
                            rs.getString("user_address"),
                            role // Assign role
                    );

                    logger.info("User Retrieved Successfully");
                    return userRegistrationResponse;
                } else {
                    logger.warn("User not Found with ID: {}", id);
                    throw new UserNotFoundException("User Not Found With ID: " + id);
                }
            }
        } catch (SQLException e) {
            logger.error("SQL Error while fetching user with ID: {}", id);
            e.printStackTrace();
        } finally {
            MDC.remove("user_id");
        }
        return null;
    }

    @Override
    public boolean CreateUser(UserRegistrationRequest userRegistrationRequest) throws UserCreationException {
        logger.debug("Entering CreateUser method with request: {}", userRegistrationRequest);
        String query = "INSERT INTO user_registration(user_first_name, user_last_name, user_email, user_password, user_phonenumber, user_address, role) VALUES(?,?,?,?,?,?,?)";

        try (Connection con = ConnectionFactory.getConnectionFactory().getConnection()) {
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, userRegistrationRequest.getUser_first_name());
            stmt.setString(2, userRegistrationRequest.getUser_last_name());
            stmt.setString(3, userRegistrationRequest.getUser_email());
            stmt.setString(4, userRegistrationRequest.getUser_password());
            stmt.setLong(5, userRegistrationRequest.getUser_phonenumber());
            stmt.setString(6, userRegistrationRequest.getUser_address());
            stmt.setString(7, userRegistrationRequest.getRole().name()); // Set role

            int result = stmt.executeUpdate();
            if (result > 0) {
                return true;
            } else {
                logger.warn("Failed to Create user with Email: {}", userRegistrationRequest.getUser_email());
                throw new UserCreationException("User Not Created with Email: " + userRegistrationRequest.getUser_email());
            }

        } catch (SQLException e) {
            logger.error("SQL Error while creating user with Email: {}", userRegistrationRequest.getUser_email());
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean UpdateUser(UserRegistrationRequest userRegistrationRequest) throws SQLException, UserUpdateException {
        logger.debug("Entering UpdateUser method with request: {}", userRegistrationRequest);

        String query = "UPDATE user_registration SET user_first_name=?, user_last_name=?, user_email=?, user_password=?, user_phonenumber=?, user_address=?, role=? WHERE user_id=?";

        try (Connection con = ConnectionFactory.getConnectionFactory().getConnection()) {
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, userRegistrationRequest.getUser_first_name());
            stmt.setString(2, userRegistrationRequest.getUser_last_name());
            stmt.setString(3, userRegistrationRequest.getUser_email());
            stmt.setString(4, userRegistrationRequest.getUser_password());
            stmt.setLong(5, userRegistrationRequest.getUser_phonenumber());
            stmt.setString(6, userRegistrationRequest.getUser_address());
            stmt.setString(7, userRegistrationRequest.getRole().name()); 

            int result = stmt.executeUpdate();

            if (result > 0) {
                logger.info("User Updated Successfully with Email: {}", userRegistrationRequest.getUser_email());
                return true;
            } else {
                logger.warn("Failed to Update user with Email: {}", userRegistrationRequest.getUser_email());
                throw new UserUpdateException("User Not Updated with Email: " + userRegistrationRequest.getUser_email());
            }
        } catch (SQLException e) {
            logger.error("SQL Error while updating user with Email: {}", userRegistrationRequest.getUser_email());
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean DeleteUser(long id) throws UserDeleteException {
        logger.debug("Entering DeleteUser method with id: {}", id);
        String query = "DELETE FROM user_registration WHERE user_id = ?";
        try (Connection con = ConnectionFactory.getConnectionFactory().getConnection()) {
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setLong(1, id);

            int result = stmt.executeUpdate();
            if (result > 0) {
                logger.info("User deleted successfully with ID: {}", id);
                return true;
            } else {
                logger.warn("Failed to delete user with ID: {}", id);
                throw new UserDeleteException("User not deleted with ID: " + id);
            }
        } catch (SQLException e) {
            logger.error("SQL Error while deleting user with ID: {}", id);
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<UserRegistrationResponse> getAllUsers() throws SQLException {
        logger.debug("Entering getAllUsers method");

        String query = "SELECT * FROM user_registration";

        List<UserRegistrationResponse> userRegistrationResponse = new ArrayList<>();

        try (Connection con = ConnectionFactory.getConnectionFactory().getConnection()) {
            PreparedStatement stmt = con.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int user_id = rs.getInt("user_id");
                String user_first_name = rs.getString("user_first_name");
                String user_last_name = rs.getString("user_last_name");
                String user_email = rs.getString("user_email");
                String user_password = rs.getString("user_password");
                long user_phonenumber = rs.getLong("user_phonenumber");
                String user_address = rs.getString("user_address");
                Role role = Role.valueOf(rs.getString("role")); // Fetch role

                UserRegistrationResponse user = new UserRegistrationResponse(user_id, user_first_name, user_last_name, user_email, user_password, user_phonenumber, user_address, role);

                userRegistrationResponse.add(user);
            }
            logger.info("Retrieved {} users", userRegistrationResponse.size());
            return userRegistrationResponse;

        } catch (SQLException e) {
            logger.error("SQL Error while retrieving all users");
            e.printStackTrace();
        }
        return null;
    }
    
    @Override
    public UserRegistrationResponse getUserByEmail(String email) throws SQLException {
        UserRegistrationResponse userRegistrationResponse = null;
        String query = "SELECT * FROM user_registration WHERE user_email = ?";

        try (Connection con = ConnectionFactory.getConnectionFactory().getConnection();
             PreparedStatement stmt = con.prepareStatement(query)) {

            stmt.setString(1, email);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    // Convert roleString to Role enum
                    String roleString = rs.getString("role");
                    Role role = Role.valueOf(roleString.toUpperCase());

                    // Create UserRegistrationResponse object
                    userRegistrationResponse = new UserRegistrationResponse(
                        rs.getInt("user_id"),
                        rs.getString("user_first_name"),
                        rs.getString("user_last_name"),
                        rs.getString("user_email"),
                        rs.getString("user_password"),
                        rs.getLong("user_phonenumber"),
                        rs.getString("user_address"),
                        role
                    );
                }
            }
        }
        return userRegistrationResponse;
    }

        
    public Role authenticateRole(String email, String password) {
        String query = "SELECT role FROM user_registration WHERE user_email = ? AND user_password = ?";
        try (Connection con = ConnectionFactory.getConnectionFactory().getConnection();
             PreparedStatement stmt = con.prepareStatement(query)) {

            stmt.setString(1, email);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String roleString = rs.getString("role");

                try {
                    return Role.valueOf(roleString.toUpperCase());
                } catch (IllegalArgumentException e) {
                    return null;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; 
    }
}
