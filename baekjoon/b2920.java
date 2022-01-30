package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b2920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        boolean asc = true;
        boolean des = true;
        int[] arr = new int[8];
        for (int i = 0; i < 8; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (i == 0)
                continue;
            if (arr[i] < arr[i - 1])
                asc = false;
            if (arr[i] > arr[i - 1])
                des = false;
            if (!asc && !des) {
                System.out.println("mixed");
                break;
            }
        }
        if (asc)
            System.out.println("ascending");
        if (des)
            System.out.println("descending");
    }
}