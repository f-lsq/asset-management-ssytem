import java.util.Scanner;

public class PhysicalProduct extends Product {
    private String size; // S, M, L, XL, etc
    private double weight; // In kilograms
    private String color;

    public void displayNetPrice() {
        double tax = calculateSalesTax();
        double netPrice = getPrice() + tax;
        System.out.println("Net price: $" + netPrice);
    }

    @Override
    public void displayDetails() {
        // Call displayDetails() method from Product class (parent)
        super.displayDetails();
        System.out.println("Physical product size: " + getSize());
        System.out.println("Physical product weight: " + getWeight() + "kg");
        System.out.println("Physical product color: " + getColor());
    }

    @Override
    public void editDetails() {
        // Call editDetails() method from Product class (parent)
        super.editDetails();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the updated size (S, M, L, XL, etc): " + getSize());
        String updatedSize = scanner.nextLine();
        this.setSize(updatedSize);

        System.out.println("Enter the updated weight (in kilograms): " + getWeight());
        double updatedWeight = scanner.nextDouble();
        scanner.nextLine(); //consumes the newline character in the buffer
        this.setWeight(updatedWeight);

        System.out.println("Enter the new color: " + getColor());
        String updatedColor = scanner.nextLine();
        this.setColor(updatedColor);
    }

    // Default Constructor
    public PhysicalProduct(){
        // Inherits default constructor from Product class (parent)
        super();
        this.size = "N/A";
        this.weight = 0.0;
        this.color = "N/A";
    }

    // Overloaded Constructor
    public PhysicalProduct(String name, double cost, String id, String size, double weight, String color){
        // Call the constructor from Product class (parent)
        super(name, cost, id);
        this.size = size;
        this.weight = weight;
        this.color = color;
    }

    // Getter and Setters
    public String getSize(){
        return size;
    }

    public void setSize(String size) throws IllegalArgumentException{
        if (size != null && !size.isEmpty()) {
            this.size = size;
        } else {
            throw new IllegalArgumentException("Invalid size. Please provide a non-empty string.");
        }
    }

    public double getWeight(){
        return weight;
    }

    public void setWeight(double weight) throws IllegalArgumentException{
        if (weight >= 0) {
            this.weight = weight;
        } else {
            throw new IllegalArgumentException("Illegal cost. Please provide a non-negative value.");
        }
    }

    public String getColor(){
        return color;
    }

    public void setColor(String color) throws IllegalArgumentException{
        if (color != null && !color.isEmpty()) {
            this.color = color;
        } else {
            throw new IllegalArgumentException("Invalid color. Please provide a non-empty string.");
        }
    }
}
