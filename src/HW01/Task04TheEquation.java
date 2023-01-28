// 4*. Задано уравнение вида q + w = e, q, w, e >= 0.
// Некоторые цифры могут быть заменены знаком вопроса, например 2? + ?5 = 69.
// Требуется восстановить выражение до верного равенства.
// Предложить хотя бы одно решение или сообщить, что его нет.

// данный вариант работает только с вариантами подобными примеру
public class Task04TheEquation {
    public static void main(String[] args) {
        String a = "?4";
        String b = "4?";
        String c = "88";
        int x = stringToInt(a);
        int y = stringToInt(b);
        int z = stringToInt(c);
        int minNumber = minNum(x, y);
        int temp = 0;
        if (minNumber == -1) {
            temp = z / 2;
            System.out.print(temp);
        }
        else if (minNumber == x) {
            temp = (z - x) % 10;
            x = temp * 10 + x;
            y = y + temp;
        }
        else if (minNumber == y) {
            temp = (z - y) % 10;
            y = temp * 10 + y;
            x = x + temp;
        }

        System.out.print(x + " + " + y + " = " + z);
    }

    public static Integer minNum(int x, int y) {
        if (x < 10) return x;
        else if (y < 10) return  y;
        else return  -1;
    }
    public static Integer stringToInt(String a) {
        if (a.charAt(1) == '?') {
            int x = Integer.parseInt(a.replaceAll("[^0-9]", ""));
            x *= 10;
            return x;
        } else if (a.charAt(0) == '?') {
            int x = Integer.parseInt(a.replaceAll("[^0-9]", ""));
            return x;
        } else {
            int x = Integer.parseInt(a);
            return x;
        }
    }
}
