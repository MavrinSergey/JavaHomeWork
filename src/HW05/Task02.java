package HW05;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

//Пусть дан список сотрудников:Иван Иванов
//        Светлана Петрова
//        Кристина Белова
//        Анна Мусина
//        Анна Крутова
//        Иван Юрин
//        Петр Лыков
//        Павел Чернов
//        Петр Чернышов
//        Мария Федорова
//        Марина Светлова
//        Мария Савина
//        Мария Рыкова
//        Марина Лугова
//        Анна Владимирова
//        Иван Мечников
//        Петр Петин
//        Иван Ежов
//        Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений. Отсортировать по убыванию популярности.
public class Task02 {
    public static void main(String[] args) {
        ArrayList<String> listOfEmployees = new ArrayList<>(Arrays.asList("Светлана Петрова", "Кристина Белова", "Анна Мусина", "Анна Крутова", "Иван Юрин", "Петр Лыков", "Павел Чернов", "Петр Чернышов", "Мария Федорова", "Марина Светлова", "Мария Савина", "Мария Рыкова", "Марина Лугова", "Анна Владимирова", "Иван Мечников", "Петр Петин", "Иван Ежов"));
        ArrayList<String> listFirstName = lastNameRemove(listOfEmployees);
        Map<String, Long> reslist =listDuplicates(listFirstName);
        System.out.println(reslist);
    }

    public static ArrayList<String> lastNameRemove(ArrayList<String> arr) {
        ArrayList<String> resList = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            resList.add((arr.get(i).split(" "))[0]);
        }
        return resList;
    }

    public static Map<String, Long> listDuplicates(ArrayList<String> arr) {
        TreeMap<String, Long> treeMap = new TreeMap<>();
        Map<String, Long> frequency =
                arr.stream().collect(Collectors.groupingBy(
                        Function.identity(), Collectors.counting()));

        frequency.forEach((k, v) -> {
            System.out.println(k + ": " + v);
            treeMap.put(k, v);
        });
            treeMap.descendingMap();
        return treeMap;


    }

}
