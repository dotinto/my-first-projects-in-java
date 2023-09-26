import java.util.Random;
import java.util.Scanner;

public class PasswordGenerator {
    public static char generatePassword() {
        Random random = new Random();
        char[] symbols = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM1234567890".toCharArray();
        return symbols[random.nextInt(symbols.length)];
    }
    public static void main(String[] args) {
        System.out.println("----------------------");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter password length: ");
        
        int length = scanner.nextInt();
        System.out.println("----------------------");
        String out = "";
        for (int i = 0; i <= length - 1; i++) {
            out += generatePassword();
        };
        scanner.close();
        System.out.println(out);
        System.out.println("----------------------");
    }
}
