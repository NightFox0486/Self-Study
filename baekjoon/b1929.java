import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class b1929 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        for (int i = M; i <= N; i++) {
            if (isPrime(i)) {
                bw.write(Integer.toString(i) + "\n");
            }
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
