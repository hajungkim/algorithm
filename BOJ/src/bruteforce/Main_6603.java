package bruteforce;
/*
로또
https://www.acmicpc.net/problem/6603
 */
import java.util.*;
import java.io.*;
public class Main_6603 {
    static int k, S[], nums[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            if (st.countTokens() == 1) break;
            k = Integer.parseInt(st.nextToken());
            S = new int[k];
            nums = new int[6];
            for (int i = 0; i < k; i++) {
                S[i] = Integer.parseInt(st.nextToken());
            }
            comb(0, 0);
            System.out.println();
        }
    }

    static void comb(int cnt, int start) {
        if (cnt == 6) {
            StringBuilder sb = new StringBuilder();
            for (int n : nums) {
                sb.append(n + " ");
            }
            System.out.println(sb);
            return;
        }

        for (int i = start; i < k; i++) {
            nums[cnt] = S[i];
            comb(cnt + 1, i + 1);
        }
    }
}
