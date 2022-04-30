package baekjoon;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class b1755 {
    public static void main(String[] args) {
        String[] words = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten" };
        Comparator<Integer> comp = new Comparator<Integer>() {

            @Override
            public int compare(Integer a, Integer b) { // 입력 받은 숫자의 자릿수 별로 문자변환값을 확인하고 비교 후 리턴
                if (a < 10 && b < 10) {
                    return words[a].compareTo(words[b]);
                } else if (a < 10) {
                    int temp = words[a].compareTo(words[b / 10]);
                    if (temp == 0)
                        return -1;
                    else
                        return temp;
                } else if (b < 10) {
                    int temp = words[a / 10].compareTo(words[b]);
                    if (temp == 0)
                        return 1;
                    else
                        return temp;
                } else {
                    if (words[a / 10].equals(words[b / 10])) {
                        return words[a % 10].compareTo(words[b % 10]);
                    } else {
                        return words[a / 10].compareTo(words[b / 10]);
                    }
                }
            }
        };
        PriorityQueue<Integer> pq = new PriorityQueue<>(comp); // 위에서 지정한 컴퍼레이터를 전달

        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        for (int i = M; i <= N; i++) {
            pq.offer(i);
        }
        int cnt = 0;
        while (!pq.isEmpty()) {
            System.out.print(pq.poll() + " ");
            cnt++;
            if (cnt == 10) { // 한 줄에 10개
                System.out.println();
                cnt = 0;
            }
        }

    }
}
// eigth five four nine one seven six three two zero
// 8 5 4 9 1 7 6 3 2 0