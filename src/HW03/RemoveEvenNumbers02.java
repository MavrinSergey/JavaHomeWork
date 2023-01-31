package HW03;

import java.util.Arrays;

// Пусть дан произвольный список целых цисел, удалить из него четный числа.
public class RemoveEvenNumbers02 {
    public static void main(String[] args) {
        int[] array = new int[] {2, 5, 1, 6, 4, 8, 3, 7, 9};
        int[] resArr = MergeSort(array);
        printArray(resArr);

    }
    public static int[] MergeSort(int[] arr){
        int[] temparrey1 = Arrays.copyOfRange(arr, 0, arr.length/2);
        int[] temparrey2 = Arrays.copyOfRange(arr, arr.length/2, arr.length);
        int[] resArr = new int[arr.length];
        printArray(temparrey1);
        printArray(temparrey2);
        int j = 0;
        int k = 0;
        for (int i = 0; i < arr.length ; i++) {
            if (temparrey1[j] < temparrey2[k]) {
                resArr[i] = temparrey1[j];
                if (j < temparrey1.length-1) {
                    i++;
                    j++;
                }
            } else {
                resArr[i] = temparrey2[k];
                if (k < temparrey2.length-1) {
                    i++;
                    k++;
                }
            }
            if (j == temparrey1.length-1 || k == temparrey2.length-1) {
                if (j == temparrey1.length-1) {
                    System.arraycopy(temparrey2,
                            k,
                            resArr,
                            i,
                            temparrey2.length-1-k);
//                    resArr = Arrays.copyOfRange(temparrey2, k, temparrey2.length);
                } else {
                    System.arraycopy(temparrey1,
                            j,
                            resArr,
                            i,
                            temparrey1.length-1-j);
//                    resArr = Arrays.copyOfRange(temparrey1, j, temparrey1.length);
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
