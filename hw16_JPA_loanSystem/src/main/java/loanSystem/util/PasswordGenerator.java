package loanSystem.util;

import java.util.Random;

public class PasswordGenerator{
    private static final String CAPITAL_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String SMALL_LETTERS = "abcdefghijklmnopqrstuvwxyz";
    private static final String SPECIAL_CHARACTERS = "@#$%&";
    private static final String NUMBERS = "0123456789";

    public static String generatePassword() {
        StringBuilder password = new StringBuilder();
        Random random = new Random();

        // Add at least one capital letter
        password.append(CAPITAL_LETTERS.charAt(random.nextInt(CAPITAL_LETTERS.length())));

        // Add at least one small letter
        password.append(SMALL_LETTERS.charAt(random.nextInt(SMALL_LETTERS.length())));

        // Add at least one special character
        password.append(SPECIAL_CHARACTERS.charAt(random.nextInt(SPECIAL_CHARACTERS.length())));

        // Add at least one number
        password.append(NUMBERS.charAt(random.nextInt(NUMBERS.length())));

        // Generate the remaining characters
        int remainingLength = 8 - password.length();
        for (int i = 0; i < remainingLength; i++) {
            String validCharacters = CAPITAL_LETTERS + SMALL_LETTERS + SPECIAL_CHARACTERS + NUMBERS;
            password.append(validCharacters.charAt(random.nextInt(validCharacters.length())));
        }

        // Shuffle the characters in the password
        for (int i = password.length() - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            char temp = password.charAt(i);
            password.setCharAt(i, password.charAt(j));
            password.setCharAt(j, temp);
        }

        return password.toString();
    }
}
