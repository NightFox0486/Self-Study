package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b2529 {

    static boolean[] check;
    static int N;
    static long max;
    static String max_str;
    static String min_str;
    static long min;
    static int[] arr;
    static char[] input;

    static void recur(int cur) {
        if (cur == N + 1) {
            for (int i = 0; i < N; i++) {
                if (input[i] == '<') {
                    if (!(arr[i] < arr[i + 1]))
                        return;
                } else if (input[i] == '>') {
                    if (!(arr[i] > arr[i + 1]))
                        return;
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i <= N; i++) {
                char temp = (char) (arr[i] + '0');
                sb.append(temp);
            }
            long tempInt = Long.parseLong(sb.toString());
            if (max < tempInt) {
                max = tempInt;
                max_str = sb.toString();
            }
            if (min > tempInt) {
                min = tempInt;
                min_str = sb.toString();
            }

            return;
        }
        for (int i = 0; i < 10; i++) {
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
        check = new boolean[10];
        N = Integer.parseInt(br.readLine());
        max = Long.MIN_VALUE;
        min = Long.MAX_VALUE;
        arr = new int[N + 1];
        input = new char[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            input[i] = st.nextToken().charAt(0);
        }
        recur(0);

        System.out.println(max_str);
        System.out.println(min_str);
    }
}
