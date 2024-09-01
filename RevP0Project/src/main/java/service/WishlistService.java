package service;

import java.sql.SQLException;
import java.util.List;

import dao.WishlistDAOClass;
import dto.WishlistRequest;
import dto.WishlistResponse;
import exceptions.WishlistCreateException;
import exceptions.WishlistDeleteException;
import exceptions.WishlistNotFoundException;
import exceptions.WishlistUpdateException;

public class WishlistService {
	
	private final WishlistDAOClass wishlistDao;
	
	
	public WishlistService() {
		wishlistDao=new WishlistDAOClass();
	}

	public WishlistResponse getWishlistById(long id) throws SQLException, WishlistNotFoundException {
		return wishlistDao.getWishlistById(id);
	}
	
	public boolean CreateWishlist(WishlistRequest wishlistRequest) throws WishlistCreateException {
		return wishlistDao.CreateWishlist(wishlistRequest);
	}
	
	public boolean UpdateWishlist(WishlistRequest wishlistRequest) throws WishlistUpdateException {
		return wishlistDao.UpdateWishlist(wishlistRequest);
	}
	
	public boolean DeleteWishlistById(long id) throws WishlistDeleteException {
		return wishlistDao.DeleteWishlistById(id);
	}
	
	public List<WishlistResponse> getAllWishlistById() {
		return wishlistDao.getAllWishlistById();
	}
	
	public static void main(String[] args) {
		WishlistService ws=new WishlistService();
		
//		System.out.println(ws.CreateWishlist(new WishlistRequest(1, 1, 4)));
//		System.out.println(ws.CreateWishlist(new WishlistRequest(2, 2, 9)));
//		System.out.println(ws.CreateWishlist(new WishlistRequest(3, 3, 18)));
//		System.out.println(ws.CreateWishlist(new WishlistRequest(4, 4, 17)));
//		System.out.println(ws.CreateWishlist(new WishlistRequest(5, 5, 5)));
//		System.out.println(ws.CreateWishlist(new WishlistRequest(6, 6, 7)));
		
		List<WishlistResponse> Wishlist=ws.getAllWishlistById();
		
		for(WishlistResponse wishlist : Wishlist) {
			System.out.println(wishlist.toString());
		}
	}

}
