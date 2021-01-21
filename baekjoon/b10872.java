import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class b10872 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(Integer.toString(factorial(Integer.parseInt(bf.readLine()))));
        bw.flush();
        bw.close();
        bf.close();
    }

    static int factorial(int n) {
        if (n == 0)
            return 1;
        if (n == 1)
            return 1;
        else
            return factorial(n - 1) * n;
    }
}
