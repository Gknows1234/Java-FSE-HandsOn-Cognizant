




public class SearchTest {
    public static void main(String[] args) {
        Product[] catalog = {
            new Product(7, "Headphones", "Audio"),
            new Product(3, "Sneakers", "Footwear"),
            new Product(1, "Novel", "Books"),
            new Product(9, "Desk Lamp", "Furniture"),
            new Product(5, "Smartwatch", "Electronics"),
            new Product(2, "Backpack", "Accessories")
        };

        int searchTarget = 5;

        System.out.println("=== Linear Search ===");
        long startLinear = System.nanoTime();
        Product linearResult = SearchAlgorithms.linearSearch(catalog, searchTarget);
        long durationLinear = System.nanoTime() - startLinear;
        System.out.println("Result : " + linearResult);
        System.out.println("Time   : " + durationLinear + " ns");

        System.out.println("\n=== Binary Search ===");
        long startBinary = System.nanoTime();
        Product binaryResult = SearchAlgorithms.binarySearch(catalog, searchTarget);
        long durationBinary = System.nanoTime() - startBinary;
        System.out.println("Result : " + binaryResult);
        System.out.println("Time   : " + durationBinary + " ns");

        System.out.println("\n=== Search for non-existent ID (99) ===");
        Product missing = SearchAlgorithms.linearSearch(catalog, 99);
        System.out.println("Linear result: " + missing);
        missing = SearchAlgorithms.binarySearch(catalog, 99);
        System.out.println("Binary result: " + missing);
    }
}
