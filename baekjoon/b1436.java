package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class b1436 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(bf.readLine());
        int cnt = 0;
        int i;
        for (i = 0; cnt != N; i++) {
            if (Integer.toString(i).contains("666"))
                cnt++;
        }
        bw.write(Integer.toString(i - 1));
        bw.flush();
        bw.close();
        bf.close();
    }
}
