package main.com.java.example.mvc.view;

import java.util.Objects;
import java.util.Scanner;

import main.com.java.example.mvc.model.Login;
import main.com.java.example.mvc.model.LoginModel;

public class LoginView {
	private final LoginModel model;
	private LoginListener loginListener;

	public LoginView(LoginModel model) {
		this.model = model;
	}

	public void loginForm() {
		String userName = "";
		String password = "";
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter username: ");
		userName = sc.nextLine();

		System.out.println("Enter password: ");
		password = sc.nextLine();

		System.out.println("Enter return key to login");
		sc.nextLine();

		if (!userName.isEmpty() && !password.isEmpty()) {
			loginListener.performLogin(new Login(userName, password));
		}
	}

	public void addLoginListener(LoginListener loginListener) {
		this.loginListener = Objects.requireNonNull(loginListener, "loginListener must not be null.");
	}
	
	public void dataFromController(String data) {
		System.out.println("Data from controller to view" + data);
	}
}
