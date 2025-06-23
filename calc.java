import java.util.Scanner;

public class calc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean keepRunning = true;

        while (keepRunning) {
            System.out.println("Enter first number:");
            double num1 = sc.nextDouble();

            System.out.println("Enter an operator (+, -, *, /):");
            char operator = sc.next().charAt(0);

            System.out.println("Enter second number:");
            double num2 = sc.nextDouble();

            double result = 0;
            boolean validOperator = true;

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;

                case '-':
                    result = num1 - num2;
                    break;

                case '*':
                    result = num1 * num2;
                    break;

                case '/':
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        System.out.println("Error: Division by zero.");
                        validOperator = false;
                    }
                    break;

                default:
                    System.out.println("Invalid operator!");
                    validOperator = false;
            }

            if (validOperator) {
                System.out.println("Result: " + result);
            }

            System.out.println("Do you want to perform another calculation? (yes/no)");
            String choice = sc.next().toLowerCase();

            if (!choice.equals("yes")) {
                keepRunning = false;
                System.out.println("Calculator exited.");
            }
        }

        sc.close();
    }
}
