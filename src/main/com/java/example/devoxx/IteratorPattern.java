package main.com.java.example.devoxx;

import java.util.ArrayList;
import java.util.List;

public class IteratorPattern {
    public static void main(String[] args) {
        var names = List.of("Dory", "Gill", "Bruce", "Nemo", "Darla", "Marlin", "Jacques");

        // External iterators - we control the iteration
        int count = 0;
        for (var name : names) {
            if (name.length() == 4) {
                System.out.println(name.toUpperCase());
                count++;

                if (count == 2) {
                    break;
                }
            }
        }

        System.out.println("----------");
        // Internal iterator using functional style
        names.stream()
                .filter(name -> name.length() == 4)
                .map(String::toUpperCase)
                .limit(2) // Limit can be used to break the code
                // takeWhile(predicate)
                .forEach(System.out::println);

        // limit and takeWhile (Java 9), are the functional equivalent of break
        // from the imperative style.

        System.out.println("Adding items to collection in functional pipeline(shared mutability)");
        // Convert a name to uppercase if it has a length of == 4 and add it to a collection
        // Imperative style
        var result1 = new ArrayList<String>();
        for (var name : names) {
            if (name.length() == 4) {
                result1.add(name.toUpperCase());
            }
        }

        // Functional style
        var result2 = new ArrayList<String>();

        names.stream()
                .filter(name -> name.length() == 4)
                .map(String::toUpperCase)
                // functional pipeline should be pure, using parallel stream on will break the code
                // here we are doing shared mutability
                .forEach(result2::add); // Bad Idea, mutating the code in the functional stream
        // Avoid shared mutable variables.

        // 1. Pure function should not change any state that is visible outside
        // 2. Pure function should not depend on anything outside that might, possibly change.

        System.out.println(result1 + " " + result2);
    }
}
