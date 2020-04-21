/*Sam's house has an apple tree and an orange tree that yield an abundance of fruit. In the diagram below,
the red region denotes his house, where s is the start point, and t is the endpoint.
The apple tree is to the left of his house, and the orange tree is to its right.
You can assume the trees are located on a single point, where the apple tree is at point a,
and the orange tree is at point b.

Apple and orange(2).png

When a fruit falls from its tree, it lands d units of distance from its tree of origin along the x-axis.
A negative value of d means the fruit fell d units to the tree's left,
and a positive value of d means it falls d units to the tree's right.

Given the value of d for m apples and n oranges, determine how many apples
and oranges will fall on Sam's house (i.e., in the inclusive range [s,t])?

For example, Sam's house is between s=7 and t=10. The apple tree is located at a=4 and the orange at b=12.
There are m=3 apples and n=3 oranges. Apples are thrown apples=[2,3,-4] units distance from a,
and oranges=[3,-2,-4] units distance. Adding each apple distance to the position of the tree,
they land at [4+2,4+3,4+-4] = [6,7,0]. Oranges land at [12+3, 12+-2, 12+-4]=[15,10,8].
One apple and two oranges land in the inclusive range 7-10 so we print

1
2
Function Description

Complete the countApplesAndOranges function in the editor below.
It should print the number of apples and oranges that land on Sam's house, each on a separate line.

countApplesAndOranges has the following parameter(s):

s: integer, starting point of Sam's house location.
t: integer, ending location of Sam's house location.
a: integer, location of the Apple tree.
b: integer, location of the Orange tree.
apples: integer array, distances at which each apple falls from the tree.
oranges: integer array, distances at which each orange falls from the tree.
Input Format

The first line contains two space-separated integers denoting the respective values of s and t.
The second line contains two space-separated integers denoting the respective values of a and b.
The third line contains two space-separated integers denoting the respective values of m and n.
The fourth line contains m space-separated integers denoting the respective distances that each apple falls from point a.
The fifth line contains n space-separated integers denoting the respective distances that each orange falls from point b.

Output Format

Print two integers on two different lines:

The first integer: the number of apples that fall on Sam's house.
The second integer: the number of oranges that fall on Sam's house.
Sample Input 0

7 11
5 15
3 2
-2 2 1
5 -6
Sample Output 0

1
1
*/

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class AppleAndOrange {
    // Complete the countApplesAndOranges function below.
    static void countApplesAndOranges(int s, int t, int a, int b, int[] apples, int[] oranges) {
        int fallingAppleCount=0;
        int fallingOrangeCount=0;

        for(int i=0; i<apples.length; i++){
            int fallingApple = a+apples[i];
            if(fallingApple >= s && fallingApple <=t){
                fallingAppleCount++;
            }
        }

        for(int j=0; j<oranges.length; j++){
            int fallingOrange = b+oranges[j];
            if(fallingOrange >= s && fallingOrange <=t){
                fallingOrangeCount++;
            }
        }

        System.out.println(fallingAppleCount);
        System.out.println(fallingOrangeCount);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] st = scanner.nextLine().split(" ");

        int s = Integer.parseInt(st[0]);

        int t = Integer.parseInt(st[1]);

        String[] ab = scanner.nextLine().split(" ");

        int a = Integer.parseInt(ab[0]);

        int b = Integer.parseInt(ab[1]);

        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        int[] apples = new int[m];

        String[] applesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            int applesItem = Integer.parseInt(applesItems[i]);
            apples[i] = applesItem;
        }

        int[] oranges = new int[n];

        String[] orangesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int orangesItem = Integer.parseInt(orangesItems[i]);
            oranges[i] = orangesItem;
        }

        countApplesAndOranges(s, t, a, b, apples, oranges);

        scanner.close();
    }
}
