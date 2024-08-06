import java.util.Scanner;

class Package {
    private double weight;

    public Package(double weight) {
        this.weight = weight;
    }

    public double getShippingCost() {
        return 5 + (weight > 5 ? Math.ceil(weight) - 5: 0);
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double weight = sc.nextDouble();
        Package p = new Package(weight);
        System.out.println(p.getShippingCost());

        sc.close();

    }
}