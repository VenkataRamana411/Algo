/*
package Assignement;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class PhoneKeypad {

    private static final Map<Character, String> letters = new HashMap<>();

    static {
        // Mapping of digits to letters on phone keypad
        letters.put('2', "ABC");
        letters.put('3', "DEF");
        letters.put('4', "GHI");
        letters.put('5', "JKL");
        letters.put('6', "MNO");
        letters.put('7', "PQRS");
        letters.put('8', "TUV");
        letters.put('9', "WXYZ");
    }

    public static String getLetters(String number) {
        StringBuilder result = new StringBuilder();
        for (char c : number.toCharArray()) {
            if (letters.containsKey(c)) {
                result.append(letters.get(c));
            } else {
                return "Invalid Input. Please enter digits only.";
            }
        }
        return result.length() < 1 ? "" : result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        while (char letter : input.toCharArray()) {
            try {
                System.out.print("Enter a phone number: ");
                input = scanner.nextLine().trim();

                // Validate input to ensure it only contains digits
                if (input.matches("^[0-9]+$")) {
                    isValidInput = true;
                } else {
                    System.out.println("Invalid Input. Please enter digits only.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input. Please enter digits only.");
                scanner.nextLine(); // Clear the scanner buffer
            }
        }

        String letters = getLetters(input);
        System.out.println("Letters for " + input + ": " + letters);
    }
}
*/
