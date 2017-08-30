package it.biagio.service;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.List;

import com.alibaba.fastjson.JSON;

import it.biagio.model.Contact;
import it.biagio.model.User;

public class UserService implements UserServiceInterface{
	public User getUser(String username, String password) throws Exception
	{
		try
		{
			URL url = new URL("http://localhost:8081/User/getAccess" + username + "/" + password);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			con.setRequestMethod("GET");
						
			BufferedReader read = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String string;
			StringBuffer response = new StringBuffer();
			
			while((string = read.readLine()) != null)
			{
				response.append(string);
			}
			
			return JSON.parseObject(response.toString(), User.class);
			
			
		}
		
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public List<Contact> getContacts(int id) throws Exception
	{
		try
		{
			URL url = new URL("http://localhost:8081/Contact/getContacsByUser" + id);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			con.setRequestMethod("GET");
			
			BufferedReader read = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String string;
			StringBuffer response = new StringBuffer();
			
			while((string = read.readLine()) != null)
			{
				response.append(string);
			}
			
			return JSON.parseArray(response.toString(), Contact.class);
		}
		
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public void addContact(String toJSON) throws Exception
	{
		try
		{
			// open connection
			URL url = new URL("http://localhost:8081/Contact/saveContact");
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			byte[] postData = toJSON.getBytes(StandardCharsets.UTF_8);
			
			// set connection parameters and connect
			con.setDoOutput(true);
			con.setDoInput(true);
			con.setRequestMethod("POST");
			con.setRequestProperty("Content-Type", "application/json");
			con.setRequestProperty("charset", "utf-8");
			con.setRequestProperty("Content-Length", Integer.toString(postData.length));
			con.connect();
			
			// write data
			DataOutputStream output = new DataOutputStream(con.getOutputStream());
			output.write(postData);
			
			int responseCode = con.getResponseCode();
	
			BufferedReader in = new BufferedReader(
			        			new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			//print result
			System.out.println("Response code: " + responseCode);
			System.out.println(response.toString());
			
			output.close();
		}
		
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	public String deleteContact(int contactId) throws Exception
	{
		try
		{
			URL url = new URL("http://localhost:8081/Contact/deletePerson" + contactId);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			con.setRequestMethod("DELETE");
			
			BufferedReader read = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String string;
			StringBuffer response = new StringBuffer();
			
			while((string = read.readLine()) != null)
			{
				response.append(string);
			}
			
			System.out.println("RESPONSE: " + response.toString());
			return response.toString();
		}
		
		catch(Exception e)
		{
			return e.getMessage();
		}
	}
	
	public Contact getContact(int contactId) throws Exception
	{
		try
		{
			URL url = new URL("http://localhost:8081/Contact/getContactById" + contactId);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			con.setRequestMethod("GET");
			
			BufferedReader read = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String string;
			StringBuffer response = new StringBuffer();
			
			while((string = read.readLine()) != null)
			{
				response.append(string);
			}
			
			Contact responseContact =  JSON.parseObject(response.toString(), Contact.class);
			return responseContact;
		}
		
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public String editContact(Contact contact) throws Exception
	{
		try
		{
			// open connection
			URL url = new URL("http://localhost:8081/Contact/editContact");
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			byte[] postData = JSON.toJSONString(contact).getBytes(StandardCharsets.UTF_8);
			
			// set connection parameters and connect
			con.setDoOutput(true);
			con.setDoInput(true);
			con.setRequestMethod("POST");
			con.setRequestProperty("Content-Type", "application/json");
			con.setRequestProperty("charset", "utf-8");
			con.setRequestProperty("Content-Length", Integer.toString(postData.length));
			con.connect();
			
			// write data
			DataOutputStream output = new DataOutputStream(con.getOutputStream());
			output.write(postData);
			
			int responseCode = con.getResponseCode();
	
			BufferedReader in = new BufferedReader(
			        			new InputStreamReader(con.getInputStream()));
			
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			
			in.close();

			//print result
			System.out.println("Response code: " + responseCode);
			System.out.println(response.toString());
			
			output.close();
			return response.toString();
		}
		
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return e.getMessage();
		}
	}
	
	
	public User saveUser(User user) throws Exception
	{
		try
		{
			// open connection
			URL url = new URL("http://localhost:8081/User/saveUser");
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			byte[] postData = JSON.toJSONString(user).getBytes(StandardCharsets.UTF_8);
			
			// set connection parameters and connect
			con.setDoOutput(true);
			con.setDoInput(true);
			con.setRequestMethod("POST");
			con.setRequestProperty("Content-Type", "application/json");
			con.setRequestProperty("charset", "utf-8");
			con.setRequestProperty("Content-Length", Integer.toString(postData.length));
			con.connect();
			
			// write data
			DataOutputStream output = new DataOutputStream(con.getOutputStream());
			output.write(postData);
				
			BufferedReader in = new BufferedReader(
			        			new InputStreamReader(con.getInputStream()));
			
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			
			in.close();
			output.close();
			
			return JSON.parseObject(response.toString(), User.class);
			
		}
		
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return null;
		}
	}
}
