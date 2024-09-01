package dao;

import java.sql.SQLException;
import java.util.List;

import dto.UserRegistrationRequest;
import dto.UserRegistrationResponse;
import exceptions.UserCreationException;
import exceptions.UserDeleteException;
import exceptions.UserNotFoundException;
import exceptions.UserUpdateException;


public interface UserRegistrationDAO {
	
	UserRegistrationResponse getUserById(long id) throws SQLException, UserNotFoundException;
	boolean CreateUser(UserRegistrationRequest userRegistrationRequest) throws UserCreationException;
	boolean UpdateUser(UserRegistrationRequest userRegistrationRequest) throws SQLException, UserUpdateException;
	boolean DeleteUser(long id) throws UserDeleteException;
	List<UserRegistrationResponse> getAllUsers() throws SQLException, UserNotFoundException;
	UserRegistrationResponse getUserByEmail(String email) throws SQLException; 

}
