package bruteforce;
/*
차이를 최대로
https://www.acmicpc.net/problem/10819
 */
import java.util.*;
import java.io.*;
public class Main_10819 {
    static int N, arr[], nums[], result;
    static boolean visit[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        nums = new int[N];
        visit = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        comb(0);
        System.out.println(result);
    }

    static void comb(int cnt) {
        if (cnt == N) {
            result = Math.max(result, calc());
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visit[i]) continue;
            nums[cnt] = arr[i];
            visit[i] = true;
            comb(cnt + 1);
            visit[i] = false;
        }
    }

    static int calc() {
        int sum = 0;
        for (int i = 0; i < N-1; i++) {
            sum += Math.abs(nums[i] - nums[i+1]);
        }
        return sum;
    }
}
