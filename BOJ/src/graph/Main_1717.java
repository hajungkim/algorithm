package graph;
/*
집합의 표현
https://www.acmicpc.net/problem/1717
 */
import java.util.*;
import java.io.*;
public class Main_1717 {
    static int parent[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        parent = new int[n+1];
        for (int i = 0; i < n+1; i++) {
            parent[i] = i;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            if (op == 0) union(num1, num2);
            else {
                if (find(num1) == find(num2)) sb.append("YES"+"\n");
                else sb.append("NO"+"\n");
            }
        }
        System.out.println(sb);
    }

    static int find(int x) {
        if (parent[x] == x) return x;
        return find(parent[x]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) parent[b] = a;
    }
}
