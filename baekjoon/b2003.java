package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b2003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        int start = 0;
        int end = 0;
        int sum = 0;
        int cnt = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        while (true) {
            for (int i = start; i < end; i++) {
                sum += arr[i];
            }
            if (sum == M) {
                cnt++;
                start++;
            } else {
                if (sum > M)
                    start++;
                else
                    end++;
                if (end == N + 1)
                    break;
            }
            sum = 0;
        }
        System.out.println(cnt);
    }
}
