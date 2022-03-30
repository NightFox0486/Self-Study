package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b2503 {
    static int[] sub = new int[3];
    static boolean[] check = new boolean[10];
    static Queue<String> queue = new LinkedList<>();

    static void recur(int cur) {
        if (cur == 3) {
            StringBuilder sb = new StringBuilder();
            sb.append(sub[0]).append(sub[1]).append(sub[2]);
            queue.add(sb.toString());
            return;
        }
        for (int i = 1; i < 10; i++) {
            if (check[i])
                continue;
            sub[cur] = i;
            check[i] = true;
            recur(cur + 1);
            check[i] = false;
        }
    }

    static void check(String temp, int strike, int ball) {
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            int strike_cnt = 0;
            int ball_cnt = 0;
            String current = queue.poll();
            if (current.charAt(0) == temp.charAt(0)) {
                strike_cnt++;
            }
            if (current.charAt(1) == temp.charAt(1)) {
                strike_cnt++;
            }
            if (current.charAt(2) == temp.charAt(2)) {
                strike_cnt++;
            }
            if (current.charAt(0) == temp.charAt(1)) {
                ball_cnt++;
            }
            if (current.charAt(0) == temp.charAt(2)) {
                ball_cnt++;
            }
            if (current.charAt(1) == temp.charAt(0)) {
                ball_cnt++;
            }
            if (current.charAt(1) == temp.charAt(2)) {
                ball_cnt++;
            }
            if (current.charAt(2) == temp.charAt(0)) {
                ball_cnt++;
            }
            if (current.charAt(2) == temp.charAt(1)) {
                ball_cnt++;
            }
            if (strike_cnt == strike && ball_cnt == ball) {
                queue.add(current);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        recur(0);
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String temp = st.nextToken();
            int strike = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());
            check(temp, strike, ball);
        }
        System.out.println(queue.size());
    }
}
