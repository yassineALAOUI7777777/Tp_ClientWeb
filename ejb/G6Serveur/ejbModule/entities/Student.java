package entities;
import jakarta.persistence.*;

import java.io.Serializable;


@Entity
public class Student extends User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -558553967080513790L;


	public Student(String password, String login) {
		super(password, login);
		// TODO Auto-generated constructor stub
	}
	private String firstName;
	private String lastName;
	private String telephone;
	
	@ManyToOne
	private Filiere filiere;
	
	
	
	public Filiere getFiliere() {
		return filiere;
	}
	public void setFiliere(Filiere filiere) {
		this.filiere = filiere;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	public Student() {}

	
	
}
