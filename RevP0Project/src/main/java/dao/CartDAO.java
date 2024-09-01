package dao;

import java.sql.SQLException;
import java.util.List;

import dto.CartRequest;
import dto.CartResponse;
import exceptions.CartCreateException;
import exceptions.CartDeleteException;
import exceptions.CartNotFoundException;
import exceptions.CartUpdateException;

public interface CartDAO {
	
	CartResponse getCartById(long id) throws SQLException, CartNotFoundException;
	boolean CreateCart(CartRequest cartRequest) throws SQLException, CartCreateException;
	boolean UpdateCart(CartRequest cartRequest) throws SQLException, CartUpdateException;
	boolean DeleteCart(long id) throws SQLException, CartDeleteException;
	List<CartResponse> getAllCart() throws SQLException;

}
