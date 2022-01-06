package reco.part3;
/*
단지번호붙이기
https://www.acmicpc.net/problem/2667
 */
import java.util.*;
import java.io.*;
public class Main_2667 {
    static int N, result;
    static List<Integer> list;
    static char map[][];
    static int[] dx = {0, 0, -1, 1}, dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        map = new char[N][];
        list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == '1') {
                    map[i][j] = '0';
                    bfs(i, j);
                    result++;
                }
            }
        }
        System.out.println(result);
        Collections.sort(list);
        for (int i : list) {
            System.out.println(i);
        }
    }

    static void bfs(int r, int c) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(r, c));
        int count = 1;
        while (!q.isEmpty()) {
            int x = q.peek().x;
            int y = q.poll().y;
            for (int i = 0; i < 4; i++) {
                int xx = x + dx[i];
                int yy = y + dy[i];
                if (xx < 0 || xx >= N || yy < 0 || yy >= N || map[xx][yy] == '0') continue;
                map[xx][yy] = '0';
                count++;
                q.add(new Node(xx, yy));
            }
        }
        list.add(count);
    }

    static class Node {
        int x, y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
