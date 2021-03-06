package com.aion.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aion.services.ProfileService;
import com.aion.services.TransactionService;
import com.aion.javabean.Product;
import com.aion.javabean.ProfileBean;
import com.aion.javabean.TransBean;;

/**
 * Servlet implementation class DisplayProfileServlet
 */
@WebServlet("/DisplayProfileServlet")
public class DisplayProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = (String) request.getSession().getAttribute("username");
		System.out.println("benj" + uname);
		int f = (int) request.getSession().getAttribute("iduser");
		System.out.println("wakaka: "+ f);
		ProfileService profserv = new ProfileService();
		TransactionService transService = new TransactionService();
		ArrayList<ProfileBean> profiles = profserv.getSelectedUser(uname);
		ArrayList<Product> trans = transService.getAllTransactions((Integer)request.getSession().getAttribute("iduser"));
		
		//System.out.println(profiles);
		request.setAttribute("profile", profiles);
		request.setAttribute("transaction",trans);
		request.getRequestDispatcher("userprof.jsp").forward(request, response);
	}

}
