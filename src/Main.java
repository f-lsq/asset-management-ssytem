//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.sql.SQLOutput;
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
                displayAssets();
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
                System.out.println("Enter the dimension of the tangible asset (in meters - L x W x H): ");
                String dimension = scanner.nextLine();
                System.out.println("Enter the weight of the tangible asset (in kilograms): ");
                double weight = scanner.nextDouble();
                scanner.nextLine(); // consume the newline character remaining in the buffer
                System.out.println("Enter the color of the tangible asset: ");
                String color = scanner.nextLine();

                TangibleAsset tangibleAsset = new TangibleAsset(name, cost, id, dimension, weight, color);
                assetList.add(tangibleAsset);
                System.out.println("Tangible asset added successfully");
                break;
            } else if (choice == 2) {
                System.out.println("Enter the type of the intangible asset (definite or indefinite): ");
                String type = scanner.nextLine();
                System.out.println("Enter the duration of the intangible asset (in years): ");
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
        for (int i = 0; i < assetList.size(); i++) {
            Asset asset = assetList.get(i);
            System.out.println("Asset #" + i);
            asset.displayDetails();
            System.out.println("------------------");
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose an option:");
        System.out.println("1. Exit");
        System.out.println("2. Edit a asset");
        System.out.println("3. Delete a asset");
        int option = scanner.nextInt();

        if (option == 2) {
            System.out.println("Enter the index of the asset you want to edit");
            int index = scanner.nextInt();
            scanner.nextLine(); //consumes the newline character in the buffer
            if (index >= 0 && index < assetList.size()) {
                Asset assetToUpdate = assetList.get(index);
                editAsset(assetToUpdate);
            } else {
                System.out.println("Invalid Index.");
            }
        } else if (option == 3) {
            System.out.println("Enter the index of the asset you want to delete: ");
            int index = scanner.nextInt();
            scanner.nextLine(); //consumes the newline character in the buffer
            if (index >= 0 && index < assetList.size()) {
                assetList.remove(index);
                System.out.println("Asset deleted");
            } else {
                System.out.println("Invalid Index.");
            }
        }


    }

    public static void editAsset(Asset asset) {
        asset.editDetails();
    }

}