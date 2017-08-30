package it.biagio.servlet;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.biagio.service.UserService;

/**
 * Servlet implementation class deleteContact
 */
@WebServlet("/deleteContact")
public class deleteContact extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(deleteContact.class.getName());
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.getRequestDispatcher("contacts.jsp").forward(request, response);
		
		int contact = Integer.parseInt(request.getParameter("contact"));
		logger.info("" + contact);
		UserService us = new UserService();
		
		// delete contact
		try
		{
			String returnedResponse = us.deleteContact(contact);
			logger.info(returnedResponse);
			RequestDispatcher rq = request.getRequestDispatcher("/showContacts");
			rq.forward(request, response);
		}
		
		catch(Exception e)
		{
			logger.info(e.getMessage());
			RequestDispatcher rq = request.getRequestDispatcher("failure.jsp");
			rq.forward(request, response);
		}
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*int contact = Integer.parseInt(request.getParameter("contact"));
		UserService us = new UserService();
		
		// delete contact
		try
		{
			String returnedResponse = us.deleteContact(contact);
			logger.info(returnedResponse);
		}
		
		catch(Exception e)
		{
			logger.info(e.getMessage());
		}
		
		finally
		{
			RequestDispatcher rq = request.getRequestDispatcher("/showContacts");
			rq.forward(request, response);
		}*/
	}

}
