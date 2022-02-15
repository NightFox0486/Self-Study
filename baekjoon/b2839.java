package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class b2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int a = Integer.parseInt(st.nextToken());
        int cnt = 0;
        int temp;
        if (a % 5 == 0)
            cnt = a / 5;
        if (a % 3 == 0)
            cnt = a / 3;
        temp = a / 5;
        for (int i = temp; i > 0; i--) {
            if ((a - i * 5) % 3 == 0) {
                i += (a - i * 5) / 3;
                cnt = i;
                break;
            }
        }

        if (cnt == 0)
            cnt = -1;
        bw.write(Integer.toString(cnt));
        bw.flush();
        bw.close();
    }
}