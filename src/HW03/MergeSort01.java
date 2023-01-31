package HW03;

import java.util.ArrayList;
import java.util.Random;
import java.util.stream.IntStream;

// Реализовать алгоритм слиянием
public class MergeSort01 {
    public static void main(String[] args) {
        int[] array = RandomRandom();
        printArray(array);
        ArrayList<Integer> tempArrey1 = new ArrayList<>();
        ArrayList<Integer> tempArrey2 = new ArrayList<>();
        Boolean endSort = true;
        while (endSort) {
            OneToTwo(array, tempArrey1, tempArrey2, endSort);

            int[] temp1 = tempArrey1.stream().flatMapToInt(IntStream::of).toArray();
            int[] temp2 = tempArrey2.stream().flatMapToInt(IntStream::of).toArray();

            if (tempArrey2.size() == 0) {
                endSort = !endSort;
            } else {
                int[] resArray = MergeSort(array.length, temp1, temp2);
                array = resArray;
            }
        }
        System.out.println(tempArrey1);

    }
    public static int[] RandomRandom() {
        Random random = new Random();
        int[] array = new int[random.nextInt(20)];

        IntStream.range(0, array.length) // С помощью стрима проходим по всему массиву
                // Заносим рандомное число в ячейку массива
                // Рандомные значения могут быть в диапазоне от 0 до 99 включительно
                .forEach(index -> array[index] = random.nextInt(20));
        return array;
    }
    public static void OneToTwo(int[] arr, ArrayList<Integer> tempArrey1, ArrayList<Integer> tempArrey2, Boolean flagOut) {
        tempArrey1.clear();
        tempArrey2.clear();
        Boolean flag = true;
        for (int i = 0; i < arr.length ; i++) {
            if (i == 0){
                tempArrey1.add(arr[i]);
            }
            else {
                if (arr[i-1] <= arr[i] && flag) {
                    tempArrey1.add(arr[i]);
                } else if (arr[i-1] < arr[i] && !flag) {
                    tempArrey2.add(arr[i]);
                }
                else if (arr[i-1] > arr[i] && flag) {
                    flag = !flag;
                    tempArrey2.add(arr[i]);
                }
                else if (arr[i-1] >= arr[i] && !flag) {
                    flag = !flag;
                    tempArrey1.add(arr[i]);
                }
            }
        }
    }
    public static int[] MergeSort(int x, int[] tempArrey1, int[] tempArrey2){
        int[] resArr = new int[x];
        int j = 0;
        int k = 0;
        for (int i = 0; i < resArr.length ; i++) {
            if (tempArrey1[j] < tempArrey2[k]) {
                resArr[i] = tempArrey1[j];
                if (j <= tempArrey1.length-1) {
                    j++;
                }
            } else {
                resArr[i] = tempArrey2[k];
                if (k <= tempArrey2.length-1) {
                    k++;
                }
            }
            if (j == tempArrey1.length || k == tempArrey2.length) {
                if (j == tempArrey1.length) {
                    System.arraycopy(tempArrey2,
                            k,
                            resArr,
                            i+1,
                            tempArrey2.length-k);
                    break;
                } else {
                    System.arraycopy(tempArrey1,
                            j,
                            resArr,
                            i+1,
                            tempArrey1.length-j);
                    break;
                }
            }
        }
        return resArr;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println();
    }
}
