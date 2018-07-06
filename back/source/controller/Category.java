package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.CategoryBO;

public class Category extends HttpServlet {

    private static final long serialVersionUID = 1L;
       
    public Category() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	CategoryBO bo = new CategoryBO();
    	String name = request.getParameter("categoryName");
    	if(name != null)
    		response.getWriter().append(bo.getCategoryByName(name));
		else
			response.getWriter().append(bo.getAllCategorys());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	CategoryBO bo = new CategoryBO();
		String name = request.getParameter("categoryName");
		bo.insert(name);
		response.getWriter().append(bo.getAllCategorys());
	}
}