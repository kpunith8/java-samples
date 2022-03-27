package main.com.java.example.main;

import main.com.java.example.builderpattern.NutritionFactBuilderPattern;

public class BuilderPatternTest {

	public static void main(String[] args) {
		NutritionFactBuilderPattern cocaCola = new NutritionFactBuilderPattern.Builder(
				2, 1).fat(20).carbohydrate(30).sodium(40).build();
		NutritionFactBuilderPattern dietCocaCola = new NutritionFactBuilderPattern.Builder(
				2, 1).carbohydrate(10).sodium(8).build();

		System.out.println("Normal Coca-Cola Object: " + cocaCola);
		System.out.println("Diet Coca-Cola Object: " + dietCocaCola);
		System.out.println("No of servings for normal Coca-Cola: "
				+ cocaCola.getServings());

	}
}
