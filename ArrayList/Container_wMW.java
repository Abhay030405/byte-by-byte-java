import java.util.*;

public class Container_wMW {

    public static int maxWater(ArrayList<Integer> container) {
        int n = container.size();
        int width = 1;
        int tempStorage = 0;
        int maxWater = 0;
        int mxh = container.get(0);
        int mih = 0;
        for(int i=1; i<n; i++) {
            if(container.get(i) > mxh) {
                tempStorage += (width * mxh);
            } else {
                maxWater += (width * Math.min(container.get(i), container.get(i-1)));
                width = 1; // Reset width for the next segment
            }
        }
        return maxWater; 
        
        }


     public static void main(String[] args) {
        // Create an ArrayList to hold Integer objects
        ArrayList<Integer> numbers = new ArrayList<>();

        // Add some numbers to the list
        numbers.add((int)(Math.random() * 10) + 1);
        numbers.add((int)(Math.random() * 10) + 1);
        numbers.add((int)(Math.random() * 10) + 1);
        numbers.add((int)(Math.random() * 10) + 1);
        numbers.add((int)(Math.random() * 10) + 1); 
        numbers.add((int)(Math.random() * 10) + 1);
        numbers.add((int)(Math.random() * 10) + 1);
        numbers.add((int)(Math.random() * 10) + 1);
        numbers.add((int)(Math.random() * 10) + 1);
        numbers.add((int)(Math.random() * 10) + 1);

        // Print the contents of the list
        System.out.println("Numbers in the list: " + numbers);    
    }
}

