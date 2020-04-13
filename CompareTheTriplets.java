/*
Alice and Bob each created one problem for HackerRank. A reviewer rates the two challenges,
awarding points on a scale from 1 to 100 for three categories: problem clarity, originality,
and difficulty.

We define the rating for Alice's challenge to be the triplet a=(a[0],a[1],a[2]),
and the rating for Bob's challenge to be the triplet b=(b[0],b[1],b[2]).

Your task is to find their comparison points by comparing
a[0] with b[0], a[1] with b[1], a[2] and b[2] with .

If a[i]>b[i], then Alice is awarded  point.
If a[i]<b[i], then Bob is awarded  point.
If a[i]=b[i], then neither person receives a point.
Comparison points is the total points a person earned.

Given a and b, determine their respective comparison points.

For example, a=[1,2,3] and b[3,2,1]. For elements 0, Bob is awarded a point because a[0]<b[0].
For the equal elements a[1] and b[1], no points are earned. Finally, for elements 2, a[2]>b[2]
so Alice receives a point. Your return array would be [1,1] with Alice's score first and Bob's second.

Function Description

Complete the function compareTriplets in the editor below.
It must return an array of two integers, the first being Alice's score and the second being Bob's.

compareTriplets has the following parameter(s):

a: an array of integers representing Alice's challenge rating
b: an array of integers representing Bob's challenge rating
Input Format

The first line contains 3 space-separated integers, a[0], a[1], and a[2],
describing the respective values in triplet a.
The second line contains 3 space-separated integers, b[0], b[1], and b[2],
describing the respective values in triplet b.

Output Format

Return an array of two integers denoting the respective comparison points earned by Alice and Bob.

Sample Input 0

5 6 7
3 6 10
Sample Output 0

1 1
*/
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

public class CompareTheTriplets {
    // Complete the compareTriplets function below.
    static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {

        /*int aliceScore = 0;
        int bobScore = 0;

        for (int i = 0; i < a.size() && i < b.size(); i++) {
            if (a.get(i) > b.get(i))
                aliceScore++;
            else if (a.get(i) < b.get(i))
                bobScore++;
        }
        return Arrays.asList(aliceScore, bobScore);*/

        //OR

        int aliceScore = 0;
        int bobScore = 0;

        for(int i=0; i<3; i++){
            int alice = a.get(i);
            int bob = b.get(i);
            if(alice != bob){
                int temp = alice > bob ? aliceScore++ : bobScore++;
            }
        }

        List<Integer> score = new ArrayList<>();
        score.add(aliceScore);
        score.add(bobScore);
        return score;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> b = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = compareTriplets(a, b);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
