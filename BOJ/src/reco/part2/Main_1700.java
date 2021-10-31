package reco.part2;
/*
멀티탭 스케줄링
https://www.acmicpc.net/problem/1700
 */
import java.util.*;
import java.io.*;
public class Main_1700 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        boolean isUsed[] = new boolean[K+1];
        ArrayList<Integer> list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        int cnt = 0;
        for (int i = 0; i < K; i++) {
            int input = Integer.parseInt(st.nextToken());
            if (cnt < N) {
                if (isUsed[input]) continue;
                isUsed[input] = true;
                cnt++;
            }
            else list.add(input);
        }
        int result = 0;
        for (int i = 0; i < list.size(); i++) {
            int curr = list.get(i);
            if (isUsed[curr]) continue;
            ArrayList<Integer> temp = new ArrayList<>();
            for (int j = i; j < list.size(); j++) {
                if (isUsed[list.get(j)] && !temp.contains(list.get(j))) {
                    temp.add(list.get(j));
                }
            }
            if (temp.size() == N) {
                isUsed[temp.get(temp.size()-1)] = false;
            } else {
                for (int j = 1; j < K+1; j++) {
                    if (isUsed[j] && !temp.contains(j)) {
                        isUsed[j] = false;
                        break;
                    }
                }
            }
            isUsed[curr] = true;
            result++;
        }
        System.out.println(result);
    }
}
