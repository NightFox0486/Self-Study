import java.util.Scanner;

public class b10870 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(fibonacci(sc.nextInt()));
        sc.close();
    }

    static int fibonacci(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        if (n > 1)
            return fibonacci(n - 1) + fibonacci(n - 2);
        return -1;
    }
}
