package com.java.example.builder.pattern;

/**
 */
public class NutritionFactBuilderPattern {

	/* All final members */
	private final int servingSize;
	private final int servings;
	private final int fat;
	private final int sodium;
	private final int carbohydrate;

	public static class Builder {
		// Required parameters
		private final int servingSize;
		private final int servings;

		// Optional parameters - initialized to default values
		private int fat = 0;
		private int sodium = 0;
		private int carbohydrate = 0;

		public Builder(int servingSize, int servings) {
			this.servingSize = servingSize;
			this.servings = servings;
		}

		public Builder fat(int val) {
			fat = val;
			return this;
		}

		public Builder sodium(int val) {
			sodium = val;
			return this;
		}

		public Builder carbohydrate(int val) {
			carbohydrate = val;
			return this;
		}

		public NutritionFactBuilderPattern build() {
			return new NutritionFactBuilderPattern(this);
		}
	}

	private NutritionFactBuilderPattern(Builder builder) {
		servingSize = builder.servingSize;
		servings = builder.servings;
		fat = builder.fat;
		sodium = builder.sodium;
		carbohydrate = builder.carbohydrate;
	}

	/*
	 * Only getters to provide Immutability
	 */
	public int getServingSize() {
		return servingSize;
	}

	public int getServings() {
		return servings;
	}

	public int getFat() {
		return fat;
	}

	public int getSodium() {
		return sodium;
	}

	public int getCarbohydrate() {
		return carbohydrate;
	}

	@Override
	public String toString() {
		return "Serving Size: " + servingSize + ", Servings: " + servings
				+ ", Fat: " + fat + ", Sodium: " + sodium + ", CarboHydrate: "
				+ carbohydrate;
	}
}
