package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

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
                for (int j = 2 * i; j < N + 1; j += i) {
                    arr[j] = true;
                }
            }
        }
        List<Integer> primenum = new ArrayList<>();
        for (int i = 2; i < N + 1; i++) {
            if (arr[i] == false) {
                primenum.add(i);
            }
        }
        prime_cnt = primenum.size();
        while (e < N) {
            if (sum == N) {
                cnt++;
                if (e == prime_cnt - 1)
                    break;
                sum += primenum.get(++e);
            } else if (sum > N) {
                sum -= primenum.get(s++);
            } else {
                if (e == prime_cnt - 1)
                    break;
                sum += primenum.get(++e);
            }
        }
        System.out.println(cnt);
    }
}
