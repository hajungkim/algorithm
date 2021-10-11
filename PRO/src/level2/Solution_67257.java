package level2;

import java.util.*;

public class Solution_67257 {
    static ArrayList<String> list;
    static long answer;
    static String[] op, order;
    static boolean[] visit;

    public static void main(String[] args) {
        String expression = "100-200*300-500+20";
        list = new ArrayList<>();
        String str = "";
        for (char c : expression.toCharArray()) {
            if (c == '+' || c == '-' || c == '*') {
                list.add(str);
                list.add(c + "");
                str = "";
            } else {
                str += c;
            }
        }
        list.add(str);

        op = new String[3];
        op[0] = "+"; op[1] = "-"; op[2] = "*";
        order = new String[3];
        visit = new boolean[3];
        answer = 0;
        comb(0, expression);
        System.out.println(answer);
    }

    static void comb(int cnt, String ex) {
        if (cnt == 3) {
            answer = Math.max(answer, Math.abs(calc(ex)));
            return;
        }

        for (int i = 0; i < 3; i++) {
            if (visit[i]) continue;
            visit[i] = true;
            order[cnt] = op[i];
            comb(cnt + 1, ex);
            visit[i] = false;
        }
    }

    static long calc(String ex) {
        ArrayList<String> temp = new ArrayList<>();
        Deque<String> dq = new ArrayDeque<>();
        for (String s : list) {
            temp.add(s);
        }
        for (String s : order) {
            System.out.println(s + "=========");
            for (int i = 0; i < temp.size(); i++) {
                String tem = temp.get(i);
                if (tem.equals(s)) {
                    Long op1 = Long.parseLong(dq.pollLast());
                    Long op2 = Long.parseLong(temp.get(i+1));
                    Long sum = 0L;
                    if (s.equals("+")) {
                        sum = op1 + op2;
                    } else if (s.equals("-")) {
                        sum = op1 - op2;
                    } else {
                        sum = op1 * op2;
                    }
                    dq.add(String.valueOf(sum));
                    i++;
                } else {
                    dq.add(tem);
                }
                System.out.println(dq.toString());
            }
            temp = new ArrayList<>();
            for (String dqStr : dq) {
                temp.add(dqStr);
            }
            dq = new ArrayDeque<>();
        }
        Long result = Long.parseLong(temp.get(0));
        return result;
    }
}
