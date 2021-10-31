package reco.part2;
/*
부분합
https://www.acmicpc.net/problem/1806
 */
import java.util.*;
import java.io.*;
public class Main_1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int start = 0, end = 0, sum = arr[0], result = Integer.MAX_VALUE;
        while (true) {
            if (sum >= S) {
                result = Math.min(end-start+1, result);
                sum -= arr[start++];
            } else {
                if (++end >= N) break;
                sum += arr[end];
            }
        }
        if (result == Integer.MAX_VALUE) System.out.println(0);
        else System.out.println(result);
    }
}
