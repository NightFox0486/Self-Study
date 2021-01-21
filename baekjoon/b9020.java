import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class b9020 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            int interval = 0 - num;
            int idx = 0;
            for (int j = 2; j <= num / 2; j++) {
                if (isPrime(j) && isPrime(num - j) && interval < j - (num - j)) {
                    interval = j - (num - j);
                    idx = j;
                }
            }
            if (interval != num)
                bw.write(Integer.toString(idx) + " " + Integer.toString(num - idx) + "\n");
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
