package src.com.stockflow.ui;

import src.com.stockflow.service.InventoryService;
import src.com.stockflow.model.Product;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Menu {
    private InventoryService service;
    private Scanner scanner;

    public Menu() {
        this.service = new InventoryService();
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        boolean running = true;
        while (running) {
            displayMainMenu();
            int option = getIntInput();

            switch (option) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    listProducts();
                    break;
                case 3:
                    searchProduct();
                    break;
                case 4:
                    updateStock();
                    break;
                case 5:
                    deleteProduct();
                    break;
                case 6:
                    showLowStockAlerts();
                    break;
                case 7:
                    generateReport();
                    break;
                case 0:
                    running = false;
                    System.out.println("\n👋 Thanks for using StockFlow. Goodbye!");
                    break;
                default:
                    System.out.println("❌ Invalid option. Try again.");
            }
        }
    }

    private void displayMainMenu() {
        System.out.println("\n╔════════════════════════════════════╗");
        System.out.println("║         STOCKFLOW - MAIN MENU       ║");
        System.out.println("╠════════════════════════════════════╣");
        System.out.println("║  1. Add Product                    ║");
        System.out.println("║  2. View Inventory                 ║");
        System.out.println("║  3. Search Product                 ║");
        System.out.println("║  4. Update Stock                   ║");
        System.out.println("║  5. Delete Product                 ║");
        System.out.println("║  6. Low Stock Alerts               ║");
        System.out.println("║  7. Generate Report                ║");
        System.out.println("║  0. Exit                           ║");
        System.out.println("╚════════════════════════════════════╝");
        System.out.print("Select an option: ");
    }

    private void addProduct() {
        System.out.println("\n--- Add New Product ---");

        System.out.print("Product name: ");
        String name = scanner.nextLine().trim();
        if (name.isEmpty()) {
            System.out.println("❌ Name cannot be empty.");
            return;
        }

        System.out.print("Product code (unique): ");
        String code = scanner.nextLine().trim().toUpperCase();
        if (code.isEmpty()) {
            System.out.println("❌ Code cannot be empty.");
            return;
        }

        System.out.print("Quantity: ");
        int quantity = getIntInput();
        if (quantity < 0) {
            System.out.println("❌ Quantity cannot be negative.");
            return;
        }

        System.out.print("Price: ");
        double price = getDoubleInput();
        if (price < 0) {
            System.out.println("❌ Price cannot be negative.");
            return;
        }

        System.out.print("Minimum stock: ");
        int minimumStock = getIntInput();
        if (minimumStock < 0) {
            System.out.println("❌ Minimum stock cannot be negative.");
            return;
        }

        Product product = new Product(name, code, quantity, price, minimumStock);
        service.addProduct(product);
    }

    private void listProducts() {
        System.out.println("\n--- Inventory List ---");
        List<Product> products= service.listAllProducts();

        if (products.isEmpty()) {
            System.out.println("📦 No products registered yet.");
            return;
        }

        for (Product p : products) {
            System.out.println(p);
        }
    }

    private void searchProduct() {
        System.out.println("\n--- Search Product ---");
        System.out.print("Enter product code or name: ");
        String search = scanner.nextLine().trim();

        Optional<Product> byCode = service.searchByCode(search.toUpperCase());
        if (byCode.isPresent()) {
            System.out.println("\n" + byCode.get());
            return;
        }

        List<Product> byName = service.searchByName(search);
        if (!byName.isEmpty()) {
            System.out.println("\nResults found:");
            for (Product p : byName) {
                System.out.println(p);
            }
        } else {
            System.out.println("❌ No products found.");
        }
    }

    private void updateStock() {
        System.out.println("\n--- Update Stock ---");
        System.out.print("Enter product code: ");
        String code = scanner.nextLine().trim().toUpperCase();

        System.out.print("New quantity: ");
        int newQuantity = getIntInput();

        if (newQuantity < 0) {
            System.out.println("❌ Quantity cannot be negative.");
            return;
        }

        service.updateQuantity(code, newQuantity);
    }

    private void deleteProduct() {
        System.out.println("\n--- Delete Product ---");
        System.out.print("Enter product code to delete: ");
        String code = scanner.nextLine().trim().toUpperCase();

        System.out.print("Are you sure? (y/n): ");
        String confirm = scanner.nextLine().trim().toLowerCase();
        if (confirm.equals("y")) {
            service.deleteProduct(code);
        } else {
            System.out.println("❌ Operation cancelled.");
        }
    }

    private void showLowStockAlerts() {
        System.out.println("\n--- Low Stock Alerts ---");
        List<Product> lowStock = service.getLowStockProducts();

        if (lowStock.isEmpty()) {
            System.out.println("✅ All products have sufficient stock.");
            return;
        }

        System.out.println("⚠️  " + lowStock.size() + " product(s) with low stock:\n");
        for (Product p : lowStock) {
            System.out.println(p);
        }
    }

    private void generateReport() {
        System.out.println(service.generateReport());
    }

    private int getIntInput() {
        try {
            int value = Integer.parseInt(scanner.nextLine().trim());
            return value;
        } catch (NumberFormatException e) {
            System.out.println("❌ Please enter a valid number.");
            return -1;
        }
    }

    private double getDoubleInput() {
        try {
            double value = Double.parseDouble(scanner.nextLine().trim());
            return value;
        } catch (NumberFormatException e) {
            System.out.println("❌ Please enter a valid number.");
            return -1;
        }
    }
}