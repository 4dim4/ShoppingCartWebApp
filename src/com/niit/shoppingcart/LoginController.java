package com.niit.shoppingcart;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CORBA.Request;

import com.niit.shoppingcart.LoginDAO;
/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		System.out.println("dopost"); 
		String userID = request.getParameter("userID");
		String password = request.getParameter("password");

	LoginDAO l=new LoginDAO();
	RequestDispatcher dispatcher;
	if(l.isValidUser(userID,password)==true)
	{
		dispatcher=request.getRequestDispatcher("home.html");
		dispatcher.forward(request, response);
	}
	else
	{
		dispatcher=request.getRequestDispatcher("Login.html");
		PrintWriter writer=response.getWriter();
		writer.append("invalid credentials......... TRY AGAIN!!!");
		dispatcher.include(request, response);
	}
	}
}