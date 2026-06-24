package src.com.stockflow.service;


import src.com.stockflow.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InventoryService {
     private List<Product> products;

     public InventoryService() {
          this.products = new ArrayList<>();
     }

     // Add product`1
     public boolean addProduct(Product product) {
          if (codeExists(product.getCode())) {
               System.out.println("❌ Product with code " + product.getCode() + " already exists.");
               return false;
          }
          products.add(product);
          System.out.println("✅ Product added successfully.");
          return true;
     }

     // List all products
     public List<Product> listAllProducts() {
          return new ArrayList<>(products);
     }

     // Search by code
     public Optional<Product> searchByCode(String code) {
          return products.stream()
                  .filter(p -> p.getCode().equals(code))
                  .findFirst();
     }

     // Search by name
     public List<Product> searchByName(String name) {
          List<Product> results = new ArrayList<>();
          for (Product p : products) {
               if (p.getName().toLowerCase().contains(name.toLowerCase())) {
                    results.add(p);
               }
          }
          return results;
     }

     // Update quantity
     public boolean updateQuantity(String code, int newQuantity) {
          Optional<Product> product = searchByCode(code);
          if (product.isPresent()) {
               product.get().setQuantity(newQuantity);
               System.out.println("✅ Product updated.");
               return true;
          }
          System.out.println("❌ Product not found.");
          return false;
     }

     // Delete product
     public boolean deleteProduct(String code) {
          Optional<Product> product = searchByCode(code);
          if (product.isPresent()) {
               products.remove(product.get());
               System.out.println("✅ Product deleted.");
               return true;
          }
          System.out.println("❌ Product not found.");
          return false;
     }

     // Get low stock products
     public List<Product> getLowStockProducts() {
          List<Product> lowStock = new ArrayList<>();
          for (Product p : products) {
               if (p.isLowStock()) {
                    lowStock.add(p);
               }
          }
          return lowStock;
     }

     // Generate report
     public String generateReport() {
          StringBuilder report = new StringBuilder();
          report.append("\n========== INVENTORY REPORT ==========\n");
          report.append("Total Products: ").append(products.size()).append("\n");
          report.append("Total Inventory Value: $").append(String.format("%.2f", getTotalInventoryValue())).append("\n");
          report.append("Products with Low Stock: ").append(getLowStockProducts().size()).append("\n\n");

          for (Product p : products) {
               report.append(p.toString()).append("\n");
          }
          report.append("=======================================\n");
          return report.toString();
     }

     // Calculate total inventory value
     public double getTotalInventoryValue() {
          return products.stream()
                  .mapToDouble(Product::getTotalValue)
                  .sum();
     }

     // Helper method
     private boolean codeExists(String code) {
          return products.stream().anyMatch(p -> p.getCode().equals(code));
     }
}