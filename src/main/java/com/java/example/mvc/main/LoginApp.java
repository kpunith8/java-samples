package com.java.example.mvc.main;

import com.java.example.mvc.controller.LoginController;
import com.java.example.mvc.model.LoginModel;
import com.java.example.mvc.view.LoginView;

public class LoginApp {
	public static void main(String[] args) {
		LoginModel loginModel = new LoginModel();

		LoginView loginView = new LoginView(loginModel);
		LoginController loginController = new LoginController(loginView, loginModel);

		loginView.addLoginListener(loginController);
		loginView.loginForm();
	}
}
