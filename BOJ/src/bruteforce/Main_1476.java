package bruteforce;
import java.util.*;
import java.io.*;
/*
날짜 계산
https://www.acmicpc.net/problem/1476
 */
public class Main_1476 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int result = 1, e = 1, s = 1, m = 1;
        while (true) {
            if (e == E && s == S && m == M) break;
            e++;
            s++;
            m++;
            if (e > 15) e = 1;
            if (s > 28) s = 1;
            if (m > 19) m = 1;
            result++;
        }
        System.out.println(result);
    }
}
