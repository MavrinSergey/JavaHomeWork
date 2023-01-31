// 1. Вычислить n-ое треугольного число(сумма чисел от 1 до n), n! (произведение чисел от 1 до n)
import java.util.Scanner;

public class Factorial01 {
    public static void main(String[] args) {

        System.out.println("Привет данная программа вычисляет треугольное число и факториал введенного вами числа");
//      int n = Integer.parseInt(System.console().readLine("Введите число: "));
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число: ");
        int n = scanner.nextInt();

        int sum = (n * (n + 1) / 2);

        int mult = FactNaive(n);

        System.out.printf("треугольное число равно %d; факториал равен %d", sum, mult);
    }

    public static int FactNaive(int n) {
        int r = 1;
        for (int i = 2; i <= n; ++i) {
            r = r * i;
        }
            return r;
    }
}