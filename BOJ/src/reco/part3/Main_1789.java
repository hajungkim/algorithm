package reco.part3;
/*
수들의 합
https://www.acmicpc.net/problem/1789
 */
import java.util.*;
import java.io.*;
public class Main_1789 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long S = Long.parseLong(br.readLine());
        int count = 1;
        long sum = 0;
        while (sum <= S) {
            sum += count++;
        }
        System.out.println(count-2);
    }
}
