package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b1644 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int sum = 2; // 소수의 첫번째 값
        int s = 0;
        int e = 0;
        int cnt = 0;
        int prime_cnt = 0;
        boolean[] arr = new boolean[N + 1];
        if (N == 1) {
            System.out.println(0);
            System.exit(0);
        }
        for (int i = 2; i < N + 1; i++) {
            if (arr[i] == false) {
                for (int j = i + 1; j < N + 1; j++) {
                    if (arr[j] == true)
                        continue;
                    if (j % i == 0) {
                        arr[j] = true;
                        prime_cnt++;
                    }
                }
            }
        }
        prime_cnt = N + 1 - prime_cnt;
        int[] primenum = new int[prime_cnt];
        prime_cnt = 0;
        for (int i = 2; i < N + 1; i++) {
            if (arr[i] == false) {
                primenum[prime_cnt] = i;
                prime_cnt++;
            }
        }
        while (e < N) {
            if (sum == N) {
                cnt++;
                if (e == prime_cnt - 1)
                    break;
                sum += primenum[++e];
            } else if (sum > N) {
                sum -= primenum[s++];
            } else {
                if (e == prime_cnt - 1)
                    break;
                sum += primenum[++e];
            }
        }
        // for (int i = 0; i < N + 1; i++) {
        // System.out.println(arr[i] + ":" + i + "--" + prime_cnt);
        // }
        System.out.println(cnt);
    }
}
