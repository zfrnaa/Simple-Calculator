package src.main.nonapp;

import java.util.Scanner;

class Calculatorori
{
    // Set Prompt to display to the user to enter two numbers.
    private static final String INP_TWONUMBER = "Enter two numbers: ";

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in); // Scanner object to read input from the user.

        int num1; // First number variable
        int num2; // Second number variable
        int choice; // variable name for choice
        boolean continueCalculation = true; // Whether the user wants to continue with the calculator.

        System.out.println("Hello world!");
        System.out.println("Here is your calculation for each operation\n");

        do {
            System.out.println("Select the operation:\n");
            System.out.println("1. Addition\n2. Multiply\n3. Division\n4. Modulus\n5. Exit\n");
            //Operation that the user wants to perform
            choice = input.nextInt();

            switch (choice) {
                case 1 -> { // Addition
                    System.out.println(INP_TWONUMBER);
                    num1 = input.nextInt(); //1st and 2nd number entered by the user.
                    num2 = input.nextInt();
                    System.out.println("The sum is: " + add(num1, num2));
                }
                case 2 -> { // Multiplication
                    System.out.println(INP_TWONUMBER);
                    num1 = input.nextInt();
                    num2 = input.nextInt();
                    System.out.println("The product is: " + multiply(num1, num2));
                }
                case 3 -> { // Division
                    System.out.println(INP_TWONUMBER);
                    num1 = input.nextInt();
                    num2 = input.nextInt();
                    System.out.println("The quotient is: " + divide(num1, num2));
                }
                case 4 -> { // Modulus
                    System.out.println(INP_TWONUMBER);
                    num1 = input.nextInt();
                    num2 = input.nextInt();
                    System.out.println("The remainder is: " + modulo(num1, num2));
                }
                case 5 -> continueCalculation = false;
                default -> System.out.println("Invalid choice");
            }

            if (continueCalculation)
            {
                System.out.println("Do you want to continue? (yes/no)");
                String continueChoice = input.next();
                continueCalculation = continueChoice.equalsIgnoreCase("yes");
            }
        } while (continueCalculation);
    }

    public static int add(int n1, int n2)
    { // Returns the sum of n1 and n2.
        return n1 + n2;
    }

    public static int multiply(int n1, int n2)
    { // Returns the product of n1 and n2.
        return n1 * n2;
    }

    public static double divide(double n1, double n2)
    { // Returns the quotient of n1 and n2.
        return n1 / n2;
    }

    public static double modulo(double n1, double n2)
    { // Returns the remainder of n1 divided by n2.
        return n1 % n2;
    }
}
