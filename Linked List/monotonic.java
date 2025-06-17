import java.util.ArrayList;
public class monotonic {
    public static boolean isMonotonic(ArrayList<Integer> container) {
        int increasing = 0;
        int decreasing = 0;
        int n = container.size();
        for (int i = 1; i < n; i++) {
            if (container.get(i) > container.get(i - 1)) {
                increasing++;
            } else if (container.get(i) < container.get(i - 1)) {
                decreasing++;
            }
        }
        if(increasing == 0 || decreasing == 0) {
            return true; // The list is monotonic
        } else {
            return false; // The list is not monotonic
        }
    }
    public static void main(String[] args) {
        // Create an ArrayList to hold Integer objects
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(9); 
        numbers.add(11);
        numbers.add(8);
        numbers.add(22);
        // Print the contents of the list   
        System.out.println("Numbers in the list: " + numbers);
        System.out.println("Is the list monotonic? " + isMonotonic(numbers));
        // Add some numbers to the list
    }
}
