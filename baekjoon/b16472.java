package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b16472 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max = Integer.MIN_VALUE;
        int N = Integer.parseInt(br.readLine());
        int[] check = new int['z' - 'a' + 1];
        int checkSize = 0;
        char[] chArr = br.readLine().toCharArray();
        int s = 0;
        int e = 0;
        int inputSize = chArr.length;
        int currentlength = 0;
        while (e < inputSize) {
            if (0 == check[chArr[e] - 'a']) {
                checkSize++;
            }
            check[chArr[e] - 'a']++;
            while (checkSize > N) {
                if (1 == check[chArr[s] - 'a']) {
                    checkSize--;
                }
                check[chArr[s++] - 'a']--;
                // while (0 == check[chArr[s] - 'a'])
                // s++;
            }
            currentlength = e - s + 1;
            max = Math.max(max, currentlength);
            e++;
        }
        System.out.println(max);
    }
}
