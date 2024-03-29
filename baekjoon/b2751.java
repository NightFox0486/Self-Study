package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class b2751 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(bf.readLine());
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for (int i = 0; i < N; i++) {
            arr.add(Integer.parseInt(bf.readLine()));
        }
        Collections.sort(arr);
        for (int i = 0; i < N; i++) {
            bw.write(Integer.toString(arr.get(i)) + "\n");
        }
        bw.flush();
        bw.close();
        bf.close();
    }
}
