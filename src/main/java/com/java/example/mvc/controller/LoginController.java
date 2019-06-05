package com.java.example.mvc.controller;

import com.java.example.mvc.model.Login;
import com.java.example.mvc.model.LoginModel;
import com.java.example.mvc.view.LoginListener;
import com.java.example.mvc.view.LoginView;

public class LoginController implements LoginListener {
	private final LoginView loginView;
	private final LoginModel loginModel;

	public LoginController(LoginView loginView, LoginModel loginModel) {
		this.loginView = loginView;
		this.loginModel = loginModel;
	}

	@Override
	public void performLogin(Login login) {
		System.out.println("Login successfull");
		System.out.println("Welcome: " + login.getUserName());

		if (!login.getUserName().isEmpty() && !login.getPassword().isEmpty()) {
			loginView.dataFromController(login.getUserName() + "-" + login.getPassword());
		}
	}
}
