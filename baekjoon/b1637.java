package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b1637 {
    static int N;
    static InputNum[] list;

    static class InputNum {
        long s;
        long e;
        long d;

        InputNum(long s, long e, long d) {
            this.s = s;
            this.e = e;
            this.d = d;
        }
    }

    static long check(long target) {
        long cnt = 0;
        for (int i = 0; i < N; i++) {
            if (list[i].s <= target)
                cnt += (Math.min(target, list[i].e) - list[i].s) / list[i].d + 1;
        }
        // for (int i = 0; i < N; i++) {
        // if (target < list.get(i).s)
        // continue;
        // if (list.get(i).e <= target) {
        // cnt += (list.get(i).e - list.get(i).s) / list.get(i).d + 1;
        // continue;
        // }
        // long temp = list.get(i).s;
        // cnt++;
        // while (temp <= target) {
        // temp += list.get(i).d;
        // if (temp > list.get(i).e)
        // break;
        // cnt++;
        // }
        // }
        return cnt;
    }

    static long check_cnt(long target) {
        long cnt = 0;
        for (int i = 0; i < N; i++) {
            if (list[i].s <= target)
                cnt += (Math.min(target, list[i].e) - list[i].s) / list[i].d + 1;
        }
        // for (int i = 0; i < N; i++) {
        // if (target < list.get(i).s)
        // continue;
        // if (list.get(i).e <= target) {
        // cnt += (list.get(i).e - list.get(i).s) / list.get(i).d + 1;
        // continue;
        // }
        // long temp = list.get(i).s;
        // cnt++;
        // while (temp <= target) {
        // temp += list.get(i).d;
        // if (temp > list.get(i).e)
        // break;
        // cnt++;
        // }
        // }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        list = new InputNum[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            // list.add(new InputNum(s, e, d));
            list[i] = new InputNum(s, e, d);
        }
        long left = 0;
        long right = (long) Integer.MAX_VALUE + 1;
        while (left < right) {
            long mid = (left + right) / 2;
            if (check(mid) % 2 == 0) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (left == (long) Integer.MAX_VALUE + 1)
            System.out.println("NOTHING");
        else
            System.out.println((left) + " " + (check(left) - check(left - 1)));
    }
}
