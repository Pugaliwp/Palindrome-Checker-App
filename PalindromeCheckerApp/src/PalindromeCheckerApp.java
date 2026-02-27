import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class PalindromeCheckerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string to check if it's a palindrome: ");
        String originalString = scanner.nextLine();
        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < originalString.length(); i++) {
            char c = originalString.charAt(i);
            queue.add(c);
            stack.push(c);
        }

        boolean isPalindrome = true;

        while (!queue.isEmpty() && !stack.isEmpty()) {
            char queueChar = queue.remove();
            char stackChar = stack.pop();

            if (queueChar != stackChar) {
                isPalindrome = false;
                break;
            }
        }
        if (isPalindrome) {
            System.out.println("Result: The string is a Palindrome.");
        } else {
            System.out.println("Result: The string is not a Palindrome.");
        }

        scanner.close();
    }
}