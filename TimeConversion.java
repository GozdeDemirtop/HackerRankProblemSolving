/*Given a time in 12-hour AM/PM format, convert it to military (24-hour) time.

Note: Midnight is 12:00:00AM on a 12-hour clock, and 00:00:00 on a 24-hour clock.
Noon is 12:00:00PM on a 12-hour clock, and 12:00:00 on a 24-hour clock.

Function Description

Complete the timeConversion function in the editor below.
It should return a new string representing the input time in 24 hour format.

timeConversion has the following parameter(s):

s: a string representing time in 12 hour format
Input Format

A single string  containing a time in 12-hour clock format
(i.e.: hh:mm:ssAM or hh:mm:ssPM), where 01<= hh <=12 and 00<= mm,ss <=59.

All input times are valid
Output Format

Convert and print the given time in 24-hour format, where 00<= hh <=23.

Sample Input 0

07:05:45PM
Sample Output 0

19:05:45*/

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class TimeConversion {

    /*
     * Complete the timeConversion function below.
     */
    static String timeConversion(String s) {
        /*
         * Write your code here.
         */

        String [] str = s.split(":"); // str = {07, 05, 45PM}
        int hour = Integer.parseInt(str[0]); // {07} convert to int

        String min = str[1]; // {05}
        String secPeriod = str[2]; //{45PM}
        String sec = secPeriod.substring(0, secPeriod.length()-2); //{45}
        String period = secPeriod.substring(secPeriod.length()-2, secPeriod.length()); //{PM}

        String newTimeString= "";

        if(hour > 0 && hour < 12 && period.equalsIgnoreCase("AM")){
            newTimeString = String.format("%02d", hour) + ":" + min + ":" + sec;
        }

        else if(hour > 0 && hour < 12 && period.equalsIgnoreCase("PM")){
            newTimeString = (12 + hour) + ":" + min + ":" + sec;
        }

        else if(hour == 12 && period.equalsIgnoreCase("AM")){
            newTimeString = "00" + ":" + min + ":" + sec;
        }

        else if(hour == 12 && period.equalsIgnoreCase("PM")){
            newTimeString = hour + ":" + min + ":" + sec;
        }

        return newTimeString;


    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scan.nextLine();

        String result = timeConversion(s);

        bw.write(result);
        bw.newLine();

        bw.close();
    }
}
