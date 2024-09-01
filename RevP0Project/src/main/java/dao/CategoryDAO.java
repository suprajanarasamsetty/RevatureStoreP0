package dao;

import java.sql.SQLException;
import java.util.List;

import dto.CategoryRequest;
import dto.CategoryResponse;
import exceptions.CategoryCreateException;
import exceptions.CategoryDeleteException;
import exceptions.CategoryNotFoundException;
import exceptions.CategoryUpdateException;

public interface CategoryDAO {
	
	CategoryResponse getCategoryById(long id) throws SQLException, CategoryNotFoundException;
	boolean CreateCategory(CategoryRequest categoryRequest) throws SQLException, CategoryCreateException;
	boolean UpdateCategory(CategoryRequest categoryRequest) throws SQLException, CategoryUpdateException;
	boolean DeleteCategoryById(long id) throws SQLException, CategoryDeleteException;
	List<CategoryResponse> getAllCategories() throws SQLException, CategoryNotFoundException;

}
