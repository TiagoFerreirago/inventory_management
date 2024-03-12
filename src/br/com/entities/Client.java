package br.com.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Client {

	private String name;
	private String email;
	private Date date;
	
	private SimpleDateFormat fmt= new SimpleDateFormat("dd/MM/yyyy");
	
	public Client() {
		
	}

	public Client(String name, String email, Date date) {
		
		this.name = name;
		this.email = email;
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDate() {
		return date;
	}

	public void setBirthDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Client: " + name + " " +"("+fmt.format(date) +")"+ " - "+ email;
	}
	
	
}
