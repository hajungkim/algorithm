package reco.part2;
/*
재귀 탐색의 기본
연산자 끼워넣기
https://www.acmicpc.net/problem/14888
 */
import java.util.*;
import java.io.*;
public class Main_14888 {
    static int nums[], op[], N, min, max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        op = new int[4];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            op[i] = Integer.parseInt(st.nextToken());
        }
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        calc(op[0], op[1], op[2], op[3], 1, nums[0]);
//        calc2(1, nums[0]);
        System.out.println(max);
        System.out.println(min);
    }

    static void calc(int plus, int minus, int multi, int divi, int depth, int sum) {
        if (depth == N) {
            min = Math.min(min, sum);
            max = Math.max(max, sum);
        }
        if (plus > 0) calc(plus - 1, minus, multi, divi, depth + 1, sum + nums[depth]);
        if (minus > 0) calc(plus, minus - 1, multi, divi, depth + 1, sum - nums[depth]);
        if (multi > 0) calc(plus, minus, multi - 1, divi, depth + 1, sum * nums[depth]);
        if (divi > 0) calc(plus, minus, multi, divi - 1, depth + 1, sum / nums[depth]);
    }

    static void calc2(int depth, int sum) {
        if (depth == N) {
            min = Math.min(min, sum);
            max = Math.max(max, sum);
        }
        for (int i = 0; i < 4; i++) {
            if (op[i] == 0) continue;
            op[i]--;
            if (i == 0) calc2(depth + 1, sum + nums[depth]);
            else if (i == 1) calc2(depth + 1, sum - nums[depth]);
            else if (i == 2) calc2(depth + 1, sum * nums[depth]);
            else calc2(depth + 1, sum / nums[depth]);
            op[i]++;
        }
    }
}
