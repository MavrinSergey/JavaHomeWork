package HW03;

import java.util.ArrayList;
import java.util.Random;
// Пусть дан произвольный список целых цисел, удалить из него четный числа.
public class RemoveEvenNumbers02 {
    public static void main(String[] args) {
        ArrayList<Integer> array = RandomRandom(10, 10);
        ArrayList<Integer> resArr = RemovingEvenNumbers(array);
        System.out.println(array);
        System.out.println(resArr);
    }

    public static ArrayList<Integer> RemovingEvenNumbers(ArrayList<Integer> arr) {
        ArrayList<Integer> resArr = new ArrayList<>();
        arr.stream().filter(i -> i % 2 != 0).forEach(x -> resArr.add(x));
        return resArr;
    }

    public static ArrayList<Integer> RandomRandom(int size, int range) {
        Random random = new Random();
        ArrayList<Integer> array = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            array.add(random.nextInt(range));
        }
        return array;
    }
}
