package main.com.java.example.solid;

// Derived types must be completely substitutable for their base types.
// if class A is a subtype of class B, we should be able to replace B with A without disrupting the behavior of our program.
public class LiskovSubstitution {

    public static void main(String[] args) {
        Engine motorCarEngine = new Engine();
        Car motorCar = new MotorCar(motorCarEngine);

        // Try without calling the turnOnEngine method and execute accelerate method
        motorCar.turnOnEngine();
        motorCar.accelerate(10);
    }
}

class Engine {
    public void on() {
        System.out.println("Engine is turned on");
    }

    public void powerOn(int speed) {
        System.out.println("Moving at speed, " + speed);
    }
}


interface Car {

    void turnOnEngine();

    void accelerate(int speed);
}

class MotorCar implements Car {
    private Engine engine;
    private boolean isEngineOn = false;

    public MotorCar(Engine engine) {
        this.engine = engine;
    }

    @Override
    public void turnOnEngine() {
        isEngineOn = true;
    }

    @Override
    public void accelerate(int speed) {
        if (isEngineOn) {
            engine.powerOn(speed);
        } else {
            System.out.println("Engine is not turned on!!");
        }
    }
}

// By throwing a car without an engine into the mix, we are inherently changing the behavior of our program.
// This is a violation of Liskov substitution.
class ElectricCar implements Car {
    @Override
    public void turnOnEngine() {
        // No engine to turn on, and it breaks the contract as we should adhere to the contract.
        throw new AssertionError("I don't have an engine!");
    }

    @Override
    public void accelerate(int speed) {
        // Acceleration can be done as usual.
    }
}

// To fix this, create an interface CarWithEngine with only the turnOnEngine() in it and create another
// interface CarWithAcceleration with accelerate() in it.
// Now, ElectricCar class should implement only the interface with accelerate() in it, and MotorCar class should
// implement both interfaces to support, turnOnEngine() and accelerate() methods.

// Another example to consider is, bank with different account types, where we don't allow withdrawals from fixed deposit
// accounts and saving and current accounts are allowed to withdraw.
// Refer: https://www.baeldung.com/java-liskov-substitution-principle