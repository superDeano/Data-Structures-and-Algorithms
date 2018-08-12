//
//  ISSort.cpp
//  testingInsertionSort
//
//  Created by Dean Chong San on 2018-07-07.
//  Copyright © 2018 superDeano. All rights reserved.
//

#include <stdio.h>
#include <iostream>
#include <array>

int main(){
    
    std::cout << "HELLO WORLD ";
    
    std::array<int, 28> numbers = { 198, 120, 113947, 21932, 2954, 5206, 2274, 1396, 584, 3385, 12084, 33930, 54827, 7020, 1932, 211, 281, 2315, 6869, 17, 28, 10184, 193, 190, 192, 382, 18, 15392};
    
    
    int count = 0;
    int startAscending, endAscending, startDescending, endDescending, compCounter = 0;
    clock_t startTime, endingTime;
    
    
    
    //For timing purposes
     startTime = clock();
    
    
    //For loop to go check for ascending order
    for (int y = 0; y < numbers.size() -1; y++) {
        
        count = y;
        
        if (numbers[y] < numbers[y + 1]) {
            
            //Getting the ascending index
            startAscending = y;
            while (numbers[count] <= numbers[count + 1]) {
                //printing out the runs
                std::cout << numbers[count] << " ";
                //increments while it is in ascending
                count++;
                compCounter++;
            }
            //Getting the final index of where the ascending run ends
            endAscending = count;
            continue;
        }
        else if(numbers[y] > numbers[y + 1]){
            
            int middleIndexDescending, tempHolder;
            
            //Getting the first index of the descending run
            startDescending = y;
            
            //While loop to find a run of descending
            while (numbers[count] >= numbers[count + 1]) {
                
                //printing out the runs
                std::cout << numbers[count] << " ";
                //increments while it is in ascending
                count++;
                compCounter++;
                
            }
            //TO CHNAGE THE DESCENDING RUN INTO AN ASCENDING ONE
            //The final index of the descending run
            endDescending = count;
            
            //To get a middle index for switching the descending runs
            middleIndexDescending = (endDescending - startDescending)/2;
            
            //Checks if the number is odd
            if (middleIndexDescending % 2 != 0) {
                
                //For loop for switching the numbers
                for (int x = 0; x >= middleIndexDescending; x++) {
                    tempHolder = numbers[startDescending + x];
                    numbers[startDescending + x] = numbers[endDescending - x];
                    numbers[endDescending - x] = tempHolder;
                }
            }
            else {
                
                for (int x = 0; x >= (middleIndexDescending - 1); x++) {
                    tempHolder = numbers[startDescending + x];
                    numbers[startDescending + x] = numbers[endDescending - x];
                    numbers[endDescending - x] = tempHolder;
                }
                
                
            }
            //At the end we continue in the enclosing for loop
            continue;
        }
    }
    
    //calling the Insertion sort method and adds the number of comparisons from that
    
    
    
    //For timing purposes
     endingTime = clock();
    
    
    
    
    return 0;
}
