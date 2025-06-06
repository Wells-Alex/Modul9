import java.util.ArrayList;

public class MyArrayList {
    public static void main(String[] args) {
        int[] numbers = {3, 7, 1, 9, 2};
        ArrayList<Integer> list = new ArrayList<>();
        for (int number : numbers) {
        list.add(number);
        }
        System.out.println(list);
        list.add(1);
        list.remove(2);
        System.out.println(list.get(1));
        list.clear();
        System.out.println(list);
    }
}
