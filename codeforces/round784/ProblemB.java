package codeforces.round784;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ProblemB {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n + 1];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[Integer.parseInt(st.nextToken())]++;
            }
            int ans = -1;
            for (int j = 0; j <= n; j++) {
                if (arr[j] >= 3) {
                    ans = j;
                }
            }
            System.out.println(ans);
        }
    }
}
