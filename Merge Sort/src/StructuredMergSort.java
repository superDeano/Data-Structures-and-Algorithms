import java.math.BigInteger;

public abstract class StructuredMergSort {

    public static void sort(int[] arr) {

        JumpList theRuns = new JumpList(arr.length);

        int startAscending, startDescending, endDescending, compCounter = 0;
        int numOfRuns = 0;
        boolean sorted = false;


        //For timing purposes
        BigInteger startTime = BigInteger.valueOf(System.nanoTime());

        do {

            //For loop to go check for ascending order
            for (int y = 0; y < arr.length; y++) {

                int lengthOfRun = 0;

                if (((y + 1) < (arr.length - 1)) && (arr[y] < arr[y + 1])) {

                    //Getting the ascending index
                    startAscending = y;
                    while (((y + 1) < (arr.length - 1)) && (arr[y] <= arr[y + 1])) {

                        //increments while it is in ascending
                        y++;
                        compCounter++;
                        lengthOfRun++;
                        numOfRuns++;
                    }
                    theRuns.enqueue(new ARun(startAscending, lengthOfRun));
                    sorted = true;
                    continue;
                } else if (((y + 1) < (arr.length - 1)) && (arr[y] > arr[y + 1])) {

                    int middleIndexDescending, tempHolder;

                    //Getting the first index of the descending run
                    startDescending = y;

                    //While loop to find a run of descending
                    while (arr[y] >= arr[y + 1]) {

                        //increments while it is in ascending
                        y++;
                        compCounter++;
                        lengthOfRun++;
                        numOfRuns++;
                    }

                    //TO CHNAGE THE DESCENDING RUN INTO AN ASCENDING ONE
                    //The final index of the descending run
                    endDescending = y;

                    //To get a middle index for switching the descending runs
                    middleIndexDescending = (endDescending - startDescending) / 2;

                    //For loop for switching the numbers
                    for (int x = 0; x > middleIndexDescending; x++) {
                        tempHolder = arr[startDescending + x];
                        arr[startDescending + x] = arr[endDescending - x];
                        arr[endDescending - x] = tempHolder;
                    }
                    theRuns.enqueue(new ARun(startDescending, lengthOfRun));

                    sorted = false;

                    //At the end we continue in the enclosing for loop
                    continue;
                }
            }
            while (numOfRuns-- >= 0) ;
            compCounter += MergSort.merge(arr, theRuns.dequeue(), theRuns.dequeue());

            //Repeat the sorting
        } while (!sorted);


        //For timing purposes
        BigInteger estTime = BigInteger.valueOf(System.nanoTime()).subtract(startTime);

        //Prints out the whole sorted array
        System.out.print("\nThe sorted array is: ");

        for (int a = 0; a < arr.length; a++) {
            System.out.print(arr[a] + " ");
        }

        System.out.println("\nThe number of comparison program is " + compCounter);

        System.out.println("\nThe time taken for the program in nanosecond is " + estTime +"ns");


    }


}


