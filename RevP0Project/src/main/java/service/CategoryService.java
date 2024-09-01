package service;

import java.sql.SQLException;
import java.util.List;

import dao.CategoryDAOClass;
import dto.CategoryRequest;
import dto.CategoryResponse;
import exceptions.CategoryCreateException;
import exceptions.CategoryDeleteException;
import exceptions.CategoryNotFoundException;
import exceptions.CategoryUpdateException;

public class CategoryService {
	
	private final CategoryDAOClass categoryDao;
	
	public CategoryService() {
		categoryDao =new CategoryDAOClass();
	}
	
	public CategoryResponse getCategoryById(long id) throws SQLException, CategoryNotFoundException {
		return categoryDao.getCategoryById(id);
	}
	
	public boolean CreateCategory(CategoryRequest categoryRequest) throws SQLException, CategoryCreateException {
		return categoryDao.CreateCategory(categoryRequest);
	}
	
	public boolean UpdateCategory(CategoryRequest categoryRequest) throws SQLException, CategoryUpdateException{
		return categoryDao.UpdateCategory(categoryRequest);
	}
	
	public boolean DeleteCategoryById(long id) throws SQLException, CategoryDeleteException {
		return categoryDao.DeleteCategoryById(id);
	}

	public List<CategoryResponse> getAllCategories() throws SQLException, CategoryNotFoundException {
		return categoryDao.getAllCategories();
	}
	
	public static void main(String[] args) throws SQLException, CategoryNotFoundException {
		CategoryService Category = new CategoryService();	
		
		List<CategoryResponse> category=Category.getAllCategories();
		
		for(CategoryResponse CR : category) {
			System.out.println(CR.toString());
		}
	}

}
