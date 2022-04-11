package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class b1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack stack = new Stack();
        boolean check = false;
        StringBuilder sb = new StringBuilder();
        int cnt = 1;
        try {
            for (int i = 0; i < N; i++) {
                int temp = Integer.parseInt(br.readLine());

                if (stack.isEmpty()) {
                    stack.push(cnt++);
                    sb.append("+\n");
                }
                if ((int) stack.peek() < temp) {
                    while ((int) stack.peek() < temp) {
                        stack.push(cnt++);
                        sb.append("+\n");
                    }
                } else if ((int) stack.peek() > temp) {
                    while ((int) stack.peek() > temp) {
                        stack.pop();
                        sb.append("-\n");
                    }
                }
                stack.pop();
                sb.append("-\n");

            }
        } catch (Exception e) {
            sb.delete(0, sb.length());
            sb.append("NO");
            check = true;
        }
        if (check)
            System.out.println(sb);
        else {
            sb.delete(sb.length() - 1, sb.length());
            System.out.println(sb);
        }
    }
}
