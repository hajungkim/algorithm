package reco.part1;
/*
지능형 기차
https://www.acmicpc.net/problem/2460
 */
import java.util.*;
import java.io.*;
public class Main_2460 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int cnt = 0, max = 0;
        for (int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine());
            int out = Integer.parseInt(st.nextToken());
            int in = Integer.parseInt(st.nextToken());
            cnt -= out;
            cnt += in;
            max = Math.max(max, cnt);
        }
        System.out.println(max);
    }
}
