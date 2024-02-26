public class TangibleAsset extends Asset{
    private String dimension; // In meters (Length x Width x Height)
    private double weight; // In kilograms
    private String color;

    public void displayNetBookValue() {
        // For the current year
        double markdown = calculateMarkdown();
        double netBookValue = getCost() - markdown;
        System.out.println("Net Book Value for the Current Year: $" + netBookValue);
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
