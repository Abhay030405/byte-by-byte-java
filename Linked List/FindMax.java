import java.util.ArrayList;
import java.util.List;
public class FindMax {
    public static int findMax(List<Integer> numbers) {
        // Check if the list is empty
        if (numbers.isEmpty()) {
            throw new IllegalArgumentException("List cannot be empty");
        }
        
        // Initialize max with the first element
        int max = numbers.get(0);
        
        // Iterate through the list to find the maximum value
        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i) > max) {
                max = numbers.get(i);
            }
        }
        
        return max;
    }
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        // Adding numbers to the list
        numbers.add(10);
        numbers.add(20);
        numbers.add(5);
        numbers.add(30);
        numbers.add(15);
        
        // Find the maximum number
        int max = findMax(numbers);
        System.out.println("The maximum number is: " + max);
    }
}
