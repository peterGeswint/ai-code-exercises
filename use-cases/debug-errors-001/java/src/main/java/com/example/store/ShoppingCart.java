// ShoppingCart.java
package com.example.store;

import java.util.ArrayList;
import java.util.List;

/**
 * 1. The Root Cause
 * The root cause is unvalidated input into the data structure.
 * 
 * In the Main.java,the cart.addItem(null) is called explicitly;. The
 * ShoppingCart
 * accepts this null and stores it in the items list. Later, when
 * calculateTotal() iterates through that list, it eventually reaches that null
 * entry. At line 22, the code attempts to execute null.getPrice(), which is
 * impossible, causing the crash.
 */

/**
 * Suggested Fixes
 * Option A: The "Gated Entry" (Recommended)
 * Prevent the null from ever entering your list. This is the best approach
 * because it keeps your data "clean."
 * 
 * Java
 * public void addItem(Product product) {
 * if (product != null) {
 * items.add(product);
 * } else {
 * System.err.println("Warning: Cannot add a null product to the cart.");
 * }
 * }
 * Option B: The "Defensive Loop"
 * If it can't be guaranteed the list is clean, it is best to check for null
 * during the
 * calculation.
 * 
 * Java
 * public double calculateTotal() {
 * double total = 0;
 * for (Product product : items) {
 * if (product != null) {
 * total += product.getPrice();
 * }
 * }
 * return total;
 * }
 * Option C: The Modern Stream Approach
 * Using Java Streams makes this very concise by filtering out nulls
 * automatically.
 * 
 * Java
 * public double calculateTotal() {
 * return items.stream()
 * .filter(java.util.Objects::nonNull)
 * .mapToDouble(Product::getPrice)
 * .sum();
 * }
 * 
 * Learning Points
 * Trusting the Caller. Never assume that the person using your method will pass
 * valid data.
 * Fail-Fast. If your application absolutely requires a product to be non-null,
 * use Objects.requireNonNull(product, "Product cannot be null"); in the
 * constructor or setter. This crashes the app immediately at the point of
 * failure rather than letting the null hide in a list until later.
 */

public class ShoppingCart {
    private List<Product> items;

    public ShoppingCart() {
        items = new ArrayList<>();
    }

    public void addItem(Product product) {
        items.add(product);
    }

    public double calculateTotal() {
        double total = 0;
        for (Product product : items) {
            // Error occurs when a null product is in the list
            total += product.getPrice();
        }
        return total;
    }

    public void checkout() {
        System.out.println("Total price: $" + calculateTotal());
        // Process payment etc.
    }
}