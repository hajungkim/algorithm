package reco.part1;
/*

 */
import java.util.*;
import java.io.*;
public class Main_3460 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            String binary = "";
            int N = Integer.parseInt(br.readLine());
            binary = Integer.toBinaryString(N);
            StringBuilder sb = new StringBuilder();
            for (int i = binary.length()-1; i >= 0; i--) {
                char c = binary.charAt(i);
                if (c == '1') sb.append(binary.length()-1-i + " ");
            }
            System.out.println(sb);
        }
    }
}
