/*
다음 순열
https://www.acmicpc.net/problem/10972
 */
package bruteforce;
import java.util.*;
import java.io.*;
public class Main_10972 {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        boolean last = true;
        for (int i = N-1; i > 0; i--) {
            if (arr[i] > arr[i-1]) {
                for (int j = N-1; j > i-1; j--) {
                    if (arr[j] > arr[i - 1]) {
                        swap(j, i - 1);
                        break;
                    }
                }
                while (true) {
                    boolean tf = true;
                    for (int j = i; j < N - 1; j++) {
                        if (arr[j] > arr[j + 1]) {
                            swap(j, j + 1);
                            tf = false;
                        }
                    }
                    if (tf) break;
                }
                last = false;
                break;
            }
        }
        if (last) {
            System.out.println(-1);
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i : arr) {
                sb.append(i + " ");
            }
            System.out.println(sb);
        }
    }

    static void swap(int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}
