package entities;

import java.util.List;



import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class User implements Serializable {
	/**
	 * 
	 */
	
	private static final long serialVersionUID = -558553967080513790L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected int id;
	
	protected String password;
	protected String login;
	
	@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "User_Role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> role;
	
	public User(String password, String login){
		this.password = password;
		this.login = login;
	}
	
	public User () {
		
	}
	public List<Role> getRole() {
		return role;
	}
	public void setRole(List<Role> role) {
		this.role = role;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	
	
}
