import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

interface PalindromeStrategy {
    boolean isPalindrome(String str);
}

class StackStrategy implements PalindromeStrategy {
    @Override
    public boolean isPalindrome(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
        }

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != stack.pop()) {
                return false;
            }
        }
        return true;
    }
}

class DequeStrategy implements PalindromeStrategy {
    @Override
    public boolean isPalindrome(String str) {
        Deque<Character> deque = new LinkedList<>();
        for (int i = 0; i < str.length(); i++) {
            deque.addLast(str.charAt(i));
        }

        while (deque.size() > 1) {
            char first = deque.removeFirst();
            char last = deque.removeLast();
            if (first != last) {
                return false;
            }
        }
        return true;
    }
}

public class PalindromeCheckerApp {
    private PalindromeStrategy strategy;

    public PalindromeCheckerApp(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean executeStrategy(String str) {
        return strategy.isPalindrome(str);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string to check if it's a palindrome: ");
        String originalString = scanner.nextLine();

        System.out.println("Choose strategy (1 for Stack, 2 for Deque): ");
        int choice = scanner.nextInt();

        PalindromeStrategy selectedStrategy;
        if (choice == 1) {
            selectedStrategy = new StackStrategy();
        } else {
            selectedStrategy = new DequeStrategy();
        }

        PalindromeCheckerApp app = new PalindromeCheckerApp(selectedStrategy);
        boolean isPalindrome = app.executeStrategy(originalString);

        if (isPalindrome) {
            System.out.println("Result: The string is a Palindrome.");
        } else {
            System.out.println("Result: The string is not a Palindrome.");
        }

        scanner.close();
    }
}