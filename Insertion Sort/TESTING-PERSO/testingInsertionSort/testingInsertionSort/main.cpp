//
//  main.cpp
//  testingInsertionSort
//
//  Created by Dean Chong San on 2018-07-04.
//  Copyright © 2018 superDeano. All rights reserved.
//

#include <iostream>
#include <array>
#include <time.h>

//using namespace std;


int main(int argc, const char * argv[]) {
    clock_t t1, t2;
    t1 = clock();
    std::array<int, 28> numbers = { 198, 120, 113947, 21932, 2954, 5206, 2274, 1396, 584, 3385, 12084, 33930, 54827, 7020, 1932, 211, 281, 2315, 6869, 17, 28, 10184, 193, 190, 192, 382, 18, 15392};
   
    std::cout <<"The array size is  "<<numbers.size() << std::endl;
    
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
           
            if((numbers[currentIndex + 1]>= numbers[dummyIndex - 1])||(dummyIndex == 0)){
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
            numbers[x] = numbers[x-1];
        }
        //puts the numbers back
        numbers[dummyIndex] = tempHolder;
        }
        
        //Increments
        currentIndex++;
    
        if (currentIndex == (numbers.size() -1)){
            break;
        }
    }
    //until it reaches the end of the array
    while (currentIndex <= (numbers.size()-1));
    t2 = clock();
    float diff = (t2- t1);
    
    for (int w = 0; w < numbers.size(); w++)
    {
        std::cout << numbers[w] << " ";
    }
    
    std::cout<< "\nThe number of comparison is " << comparisonsCounter << std::endl;
    std::cout << "\nThe time taken is " << diff << std::endl;
    return 0;
}










