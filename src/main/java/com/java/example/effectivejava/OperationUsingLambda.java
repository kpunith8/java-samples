package com.java.example.effectivejava;

import java.util.function.DoubleBinaryOperator;

public enum OperationUsingLambda
{
    PLUS("+", (x, y) -> x + y),
    MINUS("-", (x, y) -> x - y),
    TIMES("*", (x, y) -> x * y),
    DEVIDE("/", (x, y) -> x / y);

    private final String symbol;
    private final DoubleBinaryOperator operator;

    private OperationUsingLambda(String symbol, DoubleBinaryOperator operator)
    {
        this.symbol = symbol;
        this.operator = operator;
    }

    @Override
    public String toString()
    {
        return symbol;
    }

    public double apply(double x, double y)
    {
        return operator.applyAsDouble(x, y);
    }
}
