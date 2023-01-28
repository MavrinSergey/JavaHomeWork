// 3. Реализовать простой калькулятор

import java.util.Scanner;
public class Task03Calculator {
    public static void main(String[] args) {
        System.out.println("Привет это простейший калькулятор который умеет складывать вычитать умножать и делить");
//      int n = Integer.parseInt(System.console().readLine("Введите число: "));
        Scanner in = new Scanner(System.in);
        System.out.print("Введите первое число: ");
        int a = in.nextInt();
        System.out.print("Введите второе число: ");
        int b = in.nextInt();
        System.out.print("Введите действе которое хотите произвести с данными числами(+, *, /, -): ");
        String c = in.nextLine();
        c = in.nextLine();
        int x;
        switch (c) {
            case "+":
                x = sum(a, b);
                System.out.println("Результат: " + x);
                break;
            case "*":
                x = mult(a, b);
                System.out.println("Результат: " + x);
                break;
            case "/":
                if (b == 0)
                    System.out.print("На ноль делить нельзя. Попробуйте другое значение");
                else {
                    x = div(a, b);
                    System.out.println("Результат: " + x);
                }
                break;
            case "-":
                x = diff(a, b);
                System.out.println("Результат: " + x);
                break;
        }
    }

    public static int sum(int a, int b) {
        int x = a + b;
        return x;
    }

    public static int mult(int a, int b) {
        int x = a * b;
        return x;
    }

    public static int div(int a, int b) {
            int x = a / b;
            return x;
        }

    public static int diff(int a, int b) {
        int x = a - b;
        return x;
    }
}
