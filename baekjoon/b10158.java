package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b10158 {
    static int w;
    static int h;
    static int p;
    static int q;
    static int t;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        p = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(br.readLine());
        if (((t + p) / w) % 2 == 1) {
            p = w - ((t + p) % w);
        } else {
            p = ((t + p) % w);
        }
        if (((t + q) / h) % 2 == 1) {
            q = h - ((t + q) % h);
        } else {
            q = ((t + q) % h);
        }
        System.out.println(p + " " + q);
    }
}
