// FactorialCalculator.java
package com.example.recursion;

/**
 * A utility class for calculating factorials.
 * 
 * The factorial of a non-negative integer n is the product of all
 * positive integers less than or equal to n.
 * 
 * For example:
 * 5! = 5 × 4 × 3 × 2 × 1 = 120
 */
public class FactorialCalculator {

    /**
     * Main method to demonstrate the factorial calculation.
     */
    public static void main(String[] args) {
        int result = calculateFactorial(5);
        System.out.println("Factorial of 5 is: " + result);
    }

    /**
     * Calculates the factorial of a number recursively.
     * 
     * @param num The number to calculate factorial for
     * @return The factorial value
     */

    /**
     * 1. The Root Cause
     * The root cause is a missing base case.
     * 
     * In recursion, a base case is the "stop sign" that tells the function to stop
     * calling itself. Without it, your function calculateFactorial(num) will keep
     * subtracting 1 from num forever (5, 4, 3, 2, 1, 0, -1, -2...). Eventually, the
     * JVM runs out of memory in the Stack—the area reserved for tracking active
     * method calls—resulting in the java.lang.StackOverflowError.
     * 
     * // FactorialCalculator.java
     * package com.example.recursion;
     * 
     * public class FactorialCalculator {
     * public static void main(String[] args) {
     * int result = calculateFactorial(5);
     * System.out.println("Factorial of 5 is: " + result);
     * }
     * 
     * public static int calculateFactorial(int num) {
     * // Missing base case or incorrect recursive call
     * // This will cause infinite recursion
     * return num * calculateFactorial(num - 1);
     * }
     * }
     * 
     * Learning Points
     * Blind Recursion. Never write a recursive function without writing the if
     * (baseCase) condition first.
     * Ignoring Integer Overflow. An int in Java can only hold up to
     * $2,147,483,647$. Since factorials grow explosively, $13!$ will exceed this
     * limit and give you a wrong/negative result.
     * Fail-Fast. If your application absolutely requires a product to be non-null,
     * use Objects.requireNonNull(product, "Product cannot be null"); in the
     * constructor or setter. This crashes the app immediately at the point of
     * failure rather than letting the null hide in a list until later.
     */

    public static int calculateFactorial(int num) {
        // Added the missing base case - Base Case: stop at 0 or 1
        if (num <= 1) {
            return 1;
        }
        return num * calculateFactorial(num - 1);
    }
}