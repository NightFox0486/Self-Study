package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class b2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] input = new int[N + 1];
        int[] output = new int[N + 1];
        Stack<Integer> stack = new Stack<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = N; i > 0; i--) {
            if (input[i] < input[i - 1])
                output[i] = i - 1;
            else
                stack.push(i);
            while (!stack.isEmpty() && input[stack.peek()] < input[i - 1]) {
                output[stack.pop()] = i - 1;
            }

        }
        for (int i = 1; i <= N; i++) {
            sb.append(output[i] + " ");
        }
        System.out.println(sb);
    }
}