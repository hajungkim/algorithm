package level1;

import java.util.*;
import java.util.Map.Entry;
public class Solution_92334 {
    class Solution {
        public int[] solution(String[] id_list, String[] report, int k) {
            HashMap<String, Integer> deCnt = new HashMap<>();
            HashMap<String, String> deStr = new HashMap<>();
            HashMap<String, Integer> mailCnt = new HashMap<>();

            for (String str : report) {
                String[] repo = str.split(" ");
                if (deStr.get(repo[0]) == null) {
                    deStr.put(repo[0], repo[1] + " ");
                } else {
                    if (deStr.get(repo[0]).contains(repo[1])) continue;
                    deStr.put(repo[0], deStr.get(repo[0]) + repo[1] + " ");
                }
                if (deCnt.get(repo[1]) == null) deCnt.put(repo[1], 1);
                else deCnt.put(repo[1], deCnt.get(repo[1]) + 1);
            }
            for (Entry<String, Integer> entry : deCnt.entrySet()) {
                if (entry.getValue() < k) continue;
                for (Entry<String, String> entry2 : deStr.entrySet()) {
                    if (entry2.getValue().contains(entry.getKey())) {
                        if (mailCnt.get(entry2.getKey()) == null) mailCnt.put(entry2.getKey(), 1);
                        else mailCnt.put(entry2.getKey(), mailCnt.get(entry2.getKey()) + 1);
                    }
                }
            }

            int[] answer = new int[id_list.length];
            for (int i = 0; i < id_list.length; i++) {
                if (mailCnt.get(id_list[i]) == null) continue;
                answer[i] = mailCnt.get(id_list[i]);
            }
            return answer;
        }
    }
}
