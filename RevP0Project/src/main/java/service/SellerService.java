package service;

import java.sql.SQLException;
import java.util.List;

import dao.SellerDAOClass;
import dto.SellerRequest;
import dto.SellerResponse;
import exceptions.SellerCreateException;
import exceptions.SellerNotFoundException;
import exceptions.SellerUpdateException;

public class SellerService {
	
	private final SellerDAOClass sellerDao;
	
		public SellerService() {
			sellerDao =new SellerDAOClass();
		}
		
		public SellerResponse getSellerById(long id) throws SQLException, SellerNotFoundException {
			return sellerDao.getSellerById(id);
		}

		public boolean CreateSeller(SellerRequest sellerRequest) throws SQLException, SellerCreateException {
			return sellerDao.CreateSeller(sellerRequest);
		}
		
		public boolean UpdateSeller(SellerRequest sellerRequest) throws SQLException, SellerUpdateException {
			return sellerDao.UpdateSeller(sellerRequest);
		}

		public List<SellerResponse> getAllSellers() throws SQLException, SellerNotFoundException {
			return sellerDao.getAllSellers();
		}
		 
		public static void main(String[] args) throws SQLException, SellerNotFoundException {
			SellerService ss=new SellerService();
			
			
			//for fetching values in Seller table
			List<SellerResponse> sr=ss.getAllSellers();
				for(SellerResponse Sellers:sr) {
					System.out.println(Sellers.toString());
				}
			}
		
	}
