package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class b4153 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        while (true) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 3; i++) {
                list.add(Integer.parseInt(st.nextToken()));
            }
            if (list.get(0) == 0)
                break;
            Collections.sort(list);
            if (list.get(0) * list.get(0) + list.get(1) * list.get(1) == list.get(2) * list.get(2)) {
                bw.write("right\n");
            } else {
                bw.write("wrong\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
