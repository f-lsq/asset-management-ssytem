import java.util.Scanner;
public abstract class Asset { // Asset class (abstract base class) cannot be instantiated
    private String name;
    private double cost; // Historical cost (At date of purchase)
    private String id;

    public abstract double calculateMarkdown() {
        /// ???
    }

    public void displayDetails() {
        System.out.println("Asset name: " + getName());
        System.out.println("Asset cost: " + getCost());
        System.out.println("Asset id: " + getId());
    }

    public void editDetails() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the updated name: ");
        String updatedName = scanner.nextLine();
        this.setName(updatedName);

        System.out.println("Enter the updated cost");
        double updatedCost = scanner.nextDouble();
        scanner.nextLine(); //consumes the newline character in the buffer
        this.setCost(updatedCost);

        System.out.println("Enter the updated id");
        String updatedId = scanner.nextLine();
        this.setId(updatedId);
    }

    // Default Constructor
    public Asset(){
        this.name = "N/A";
        this.cost = 0.0;
        this.id = "N/A";
    }

    // Overloaded Constructor
    public Asset(String name, double cost, String id) {
        this.name = name;
        this.cost = cost;
        this.id = id;
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

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) throws IllegalArgumentException{
        if (cost >= 0) {
            this.cost = cost;
        } else {
            throw new IllegalArgumentException("Illegal cost. Please provide a non-negative value.");
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) throws IllegalArgumentException{
        if (id != null && !id.isEmpty()) {
            this.id = id;
        } else {
            throw new IllegalArgumentException("Invalid ID. Please provide a non-empty string.");
        }

    }

}