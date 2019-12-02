package objects;

import java.io.Serializable;

public class Author implements Serializable  {
	private static final long serialVersionUID = 1L; 
	private String name ;
	private String surname;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Author(String name, String surname) {
		super();
		this.name = name;
		this.surname = surname;
	}}
