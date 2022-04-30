package codeforces.round784;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProblemE {
    static int n;
    static int cnt;
    static int[] arr = new int[2];
    static boolean[] check;
    static String[] str;

    static void recur(int cur, int start) {
        if (cur == 2) {
            String A = str[arr[0]];
            String B = str[arr[1]];
            if (A.charAt(0) == B.charAt(0)) {
                if (A.charAt(1) != B.charAt(1)) {
                    cnt++;
                }
            }
            if (A.charAt(1) == B.charAt(1)) {
                if (A.charAt(0) != B.charAt(0)) {
                    cnt++;
                }
            }
            // System.out.println(arr[0] + "," + arr[1]);
            return;
        }
        for (int i = start; i < n; i++) {
            if (check[i])
                continue;
            check[i] = true;
            arr[cur] = i;
            recur(cur + 1, i + 1);
            check[i] = false;
        }
    }

    static void solve() {
        for (int i = 0; i < n - 1; i++) {
            for (int j = i; j < n; j++) {
                if (str[i].charAt(0) == str[j].charAt(0)) {
                    if (str[i].charAt(1) != str[j].charAt(1)) {
                        cnt++;
                    }
                }
                if (str[i].charAt(1) == str[j].charAt(1)) {
                    if (str[i].charAt(0) != str[j].charAt(0)) {
                        cnt++;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            n = Integer.parseInt(br.readLine());
            str = new String[n];
            check = new boolean[n];
            cnt = 0;
            for (int j = 0; j < n; j++) {
                str[j] = br.readLine();
            }
            // recur(0, 0);
            solve();
            System.out.println(cnt);
        }
    }
}
