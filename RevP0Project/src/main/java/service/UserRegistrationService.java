package service;

import java.sql.SQLException;
import java.util.List;

import dao.UserRegistrationDAOClass;
import dto.UserRegistrationRequest;
import dto.UserRegistrationResponse;
import exceptions.UserCreationException;
import exceptions.UserDeleteException;
import exceptions.UserNotFoundException;
import exceptions.UserUpdateException;

public class UserRegistrationService {
	
	private final UserRegistrationDAOClass userRegistrationDao;
		
		public UserRegistrationService() {
			userRegistrationDao =new UserRegistrationDAOClass();
		}
		public UserRegistrationResponse getUserById(long id) throws UserNotFoundException, SQLException{
			return userRegistrationDao.getUserById(id);
		}
		
		public boolean DeleteUser(long id) throws UserDeleteException {
			return userRegistrationDao.DeleteUser(id);
		}			
		
		public boolean UpdateUser(UserRegistrationRequest userRegistrationRequest) throws SQLException, UserUpdateException {
			return userRegistrationDao.UpdateUser(userRegistrationRequest);
			
		}
		public boolean CreateUser(UserRegistrationRequest userRegistrationRequest) throws SQLException, UserCreationException {
			return userRegistrationDao.CreateUser(userRegistrationRequest);
			
		}
		public List<UserRegistrationResponse> getAllUsers() throws SQLException, UserNotFoundException{
			return userRegistrationDao.getAllUsers();
		}
		
		
		public static void main(String[] args) throws SQLException, UserCreationException {
			UserRegistrationService urs=new UserRegistrationService();
			
			//System.out.println(urs.getUserById(5));
			
			//for Updating the user
//			System.out.println(urs.UpdateUser(new UserRegistrationRequest(1, "Raheem", "Sheik", "babulal@gmail.com", "babulal123", 949479728, "Konthamuru, Rajahmundry")));
			
			//for inserting values in user_registration table
//			System.out.println(urs.CreateUser(new UserRegistrationRequest(1, "Suneel", "Karri", "suneel@gmail.com", "suneel@123", 730663981, "Bobbili, Visakhapatnam")));
			//System.out.println(urs.CreateUser(new UserRegistrationRequest(6, "kiran", "Kammidi", "kammidikiran@gmail.com", "KiranSindhu", 759425865, "Lalacheruvu, Rajahmundry")));
//			System.out.println(urs.CreateUser(new UserRegistrationRequest(3, "Emily", "Johnson", "emily.johnson@example.com", "EmilyJohn@123", 345-678-9012, "789 Pine St, Somewhere, USA"
//					+ "")));
//			System.out.println(urs.CreateUser(new UserRegistrationRequest(4, "Michael", "Brown", "michael.brown@example.com", "Michael@4455", 456-789-0123, "101 Maple Ave, Cityville, USA")));
//			System.out.println(urs.CreateUser(new UserRegistrationRequest(5, "Olivia", "Davis", "olivia.davis@example.com", "Olivia$554", 567-890-1234, "202 Oak St, Townsville, USA")));
			
			//for fetching the values from user table
			List<UserRegistrationResponse> user=urs.getAllUsers();
			
			for(UserRegistrationResponse User:user) {
				System.out.println(User.toString());
				
			}
								
		}

}
