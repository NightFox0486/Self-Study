package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class b18310 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int min = Integer.MAX_VALUE;
        int index = 0;
        int N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<Integer>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(list);
        int s = list.get(0);
        int e = list.get(N - 1);
        int d = (s + e) / 2;
        for (int i = 0; i < N; i++) {
            int temp = Math.abs(list.get(i) - d);
            if (min > temp) {
                min = temp;
                index = list.get(i);
            }
        }
        System.out.println(index);
    }
}
