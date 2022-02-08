package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b14465 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = 1;
        }
        for (int i = 0; i < B; i++) {
            arr[Integer.parseInt(br.readLine()) - 1] = 0;
        }
        int s = 0;
        int e = K - 1;
        int sum = 0;
        for (int i = 0; i < K; i++) {
            sum += arr[i];
        }
        int max = sum;
        while (e < N - 1) {
            sum -= arr[s++];
            sum += arr[++e];
            if (sum > max) {
                max = sum;
            }
        }
        System.out.println(K - max);
    }
}
