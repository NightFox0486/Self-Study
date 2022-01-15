package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class b18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        int arr[] = new int[N];
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        ArrayList<Integer> al = new ArrayList<Integer>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            al.add(arr[i]);
        }
        Collections.sort(al);

        for (int i = 0; i < N; i++) {
            if (!hm.containsKey(al.get(i))) {
                hm.put(al.get(i), cnt++);
            }
        }

        for (int i = 0; i < N; i++) {
            sb.append(hm.get(arr[i])).append(" ");
        }

        System.out.println(sb);
    }
}