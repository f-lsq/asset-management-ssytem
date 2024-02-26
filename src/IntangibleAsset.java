public class IntangibleAsset extends Asset{
    private String type; // Definite (eg. Legal Agreement) or Indefinite (eg. Brand name)
    private double duration; // in Years

    public void displayNetBookValue() {
        // For the current year
        double markdown = calculateMarkdown();
        double netBookValue = getCost() - markdown;
        System.out.println("Net Book Value for the Current Year: $" + netBookValue);
    }

    // Default Constructor
    public IntangibleAsset(){
        // Inherits default constructor from Asset class (parent)
        super();
        this.type = "N/A";
        this.duration = 0.0;
    }

    // Overloaded Constructor
    public IntangibleAsset(String name, double cost, String id, String type, double duration) {
        // Call the constructor from Asset class (parent)
        super(name, cost, id);
        this.type = type;
        this.duration = duration;
    }

    // Getters and Setters
    public String getType(){
        return type;
    }

    public void setType(String type) throws IllegalArgumentException{
        if (type != null && !type.isEmpty()) {
            this.type = type;
        } else {
            throw new IllegalArgumentException("Invalid type. Please provide a non-empty string.");
        }
    }

    public double getDuration(){
        return duration;
    }

    public void setDuration(double duration) throws IllegalArgumentException{
        if (duration >= 0) {
            this.duration = duration;
        } else {
            throw new IllegalArgumentException("Illegal duration. Please provide a non-negative value.");
        }
    }


}
