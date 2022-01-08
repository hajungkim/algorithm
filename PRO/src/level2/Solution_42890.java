package level2;
/*
후보키
https://programmers.co.kr/learn/courses/30/lessons/42890
 */
import java.util.*;
public class Solution_42890 {
    int len;
    boolean[] visit;
    List<String> list;

    public int solution(String[][] relation) {
        len = relation[0].length;
        list = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            visit = new boolean[len];
            comb(0, 0, i+1, relation);
        }

        return list.size();
    }

    // 후보키 모든 경우의 수 고르기
    void comb(int depth, int start, int end, String[][] relation) {
        if (depth == end) {
            check(relation);
            return;
        }
        for (int i = start; i < len; i++) {
            visit[i] = true;
            comb(depth + 1, i + 1, end, relation);
            visit[i] = false;
        }
    }

    void check(String[][] relation) {
        // 속성을 0, 1, 2... 로 보고 조합으로 선택한 속성은 문자열에 붙이기
        String col = "";
        for (int i = 0; i < len; i++) {
            if (visit[i]) col += i;
        }
        // 기존 후보키가 col의 부분집합이라면 최소성을 만족하지 않기 때문에 검사
        for (String s : list) {
            int cnt = 0;
            for (int i = 0; i < col.length(); i++) {
                if (s.contains(String.valueOf(col.charAt(i)))) cnt++;
            }
            if (s.length() == cnt) return;
        }
        // 튜플에 중복된 값이 있는지 봐서 유일성을 만족하는지 검사
        Set<String> set = new HashSet<>();
        for (int i = 0; i < relation.length; i++) {
            String str = "";
            for (int j = 0; j < relation[0].length; j++) {
                if (visit[j]) str += relation[i][j];
            }
            if (set.contains(str)) return;
            else set.add(str);
        }
        list.add(col);
    }
}