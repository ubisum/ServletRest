package it.biagio.servlet;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import it.biagio.model.Contact;
import it.biagio.model.User;
import it.biagio.service.UserService;

/**
 * Servlet implementation class AddContact
 */
@WebServlet("/AddContact")
public class AddContact extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(AddContact.class.getName());
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("addContact.jsp").forward(request, response);
		}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// create new Contact
		Contact contact = new Contact();
		
		// create a UserService
		UserService us = new UserService();
		
		// fill fields
		contact.setEmail(request.getParameter("email"));
		contact.setName(request.getParameter("name"));
		contact.setSurname(request.getParameter("surname"));
		contact.setTelephone(request.getParameter("telephone"));
		contact.setUser((User)request.getSession().getAttribute("id"));
		
		RequestDispatcher requestDispatcher; 
		
		try
		{
			us.addContact(JSON.toJSONString(contact));
			requestDispatcher = request.getRequestDispatcher("/showContacts");
			requestDispatcher.forward(request, response);
		}
		
		catch(Exception e)
		{
			logger.info(e.getMessage());
			requestDispatcher = request.getRequestDispatcher("failure.jsp");
			requestDispatcher.forward(request, response);
		}
		
	
	}

}
