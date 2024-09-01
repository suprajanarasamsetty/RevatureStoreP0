package service;

import java.sql.SQLException;
import java.util.List;

import dao.ProductDAOClass;
import dto.ProductRequest;
import dto.ProductResponse;
import exceptions.ProductCreationException;
import exceptions.ProductDeletionException;
import exceptions.ProductNotFoundException;
import exceptions.ProductUpdateException;

public class ProductService {
	
	private final ProductDAOClass productDao;
	
	public ProductService() {
		
		productDao = new ProductDAOClass();
	}
	
	public ProductResponse getProductById(long id) throws SQLException {
			try {
				return productDao.getProductById(id);
			} catch (SQLException | ProductNotFoundException e) {
				e.printStackTrace();
			}
			return null;
		
	}
	
	public boolean DeleteProductByID(long id) throws SQLException, ProductDeletionException{
		return productDao.DeleteProductById(id);
	}
	
	public boolean UpdateProductById(ProductRequest productRequest) throws SQLException, ProductUpdateException {
		return productDao.UpdateProductById(productRequest);
	}
	
	public boolean createProduct(ProductRequest productRequest) throws SQLException, ProductCreationException {
		return productDao.CreateProduct(productRequest);
	}
	public List<ProductResponse> getAllProducts() {
		return productDao.getAllProducts();
	}
	
	public boolean addProduct(ProductRequest productRequest) throws SQLException {
		 try {
		        return productDao.addProduct(productRequest);
		    } 
		 	catch (Exception e) {
		        System.out.println("Exception: " + e.getMessage());
		        e.printStackTrace();
		        return false;
		    }
    }
	public static void main(String[] args) throws SQLException, ProductDeletionException, ProductNotFoundException {
		
		ProductService p=new ProductService();
		
		//System.out.println(p.getProductById(40));
		
		//for deleting the product
//		int ProductIDtoDelete=1;
//		p.productDao.DeleteProduct(ProductIDtoDelete);
//		System.out.println("Product Deleted Successfully");
		
		//for updating the Product;
		//System.out.println(p.UpdateProductById(new ProductRequest(2, "Levi's Men's Slim Fit Denim Shirt", 2499.00, 1, 1)));
		
//		//for inserting values in products table
//		System.out.println(p.createProduct(new ProductRequest(1, "Dior Sauvage Eau de Toilette", 7000.00, 5, 3)));
		List<ProductResponse> products=p.getAllProducts();
		
		for(ProductResponse product : products) {
			System.out.println(product.toString());
		}
	}

}
