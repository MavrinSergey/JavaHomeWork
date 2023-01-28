import java.util.ArrayList;

// 5*. Дан массив nums = [3,2,2,3] и число val = 3.
// Если в массиве есть числа, равные заданному, нужно перенести эти элементы в конец массива.
// Таким образом, первые несколько (или все) элементов массива должны быть отличны от заданного, а остальные - равны ему.
public class Task05 {
    public static void main(String[] args) {
        int[] nums = new int[] {2, 3, 2, 2, 3, 3, 3, 2, 3, 2};
        int val = 3;
        int count = nums.length - 1;
//        System.out.print(count);
        for (int i = nums.length - 1; i >= 0 ; i--) {
            if (nums[i] == val && nums[count] == val) {
                count--;
            } else if (nums[i] == val && nums[count] != val) {
                int temp = nums[i];
                nums[i] = nums[count];
                nums[count] = temp;
                count--;

            }
        }
        printArr(nums);
    }
    public static void printArr(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
        }
    }
}
