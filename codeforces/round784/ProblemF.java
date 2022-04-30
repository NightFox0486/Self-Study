package codeforces.round784;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ProblemF {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] input = new int[n];
            int[] alice = new int[n];
            int[] bob = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                input[j] = Integer.parseInt(st.nextToken());
            }
            alice[0] = input[0];
            bob[n - 1] = input[n - 1];
            for (int j = 1; j < n; j++) {
                alice[j] = alice[j - 1] + input[j];
                bob[n - 1 - j] = bob[n - j] + input[n - 1 - j];
            }
            int a = 0;
            int b = n - 1;
            int cnt = 0;
            while (a < b) {
                if (alice[a] == bob[b]) {
                    cnt = a + n - b + 1;
                    a++;
                } else if (alice[a] < bob[b]) {
                    a++;
                } else {
                    b--;
                }
            }
            System.out.println(cnt);
        }
    }
}
