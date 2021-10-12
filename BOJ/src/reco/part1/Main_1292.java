package reco.part1;
/*

 */
import java.util.*;
import java.io.*;
public class Main_1292 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int num = 1, cnt = 0;
        ArrayList<Integer> list = new ArrayList<>();
        while (cnt <= 1000) {
            for (int i = 0; i < num; i++) {
                list.add(num);
                cnt++;
            }
            num++;
        }
        int sum = 0;
        for (int i = a; i <= b; i++) {
            sum += list.get(i-1);
        }
        System.out.println(sum);
    }
}
