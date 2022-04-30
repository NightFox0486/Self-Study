package codeforces.round784;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProblemD {
    static char[] arr;

    static boolean checker(int n) {
        if (arr[n - 1] == arr[n] && arr[n] == arr[n + 1]) {
            if (arr[n] != 'W')
                return false;
        }
        if (arr[n - 1] == 'W' && arr[n + 1] == 'W') {
            if (arr[n] != 'W')
                return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());
            String temp = br.readLine();
            arr = new char[n];
            boolean check = true;
            for (int j = 0; j < n; j++) {
                arr[j] = temp.charAt(j);
            }
            if (n >= 3) {
                for (int j = 1; j < n - 1; j++) {
                    if (!checker(j)) {
                        check = false;
                        break;
                    }
                }
            } else {
                if (n == 2) {
                    if (arr[0] == arr[1])
                        check = false;
                    else {
                        if (arr[0] == 'W' || arr[1] == 'W')
                            check = false;
                    }
                } else
                    check = false;
            }
            if (check) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
