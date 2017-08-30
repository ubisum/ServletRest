package it.biagio.servlet;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.biagio.model.Contact;
import it.biagio.model.User;
import it.biagio.service.UserService;

/**
 * Servlet implementation class updateContact
 */
@WebServlet("/updateContact")
public class updateContact extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(updateContact.class.getName());
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int contactId = Integer.parseInt(request.getParameter("contactId"));
		UserService service = new UserService();
		
		try
		{
			Contact contact = service.getContact(contactId);
			request.getSession().setAttribute("contact", contact);
		}
		
		catch(Exception e)
		{
			logger.info(e.getMessage());
		}
		
		request.getRequestDispatcher("updateContact.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int contactId = Integer.parseInt(request.getParameter("contactId"));
		UserService service = new UserService();
		
		// get info about contact
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		String telephone = request.getParameter("telephone");
		String email = request.getParameter("email");
		
		// prepare a new contact
		Contact contact = new Contact();
		contact.setEmail(email);
		contact.setName(name);
		contact.setSurname(surname);
		contact.setTelephone(telephone);
		contact.setId(contactId);
		
		String result;
		
		try
		{
			result = service.editContact(contact);
		}
		
		catch(Exception e)
		{
			result = e.getMessage();
		}
		
		logger.info(result);
		request.getRequestDispatcher("showContacts").forward(request, response);
		
		
	}

}
