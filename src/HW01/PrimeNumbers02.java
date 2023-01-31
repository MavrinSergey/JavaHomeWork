package HW01;
// 2. Вывести все простые числа от 1 до 1000
import java.util.ArrayList;
public class PrimeNumbers02 {
    public static void main(String[] args) {
        ArrayList<Integer> multiplications = new ArrayList<Integer>();
        multiplications.add(2);
            int iterations = 0;
        for (int i = 3; i <= 1000; i+=2) {
            boolean temp = true;
            for (short j = 1; j < multiplications.size(); j++) { // почему нет ошибки ведь при первой итерации в списке нет элемента с индексом 1
                iterations++;
                if (i % multiplications.get(j) == 0) {
                    temp = false;
                    break;
                }
            }
            if (temp) {
                multiplications.add(i);
        }
    }
        printList(multiplications);
        System.out.println("Кол-во простых чисел до 1000 " + multiplications.size());// проверка по кол-ву простых чисел
        System.out.println("Кол-во итераций " + iterations);// кол-во итераций
    }
    public static void printList(ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + ", ");
        }
        System.out.println();
    }
}