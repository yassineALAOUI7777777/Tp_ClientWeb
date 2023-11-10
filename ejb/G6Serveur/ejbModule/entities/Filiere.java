package entities;

import java.io.Serializable;

import jakarta.persistence.*;

@Entity
public class Filiere implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -558553967080513790L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	

	protected int id;
	
	private String code;
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
public Filiere () {
		
	}
	
	
}
