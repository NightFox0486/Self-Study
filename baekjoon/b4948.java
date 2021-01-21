import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class b4948 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int cnt = 0;
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }
            for (int i = n + 1; i <= 2 * n; i++) {
                if (isPrime(i)) {
                    cnt++;
                }
            }
            bw.write(Integer.toString(cnt) + "\n");
            cnt = 0;
        }
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
