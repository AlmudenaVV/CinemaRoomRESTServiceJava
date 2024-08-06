import java.util.Scanner;

class BinarySearch {
    /**
     * @param nums ordered sequence of integers
     * @param key  an element for searching
     * @return index of key or a negative value
     */
    public static int callBinarySearch(int[] nums, int key) {
        // write your code here
        return java.util.Arrays.binarySearch(nums, key);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the array from input (space-separated integers)
        String[] input = scanner.nextLine().split(" ");
        int[] sortedArray = new int[input.length];

        // Parse the integers from the input
        for (int i = 0; i < input.length; i++) {
            sortedArray[i] = Integer.parseInt(input[i]);
        }

        // Read the key to search for
        int key = scanner.nextInt();

        // Call the method and print the result
        int result = callBinarySearch(sortedArray, key);
        System.out.println(result);
    }
}