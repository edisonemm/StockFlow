package src.com.stockflow.model;

import java.util.UUID;

public class Product {
    private String id;
    private String name;
    private String code;
    private int quantity;
    private double price;
    private int minimumStock;

    public Product(String name, String code, int quantity, double price, int minimumStock) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.code = code;
        this.quantity = quantity;
        this.price = price;
        this.minimumStock = minimumStock;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getCode() { return code; }
    public int getQuantity() { return quantity; }
    public double getPrice() { return price; }
    public int getMinimumStock() { return minimumStock; }

    public void setQuantity(int quantity) { this.quantity = quantity; }

    // Business logic
    public boolean isLowStock() {
        return quantity < minimumStock;
    }
    public double getTotalValue() {
        return quantity * price;
    }

    @Override
    public String toString() {
        return String.format("[%s] %s (Code: %s) | Stock: %d | Price: $%.2f | Total: $%.2f %s",
                id.substring(0, 8),
                name,
                code,
                quantity,
                price,
                getTotalValue(),
                isLowStock() ? "⚠️ LOW STOCK" : "");
    }
}
