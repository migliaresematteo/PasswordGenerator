import java.util.Random;

public class PasswordGenerator {

    private static final String CARATTERI = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*()_+-=";

    public static String generaPassword(int lunghezza) {
        StringBuilder password = new StringBuilder();
        Random random = new Random();
        while (password.length() < lunghezza) {
            password.append(CARATTERI.charAt(random.nextInt(CARATTERI.length())));
        }
        return password.toString();
    }
}
