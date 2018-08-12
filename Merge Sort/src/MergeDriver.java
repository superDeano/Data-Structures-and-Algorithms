import static java.lang.Integer.MAX_VALUE;

public class MergeDriver {

    public static void main(String[] args) {

        if (args.length == 2) {

            //Generating random array
            int[] numbers = new int[Integer.parseInt(args[1])];
            for (int i = 0; i < numbers.length; i++) {
                //Integer MAX_VALUE
                numbers[i] = (int) (Math.random() * 0 + MAX_VALUE);
            }

            if (args[0] == "SMS") {
                //Calls Structured Merge Sort
                StructuredMergSort.sort(numbers);

            } else if (args[0] == "MS") {
                //Calls Regular Merge Sort
                MergSort.sort(numbers);

            }

        } else {
            //The array
            int[] numbers = new int[args.length - 1];

            for (int i = 1; i < args.length; i++) {
                numbers[i - 1] = Integer.parseInt(args[i]);
            }

            if (args[0] == "SMS") {
                //Calls Structured Merge Sort
                StructuredMergSort.sort(numbers);

            } else if (args[0] == "MS") {
                //Calls Regular Merge Sort
                MergSort.sort(numbers);
            }
        }


        //creates a new array of numbers with the right number of numbers
        int[] numbers = new int[args.length - 1];

        //counts how many numbers there are in the array string numbers
        for (int x = 0; x < args.length - 1; x++) {
            //Transforms each string of numbers into int and put it into the array
            numbers[x] = Integer.parseInt(args[x]);
        }

    }
}
