import java.util.Scanner;

public class PalindromeCheckerApp {

    public static boolean checkWithTwoPointers(String str) {
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static boolean checkWithStringBuilder(String str) {
        String reversed = new StringBuilder(str).reverse().toString();
        return str.equals(reversed);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string to check if it's a palindrome: ");
        String input = scanner.nextLine();

        long startTime1 = System.nanoTime();
        boolean result1 = checkWithTwoPointers(input);
        long endTime1 = System.nanoTime();
        long duration1 = endTime1 - startTime1;

        long startTime2 = System.nanoTime();
        boolean result2 = checkWithStringBuilder(input);
        long endTime2 = System.nanoTime();
        long duration2 = endTime2 - startTime2;

        if (result1) {
            System.out.println("Result: The string is a Palindrome.");
        } else {
            System.out.println("Result: The string is not a Palindrome.");
        }

        System.out.println("Time taken by Two Pointers algorithm: " + duration1 + " ns");
        System.out.println("Time taken by StringBuilder algorithm: " + duration2 + " ns");

        scanner.close();
    }
}