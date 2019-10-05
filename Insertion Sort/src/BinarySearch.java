public class BinarySearch {


    public static int main (String [] args){

        //The array from the arguments
        int []sortedNum = new int[args.length];

    //To get the numbers from the strings
     for( int i = 0; i < args.length; i ++){
         sortedNum[i] = Integer.parseInt(args[i]);
     }

     int numberToBeSearched = 0;
     int lowIndex = 0, highIndex = sortedNum.length, middleIndex =0;

     middleIndex = (highIndex - lowIndex)/2;

     if (numberToBeSearched == sortedNum[middleIndex])
         return middleIndex;

     else if (numberToBeSearched < sortedNum[middleIndex]){
         highIndex = middleIndex;
     }

     else
     {
         lowIndex = middleIndex;
     }
return 0;
    }

}
