package it.biagio.servlet;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.biagio.model.User;
import it.biagio.service.UserService;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(Login.class.getName());

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		UserService us = new UserService();
		
		try
		{
			RequestDispatcher requestDispatcher; 
			User id = us.getUser(username, password);
			if(id == null)
			{
				requestDispatcher = request.getRequestDispatcher("failure.jsp");
				requestDispatcher.forward(request, response);
			}
			
			else
			{
				request.getSession().setAttribute("id", id);
				requestDispatcher = request.getRequestDispatcher("/showContacts");
				requestDispatcher.forward(request, response);
			}
					
		}
		
		catch(Exception e)
		{
			logger.info("System error");
		}
		
	}

}
