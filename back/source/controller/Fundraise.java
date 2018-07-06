package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.FundraiseBO;

public class Fundraise extends HttpServlet {

    private static final long serialVersionUID = 1L;
       
    public Fundraise() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FundraiseBO bo = new FundraiseBO();
		String date = request.getParameter("fundraiseDate");
		if(date != null)
			response.getWriter().append(bo.getFundraisesByDate(date));
		else
			response.getWriter().append(bo.getAllFundraises());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FundraiseBO bo = new FundraiseBO();
		float value = Float.parseFloat(request.getParameter("fundraiseValue"));
		String receiptName = request.getParameter("receiptName");
		String date = request.getParameter("fundraiseDate");
		
		bo.insert(value,receiptName,date);
		response.getWriter().append(bo.getAllFundraises());
	}
}