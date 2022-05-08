package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class b5397 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            Stack<Character> stack = new Stack<>();
            Stack<Character> save_stack = new Stack<>();
            for (int j = 0; j < temp.length(); j++) {
                if (temp.charAt(j) == '<') {
                    if (!stack.isEmpty())
                        save_stack.add(stack.pop());
                } else if (temp.charAt(j) == '>') {
                    if (!save_stack.isEmpty())
                        stack.add(save_stack.pop());
                } else if (temp.charAt(j) == '-') {
                    if (!stack.isEmpty())
                        stack.pop();
                } else {
                    stack.add(temp.charAt(j));
                }
            }
            while (!stack.isEmpty()) {
                save_stack.add(stack.pop());
            }
            while (!save_stack.isEmpty()) {
                bw.write(save_stack.pop());
            }
            bw.write("\n");
        }
        bw.flush();
    }
}
