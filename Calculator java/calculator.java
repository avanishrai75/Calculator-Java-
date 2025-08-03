import java.util.LinkedList;
import java.util.Scanner;

public class calculator {
    private static final int MAX_HISTORY = 5;
    private static LinkedList<String> history = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        System.out.println("Calculator with History (Last 5)");

        while (running) {
            System.out.println("\nChoose Operation:");
            System.out.println("1: Add (+)");
            System.out.println("2: Subtract (-)");
            System.out.println("3: Multiply (*)");
            System.out.println("4: Divide (/)");
            System.out.println("5: Show History");
            System.out.println("6: Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    performOperation(sc, "+");
                    break;
                case 2:
                    performOperation(sc, "-");
                    break;
                case 3:
                    performOperation(sc, "*");
                    break;
                case 4:
                    performOperation(sc, "/");
                    break;
                case 5:
                    showHistory();
                    break;
                case 6:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }

        sc.close();
        System.out.println("Calculator closed.");
    }

    private static void performOperation(Scanner sc, String operator) {
        System.out.print("Enter first number: ");
        double num1 = sc.nextDouble();
        System.out.print("Enter second number: ");
        double num2 = sc.nextDouble();

        double result = 0;
        boolean valid = true;

        switch (operator) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                if (num2 == 0) {
                    System.out.println("Cannot divide by zero.");
                    valid = false;
                } else {
                    result = num1 / num2;
                }
                break;
        }

        if (valid) {
            String expression = num1 + " " + operator + " " + num2 + " = " + result;
            System.out.println("Result: " + result);
            addToHistory(expression);
        }
    }

    private static void addToHistory(String entry) {
        if (history.size() == MAX_HISTORY) {
            history.removeFirst();
        }
        history.add(entry);
    }

    private static void showHistory() {
        if (history.isEmpty()) {
            System.out.println("No history available.");
        } else {
            System.out.println("\n--- Last " + history.size() + " Calculations ---");
            for (String record : history) {
                System.out.println(record);
            }
        }
    }
}
