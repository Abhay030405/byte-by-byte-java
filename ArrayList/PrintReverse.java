import java.util.ArrayList;
import java.util.List;
public class PrintReverse {
    public static void printReverse(List<Integer> numbers) {
        // Print the list in reverse order
        for (int i = numbers.size() - 1; i >= 0; i--) {
            System.out.print(numbers.get(i) + " ");
        }
    }
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        // Adding numbers to the list
        numbers.add(1);
        numbers.add(2);         
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        printReverse(numbers);
    }   
}