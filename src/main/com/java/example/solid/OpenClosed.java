package main.com.java.example.solid;

// classes should be open for an extension but closed for modification.
public class OpenClosed {

    public static void main(String[] args) {
        Guitar guitar = new Guitar("2022", "Mand", 12);
        SuperCoolGuitar superCoolGuitar = new SuperCoolGuitar("2021", "Kule", 11, "Orange");

        System.out.println("My Guitar details: " + guitar.getMake());
        System.out.println("Super Guitar details: " + superCoolGuitar.getFlameColor() + ", " + superCoolGuitar.getMake());
    }
}

class Guitar {

    private String make;
    private String model;
    private int volume;

    public Guitar(String make, String model, int volume) {
        this.make = make;
        this.model = model;
        this.volume = volume;
    }

    public String getMake() {
        return make;
    }

    public int getVolume() {
        return volume;
    }

    public String getModel() {
        return model;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }
}

// If we want to create a super cool guitar with added features, we should
// extend the Guitar class by SuperCoolGuitar class instead of adding another field
// describing the super coolness.

class SuperCoolGuitar extends Guitar {
    private String flameColor;

    public SuperCoolGuitar(String make, String model, int volume, String flameColor) {
        super(make, model, volume);
        this.flameColor = flameColor;
    }

    public String getFlameColor() {
        return flameColor;
    }

    public void setFlameColor(String flameColor) {
        this.flameColor = flameColor;
    }
}