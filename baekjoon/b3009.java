import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class b3009 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        ArrayList<Integer> xarr = new ArrayList<Integer>();
        ArrayList<Integer> yarr = new ArrayList<Integer>();
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            if (xarr.contains(num)) {
                xarr.remove(xarr.indexOf(num));
            } else {
                xarr.add(num);
            }
            num = Integer.parseInt(st.nextToken());
            if (yarr.contains(num)) {
                yarr.remove(yarr.indexOf(num));
            } else {
                yarr.add(num);
            }
        }
        bw.write(Integer.toString(xarr.get(0)) + " " + Integer.toString(yarr.get(0)));
        bw.flush();
        bw.close();
        br.close();
    }
}
