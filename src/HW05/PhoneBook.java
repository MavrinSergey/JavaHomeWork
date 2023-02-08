package HW05;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

//Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
public class PhoneBook {
    public static void main(String[] args) {
        HashMap<String, Set<String>> phonebook = new HashMap<>();

        phonebook.put("Иванов", new HashSet<>(Arrays.asList("89277701", "89277702")));
        phonebook.put("Васильев", new HashSet<>(Arrays.asList("89277601", "89277602")));

        phonebook.get("Иванов").add("89277703");

        System.out.println(phonebook);
    }
}
