import java.util.HashMap;
import java.util.Scanner;

public class InventoryManagementSystem {

    // Product class definition
    static class Product {
        int productId;
        String productName;
        int quantity;
        double price;

        public Product(int productId, String productName, int quantity, double price) {
            this.productId = productId;
            this.productName = productName;
            this.quantity = quantity;
            this.price = price;
        }

        @Override
        public String toString() {
            return "ID: " + productId + ", Name: " + productName +
                   ", Quantity: " + quantity + ", Price: ₹" + price;
        }
    }

    // Inventory class with operations
    static class Inventory {
        private HashMap<Integer, Product> inventoryMap = new HashMap<>();

        public void addProduct(Product product) {
            if (!inventoryMap.containsKey(product.productId)) {
                inventoryMap.put(product.productId, product);
                System.out.println("✅ Product added: " + product.productName);
            } else {
                System.out.println("⚠️ Product ID already exists.");
            }
        }

        public void updateProduct(int productId, int newQuantity, double newPrice) {
            if (inventoryMap.containsKey(productId)) {
                Product p = inventoryMap.get(productId);
                p.quantity = newQuantity;
                p.price = newPrice;
                System.out.println("✅ Product updated: " + p.productName);
            } else {
                System.out.println("❌ Product ID not found.");
            }
        }

        public void deleteProduct(int productId) {
            if (inventoryMap.containsKey(productId)) {
                inventoryMap.remove(productId);
                System.out.println("✅ Product deleted.");
            } else {
                System.out.println("❌ Product ID not found.");
            }
        }

        public void printInventory() {
            if (inventoryMap.isEmpty()) {
                System.out.println("📦 Inventory is empty.");
                return;
            }
            System.out.println("\n📋 Current Inventory:");
            for (Product p : inventoryMap.values()) {
                System.out.println(p);
            }
        }
    }

    // Main method with sample usage
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n---- Inventory Management Menu ----");
            System.out.println("1. Add Product");
            System.out.println("2. Update Product");
            System.out.println("3. Delete Product");
            System.out.println("4. Show Inventory");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Product ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();  // consume newline
                    System.out.print("Enter Product Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Quantity: ");
                    int qty = sc.nextInt();
                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();
                    inventory.addProduct(new Product(id, name, qty, price));
                    break;
                case 2:
                    System.out.print("Enter Product ID to update: ");
                    int uid = sc.nextInt();
                    System.out.print("Enter New Quantity: ");
                    int newQty = sc.nextInt();
                    System.out.print("Enter New Price: ");
                    double newPrice = sc.nextDouble();
                    inventory.updateProduct(uid, newQty, newPrice);
                    break;
                case 3:
                    System.out.print("Enter Product ID to delete: ");
                    int did = sc.nextInt();
                    inventory.deleteProduct(did);
                    break;
                case 4:
                    inventory.printInventory();
                    break;
                case 0:
                    System.out.println("👋 Exiting Inventory System...");
                    break;
                default:
                    System.out.println("⚠️ Invalid choice. Try again.");
            }
        } while (choice != 0);

        sc.close();
    }
}
