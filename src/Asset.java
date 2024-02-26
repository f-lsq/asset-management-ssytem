public class Asset {
    private String name;
    private double cost; // Historical cost (At date of purchase)
    private String id;

    protected double calculateMarkdown() {
        // Depreciation / Amortization (Assume both means the same thing)
        // Assume all assets uses straight-line method (no double-declining, etc)
        // Assume use of historical cost
        double markdownRate = 0.2; // per year
        return cost * markdownRate;
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