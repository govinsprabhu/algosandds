package algorithms.problems.array;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by GPrabhu on 3/8/2015.
 */
public class PrintSortedMatrixInSortedFormat {
    public static void main(String[] args) {
        int[][] mat = {{10, 20, 30, 40},
                {15, 25, 35, 45},
                {27, 29, 37, 48},
                {32, 33, 39, 50},
        };

        Set<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < 4; ++i)
            for (int j = 0; j < 4; ++j)
                hashSet.add(mat[i][j]);


       for(Integer integer:hashSet){
           System.out.println(integer);
       }
    }
}
