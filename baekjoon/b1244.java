package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b1244 {
    static int N;
    static int S;
    static boolean[] switches;

    static void solve(int mode, int num) {
        if (mode == 1) {
            int i = 2;
            int temp = num;
            while (N >= num) {
                switches[num] = !switches[num];
                num = temp * i++;
            }
        } else {
            int left = num;
            int right = num;
            while (left > 0 && right <= N) {
                if (left == num) {
                    switches[num] = !switches[num];
                    left--;
                    right++;
                } else {
                    if (switches[left] == switches[right]) {
                        switches[left] = !switches[left];
                        switches[right] = !switches[right];
                        left--;
                        right++;
                    } else
                        break;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        switches = new boolean[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            if (Integer.parseInt(st.nextToken()) == 1)
                switches[i] = true;
        }

        S = Integer.parseInt(br.readLine());
        for (int i = 0; i < S; i++) {
            st = new StringTokenizer(br.readLine());
            solve(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        for (int i = 1; i <= N; i++) {
            if (i % 20 == 1 && i != 1)
                System.out.println();
            if (switches[i] == true)
                System.out.print(1 + " ");
            else
                System.out.print(0 + " ");
        }
    }
}