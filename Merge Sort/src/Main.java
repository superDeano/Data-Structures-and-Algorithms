import java.util.*;

public class Main {

    public static void main(String[] args) {

        int [] array = {1, 8,20, 0, 3, 4,69, 672, 7, 2, 13,564,3,5};
        int []orderedArray = MergeSort.mergeSort(array);
        print(orderedArray);
    }


    static void print(int[]array){
        Arrays.stream(array).forEach(number -> System.out.print(number + " "));
    }
}
