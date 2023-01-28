// 6*. Напишите метод, который находит самую длинную строку общего префикса среди массива строк.
// Если общего префикса нет, вернуть пустую строку "".
public class Task06 {
    public static void main(String[] args) {
        String[] arr = new String[] {"Автобус", "Автомобиль", "Автоматический", "Автомат"};
        String max = "";
        Boolean flag = true;
        for (int i = 0; i < arr.length; i++) {
            if (arr[0].charAt(0) != arr[i].charAt(0)) {
                flag = false;
            }
        }
        if (flag) {
            for(int j = 0; j < arr.length; j++) {
                if (arr[j].length() > max.length()) max = arr[j];

            }
            System.out.print(max);
        }
    }
}
