package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        long[] arr = new long[N];
        long max = 0;
        long cnt = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }
        long start = 1;
        long end = max;
        while (start <= end) {
            cnt = 0;
            long x = (start + end) / 2;
            for (int i = 0; i < N; i++) {
                cnt += arr[i] / x;
            }
            if (cnt < K) {
                end = x - 1;
            } else {
                start = x + 1;
            }
        }
        System.out.println(end);
    }
}

// 전체 랜선 더해서 K로 나눈뒤 랜선 길이값을 1씩 줄여가며 각 랜선 나머지만큼 더했을때 K개가 나오는지 계산