package Heap;
import java.util.*;
public class PriorityQueues {
    static class Student implements Comparable<Student> {
        String name;
        int rank ;
        
        public Student(String name, int rank) {
            this.name = name;
            this.rank = rank;
        }

        @Override
        public int compareTo (Student s2) {
            return this.rank - s2.rank ;

            /*
             * It will compare the rank of Student 1 and Student 2
             * if this.rank - s2.rank is positive it means S1>S2 or prioprity of S1<S2 so S1 will come first in the Queue.
             * if this.rank - s2.rank is negetive it means S1<S2 or prioprity of S1>S2 so S2 will come first in the Queue.
             * if this.rank - s2.rank is zero it means S1=S2 so order will not matter.
             */

        }
    }

    public static void main(String []args) {
        PriorityQueue <Student> pq = new PriorityQueue<>();
        pq.add(new Student("A",4));
        pq.add(new Student("B",5));
        pq.add(new Student("C",2));
        pq.add(new Student("D",9));

        while (!pq.isEmpty()) {
            System.out.println(pq.peek().name + " --> " + pq.peek().rank);
            pq.remove();
        }

    }
}
