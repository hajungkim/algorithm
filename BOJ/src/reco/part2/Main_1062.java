package reco.part2;
/*
가르침
https://www.acmicpc.net/problem/1062
 */
import java.util.*;
import java.io.*;
public class Main_1062 {
    static int N, K, result;
    static boolean alpa[];
    static ArrayList<String> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        if (K < 5) {
            System.out.println(0);
            return;
        }
        if (K == 26) {
            System.out.println(N);
            return;
        }
        K -= 5;
        alpa = new boolean[26];
        alpa['a' - 97] = alpa['c' - 97] = alpa['i' - 97] = alpa['n' - 97] = alpa['t' - 97] = true;
        list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            list.add(word.substring(4, word.length() - 4));
        }
        comb(0, 0);
        System.out.println(result);
    }

    static void comb(int depth, int start) {
        if (depth == K) {
            int cnt = 0;
            for (int i = 0; i < list.size(); i++) {
                boolean tf = true;
                for (char c : list.get(i).toCharArray()) {
                    if (!alpa[c - 97]) {
                        tf = false;
                        break;
                    }
                }
                if (tf) cnt++;
            }
            result = Math.max(result, cnt);
        }

        for (int i = start; i < 26; i++) {
            if (alpa[i]) continue;
            alpa[i] = true;
            comb(depth + 1, i + 1);
            alpa[i] = false;
        }
    }
}
