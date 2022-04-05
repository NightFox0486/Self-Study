package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class b2531 {
    static int N;
    static int d;
    static int k;
    static int c;
    static int s;
    static int e;
    static int[] arr;
    static int max;
    static Map<Integer, Integer> map = new TreeMap<>();
    static List<Integer> startPoint = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new int[N];
        s = 0;
        e = k - 1;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if (i < k) {
                if (!map.containsKey(arr[i])) {
                    map.put(arr[i], 1);
                } else {
                    map.replace(arr[i], map.get(arr[i]) + 1);
                }
            }
        }
        max = map.size();
        for (int i = 1; i < N; i++) {
            if (map.get(arr[s]) != 1)
                map.replace(arr[s], map.get(arr[s]) - 1);
            else
                map.remove(arr[s]);
            s = (s + 1) % N;
            e = (e + 1) % N;
            if (map.containsKey(arr[e]))
                map.replace(arr[e], map.get(arr[e]) + 1);
            else
                map.put(arr[e], 1);
            if (!map.containsKey(c))
                max = Math.max(max, map.size() + 1);
            else
                max = Math.max(max, map.size());
        }
        System.out.println(max);
    }
}
