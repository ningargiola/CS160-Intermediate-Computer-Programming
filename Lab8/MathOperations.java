package edu.sdsu.cs160l.calculator;

/**
 * TODO change MathOperation class so that it has a dependency on DoubleCalculator class and not SimpleCalculator
 *  what you also need to do is change the method signatures from int to double.
 *
 */
public class MathOperations {

    private Calculator<Double> calculator;

    public MathOperations() {
        // TODO change this to use DoubleCalculator
        this.calculator = new DoubleCalculator();
    }

    // Do not change this to double, let it be int only
    public int factorial(int n) {
        double factorial = 1;
        for(double i=2;i<=n;i++){
            factorial = calculator.multiply(factorial, i);
        }
        return (int) factorial;
    }

    public double average(double[] arr){
        double sum=0;
        for(double i : arr){
            sum = calculator.add(sum, i);
        }

        return calculator.divide(sum, Double.valueOf(arr.length));
    }

    // Make sure the second variable is int only
    // the signature should look like double power(double a, int b)
    public double power(double a, int b){
        double res = 1;
        for(int i=1;i<=b;i++){
            res = calculator.multiply(res, a);
        }
        return  res;
    }

    public double midValue(double a, double b){
        Double sub = calculator.add(a, b);
        Double midValue = calculator.divide(sub, 2.0);
        return midValue;
    }

    public double fahrenheitToCelsius(double fahrenheit){
        Double baseSubtraction = calculator.subtract(fahrenheit, 32.0);
        Double baseMultiplication = calculator.multiply(baseSubtraction, 5.0);
        Double baseDivision = calculator.divide(baseMultiplication, 9.0);
        return baseDivision;
    }
}
