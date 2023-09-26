import java.util.Scanner;

class Calc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите способ вычисления (+, -, *, /): ");
        char s = scanner.next().charAt(0);
        System.out.print("Введите первое число: ");
        int a = scanner.nextInt();
        System.out.print("Введите второе число: ");
        int b = scanner.nextInt();
        scanner.close();
        switch (s) {
            case '+':
                System.out.println("Результат: " + (a + b));
                break;
            case '-':
                System.out.println("Результат: " + (a - b));
                break;
            case '*':
                System.out.println("Результат: " + (a * b));
                break;
            case '/':
                System.out.println("Результат: " + (a / b));
                break;
            default:
                break;
        }
    }
}