package HW02;
// Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.

import java.io.IOException;
import java.util.logging.*;

public class BubbleSort {
    public static void main(String[] args) throws Exception {
        int[] nums = new int[]{2, 5, 1, 6, 4, 8, 3, 7, 9};
        int[] sortNums = sort(nums);
        for (int item : nums) {
            System.out.print(item + ", ");
        }
    }

    public static int[] sort(int[] myArr) throws Exception {
        int temp = 0;
        boolean flag = true;
        int count = 0;
        while (flag) {
            flag = false;
            for (int i = 1; i < myArr.length; i++) {
                if (myArr[i] < myArr[i - 1]) {
                    count++;
                    flag = true;
                    temp = myArr[i];
                    myArr[i] = myArr[i - 1];
                    myArr[i - 1] = temp;
                    logEntry(count);
                }
            }
        }
        return myArr;
    }

    public static void logEntry(int a) throws Exception {
        Logger logger = Logger.getLogger(BubbleSort.class.getName());
        FileHandler fh = null;
        try {
            fh = new FileHandler("./src/HW02/log.txt", true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        logger.addHandler(fh);

        SimpleFormatter sFormat = new SimpleFormatter();
        fh.setFormatter(sFormat);

        logger.info(a + "-ая итерация.");
        fh.close();
    }
}
