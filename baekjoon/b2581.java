package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class b2581 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int M = Integer.parseInt(bf.readLine());
        int N = Integer.parseInt(bf.readLine());
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for (int i = M; i <= N; i++) {
            if (isPrime(i)) {
                arr.add(i);
            }
        }
        if (arr.isEmpty()) {
            bw.write("-1");
        } else {
            int sum = 0;
            for (int i = 0; i < arr.size(); i++) {
                sum += arr.get(i);
            }
            bw.write(Integer.toString(sum) + "\n");
            bw.write(Integer.toString(arr.get(0)));
        }
        bw.flush();
        bw.close();
    }

    static boolean isPrime(int num) {
        if (num == 1)
            return false;
        int temp = 2;
        while (temp <= (int) Math.sqrt(num)) {
            if (temp == num) {
                return true;
            } else {
                if (num % temp == 0) {
                    return false;
                }
            }
            temp++;
        }
        return true;
    }
}
