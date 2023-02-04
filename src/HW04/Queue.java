package HW04;

import java.util.LinkedList;

//Реализуйте очередь с помощью LinkedList со следующими методами:
// enqueue() - помещает элемент в конец очереди,
// dequeue() - возвращает первый элемент из очереди и удаляет его,
// first() - возвращает первый элемент из очереди, не удаляя.
public class Queue {
    public static void main(String[] args) {
        LinkedList<Integer> inArr = new LinkedList<>();
        inArr.add(1);
        inArr.add(2);
        inArr.add(3);
        inArr.add(4);

        System.out.println("помещает элемент в конец очереди, вторым параметром передается индекс перемещаемого элемента");
        Enqueue(inArr, 0);
        System.out.println(inArr + " после перемещения в конец очереди");
        System.out.println();

        System.out.println("возвращает первый элемент из очереди и удаляет его");
        System.out.println(inArr + " после удаления первого элемента");
        int firstNum = Dequeue(inArr);
        System.out.println(firstNum + " удаленный элемент");
        System.out.println();

        System.out.println("возвращает первый элемент из очереди, не удаляя");
        int firstNum2 = First(inArr);
        System.out.println(inArr + " начальный список");
        System.out.println(inArr + " список без изменений");
        System.out.println(firstNum2 + " первый элемент из списка");
    }
    public static void Enqueue(LinkedList<Integer> arr, int a) {
        int temp = arr.get(a);
        arr.addLast(temp);
        arr.remove(a);

    }
    public static int Dequeue(LinkedList<Integer> arr) {
        return arr.poll();
    }
    public static int First(LinkedList<Integer> arr) {
        int res = arr.get(0);
        return res;
    }
}
