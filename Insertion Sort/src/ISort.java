public class ISort {
    public static void main(String[] args) {

        //creates a new array of numbers with the right number of numbers
        int[] numbers = new int[args.length - 1];

        //counts how many numbers there are in the array string numbers
        for (int x = 0; x < args.length - 1; x++) {
            //Transforms each string of numbers into int and put it into the array
            numbers[x] = Integer.parseInt(args[x]);
        }

        //Prints out the length of the array
        System.out.println("The array is of length : " + numbers.length );


        //Prints out the unsorted array
        System.out.println("\nThe unsorted array is :");
        for (int x = 0; x < numbers.length; x++) {
            System.out.print(numbers[x] + " ");
        }


        //calls the function to sort the array
      int comparisons = Sort(numbers);

        //Prints the number of comparisons
        System.out.println("\nThe number of comparisons is " + comparisons);

    }

    //The function which sorts the numbers
    public static int Sort(int[] numbers) {

        //For timing purposes
        long startTime = System.nanoTime();

        //Sorting algorithm with n^2
        int currentIndex= 0;
        int tempHolder =0;
        int dummyIndex = 0;
        int comparisonsCounter = 0;

        //sorting the first number of the array
        if (numbers[currentIndex] > numbers[currentIndex + 1]){
            tempHolder = numbers [currentIndex];
            numbers [currentIndex] = numbers [currentIndex + 1];
            numbers[currentIndex + 1] = tempHolder;
            //first comparison
            comparisonsCounter++;
        }
        //increments the index
        currentIndex++;

        do {
            //makes use of a dummy index
            dummyIndex = currentIndex;

            if(numbers[currentIndex + 1] < numbers[dummyIndex]){

                //Another comparison
                comparisonsCounter++;

                //while loop to find where the next number is the smallest
                while(numbers[currentIndex + 1] < numbers[dummyIndex]){

                    //Checks whether it needs to break the loop or keep on moving backwards
                    if((dummyIndex == 0)||(numbers[currentIndex + 1] >= numbers[dummyIndex - 1])){
                        break;}

                    else if (numbers[currentIndex +1] < numbers[dummyIndex]){
                        //Another comparison
                        comparisonsCounter++;
                        dummyIndex--;}
                }

                //hold the number to inserted
                tempHolder = numbers[currentIndex + 1];

                //shifts the numbers
                for (int x = currentIndex + 1; x >= dummyIndex; x--){
                    if ((x-1) <= 0){
                        numbers[x] = numbers[0];}
                        else{
                    numbers[x] = numbers[x-1];}
                }
                //puts the numbers back
                numbers[dummyIndex] = tempHolder;
            }

            //Increments
            currentIndex++;

            //Knows when to break the loop
            if (currentIndex == (numbers.length -1)){
                break;
            }
        }
        //until it reaches the end of the array
        while (currentIndex <= (numbers.length-1));


        System.out.println("\nThe sorted array is: ");

            //Prints out the whole sorted array
            for (int a = 0; a < numbers.length; a++) {
                System.out.print(numbers[a] + " ");
            }

            //For timing purposes
            long estimatedTime = System.nanoTime() - startTime;

            //Prints out the time taken for the whole program
            System.out.println("\n\nThe time taken for the program in nanosecond is " + estimatedTime);

            //returns the number of comparisons made
            return comparisonsCounter;
        }

    }

