package main.com.java.example.strategy;

/**
 * Behavirol pattern
 *
 * @author Punith K
 */
public class StrategyPattern {
    static StrategyContext addContext = new StrategyContext(new OperationAdd());
    static StrategyContext subtractContext = new StrategyContext(new OperationSubtract());

    public static void main(String[] args) {
        System.out.println(addContext.executeStrategy(20, 40));
        System.out.println(subtractContext.executeStrategy(20, 40));
    }
}

interface Strategy {
    int doOperation(int a, int b);
}

class OperationAdd implements Strategy {
    @Override
    public int doOperation(int a, int b) {
        return a + b;
    }
}

class OperationSubtract implements Strategy {
    @Override
    public int doOperation(int a, int b) {
        return a - b;
    }
}

class StrategyContext {
    private final Strategy strategy;

    public StrategyContext(Strategy strategy) {
        this.strategy = strategy;
    }

    public int executeStrategy(int num1, int num2) {
        return strategy.doOperation(num1, num2);
    }
}
