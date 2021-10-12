package reco.part1;
/*
소수찾기
https://www.acmicpc.net/problem/1978
 */
import java.util.*;
import java.io.*;
public class Main_1978 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (num == 1) continue;
            boolean tf = true;
            for (int j = 2; j < num; j++) {
                if (num % j == 0) {
                    tf = false;
                    break;
                }
            }
            if (tf) cnt++;
        }
        System.out.println(cnt);
    }
}
