import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the string input from the user
        String input = scanner.nextLine();

        // Split the string by commas into an array of names
        String[] names = input.split(",");

        // TODO: Implement a Set to keep track of unique names
        // The Set interface is part of Java's collections framework and is used
        // to store unique elements - duplicates are automatically disregarded
        Set<String> uniqueNames = new LinkedHashSet<>();
        for (String name : names) {
            uniqueNames.add(name);
        }
        String result = String.join(",", uniqueNames);
        System.out.println(result);


    }
}