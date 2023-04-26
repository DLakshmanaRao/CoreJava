package com.qsns;

import java.lang.reflect.Array;
import java.util.Arrays;

public class PracticeQsns {
    public static void main(String[] args) {

        System.out.println(convertToWord(19));
        System.out.println(noOfDaysInGivenMonth(3,2020));
        int[] arr = new int[]{1,3,5,2,4};
        int[] arr1 = new int[]{1,3,5,2,4,6};

        System.out.println(medianOfArray(arr1));

    }

    public static String convertToWord(int num){
        // if num is divisible by 3 then return “Fizz”
        // if num is divisible by 5 then return “Buzz”
        //if num is divisible by 3 and 5 then return “FizzBuzz”
        // If none of the above cases are true then return number as String

        if(num%3 == 0 && num%5 ==0){
            return "FizzBuzz";
        }else if(num%5 ==0){
            return "Buzz";
        }else if(num%3 == 0){
            return "Fizz";
        }else{
            return String.valueOf(num);
        }
//        Input: 3, Output: Fizz
//        Input: 19, Output: “19”
//        Input:10, Output: “Buzz”
//        Input: 15, Output: “FizzBuzz”
    }

    public static int noOfDaysInGivenMonth(int month, int year){
//        If the year is evenly divisible by 4, it is a leap year (e.g., 2020, 2024).
//        If the year is evenly divisible by 100, it is not a leap year (e.g., 1900, 2100).
//        If the year is evenly divisible by 400, it is a leap year (e.g., 1600, 2000).

        int x = 0;
        if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12){
            return x = 31;
        }else if(month == 4 || month ==6 || month ==9 || month == 11 ){
            return x = 30;
        } else if (month == 2) {
            if((year%4 ==0 ) && (year%100 != 0)){
                return x =  29;
            } else if ((year%400 == 0)) {
                return x = 29;
            } else{
                return x = 28;
            }
        }
        return x;
    }

    public static float medianOfArray(int[] arr){
//        Note: If the elements of the set are arranged in order, then, the middle value which divides the items into two parts with equal number of items on either side is called the median.
//        Odd number of the items have just one middle value whereas; even numbers of items have two middle values, so median is mean two middle elements.
//        Example:  Input is [1,3,2,5,4] -> [1,2,3,4,5] -> Median is 3 , Since there is an odd number of numbers in the set, the median is the middle number.
//        Input is [1,3,2,5,4,6] -> [1,2,3,4,5,6] -> Median is 3.5 ,Since there is an even number of numbers in the set, the median is the mean of the two middle numbers
       Arrays.sort(arr);
       float  median = 0;
       int len = arr.length;
       if(len%2 == 0){
           float a = arr[len/2];
           float b = arr[(len/2)-1];
           median = (a+b)/2;
           return median;
       } else if (len%2 !=0) {
           median = arr[(len/2)];
           return median;
       }
       return median;
    }

}
