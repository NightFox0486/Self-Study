package baekjoon;

import java.util.Scanner;
import java.util.TreeMap;

public class b6131 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int cnt = 0;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 1; i <= 500; i++) {
            map.put(i * i, 1);
            if (map.containsKey((i * i) - N))
                cnt++;
        }
        System.out.println(cnt);
    }
}
