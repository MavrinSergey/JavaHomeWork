package HW04;

import java.util.LinkedList;
import java.util.List;

// Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернет “перевернутый” список.
public class ReverseList {
    public static void main(String[] args) {
        LinkedList<Object> inArr = new LinkedList<>();
        inArr.add("1");
        inArr.add("2");
        inArr.add("3");
        inArr.add("4");
        System.out.println(inArr);
        Revers(inArr);
        System.out.println(inArr);
    }
    public static void Revers(LinkedList<Object> arr) {
        int temp = arr.size();
        LinkedList<Object> resArr = new LinkedList<>();
        for (int i = 0; i < temp ; i++) {
            resArr.add(arr.pollLast());
        }
        for (int i = 0; i < temp ; i++) {
            arr.add(resArr.pollFirst());
        }
    }
}
