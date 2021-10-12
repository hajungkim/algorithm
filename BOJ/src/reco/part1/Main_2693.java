package reco.part1;
/*
N번째 큰 수
https://www.acmicpc.net/problem/2693
 */
import java.util.*;
import java.io.*;
public class Main_2693 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int t = 0; t < T; t++) {
            ArrayList<Integer> list = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 10; i++) {
                list.add(Integer.parseInt(st.nextToken()));
            }
            Collections.sort(list);
            System.out.println(list.get(7));
        }
    }
}
