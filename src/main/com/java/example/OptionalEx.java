package main.com.java.example;

import java.util.Optional;

public class OptionalEx {
    // Don't return a null, instead return an empty collection.
    // so that we don't need to do a null check.
    // In case of single values use Option<T>.
    public static Optional<String> getName() {
        if (Math.random() > 0.5) {
            return Optional.of("Joe");
        }

        return Optional.empty();
    }

    // Don't use Optional<T> as a parameter to methods, if needed use overloading
    public static void setName(Optional<String> name) {
        if (name.isPresent()) {
            // use the given name
        } else {
            // use the default value
        }
    }
    /*
        Above function can be called as,
        setName(Optional.empty());
        setName(Optional.of("Ram");
     */

    public static void main(String[] args) {
        var result = getName();

        System.out.println(result.orElse("Not found!"));

        // Don't do this, get() will blow up if an object doesn't exist.
        // get() doesn't reveal its intention
        // result.get()
    }

}
