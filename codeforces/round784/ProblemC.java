package codeforces.round784;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ProblemC {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] arr = new int[n];
            boolean check = true;
            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            if (n >= 3) {
                for (int j = 0; j < n - 2; j++) {
                    if (arr[j] != arr[j + 2]) {
                        check = false;
                        break;
                    }
                }
            }
            if (check) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
