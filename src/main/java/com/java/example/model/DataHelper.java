package com.java.example.model;

import java.util.List;
import java.util.stream.Collectors;

public class DataHelper {
	public static List<String> getAllNames() {
		return List.of("alfa", "bravo", "charlie", "delta", "echo", "foxtrot", "golf", "hotel", "india", "juliet",
				"kilo", "lima", "mike", "november", "oscar", "papa", "quebec", "romeo", "sierra", "tango", "uniform",
				"victor", "whiskey", "x-ray", "yankee", "zulu");
	}

	// Sakespeare sonnet
	public static List<String> getSonnet() {
		return List.of("From fairest creatures we desire increase,", "That thereby beauty's rose might never die,",
				"But as the riper should by time decease,", "His tender heir might bear his memory:",
				"But thou contracted to thine own bright eyes,",
				"Feed'st thy light's flame with self-substantial fuel,", "Making a famine where abundance lies,",
				"Thy self thy foe, to thy sweet self too cruel:", "Thou that art now the world's fresh ornament,",
				"And only herald to the gaudy spring,", "Within thine own bud buriest thy content,",
				"And, tender churl, mak'st waste in niggarding:", "Pity the world, or else this glutton be,",
				"To eat the world's due, by the grave and thee thy thy thy.");
	}

	public static List<String> expand(String str) {
		return str.codePoints().mapToObj(Character::toString).collect(Collectors.toList());
	}
}
