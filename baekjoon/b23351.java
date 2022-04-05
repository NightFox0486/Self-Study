package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b23351 {
    static int N;
    static int K;
    static int A;
    static int B;
    static int[] arr;

    static boolean check() {
        for (int i = 0; i < N; i++) {
            arr[i]--;
            if (arr[i] == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        arr = new int[N];
        int cnt = 0;
        Arrays.fill(arr, K + 1);
        while (check()) {
            int s = 0;
            int e = A - 1;
            int start = s;
            int sum = 0;
            int min;
            for (int i = s; i < A; i++)
                sum += arr[i];
            min = sum;
            while (true) {
                sum -= arr[s++];
                sum += arr[++e];
                if (min > sum) {
                    min = sum;
                    start = s;
                }
                if (e == N - 1)
                    break;

            }
            cnt++;
            for (int i = start; i < start + A; i++) {
                arr[i] += B;
            }
        }
        System.out.println(cnt);
    }
}