class InputReader {
    public static String getString() {
        // write your code here
        // Create a Scanner object using fully qualified class name
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        // Read the next line of input
        String input = scanner.nextLine();

        // Close the scanner
        scanner.close();

        // Return the input string
        return input;
    }
}