package reco.part1;
/*

 */
import java.util.*;
import java.io.*;
public class Main_10870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        /* 단순 구현 하기
        int f1 = 0, f2 = 1, sum = 0;
        for (int i = 0; i < n-1; i++) {
            sum = f1 + f2;
            f1 = f2;
            f2 = sum;
        }
        if (n == 1) sum = 1;
         */

        // 재귀
        int sum = fivo(n);
        System.out.println(sum);
    }

    static int fivo(int num) {
        if (num == 0) return 0;
        if (num == 1) return 1;

        return fivo(num-1) + fivo(num-2);
    }
}
