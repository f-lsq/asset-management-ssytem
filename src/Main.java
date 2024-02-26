//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Asset> assetList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        do {
            int choice = displayMenu();
            if (choice == 1) {
                addNewAsset();
            } if (choice == 2) {
                // displayAssets();
            }else if (choice == 3) {
                break;
            }
        } while (true);
    }

    private static int displayMenu() {
        int choice = 0;

        while(true) {
            System.out.println("Menu");
            System.out.println("1. Add an asset");
            System.out.println("2. List all assets");
            System.out.println("3. Exit");
            System.out.println("Enter your choice");
            choice = scanner.nextInt();
            scanner.nextLine(); //consumes the newline character in the buffer
            if (choice >= 1 && choice <= 3) {
                break;
            }
        } return choice;
    }

    private static void addNewAsset() {
        System.out.println("Enter the name of the asset: ");
        String name = scanner.nextLine();
        System.out.println("Enter the cost of the asset: ");
        double cost = scanner.nextDouble();
        scanner.nextLine(); //consumes the newline character in the buffer
        System.out.println("Enter the ID of the asset: ");
        String id = scanner.nextLine();

        while(true) {
            System.out.println("Choose the type of asset: ");
            System.out.println("1. Tangible Asset");
            System.out.println("2. Intangible Asset");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume the newline character remaining in the buffer

            if (choice == 1) {
                System.out.println("Enter the dimension of the tangible asset: ");
                String dimension = scanner.nextLine();
                System.out.println("Enter the weight of the tangible asset: ");
                double weight = scanner.nextDouble();
                scanner.nextLine(); // consume the newline character remaining in the buffer
                System.out.println("Enter the color of the tangible asset: ");
                String color = scanner.nextLine();

                TangibleAsset tangibleAsset = new TangibleAsset(name, cost, id, dimension, weight, color);
                assetList.add(tangibleAsset);
                System.out.println("Tangible asset added successfully");
                break;
            } else if (choice == 2) {
                System.out.println("Enter the type of the intangible asset: ");
                String type = scanner.nextLine();
                System.out.println("Enter the duration of the intangible asset: ");
                double duration = scanner.nextDouble();
                scanner.nextLine(); // consume the newline character remaining in the buffer

                IntangibleAsset intangibleAsset = new IntangibleAsset(name, cost, id, type, duration);
                assetList.add(intangibleAsset);
                System.out.println("Intangible asset added successfully");
                break;
                } else {
                System.out.println("Invalid choice. Please try again.");
                }
            }
        }
    private static void displayAssets() {
        System.out.println("List of assets:");
        for (Asset asset : assetList) {
            System.out.println("Name: " + asset.getName());
            System.out.println("Cost: " + asset.getCost());
            System.out.println("Id: " + asset.getId());
            System.out.println("----------------------");
        }
    }

}