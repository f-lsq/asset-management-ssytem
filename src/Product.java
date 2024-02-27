import java.util.Scanner;
public abstract class Product implements ITaxable{ // Product class (abstract base class) cannot be instantiated
    protected String name;
    protected double price;
    protected String sku;

    @Override
    public double calculateSalesTax() {
        double taxRate = 0.09; // 9% Tax Rate
        return getPrice() * taxRate;
    }

    public void displayDetails() {
        System.out.println("Product name: " + getName());
        System.out.println("Product price: " + getPrice());
        System.out.println("Product sku: " + getSku());
    }

    public void editDetails() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the updated name: ");
        String updatedName = scanner.nextLine();
        this.setName(updatedName);

        System.out.println("Enter the updated price");
        double updatedPrice = scanner.nextDouble();
        scanner.nextLine(); //consumes the newline character in the buffer
        this.setPrice(updatedPrice);

        System.out.println("Enter the updated SKU");
        String updatedSku = scanner.nextLine();
        this.setSku(updatedSku);
    }

    // Default Constructor
    public Product(){
        this.name = "N/A";
        this.price = 0.0;
        this.sku = "N/A";
    }

    // Overloaded Constructor
    public Product(String name, double price, String sku) {
        this.name = name;
        this.price = price;
        this.sku = sku;
    }

    // Getters and Setters (since other classes cannot assess the private variables)
    public String getName() {
        return name;
    }

    public void setName(String name) throws IllegalArgumentException{
        if (name != null && !name.isEmpty()){
            this.name = name;
        } else {
            throw new IllegalArgumentException("Illegal name. Please provide a non-empty string.");
        }

    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) throws IllegalArgumentException{
        if (price >= 0) {
            this.price = price;
        } else {
            throw new IllegalArgumentException("Illegal price. Please provide a non-negative value.");
        }
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) throws IllegalArgumentException{
        if (sku != null && !sku.isEmpty()) {
            this.sku = sku;
        } else {
            throw new IllegalArgumentException("Invalid SKU. Please provide a non-empty string.");
        }

    }

}