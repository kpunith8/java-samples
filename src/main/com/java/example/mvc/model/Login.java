package main.com.java.example.mvc.model;

import java.util.Objects;

public class Login {
	private final String userName;
	private final String password;

	public Login(String userName, String password) {
		this.userName = Objects.requireNonNull(userName, "userName cannot be null");
		this.password = Objects.requireNonNull(password, "userName cannot be null");
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}
}
