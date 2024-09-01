package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import dto.CategoryRequest;
import dto.CategoryResponse;
import exceptions.CategoryCreateException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.CategoryService;

@WebServlet("/Categories/*")
public class CategoryController extends HttpServlet {
    private CategoryService categoryService;

    public void init() {
        System.out.println("init");
        this.categoryService = new CategoryService();
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        System.out.println("Get method invoked for Categories");

		System.out.println(req.getRequestURI().substring("/RevP0Project/Categories/".length()+1));

        if (req.getRequestURI().substring("/RevP0Project/Categories/".length()+1).equals("all")) {
            try {
                List<CategoryResponse> categories = categoryService.getAllCategories();

                out.println("<H1>Categories Controller</H1>");

                for (CategoryResponse category : categories) {
                    out.printf("<p>ID: %d</p>", category.getCategoryId());
                    out.printf("<p>Name: %s</p>", category.getCategoryName());
                 
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
    		Long id=Long.parseLong(req.getRequestURI().substring("/RevP0Project/Categories/".length()));

            try {
                CategoryResponse category = categoryService.getCategoryById(id);

                out.println("<H1>Categories Controller</H1>");

                out.printf("<p>ID: %d</p>", category.getCategoryId());
                out.printf("<p>Name: %s</p>", category.getCategoryName());
         
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    	int category_id = Integer.parseInt(req.getParameter("category_id"));
        String category_name = req.getParameter("category_name");
       

        CategoryRequest category = new CategoryRequest(category_id, category_name);
        try {
            boolean response = categoryService.CreateCategory(category);
            if (response)
                resp.getWriter().println("Category with name " + category.getCategoryName() + " is Created Successfully...");
            else
                resp.getWriter().println("Category with name " + category.getCategoryName() + " is Not Created...please check and try again");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (CategoryCreateException e) {
            e.printStackTrace();
        }
    }
}
