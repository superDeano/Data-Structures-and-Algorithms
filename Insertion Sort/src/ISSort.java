import java.math.BigInteger;

public class ISSort {

    public static void main (String [] args) {

        int compCounter = 0;
        //creates a new array of numbers with the right number of numbers
        int[] numbers = new int[args.length];

        //counts how many numbers there are in the array string numbers
        for (int x = 0; x < args.length; x++) {
            //Transforms each string of numbers into int and put it into the array
            numbers[x] = Integer.parseInt(args[x]);
        }



        //Prints out the length of the array
        System.out.println("The array is of length : " + numbers.length );


        //Catches the number of comparisons made as the function to sort the array is called
        compCounter += structurePass(numbers);

        //Prints the number of comparisons
        System.out.println("\nThe number of comparisons is " + compCounter);
    }



    public static int structurePass(int [] numbers){

        int count = 0;
        int startAscending, endAscending, startDescending, endDescending, compCounter = 0;

            //For timing purposes
            BigInteger startTime = BigInteger.valueOf(System.nanoTime());

        //For loop to go check for ascending order
        for (int y = 0; y < numbers.length; y++) {

            count = y;

            if (((y+1) < (numbers.length -1))&&(numbers[y] < numbers[y + 1])) {

                //Getting the ascending index
                startAscending = y;
                while (((count+1) < (numbers.length -1))&& (numbers[count] <= numbers[count + 1])) {
                    //printing out the runs
                    System.out.print(numbers[count] + " ");

                    //increments while it is in ascending
                    count++;
                    compCounter++;
                }
                //Getting the final index of where the ascending run ends
                endAscending = count;
                continue;
            }
            else if(((y+1) < (numbers.length -1))&&(numbers[y] > numbers[y + 1])){

                int middleIndexDescending, tempHolder;

                //Getting the first index of the descending run
                startDescending = y;

                //While loop to find a run of descending
                while (numbers[count] >= numbers[count + 1]) {

                    //printing out the runs
                    System.out.print(numbers[count] + " ");
                    //increments while it is in ascending
                    count++;
                    compCounter++;

                }
                //TO CHNAGE THE DESCENDING RUN INTO AN ASCENDING ONE
                //The final index of the descending run
                endDescending = count;

                //To get a middle index for switching the descending runs
                middleIndexDescending = (endDescending - startDescending)/2;

                    //For loop for switching the numbers
                    for (int x = 0; x > middleIndexDescending; x++) {
                        tempHolder = numbers[startDescending + x];
                        numbers[startDescending + x] = numbers[endDescending - x];
                        numbers[endDescending - x] = tempHolder;
                    }

                //At the end we continue in the enclosing for loop
            continue;
            }
        }

        //calling the Insertion sort method and adds the number of comparisons from that
         compCounter += new ISort().Sort(numbers);


        //For timing purposes
        BigInteger endingTime = BigInteger.valueOf(System.nanoTime()).subtract(startTime);
        System.out.println("\n\nThe time taken for the program in nanosecond is " + endingTime);

//Returns the total number of comparisons
return  compCounter;
    }


}



