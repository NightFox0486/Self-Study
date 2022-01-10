package java1.ch5;

public class MorseConverter {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("usage: java MorseConverter Word");
            System.exit(0);
        }

        System.out.println("source:" + args[0]);
        String source = args[0].toUpperCase();

        String[] morse = { "._", "-...", "-.-", "-..", ".", "..-", "--.", "....", "..", ".---", "-.-", ".-..", "--",
                "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.." };

        String result = "";

        for (int i = 0; i < source.length(); i++) {
            result += morse[source.charAt(i) - 'A'];
        }

        System.out.println("morse:" + result);
    }
}