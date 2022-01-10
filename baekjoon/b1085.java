package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class b1085 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int min = 1000;
        if (w / 2 >= x) {
            if (x < min)
                min = x;
        } else {
            if (w - x < min)
                min = w - x;
        }
        if (h / 2 >= y) {
            if (y < min)
                min = y;
        } else {
            if (h - y < min)
                min = h - y;
        }
        bw.write(Integer.toString(min));
        bw.flush();
        bw.close();
        br.close();
    }
}
