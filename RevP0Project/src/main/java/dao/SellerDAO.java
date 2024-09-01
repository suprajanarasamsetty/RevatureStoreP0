package dao;

import java.sql.SQLException;
import java.util.List;

import dto.SellerRequest;
import dto.SellerResponse;
import exceptions.SellerCreateException;
import exceptions.SellerDeleteException;
import exceptions.SellerNotFoundException;
import exceptions.SellerUpdateException;

public interface SellerDAO {
	
	SellerResponse getSellerById(long id) throws SQLException, SellerNotFoundException;
	boolean CreateSeller(SellerRequest sellerRequest) throws SQLException, SellerCreateException;
	boolean UpdateSeller(SellerRequest sellerRequest) throws SQLException, SellerUpdateException;
	boolean DeleteSeller(long id) throws SQLException, SellerDeleteException;
	List<SellerResponse> getAllSellers() throws SQLException, SellerNotFoundException;

}
