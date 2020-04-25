import java.io.*;
import java.util.List;
import java.util.stream.Stream;

/*You will be given two arrays of integers and asked to determine all integers that satisfy the following two conditions:

The elements of the first array are all factors of the integer being considered
The integer being considered is a factor of all elements of the second array
These numbers are referred to as being between the two arrays. You must determine how many such numbers exist.

For example, given the arrays a=[2,6] and b=[24,36], there are two numbers between them: 6 and 12. 6%2=0, 6%6=0, 24%6=0
and 36%6=0 for the first value. Similarly, 12%2=0, 12%6=0 and 24%12=0, 36%12=0.

Function Description

Complete the getTotalX function in the editor below. It should return the number of integers that are between the sets.

getTotalX has the following parameter(s):

a: an array of integers
b: an array of integers
Input Format

The first line contains two space-separated integers, n and m, the number of elements in array a and the number of elements in array b.
The second line contains n distinct space-separated integers describing a[i] where 0<=i<n.
The third line contains m distinct space-separated integers describing b[j] where 0<=j<m.

Output Format

Print the number of integers that are considered to be between a and b.

Sample Input

2 3
2 4
16 32 96
Sample Output

3
Explanation

2 and 4 divide evenly into 4, 8, 12 and 16.
4, 8 and 16 divide evenly into 16, 32, 96.

4, 8 and 16 are the only three numbers for which each element of a is a factor and each is a factor of all elements of b.*/

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Count{
    public static int getTotalX(List<Integer> a, List<Integer> b) {

        int resultLCM = a.get(0);
        for(int i = 1; i<a.size(); i++){
            resultLCM = (resultLCM * a.get(i)) / gcd(a.get(i),resultLCM);
        }

        int resultGCD = b.get(0);
        for(int j=1; j<b.size(); j++){
            resultGCD = gcd(b.get(j), resultGCD);
        }

        int counter =0;
        for (int i = 1; i <=resultGCD; i++) {
            int k = resultLCM  * i;
            if (resultGCD % k == 0) {
                counter++;
            }
        }

        return counter;
    }

    public static int gcd(int a, int b){
        if(b==0){
            return a;
        }
        return gcd(b, a%b);
    }
}

public class BetweenTwoSets {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int total = Count.getTotalX(arr, brr);

        bufferedWriter.write(String.valueOf(total));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
