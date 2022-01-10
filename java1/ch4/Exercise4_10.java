package java1.ch4;

public class Exercise4_10 {
    public static void main(String[] args) {
        int num = 12345;
        int sum = 0;

        sum += num % 10 + (num % 100 / 10) + (num % 1000 / 100) + (num % 10000 / 1000) + (num / 10000);

        System.out.println("sum=" + sum);
    }
}