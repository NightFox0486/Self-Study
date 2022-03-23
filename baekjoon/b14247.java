package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class b14247 {
    static int n;
    static long[][] input;
    static long max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
        n = Integer.parseInt(br.readLine());
        input = new long[n][2];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            input[i][0] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            input[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(input, (o1, o2) -> Long.compare(o1[1], o2[1]));
        for (int i = 0; i < n; i++) {
            max += input[i][0] + input[i][1] * i;
        }

        System.out.println(max);
    }
}
