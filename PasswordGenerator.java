

import java.security.SecureRandom;
import java.util.Random;

public class PasswordGenerator {
    private static final String UPPER_CASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWER_CASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String NUMBERS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()_-+=<>?/{}[]";

    public static String generateRandomPassword(int length, boolean includeUpperCase, boolean includeLowerCase,
                                                boolean includeNumbers, boolean includeSpecialCharacters) {
        StringBuilder passwordCharacters = new StringBuilder();
        
        if (includeUpperCase)
            passwordCharacters.append(UPPER_CASE);
        
        if (includeLowerCase)
            passwordCharacters.append(LOWER_CASE);
        
        if (includeNumbers)
            passwordCharacters.append(NUMBERS);
        
        if (includeSpecialCharacters)
            passwordCharacters.append(SPECIAL_CHARACTERS);
        
        if (passwordCharacters.length() == 0) {
            throw new IllegalArgumentException("At least one character set must be selected.");
        }
        
        Random random = new SecureRandom();
        char[] password = new char[length];
        int charactersLength = passwordCharacters.length();

        for (int i = 0; i < length; i++) {
            password[i] = passwordCharacters.charAt(random.nextInt(charactersLength));
        }

        return new String(password);
    }
}
