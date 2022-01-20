package level3;

import java.util.*;
public class Solution_81303 {
    class Solution {
        public String solution(int n, int k, String[] cmd) {
            Node[] arr = new Node[n];
            for (int i = 0; i < n; i++) {
                arr[i] = new Node();
            }
            for (int i = 1; i < n; i++) {
                arr[i].prev = arr[i-1];
                arr[i-1].next = arr[i];
            }

            Stack<Node> stack = new Stack<>();
            Node curr = arr[k];
            for (String str : cmd) {
                char command = str.charAt(0);
                if (command == 'U') {
                    int X = Integer.parseInt(str.substring(2));
                    for (int i = 0; i < X; i++) {
                        curr = curr.prev;
                    }
                } else if (command == 'D') {
                    int X = Integer.parseInt(str.substring(2));
                    for (int i = 0; i < X; i++) {
                        curr = curr.next;
                    }
                } else if (command == 'C') {
                    curr.isRemoved = true;
                    stack.push(curr);
                    if (curr.prev != null) {
                        curr.prev.next = curr.next;
                    }
                    if (curr.next != null) {
                        curr.next.prev = curr.prev;
                        curr = curr.next;
                    } else {
                        curr = curr.prev;
                        curr.next = null;
                    }
                } else {
                    Node stackNode = stack.pop();
                    if (stackNode.prev != null) {
                        stackNode.prev.next = stackNode;
                    }
                    if (stackNode.next != null) {
                        stackNode.next.prev = stackNode;
                    }
                    stackNode.isRemoved = false;
                }
            }

            StringBuilder sb = new StringBuilder();
            for (Node node : arr) {
                if (node.isRemoved) sb.append("X");
                else sb.append("O");
            }

            return sb.toString();
        }

        class Node {
            boolean isRemoved;
            Node prev;
            Node next;
        }
    }
}
