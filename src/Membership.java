public class Membership implements ITaxable{
    private String type;
    private double cost;

    @Override
    public double calculateSalesTax() {
        double taxRate = 0.1; // 1% Tax Rate
        return getCost() * taxRate;
    }

    // Overloaded Constructor
    public Membership(String type, double cost) {
        this.type = type;
        this.cost = cost;
    }

    // Getters and Setters
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

}