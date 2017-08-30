package it.biagio.servlet;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.biagio.model.User;
import it.biagio.service.UserService;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(Register.class.getName());
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.getRequestDispatcher("register.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// gather data
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		// create service
		UserService us = new UserService();
		
		try
		{
			User user = us.saveUser(new User(username, password));
			if(user!= null)
			{
				request.getSession().setAttribute("id", user);
				request.getRequestDispatcher("showContacts").forward(request, response);
			}
			
			else
				request.getRequestDispatcher("failure.jsp").forward(request, response);
		}
		
		catch(Exception e)
		{
			logger.info(e.getMessage());
			
		}
	}

}
