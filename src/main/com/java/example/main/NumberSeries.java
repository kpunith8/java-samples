package main.com.java.example.main;

import java.util.Scanner;

public class NumberSeries {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int line = s.nextInt();

		for (int x = 0; x < line; x++) {

			int a = s.nextInt();
			int b = s.nextInt();
			int n = s.nextInt();

			int sum = a;

			for (int i = 0; i < n; i++) {
				sum += (int) ((Math.pow(2, i)) * b);

				System.out.print(sum + " ");
			}
			System.out.println();
		}
	}

}
