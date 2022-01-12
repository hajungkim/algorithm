package level2;
/*
캐시
https://programmers.co.kr/learn/courses/30/lessons/17680
 */
import java.util.*;
public class Solution_17680 {
    class Solution {
        public int solution(int cacheSize, String[] cities) {
            if (cacheSize == 0) return cities.length * 5;
            int answer = 0;
            ArrayList<String> list = new ArrayList<>();
            for (String city : cities) {
                city = city.toLowerCase();
                if(list.contains(city)) {
                    answer += 1;
                    list.remove(city);
                    list.add(city);
                } else {
                    answer += 5;
                    if (list.size() >= cacheSize) list.remove(0);
                    list.add(city);
                }
            }

            return answer;
        }
    }
}
