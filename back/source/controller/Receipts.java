package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.ReceiptsBO;

public class Receipts extends HttpServlet {

    private static final long serialVersionUID = 1L;
       
    public Receipts() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	ReceiptsBO bo = new ReceiptsBO();
		response.getWriter().append(bo.getAllReceipts());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	ReceiptsBO bo = new ReceiptsBO();
		String name = request.getParameter("receiptName");
		bo.insert(name);
		response.getWriter().append(bo.getAllReceipts());
	}
}