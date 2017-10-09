package javaapplication9;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class AllCombination {

    public static void main(String[] args) throws IOException {

        BufferedWriter out = new BufferedWriter(new FileWriter("lotto.txt"));

        int total = 45;
        
        int cnt = 0;
        int[] lotto = new int[6];
        int[] arr= new int[5];
        int[][] helperMatrix = new int[10][];

        //세수가 연속
        helperMatrix[0] = new int[]{1, 1, 0, 0, 0};
        helperMatrix[1] = new int[]{0, 1, 1, 0, 0};
        helperMatrix[2] = new int[]{0, 0, 1, 1, 0};
        helperMatrix[3] = new int[]{0, 0, 0, 1, 1};

        //네수가 연속
        helperMatrix[4] = new int[]{1, 1, 1, 0, 0};
        helperMatrix[5] = new int[]{0, 1, 1, 1, 0};
        helperMatrix[6] = new int[]{0, 0, 1, 1, 1};

        //다섯수가 연속
        helperMatrix[7] = new int[]{1, 1, 1, 1, 0};
        helperMatrix[8] = new int[]{0, 1, 1, 1, 1};

        //모든수가 연속
        helperMatrix[9] = new int[]{1, 1, 1, 1, 1};

        for (int i = 1; i <= total; i++) {
            for (int j = i + 1; j <= total; j++) {
                for (int k = j + 1; k <= total; k++) {
                    for (int p = k + 1; p <= total; p++) {
                        for (int q = p + 1; q <= total; q++) {
                            for (int r = q + 1; r <= total; r++) {

//                                lotto[0] = i;
//                                lotto[1] = j;
//                                lotto[2] = k;
//                                lotto[3] = p;
//                                lotto[4] = q;
//                                lotto[5] = r;

                                out.write((++cnt)+" : "+i+","+j+","+k+","+p+","+q+","+r); 
                                out.newLine();
                                
//                                for (int s = 0; s < 5; s++) 
//                                    arr[s] = (lotto[s + 1] - lotto[s] == 1) ? lotto[s + 1] - lotto[s] : 0;
//
//                                for (int[] pattern : helperMatrix) {
//                                    if (Arrays.equals(arr,pattern)) {
//                                        cnt++;
//                                        break;
                               //     }
                               // }
                            }
                        }
                    }
                }
            }
        }
        
        out.close();

        int all = choose(total, 6);
        System.out.println(cnt);
        //System.out.println( all+ "  =  " + (all-cnt) +" + " + cnt + " (# of matched patterns) ");
    }

    public static int choose(long total, long choose) {
       
        if (total < choose) {
            return 0;
        }
        
        if (choose == 0 || choose == total) {
            return 1;
        }
        
        return choose(total - 1, choose - 1) + choose(total - 1, choose);
    }
}
