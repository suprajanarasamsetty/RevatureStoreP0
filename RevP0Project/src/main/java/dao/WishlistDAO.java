package dao;

import java.sql.SQLException;
import java.util.List;

import dto.WishlistRequest;
import dto.WishlistResponse;
import exceptions.WishlistCreateException;
import exceptions.WishlistDeleteException;
import exceptions.WishlistNotFoundException;
import exceptions.WishlistUpdateException;

public interface WishlistDAO {
	WishlistResponse getWishlistById(long id) throws SQLException, WishlistNotFoundException;
	boolean CreateWishlist(WishlistRequest wishlistRequest) throws WishlistCreateException;
	boolean UpdateWishlist(WishlistRequest wishlistRequest) throws WishlistUpdateException;
	boolean DeleteWishlistById(long id) throws WishlistDeleteException;
	List<WishlistResponse> getAllWishlistById();

}
