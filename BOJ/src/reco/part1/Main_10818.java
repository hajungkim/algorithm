package reco.part1;
/*
최소, 최대
https://www.acmicpc.net/problem/10818
 */
import java.util.*;
import java.io.*;
public class Main_10818 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int min = 1000000;
        int max = -1000000;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int M = Integer.parseInt(st.nextToken());
            if (M < min) min = M;
            if (M > max) max = M;
        }
        System.out.println(min + " " + max);
    }
}
