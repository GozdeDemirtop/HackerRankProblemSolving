/*Given five positive integers,
find the minimum and maximum values that can be calculated by summing exactly four of the five integers.
Then print the respective minimum and maximum values as a single line of two space-separated long integers.

For example, arr=[1,3,5,7,9]. Our minimum sum is 1+3+5+7=16 and our maximum sum is 3+5+7+9=24. We would print

16 24
Function Description

Complete the miniMaxSum function in the editor below. It should print two space-separated integers on one line:
the minimum sum and the maximum sum of 4 of 5 elements.

miniMaxSum has the following parameter(s):

arr: an array of 5 integers
Input Format

A single line of five space-separated integers.

Output Format

Print two space-separated long integers denoting the respective minimum and maximum values
that can be calculated by summing exactly four of the five integers. (The output can be greater than a 32 bit integer.)

Sample Input

1 2 3 4 5
Sample Output

10 14
Explanation

Our initial numbers are 1, 2, 3, 4, and 5. We can calculate the following sums using four of the five integers:

If we sum everything except 1, our sum is 2+3+4+5=14.
If we sum everything except 2, our sum is 1+3+4+5=13.
If we sum everything except 3, our sum is 1+2+4+5=12.
If we sum everything except 4, our sum is 1+2+3+5=11.
If we sum everything except 5, our sum is 1+2+3+4=10.
Hints: Beware of integer overflow! Use 64-bit Integer.*/

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MiniMaxSum {
    // Complete the miniMaxSum function below.
    static void miniMaxSum(int[] arr) {

        long sum=0;
        long min=arr[0];
        long max=min;

        for (int value : arr) {
            sum += value;

            if (value < min) {
                min = value;
            } else if (value > max) {
                max = value;
            }
        }

        /*
        for(int i=0; i<arr.length; i++){
            sum+=arr[i];

            if (arr[i] < min){
                min = arr[i];
            }
            else if(arr[i] > max){
                max = arr[i];
            }
        }
        */

        System.out.print((sum-max)+" "+(sum-min));
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = new int[5];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < 5; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        miniMaxSum(arr);

        scanner.close();
    }
}