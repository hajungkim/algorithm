package level3;

import java.util.*;
public class Solution_64064 {
    class Solution {
        Set<Set<String>> set;
        public int solution(String[] user_id, String[] banned_id) {
            set = new HashSet<>();
            comb(user_id, banned_id, new LinkedHashSet<>());
            return set.size();
        }

        void comb(String[] user_id, String[] banned_id, Set<String> list) {
            if (list.size() == banned_id.length) {
                if (check(banned_id, list)) {
                    // System.out.println(list.toString());
                    set.add(new HashSet<>(list));
                }
                return;
            }
            for (String id : user_id) {
                if(list.contains(id)) continue;
                list.add(id);
                comb(user_id, banned_id, list);
                list.remove(id);
            }
        }

        boolean check(String[] banned_id, Set<String> list) {
            int idx = 0;
            for (String item : list) {
                if (item.length() != banned_id[idx].length()) return false;
                for (int i = 0; i < item.length(); i++) {
                    char itemChar = item.charAt(i), banChar = banned_id[idx].charAt(i);
                    if (banChar == '*') continue;
                    if (itemChar != banChar) return false;
                }
                idx++;
            }
            return true;
        }
    }
}
