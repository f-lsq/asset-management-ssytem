import java.util.Scanner;

public class TangibleAsset extends Asset{
    private String dimension; // In meters (Length x Width x Height)
    private double weight; // In kilograms
    private String color;

    public void displayNetBookValue() {
        // For the current year
        double markdown = calculateMarkdown();
        double netBookValue = getCost() - markdown;
        System.out.println("Net book value for the current year: $" + netBookValue);
    }

    @Override
    public void displayDetails() {
        // Call displayDetails() method from Asset class (parent)
        super.displayDetails();
        System.out.println("Tangible asset dimension: " + getDimension() + "m");
        System.out.println("Tangible asset weight: " + getWeight() + "kg");
        System.out.println("Tangible asset color: " + getColor());
    }

    @Override
    public void editDetails() {
        // Call editDetails() method from Asset class (parent)
        super.editDetails();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the updated dimension (in meters - L x W x H): " + getDimension());
        String updatedDimension = scanner.nextLine();
        this.setDimension(updatedDimension);

        System.out.println("Enter the updated weight (in kilograms): " + getWeight());
        double updatedWeight = scanner.nextDouble();
        scanner.nextLine(); //consumes the newline character in the buffer
        this.setWeight(updatedWeight);

        System.out.println("Enter the new color: " + getColor());
        String updatedColor = scanner.nextLine();
        this.setColor(updatedColor);
    }

    // Default Constructor
    public TangibleAsset(){
        // Inherits default constructor from Asset class (parent)
        super();
        this.dimension = "N/A";
        this.weight = 0.0;
        this.color = "N/A";
    }

    // Overloaded Constructor
    public TangibleAsset(String name, double cost, String id, String dimension, double weight, String color){
        // Call the constructor from Asset class (parent)
        super(name, cost, id);
        this.dimension = dimension;
        this.weight = weight;
        this.color = color;
    }

    // Getter and Setters
    public String getDimension(){
        return dimension;
    }

    public void setDimension(String dimension) throws IllegalArgumentException{
        if (dimension != null && !dimension.isEmpty()) {
            this.dimension = dimension;
        } else {
            throw new IllegalArgumentException("Invalid dimension. Please provide a non-empty string.");
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
