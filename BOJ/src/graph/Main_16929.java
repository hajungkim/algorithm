package graph;
/*
Two Dots
https://www.acmicpc.net/problem/16929
 */
import java.util.*;
import java.io.*;
public class Main_16929 {
    static int N, M;
    static char[][] map;
    static boolean[][] visit;
    static String result;
    static int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }
        result = "No";
        visit = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visit[i][j]) continue;
                visit[i][j] = true;
                dfs(i, j, 0, 0, map[i][j], 1);
                if (result.equals("Yes")) break;
            }
        }
        System.out.println(result);
    }

    static void dfs(int cx, int cy, int bx, int by, char start, int cnt) {
        System.out.println(cx + " " + cy);
        if (visit[cx][cy] && cnt >= 4) {
            result = "Yes";
            return;
        }
        visit[cx][cy] = true;
        for (int i = 0; i < 4; i++) {
            int xx = cx + dx[i];
            int yy = cy + dy[i];
            if (xx < 0 || xx >= N || yy < 0 || yy >= M || map[xx][yy] != start) continue;
            if (xx == bx && yy == by) continue;
            dfs(xx, yy, cx, cy, start, cnt+1);
        }
    }
}
