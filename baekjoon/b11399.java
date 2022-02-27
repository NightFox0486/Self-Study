package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b11399 {
    static int N;
    static int[] arr;
    static int[] input;
    static boolean[] check;
    static int min = Integer.MAX_VALUE;

    static void recur(int cur) {
        if (cur == N) {
            int sum = 0;
            for (int i = 0; i < N; i++) {
                sum += input[arr[i]] * (N - i);
            }
            min = Math.min(min, sum);
            return;
        }
        for (int i = 0; i < N; i++) {
            if (check[i])
                continue;
            check[i] = true;
            arr[cur] = i;
            recur(cur + 1);
            check[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        input = new int[N];
        arr = new int[N];
        check = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(input);
        // recur(0);
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += input[i] * (N - i);
        }
        System.out.println(sum);
    }
}
