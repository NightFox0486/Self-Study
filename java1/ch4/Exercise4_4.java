package java1.ch4;

public class Exercise4_4 {
    public static void main(String[] args) {
        int sum = 0;
        int i = 1;
        for (; sum < 100; i++) {
            if (i % 2 == 0)
                sum += i * -1;
            else
                sum += i;
        }
        System.out.println(sum + " " + i);
    }
}