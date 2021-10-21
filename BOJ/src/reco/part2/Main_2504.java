package reco.part2;
/*
스택의 응용
괄호의 값
https://www.acmicpc.net/problem/2504
 */
import java.util.*;
import java.util.regex.*;
import java.io.*;
public class Main_2504 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char arr[] = br.readLine().toCharArray();
        Stack<String> stack = new Stack<>();
        boolean wrong = false;
        for (int i = 0; i < arr.length; i++) {
            String token = String.valueOf(arr[i]);
            if (stack.isEmpty()) {
                if (token.equals(")") || token.equals("]")) {
                    wrong = true;
                    break;
                }
                stack.push(token);
            } else {
                if (token.equals("(") || token.equals("[")) {
                    stack.push(token);
                } else {
                    String element = stack.pop();
                    if (token.equals(")")) {
                        if (element.equals("(")) {
                            if (!stack.isEmpty() && Pattern.matches("[0-9]+", stack.peek())) {
                                int calc = 2 + Integer.parseInt(stack.pop());
                                stack.push(String.valueOf(calc));
                            } else {
                                stack.push("2");
                            }
                        } else if (!stack.isEmpty() && Pattern.matches("[0-9]+", element) && stack.peek().equals("(")) {
                            stack.pop();
                            int calc = 2 * Integer.parseInt(element);
                            if (!stack.isEmpty() && Pattern.matches("[0-9]+", stack.peek())) {
                                int calc2 = calc + Integer.parseInt(stack.pop());
                                stack.push(String.valueOf(calc2));
                            } else {
                                stack.push(String.valueOf(calc));
                            }
                        } else {
                            wrong = true;
                            break;
                        }
                    } else {
                        if (element.equals("[")) {
                            if (!stack.isEmpty() && Pattern.matches("[0-9]+", stack.peek())) {
                                int calc = 3 + Integer.parseInt(stack.pop());
                                stack.push(String.valueOf(calc));
                            } else {
                                stack.push("3");
                            }
                        } else if (!stack.isEmpty() && Pattern.matches("[0-9]+", element) && stack.peek().equals("[")) {
                            stack.pop();
                            int calc = 3 * Integer.parseInt(element);
                            if (!stack.isEmpty() && Pattern.matches("[0-9]+", stack.peek())) {
                                int calc2 = calc + Integer.parseInt(stack.pop());
                                stack.push(String.valueOf(calc2));
                            } else {
                                stack.push(String.valueOf(calc));
                            }
                        } else {
                            wrong = true;
                            break;
                        }
                    }
                }
            }
        }
        if (wrong || stack.isEmpty() || stack.size() > 1) System.out.println(0);
        else if (!Pattern.matches("[0-9]+", stack.peek())) System.out.println(0);
        else System.out.println(stack.pop());
    }
}
