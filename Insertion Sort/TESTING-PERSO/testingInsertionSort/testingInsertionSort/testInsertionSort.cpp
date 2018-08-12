//
//  testInsertionSort.cpp
//  A2_Quest_1
//
//  Created by Dean Chong San on 2018-07-04.
//  Copyright © 2018 Super Deano. All rights reserved.
//

#include <stdio.h>
int main(){
    //array
    int [] numbers = { 9, 10 ,1 ,22, 24, 56 ,692,2 };
    //Sorting algorithm with n^2
    //for (int w = 0; w < numbers.length; w++){
    for (int z = numbers.length() - 1; z >0;z--){
        
        while (numbers[z] < numbers[z - 1]){
            tempHolder = numbers[z];
            numbers[z] = numbers[z - 1];
            numbers[z - 1] = tempHolder;
            z--;
        }
    }
    // }
    
    for (int w = 0; w < numbers.length(); w++)
    {
        std::cout << numbers[w] << " ";
    }
    return 0;
}
