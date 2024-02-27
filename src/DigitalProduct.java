import java.util.Scanner;

public class DigitalProduct extends Product {
    private String format; // pdf, epub, etc
    private String downloadLink; // https link

    public void displayNetPrice() {
        double tax = calculateSalesTax();
        double netPrice = getPrice() + tax;
        System.out.println("Net price: $" + netPrice);
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Digital product format: " + getFormat());
        System.out.println("Digital product download link: " + getDownloadLink());
    }

    @Override
    public void editDetails() {
        Scanner scanner = new Scanner(System.in);
        super.editDetails();

        System.out.println("Enter the updated format (pdf, epub, etc): ");
        String updatedFormat = scanner.nextLine();
        this.setFormat(updatedFormat);

        System.out.println("Enter the updated download link: ");
        String updatedDownloadLink = scanner.nextLine();
        this.setDownloadLink(updatedDownloadLink);
    }

    // Default Constructor
    public DigitalProduct(){
        // Inherits default constructor from Product class (parent)
        super();
        this.format = "N/A";
        this.downloadLink = "N/A";
    }

    // Overloaded Constructor
    public DigitalProduct(String name, double cost, String id, String format, String downloadLink) {
        // Call the constructor from Product class (parent)
        super(name, cost, id);
        this.format = format;
        this.downloadLink = downloadLink;
    }

    // Getters and Setters
    public String getFormat(){
        return format;
    }

    public void setFormat(String format) throws IllegalArgumentException{
        if (format != null && !format.isEmpty()) {
            this.format = format;
        } else {
            throw new IllegalArgumentException("Invalid format. Please provide a non-empty string.");
        }
    }

    public String getDownloadLink(){
        return downloadLink;
    }

    public void setDownloadLink(String downloadLink) throws IllegalArgumentException{
        if (downloadLink != null && !downloadLink.isEmpty()) {
            this.downloadLink = downloadLink;
        } else {
            throw new IllegalArgumentException("Invalid download link. Please provide a non-empty string.");
        }
    }


}
