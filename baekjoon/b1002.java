package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class b1002 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(bf.readLine());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(bf.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            double pointdistance = Math.sqrt(Math.pow(Math.abs((double) x1 - (double) x2), 2)
                    + Math.pow(Math.abs((double) y1 - (double) y2), 2));
            double radiusdistance = Math.abs((double) r1 + (double) r2);
            double radiusdifference = Math.abs((double) r1 - (double) r2);
            if (pointdistance == 0) {
                if (r1 == r2)
                    bw.write("-1\n");
                else
                    bw.write("0\n");
            } else {
                if (pointdistance > radiusdistance)
                    bw.write("0\n");
                else if (pointdistance == radiusdistance)
                    bw.write("1\n");
                else {
                    if (radiusdifference == pointdistance)
                        bw.write("1\n");
                    else if (pointdistance + r1 < r2 || r1 > r2 + pointdistance)
                        bw.write("0\n");
                    else
                        bw.write("2\n");
                }
            }
        }
        bw.flush();
        bw.close();
        bf.close();
    }
}
