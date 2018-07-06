package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.ItemsBO;

public class Items extends HttpServlet {

    private static final long serialVersionUID = 1L;
       
    public Items() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	ItemsBO bo = new ItemsBO();
		response.getWriter().append(bo.getAllItems());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	ItemsBO bo = new ItemsBO();
		String name = request.getParameter("itemName");
		String categoryName = request.getParameter("categoryName");
		bo.insert(name,categoryName);
		response.getWriter().append(bo.getAllItems());
	}
}