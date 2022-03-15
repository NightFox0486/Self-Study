package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b14453 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int MAX = Integer.MIN_VALUE;
        int N = Integer.parseInt(br.readLine());
        char[] input = new char[N];
        int[] P = new int[N];
        int[] H = new int[N];
        int[] S = new int[N];
        for (int i = 0; i < N; i++) {
            input[i] = br.readLine().toCharArray()[0];
            if (i == 0) {
                if (input[i] == 'P') {
                    S[i] = 1;
                    P[i] = 0;
                    H[i] = 0;
                } else if (input[i] == 'H') {
                    P[i] = 1;
                    S[i] = 0;
                    H[i] = 0;
                } else if (input[i] == 'S') {
                    H[i] = 1;
                    P[i] = 0;
                    S[i] = 0;
                }
            } else {
                if (input[i] == 'P') {
                    S[i] = S[i - 1] + 1;
                    P[i] = P[i - 1];
                    H[i] = H[i - 1];
                } else if (input[i] == 'H') {
                    P[i] = P[i - 1] + 1;
                    S[i] = S[i - 1];
                    H[i] = H[i - 1];
                } else if (input[i] == 'S') {
                    H[i] = H[i - 1] + 1;
                    P[i] = P[i - 1];
                    S[i] = S[i - 1];
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum = P[i] + (H[N - 1] - H[i]);
            MAX = Math.max(sum, MAX);
            sum = P[i] + (S[N - 1] - S[i]);
            MAX = Math.max(sum, MAX);
            sum = S[i] + (P[N - 1] - P[i]);
            MAX = Math.max(sum, MAX);
            sum = S[i] + (H[N - 1] - H[i]);
            MAX = Math.max(sum, MAX);
            sum = H[i] + (P[N - 1] - P[i]);
            MAX = Math.max(sum, MAX);
            sum = H[i] + (S[N - 1] - S[i]);
            MAX = Math.max(sum, MAX);
        }
        MAX = Math.max(MAX, P[N - 1]);
        MAX = Math.max(MAX, S[N - 1]);
        MAX = Math.max(MAX, H[N - 1]);

        System.out.println(MAX);
    }
}
