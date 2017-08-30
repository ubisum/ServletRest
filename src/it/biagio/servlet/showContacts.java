package it.biagio.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.biagio.model.Contact;
import it.biagio.model.User;
import it.biagio.service.UserService;

@WebServlet("/showContacts")
public class showContacts extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = (User)request.getSession().getAttribute("id");
		UserService us = new UserService();
		RequestDispatcher requestDispatcher; 
		
		try
		{			
			// get list of contacts
			List<Contact> listOfContacts = us.getContacts(user.getId());
			
			// set session parameter
			request.getSession().setAttribute("contacts", listOfContacts);
			
			// forward
			requestDispatcher = request.getRequestDispatcher("contacts.jsp");
			requestDispatcher.forward(request, response);
		}
		
		catch(Exception e)
		{
			requestDispatcher = request.getRequestDispatcher("failure.jsp");
			requestDispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
