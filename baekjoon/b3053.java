package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class b3053 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        double R = Integer.parseInt(bf.readLine());
        bw.write(String.format("%1.6f", R * R * Math.PI) + "\n");
        bw.write(String.format("%1.6f", 2 * R * R));
        bw.flush();
        bw.close();
        bf.close();
    }
}
