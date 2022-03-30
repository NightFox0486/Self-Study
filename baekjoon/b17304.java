package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class b17304 {
    static int N;
    static int M;
    static List[] input;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Set<Integer> set = new TreeSet<>();
        Map<Integer, Integer> submap = new TreeMap<>();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        input = new List[N + 1];
        for (int i = 1; i < N + 1; i++) {
            input[i] = new ArrayList<Integer>();
        }
        int totalcnt = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            input[from].add(to);
            set.add(to);
            if (input[to].contains(from)) {
                set.remove(from);
                set.remove(to);
                submap.put(from, to);
                submap.put(to, from);
            }
        }
        totalcnt += set.size();
        while (set.size() != N) {
            if (submap.isEmpty()) {
                break;
            }
            for (Integer integer : submap.keySet()) {
                if (!set.contains(integer)) {
                    totalcnt++;
                    submap.remove(submap.get(integer));
                    submap.remove(integer);
                    break;
                }
            }
        }
        if (totalcnt == N)
            System.out.println("YES");
        else
            System.out.println("NO");
    }
}
