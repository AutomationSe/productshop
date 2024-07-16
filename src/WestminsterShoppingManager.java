import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class WestminsterShoppingManager implements ShoppingManager, Serializable {

    private static ArrayList<Product> productList = new ArrayList<Product>();
    private static final int MAX_PRODUCTS = 50;
    private Scanner scanner;
    private boolean isManager;

    public WestminsterShoppingManager() {
        productList = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    @Override
    public void addProduct() {

        if (productList.size() >= MAX_PRODUCTS) {
            System.out.println("Maximum number of products reached. Cannot add more.");
            return;
        }

        System.out.println("Enter product type (1 for Electronics, 2 for Clothing):");
        int type = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter product ID:");
        String id = scanner.nextLine();

        System.out.println("Enter product name:");
        String name = scanner.nextLine();

        System.out.println("Enter available items:");
        int availableItems = scanner.nextInt();

        System.out.println("Enter price:");
        double price = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        if (type == 1) {
            System.out.println("Enter brand:");
            String brand = scanner.nextLine();

            System.out.println("Enter warranty period (in months):");
            int warrantyPeriod = scanner.nextInt();

            productList.add(new Electronics(id, name, availableItems, price, brand, warrantyPeriod));
        } else if (type == 2) {
            System.out.println("Enter size:");
            String size = scanner.nextLine();

            System.out.println("Enter color:");
            String color = scanner.nextLine();

            productList.add(new Clothing(id, name, availableItems, price, size, color));
        } else {
            System.out.println("Invalid product type.");
            return;
        }

        System.out.println("Product added successfully.");


    }

    @Override
    public void deleteProduct() {

        System.out.println("Enter product ID to delete:");
        String id = scanner.nextLine();

        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getProductId().equals(id)) {
                Product removedProduct = productList.remove(i);
                System.out.println("Product removed: " + removedProduct.getProductName());
                System.out.println("Total products left: " + productList.size());
                return;
            }
        }

    }

    @Override
    public void printList() {

    }

    @Override
    public void save() {

    }

    public static void main(String[] args) {
        WestminsterShoppingManager manager = new WestminsterShoppingManager();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Select user type:");
        System.out.println("1. Manager");
        System.out.println("2. User");
        System.out.print("Enter your choice: ");
        int userType = scanner.nextInt();
        scanner.nextLine();

        manager.isManager = (userType == 1);

        while (true) {
            System.out.println("\nWestminster Shopping Manager");
            System.out.println("1. Add a product");
            System.out.println("2. Delete a product");
            System.out.println("3. Print product list");
            System.out.println("4. Save to file");
            System.out.println("5. Load from file");
            System.out.println("6. Open GUI");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (!manager.isManager && choice != 6 && choice != 7) {
                System.out.println("Access denied. Users can only open GUI or exit.");
                continue;
            }

            switch (choice) {
                case 1:
                    manager.addProduct();
                    break;
                case 2:
                    manager.deleteProduct();
                    break;
                case 3:
//                    manager.printProductList();
//                    break;
                case 4:
//                    manager.saveToFile();
//                    break;
                case 5:
//                    manager.loadFromFile();
//                    break;
                case 6:
//                    manager.openGUI();
//                    break;
                case 7:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

    }
}
