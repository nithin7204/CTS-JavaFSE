import java.util.Arrays;
import java.util.Comparator;

public class Tester {
    public static void main(String[] args) {
        Product[] products = {
            new Product(101, "Laptop", "Electronics"),
            new Product(205, "Shoes", "Footwear"),
            new Product(150, "Watch", "Accessories"),
            new Product(300, "Phone", "Electronics")
        };

        Product foundLinear = SearchService.linearSearch(products, 150);
        if (foundLinear != null) {
            System.out.println("Linear Search: Found - " + foundLinear.productName);
        }

        Arrays.sort(products, Comparator.comparingInt(p -> p.productId));
        Product foundBinary = SearchService.binarySearch(products, 150);
        if (foundBinary != null) {
            System.out.println("Binary Search: Found - " + foundBinary.productName);
        }
    }
}
