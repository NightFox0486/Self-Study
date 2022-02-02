package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class b2309 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[9];
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }
        int comp = sum - 100;
        Arrays.sort(arr);
        int s = 0;
        int e = 8;
        int first = 0;
        int second = 0;
        while (s < e) {
            if (arr[s] + arr[e] == comp) {
                first = s;
                second = e;
                s++;
                e--;
            } else if (arr[s] + arr[e] > comp) {
                e--;
            } else {
                s++;
            }
        }
        for (int i = 0; i < 9; i++) {
            if (i == first || i == second)
                continue;
            sb.append(arr[i] + "\n");
        }
        System.out.println(sb);
    }
}
