import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class b1978 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int cnt = 0;
        int n = Integer.parseInt(bf.readLine());
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            if (isPrime(Integer.parseInt(st.nextToken())))
                cnt++;
        }
        bw.write(Integer.toString(cnt));
        bw.flush();
        bw.close();
    }

    static boolean isPrime(int num) {
        if (num == 1)
            return false;
        int temp = 2;
        while (temp <= (int) Math.sqrt(num)) {
            if (temp == num) {
                return true;
            } else {
                if (num % temp == 0) {
                    return false;
                }
            }
            temp++;
        }
        return true;
    }
}
