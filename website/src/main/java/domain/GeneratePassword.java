package domain;

import java.util.Random;
//some comment
public class GeneratePassword {

    private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private Random random = new Random();

    public String password() {
        String password = "";
        for (int i = 0; i < 10; i++) {
            int number = random.nextInt(CHARACTERS.length());
            password += CHARACTERS.charAt(number);
        }
        return password;
    }
}
