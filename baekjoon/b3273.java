package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b3273 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());

        int start = 0;
        int end = n - 1;
        int cnt = 0;
        Arrays.sort(arr);
        while (start < end) {
            if (arr[start] + arr[end] == x) {
                cnt++;
                start++;
                end--;
            } else if (arr[start] + arr[end] > x) {
                end--;
            } else {
                start++;
            }
        }
        System.out.println(cnt);
    }
}
