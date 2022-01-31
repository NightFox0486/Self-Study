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
        int[] arr = new int[N];
        int sum = 0;
        int ans = 0;
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }
        ans = sum / N;
        for (int i = ans; true; i--) {
            cnt = 0;
            for (int j = 0; j < N; j++) {
                cnt += arr[j] / i;
            }
            if (cnt < K)
                continue;
            else {
                ans = i;
                break;
            }
        }
        System.out.println(ans);
    }
}

// 전체 랜선 더해서 K로 나눈뒤 랜선 길이값을 1씩 줄여가며 각 랜선 나머지만큼 더했을때 K개가 나오는지 계산