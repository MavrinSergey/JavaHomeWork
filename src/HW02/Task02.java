package HW02;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

//К калькулятору из предыдущего дз добавить логирование.
public class Task02 {
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
        int x = 0;
        switch (c) {
            case "+":
                x = sum(a, b);
                break;
            case "*":
                x = mult(a, b);
                break;
            case "/":
                if (b == 0) System.out.print("На ноль делить нельзя. Попробуйте другое значение");
                else {
                    x = div(a, b);
                }
                break;
            case "-":
                x = diff(a, b);
                break;
        }
        System.out.println("Результат: " + x);
        logEntry(a, b, c, x);
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

    public static void logEntry(int a, int b, String c, int x) {
        Logger logger = Logger.getLogger(BubbleSort.class.getName());
        FileHandler fh = null;
        try {
            fh = new FileHandler("./src/HW02/logCalc.txt", true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        logger.addHandler(fh);

        SimpleFormatter sFormat = new SimpleFormatter();
        fh.setFormatter(sFormat);

        logger.info(a + c + b + " = " + x);
        fh.close();

    }
}
