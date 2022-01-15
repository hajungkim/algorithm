package level2;
/*
행렬 테두리 회전하기
https://programmers.co.kr/learn/courses/30/lessons/77485
 */
public class Solution_77485 {
    class Solution {
        public int[] solution(int rows, int columns, int[][] queries) {
            int[][] map = new int[rows][columns];
            int num = 1;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    map[i][j] = num++;
                }
            }
            int[] answer = new int[queries.length];
            for (int i = 0; i < queries.length; i++) {
                int x1 = queries[i][0]-1, y1 = queries[i][1]-1, x2 = queries[i][2]-1, y2 = queries[i][3]-1;
                int min = map[x1][y1], temp = map[x1][y1];
                for (int j = x1; j < x2; j++) {
                    map[j][y1] = map[j+1][y1];
                    if (map[j][y1] < min) min = map[j][y1];
                }
                for (int j = y1; j < y2; j++) {
                    map[x2][j] = map[x2][j+1];
                    if (map[x2][j] < min) min = map[x2][j];
                }
                for (int j = x2; j > x1; j--) {
                    map[j][y2] = map[j-1][y2];
                    if (map[j][y2] < min) min = map[j][y2];
                }
                for (int j = y2; j > y1; j--) {
                    map[x1][j] = map[x1][j-1];
                    if (map[x1][j] < min) min = map[x1][j];
                }
                map[x1][y1+1] = temp;
                answer[i] = min;
            }
            return answer;
        }
    }
}
