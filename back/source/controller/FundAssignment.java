package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.FundAssignmentBO;

public class FundAssignment extends HttpServlet {

    private static final long serialVersionUID = 1L;
       
    public FundAssignment() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FundAssignmentBO bo = new FundAssignmentBO();
		String date = request.getParameter("fundassignmentDate");
		if(date != null)
			response.getWriter().append(bo.getFundassignmentsByDate(date));
		else
			response.getWriter().append(bo.getAllFundassignments());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FundAssignmentBO bo = new FundAssignmentBO();
		float value = Float.parseFloat(request.getParameter("fundassignmentValue"));
		String itemName = request.getParameter("itemName");
		String date = request.getParameter("fundassignmentDate");
		
		bo.insert(value,itemName,date);
		response.getWriter().append(bo.getAllFundassignments());
	}
}