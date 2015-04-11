package HackerRank.extra;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        long p = Long.parseLong(in.readLine());
        long q = Long.parseLong(in.readLine());
        boolean isThereOne = false;
        //for (int i = p; i <= q; i++) {
        int left = 0;
        long sqr = p*p;
        long digit = 1;
        long dummy = sqr;

        while (dummy > 0) {
            long first = dummy % 10;
            left += (first * digit);
            digit = digit * 10;
            long remain = dummy / 10;
            dummy /= 10;

            if (left + remain == p && left!= 0) {
                isThereOne = true;
                System.out.print(p);
                System.out.print(" ");
                break;
            }
        }
        // }
        if(!isThereOne){
            System.out.println("INVALID RANGE");
        }

    }
}