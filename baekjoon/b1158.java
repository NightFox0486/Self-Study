package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class b1158 {
    public static void main(String[] args) throws IOException {
        List<Integer> list = new LinkedList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        int N = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            list.add(i + 1);
        }
        int K = Integer.parseInt(st.nextToken());
        int current = K - 1;
        while (true) {
            sb.append(list.get(current) + ", ");
            list.remove(current);
            if (list.isEmpty()) {
                break;
            }
            current += (K - 1);
            current %= list.size();
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append(">");
        System.out.println(sb);
    }
}
