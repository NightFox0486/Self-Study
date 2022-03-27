package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class b11728 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int NA = Integer.parseInt(st.nextToken());
        int NB = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> pqueue = new PriorityQueue<Integer>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < NA; i++) {
            pqueue.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < NB; i++) {
            pqueue.add(Integer.parseInt(st.nextToken()));
        }
        while (!pqueue.isEmpty()) {
            sb.append(pqueue.poll() + " ");
        }
        System.out.println(sb);
    }
}
