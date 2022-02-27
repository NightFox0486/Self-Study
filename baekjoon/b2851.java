package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b2851 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        int ans = 0;
        boolean check = false;
        int[] num = new int[10];
        for (int i = 0; i < 10; i++) {
            num[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 0; i < 10; i++) {
            sum += num[i];
            if (sum >= 100) {
                if (Math.abs(sum - 100) <= Math.abs(100 - (sum - num[i]))) {
                    ans = sum;
                    check = true;
                    break;
                } else {
                    ans = sum - num[i];
                    check = true;
                    break;
                }
            }
        }
        if (!check)
            ans = sum;
        System.out.println(ans);
    }
}
