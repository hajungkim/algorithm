package reco.part3;
/*
구현 + 완탐
사탕 게임
https://www.acmicpc.net/problem/3085
 */
import java.util.*;
import java.io.*;
public class Main_3085 {
    static int N, result;
    static char map[][];
    static boolean visit[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        visit = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }
        int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < 4; k++) {
                    int x = i + dx[k];
                    int y = j + dy[k];
                    if (x < 0 || x >= N || y < 0 || y >= N || visit[x][y]) continue;
                    if (map[i][j] == map[x][y]) continue;
                    swap(i, j, x, y);
                }
                visit[i][j] = true;
            }
        }
        System.out.println(result);
    }

    static void swap(int i, int j, int x, int y) {
        char temp = map[i][j];
        map[i][j] = map[x][y];
        map[x][y] = temp;
        calc();
        map[x][y] = map[i][j];
        map[i][j] = temp;
    }

    static void calc() {
        boolean[][] visit2 = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visit2[i][j] || j + 1 >= N) continue;
                visit2[i][j] = true;
                int x = i, y = j+1, count = 1;
                while (map[i][j] == map[x][y]) {
                    visit2[x][y] = true;
                    count++;
                    y++;
                    if (y >= N) break;
                }
                result = Math.max(result, count);
            }
        }
        visit2 = new boolean[N][N];
        for (int j = 0; j < N; j++) {
            for (int i = 0; i < N; i++) {
                if (visit2[i][j] || i + 1 >= N) continue;
                visit2[i][j] = true;
                int x = i+1, y = j, count = 1;
                while (map[i][j] == map[x][y]) {
                    visit2[x][y] = true;
                    count++;
                    x++;
                    if (x >= N) break;
                }
                result = Math.max(result, count);
            }
        }
    }
}
