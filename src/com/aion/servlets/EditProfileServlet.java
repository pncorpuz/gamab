package com.aion.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aion.javabean.ProfileBean;
import com.aion.javabean.UserBean;
import com.aion.services.ProfileService;
import com.aion.services.UserService;
import com.login.dao.LoginDao;

/**
 * Servlet implementation class EditProfileServlet
 */
@WebServlet("/EditProfileServlet")
public class EditProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserBean u = new UserBean();
		ProfileBean P = new ProfileBean();
		ProfileService profserv = new ProfileService();
		UserService userserv = new UserService();
		LoginDao loginserv = new LoginDao();
		
		
		String a = request.getParameter("firstname");
		String b = request.getParameter("lastname");
		String c = request.getParameter("email");
		String d = request.getParameter("billing_address");
		System.out.println("bil_ad: "+d);
		String e = request.getParameter("shipping_address");
		System.out.println("ship_ad: "+e);
		String g = request.getParameter("new_password");
		int f = (int) request.getSession().getAttribute("iduser");
		//request.getRequestDispatcher("DisplayProfileServlet").forward(request, response);
		response.sendRedirect("DisplayProfileServlet");
		
		profserv.editprofile(a, b, c, d, e, f);
		userserv.edituser(f, g);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
}
