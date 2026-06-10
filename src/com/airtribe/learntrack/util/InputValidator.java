package com.airtribe.learntrack.util;

public class InputValidator {

    public static int validateMenuOption(String input) {
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
            return 0;
        }
    }
}
