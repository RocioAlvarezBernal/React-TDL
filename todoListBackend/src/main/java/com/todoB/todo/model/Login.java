package com.todoB.todo.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "login")

public class Login {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "username")
	private String username;

//    @NotBlank(message = "Name may not be blank")
	@Column(name = "password")
	private String password;
	
	public Login() {
	}
	
	public Login(int id, String username, String passwords) {
		this.id = id;
		this.username = username;
		this.password = passwords;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String passwords) {
		this.password = passwords;
	}


	
}
