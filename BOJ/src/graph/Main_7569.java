package graph;
/*
토마토
https://www.acmicpc.net/problem/7569
 */
import java.util.*;
import java.io.*;
public class Main_7569 {
    static int N, M, H, map[][][], zeroCnt, result;
    static Queue<Node> q;
    static int[] dx = {0, -1, 0, 1}, dy = {-1, 0, 1, 0}, dh = {-1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new int[N][M][H];
        q = new ArrayDeque<>();
        for (int k = 0; k < H; k++) {
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    map[i][j][k] = Integer.parseInt(st.nextToken());
                    if (map[i][j][k] == 0) zeroCnt++;
                    if (map[i][j][k] == 1) q.add(new Node(i, j, k, 0));
                }
            }
        }
        if (zeroCnt == 0) System.out.println(0);
        else {
            bfs();
            System.out.println(result);
        }
    }

    static void bfs() {
        int tomaCnt = 0;
        while (!q.isEmpty()) {
            int x = q.peek().x;
            int y = q.peek().y;
            int h = q.peek().h;
            int cnt = q.poll().cnt;
            result = cnt;
            for (int i = 0; i < 4; i++) {
                int xx = x + dx[i];
                int yy = y + dy[i];
                if (xx < 0 || xx >= N || yy < 0 || yy >= M || map[xx][yy][h] != 0) continue;
                map[xx][yy][h] = 1;
                q.add(new Node(xx, yy, h, cnt+1));
                tomaCnt++;
            }
            for (int i = 0; i < 2; i++) {
                int hh = h + dh[i];
                if (hh < 0 || hh >= H || map[x][y][hh] != 0) continue;
                map[x][y][hh] = 1;
                q.add(new Node(x, y, hh, cnt+1));
                tomaCnt++;
            }
        }
        if (tomaCnt != zeroCnt) result = -1;
    }

    static class Node {
        int x, y, h, cnt;
        Node(int x, int y, int h, int cnt) {
            this.x = x;
            this.y = y;
            this.h = h;
            this.cnt = cnt;
        }
    }
}
