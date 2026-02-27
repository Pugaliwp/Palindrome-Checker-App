import java.util.Scanner;

public class PalindromeCheckerApp {

    public static boolean isPalindrome(String str, int start, int end) {
        if (start >= end) {
            return true;
        }
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }
        return isPalindrome(str, start + 1, end - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string to check if it's a palindrome: ");
        String originalString = scanner.nextLine();

        boolean result = isPalindrome(originalString, 0, originalString.length() - 1);

        if (result) {
            System.out.println("Result: The string is a Palindrome.");
        } else {
            System.out.println("Result: The string is not a Palindrome.");
        }

        scanner.close();
    }
}