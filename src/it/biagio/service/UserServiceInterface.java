package it.biagio.service;

import it.biagio.model.Contact;
import it.biagio.model.User;

public interface UserServiceInterface {
	User getUser(String username, String password) throws Exception;
	Iterable<Contact> getContacts(int id) throws Exception;
	public void addContact(String toJSON) throws Exception; 
}
