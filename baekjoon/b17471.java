package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class b17471 {
    static int N;
    static List[] list;
    static int[] population;
    static boolean[] check;
    static boolean[] linkcheck;
    static int min = Integer.MAX_VALUE;
    static int[] arr;

    static void recur(int cur, int length) {
        if (cur == length) {
            int sum1 = 0;
            int[] result;
            linkcheck = new boolean[N + 1];
            for (int i = 0; i < length; i++) {
                linkcheck[arr[i]] = true;
            }
            result = linkedCheck();
            if (result[0] == 1) {
                sum1 = result[1];
                linkcheck = new boolean[N + 1];
                Arrays.fill(linkcheck, true);
                for (int i = 0; i < length; i++) {
                    linkcheck[arr[i]] = false;
                }
                result = linkedCheck();
                if (result[0] == 1) {
                    min = Math.min(Math.abs(sum1 - result[1]), min);
                }
            }
            return;
        }
        for (int i = 1; i <= N; i++) {
            if (check[i])
                continue;
            arr[cur] = i;
            check[i] = true;
            recur(cur + 1, length);
            check[i] = false;
        }
    }

    static int bfs(int n) {
        int sum = 0;
        Queue<Integer> queue = new LinkedList<>();
        linkcheck[n] = true;
        sum += population[n];
        queue.add(n);
        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int i = 0; i < list[current].size(); i++) {
                int temp = (int) list[current].get(i);
                if (linkcheck[temp])
                    continue;
                queue.add(temp);
                sum += population[temp];
                linkcheck[temp] = true;
            }
        }
        return sum;
    }

    static int[] linkedCheck() {
        int cnt = 0;
        int sum = 0;
        int[] result = new int[2];
        for (int i = 1; i <= N; i++) {
            if (!linkcheck[i]) {
                cnt++;
                sum = bfs(i);
            }
        }
        result[0] = cnt;
        result[1] = sum;
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        list = new List[N + 1];
        population = new int[N + 1];
        check = new boolean[N + 1];
        for (int i = 1; i <= N; i++)
            list[i] = new ArrayList<Integer>();
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            population[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());
            for (int j = 0; j < size; j++) {
                list[i].add(Integer.parseInt(st.nextToken()));
            }
        }
        for (int i = 1; i <= N / 2; i++) {
            arr = new int[i];
            recur(0, i);
        }
        if (min == Integer.MAX_VALUE)
            System.out.println("-1");
        else
            System.out.println(min);
    }
}
