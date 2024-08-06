import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        // number of known words
        int d = scanner.nextInt();
        scanner.nextLine();

        Set<String> knownWords = new HashSet<>();
        for (int i = 0; i < d; i++) {
            String word = scanner.nextLine().toLowerCase();
            knownWords.add(word);
        }

        // number of lines of text
        int l = scanner.nextInt();
        scanner.nextLine();

        // Set to store erroneous words (to avoid duplicates)
        Set<String> wrongWords = new HashSet<>();
        Set<String> outputWords = new HashSet<>(); // To maintain output order

        // Read the lines of text
        for (int i = 0; i < l; i++) {
            String line = scanner.nextLine().toLowerCase();
            String[] words = line.split(" ");
            for (String word : words) {
                if (!knownWords.contains(word) && !wrongWords.contains(word)) {
                    wrongWords.add(word);
                    outputWords.add(word);
                }
            }
        }

        // Print the erroneous words
        for (String word : outputWords) {
            System.out.println(word);
        }

    }
}