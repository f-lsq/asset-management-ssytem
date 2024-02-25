//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Asset asset1 = new Asset();
        asset1.setName("XPS 17 Laptop");
        asset1.setCost(450.00);
        asset1.setId("A-00125");

        Asset asset2 = new Asset();
        asset2.setName("CP Plus CP-VAC-T50PL2-V2 5MP CCTV");
        asset2.setCost(150.00);
        asset2.setId("A-00342");

        System.out.println("Asset1:");
        System.out.println("Name - " + asset1.getName());
        System.out.println("Cost - " + asset1.getCost());
        System.out.println("Id - " + asset1.getId());

        System.out.println("Asset2:");
        System.out.println("Name - " + asset2.getName());
        System.out.println("Cost - " + asset2.getCost());
        System.out.println("Id - " + asset2.getId());
    }
}
