import java.math.BigInteger;

public abstract class MergSort {


    public static void sort(int[] arr) {
        int lengthOfRun = 1;
        int compCount = 0;

        //For timing purposes
        BigInteger startTime = BigInteger.valueOf(System.nanoTime());

        do {

            //Circular array of runs
            JumpList runs = new JumpList(arr.length);

            //Getting the runs
            for (int i = 0; i < arr.length; i += lengthOfRun) {
                runs.enqueue(new ARun(i, lengthOfRun));
            }

            //To merge
            for (int i = 0; i <= (arr.length) / lengthOfRun; i += 1) {
                compCount += merge(arr, runs.dequeue(), runs.dequeue());
            }

            lengthOfRun *= 2;

        } while (lengthOfRun <= arr.length);

        //For timing purposes
        BigInteger estTime = BigInteger.valueOf(System.nanoTime()).subtract(startTime);


        //Prints out the whole sorted array
        System.out.print("\nThe sorted array is: ");

        for (int a = 0; a < arr.length; a++) {
            System.out.print(arr[a] + " ");
        }

        System.out.println("\nThe number of comparison program is " + compCount);

        System.out.println("\nThe time taken for the program in nanosecond is " + estTime +"ns");


    }

    //The function which merges runs
    public static int merge(int[] src, ARun run1, ARun run2) {

        int compCount = 0;

        //Based on runs, their lengths, compares the values
        for (int x = run1.getStart(); x <= run1.getLength(); x++) {
            for (int y = run2.getStart(); y <= run2.getLength(); y++) {
                int holder;

                if (src[y] < src[x]) {
                    compCount++;
                    holder = src[y];
                    src[y] = src[x];
                    src[x] = holder;
                }
            }
        }
        return compCount;
    }


}
