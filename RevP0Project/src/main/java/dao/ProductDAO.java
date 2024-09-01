package dao;

import java.sql.SQLException;
import java.util.List;

import dto.ProductRequest;
import dto.ProductResponse;
import exceptions.ProductCreationException;
import exceptions.ProductDeletionException;
import exceptions.ProductNotFoundException;
import exceptions.ProductUpdateException;

public interface ProductDAO {
	
	ProductResponse getProductById(long id) throws SQLException, ProductNotFoundException, ProductNotFoundException;
	boolean CreateProduct(ProductRequest productRequest) throws SQLException, ProductCreationException;
	boolean UpdateProductById(ProductRequest productRequest) throws SQLException, ProductUpdateException;
	boolean DeleteProductById(long id) throws SQLException, ProductDeletionException;
	List<ProductResponse> getAllProducts();
	boolean addProduct(ProductRequest productRequest) throws SQLException, ProductCreationException;

}
