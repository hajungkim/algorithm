package level2;
/*
게임맵최단거리
https://programmers.co.kr/learn/courses/30/lessons/1844
 */
import java.util.*;
public class Solution_1844 {
    class Solution {
        int n, m, answer;

        public int solution(int[][] maps) {
            n = maps.length;
            m = maps[0].length;
            answer = -1;
            bfs(maps);
            return answer;
        }

        void bfs(int[][] maps) {
            int[] dx = {0, 0, -1, 1}, dy = {-1, 1, 0, 0};
            Queue<Node> q = new LinkedList<>();
            q.add(new Node(0, 0, 1));
            while (!q.isEmpty()) {
                int x = q.peek().x;
                int y = q.peek().y;
                int cnt = q.poll().cnt;
                if (x == n-1 && y == m-1) {
                    answer = cnt;
                    return;
                }
                for (int i = 0; i < 4; i++) {
                    int xx = x + dx[i];
                    int yy = y + dy[i];
                    if (xx < 0 || xx >= n || yy < 0 || yy >= m || maps[xx][yy] == 0) continue;
                    q.add(new Node(xx, yy, cnt + 1));
                    maps[xx][yy] = 0;
                }
            }
        }

        class Node {
            int x, y, cnt;
            Node(int x, int y, int cnt) {
                this.x = x;
                this.y = y;
                this.cnt = cnt;
            }
        }
    }
}
