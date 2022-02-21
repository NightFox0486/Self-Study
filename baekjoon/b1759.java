package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b1759 {
    static int L;
    static int C;
    static char[] inputChar;
    static char[] tempChar;
    static int consonantCnt = 0;

    static void recur(int cur, int start, int consonantCnt) {

        if (cur == L) {
            if (consonantCnt == 0)
                return;
            else if (L - consonantCnt < 2)
                return;
            for (int i = 0; i < L; i++) {
                System.out.print(tempChar[i]);
            }
            System.out.println();
            return;
        }
        for (int i = start; i < C; i++) {
            int temp = 0;
            tempChar[cur] = inputChar[i];
            if (inputChar[i] == 'a' || inputChar[i] == 'e' || inputChar[i] == 'i' || inputChar[i] == 'o'
                    || inputChar[i] == 'u')
                temp = 1;
            recur(cur + 1, i + 1, consonantCnt + temp);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        inputChar = new char[C];
        tempChar = new char[L];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            inputChar[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(inputChar);
        recur(0, 0, 0);
    }
}