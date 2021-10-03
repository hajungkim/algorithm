package bruteforce;
/*
외판원 순회 2
https://www.acmicpc.net/problem/10971
4
0 1 0 0
0 0 1 0
0 0 0 1
1 0 0 0
 */
import java.util.*;
import java.io.*;
public class Main_10971 {
    static int N, map[][], city[], result;
    static boolean visit[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        city = new int[N];
        visit = new boolean[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        result = Integer.MAX_VALUE;
        perm(0);
        System.out.println(result);
    }

    static void perm(int cnt) {
        if (cnt == N) {
            int price = calc();
            if (price != -1) {
                result = Math.min(result, price);
            }
            return;
        }
        for (int i = 0; i < N; i++) {
            if (visit[i]) continue;
            city[cnt] = i;
            visit[i] = true;
            perm(cnt + 1);
            visit[i] = false;
        }
    }

    static int calc() {
        int price = 0;
        for (int i = 0; i < N; i++) {
            int start = i;
            int end = (i + 1) % N;
            if (map[city[start]][city[end]] == 0) return -1;
            price += map[city[start]][city[end]];
        }
        return price;
    }
}
