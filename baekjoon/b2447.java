public class b2447 {
    public static void main(String[] args) {
        printstar(27);
    }

    static void printstar(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i % 3 == 1 && j % 3 == 1)
                    System.out.print(" ");
                else
                    System.out.print("*");
            }
            System.out.println("");
        }
    }
}