package HW03;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

// Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее из этого списка.
public class MinMaxAver {
    public static void main(String[] args) {
        ArrayList<Integer> array = RandomRandom(10, 10);
        int min = Collections.min(array);
        int max = Collections.max(array);
        int sum = array.stream().mapToInt(i -> i).sum();
        int average = sum / array.size();
        System.out.println(array);
        System.out.println(min);
        System.out.println(max);
        System.out.println(sum);
        System.out.println(average);

    }
    public static ArrayList<Integer> RandomRandom(int size, int range) {
        Random random = new Random();
        ArrayList<Integer> array = new ArrayList<>();
        for (int i = 0; i < size ; i++) {
            array.add(random.nextInt(range));
        }
        return array;
    }
}
