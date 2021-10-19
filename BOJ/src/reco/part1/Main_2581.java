package reco.part1;
/*
소수
https://www.acmicpc.net/problem/2581
 */
import java.util.*;
import java.io.*;
public class Main_2581 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        if (M == 1) M = 2;
        int N = Integer.parseInt(br.readLine());
        int sum = 0, min = 10000;
        for (int i = M; i <= N; i++) {
            if (isPrime(i)) {
                sum += i;
                min = Math.min(min, i);
            }
        }
        if (sum == 0) System.out.println(-1);
        else {
            System.out.println(sum);
            System.out.println(min);
        }
    }

    static boolean isPrime(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
