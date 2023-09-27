import java.util.Scanner;

public class GuessNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Guess the number from 1 to 10");
        int guess = scanner.nextInt();
        scanner.close();
        if (guess == 7) {
            System.out.println("You guessed right!");
        } else {
            System.out.println("You guessed wrong!");
        }
    }
}
