package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b6603 {
    static int N = 6;
    static int K;
    static int[] arr;
    static int[] temp = new int[N];

    static void recur(int cur, int start) {
        if (cur == N) {
            for (int i = 0; i < N; i++) {
                System.out.print(temp[i] + " ");
            }
            System.out.println();
            return;
        }
        for (int i = start; i < K; i++) {
            temp[cur] = arr[i];
            recur(cur + 1, i + 1);
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());
            K = Integer.parseInt(st.nextToken());
            if (K == 0)
                break;
            arr = new int[K];
            for (int i = 0; i < K; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            recur(0, 0);

            System.out.println();
        }
    }
}