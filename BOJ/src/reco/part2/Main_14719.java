package reco.part2;
/*
빗물
https://www.acmicpc.net/problem/14719
 */
import java.util.*;
import java.io.*;
public class Main_14719 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int[][] map = new int[H][W];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < W; i++) {
            int start = H - Integer.parseInt(st.nextToken());
            for (int j = start; j < H; j++) {
                map[j][i] = 1;
            }
        }

        int result = 0;
        // map 모두 탐색
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W-1; j++) {
                if (map[i][j] == 1 && map[i][j+1] == 0) {   // 블록 빈 공간이 연속이면
                    int count = 0;
                    while (true) {
                        j++;
                        if (j == W) {   // 블록을 만나지 못해서 빗물 고일 수 X
                            break;
                        }
                        if (map[i][j] == 1) {   // 블록 만나서 빗물 고임
                            result += count;
                            j--;
                            break;
                        }
                        count++;
                    }
                }
            }
        }

        System.out.println(result);
    }
}
