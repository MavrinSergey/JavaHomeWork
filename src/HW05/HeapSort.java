package HW05;
//Реализовать алгоритм пирамидальной сортировки (HeapSort)

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HeapSort {
    static ArrayList<Integer> list = new ArrayList<>(
            List.of(11, 3, 5, 17, 28, 34, 3,  10, 8, 44, 18));

    public static void main(String[] args) {
        System.out.println(list);

        ArrayList<Integer> sortedList = heapify(list, list.size());

        System.out.println(sortedList);
    }

    /**
     * Упорядочиваем кучу
     */
    private static ArrayList<Integer> heapify(ArrayList<Integer> list, int length) {
        if (length == 1) return list;

        int lastParent = lastParent(length);

        for (int i = lastParent; i >= 0; i--) {
            int leftChild = i * 2 + 1;
            int rightChild = i * 2 + 2;

            if (leftChild == length - 1)
                rightChild = leftChild;

            int max = leftChild;
            if (list.get(rightChild) > list.get(max)) max = rightChild;

            if (list.get(i) < list.get(max)) {
                swapIndexes(list, max, i);
            }
        }
        swapIndexes(list, 0, length-1);
        return heapify(list, length-1);
    }

    /**
     * Метод для перестановки местами элементов под определенными индексами
     */
    private static void swapIndexes(ArrayList<Integer> list, int i, int j) {
        Collections.swap(list, i, j);
    }

    /**
     * Метод нахождения последнего родителя
     */
    private static int lastParent(int length) {
        int i;
        if (length % 2 == 0) {
            i = (length - 1) / 2;
        } else {
            i = (length - 2) / 2;
        }
        return i;
    }
}