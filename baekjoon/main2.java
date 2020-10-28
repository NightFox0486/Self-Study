import java.util.Scanner;
import java.util.HashMap;

class main2 {
    private static void solution(int day, int width, int[][] blocks) {
        int count = 0;
        int[] remain = new int[width];
        HashMap<Integer, Integer> maxlist = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> maxvalue = new HashMap<Integer, Integer>();
        for (int i = 0; i < width; i++) {
            remain[i] = 0;
        }
        for (int i = 0; i < day; i++) {
            for (int j = 0; j < width; j++) {
                remain[j] += blocks[i][j];
            }
            int temp_idx = 0;
            for (int j = 1; j < width - 1; j++) {
                if (remain[j] > remain[j - 1] && remain[j] > remain[j + 1]) {
                    maxlist.put(temp_idx, j);
                    maxvalue.put(temp_idx, remain[j]);
                    temp_idx++;
                }
            }
            for (int j = 0; j < temp_idx; j++) {
                if (j == 0) {
                    if (remain[0] > maxvalue.get(j)) {
                        for (int k = 1; k < maxlist.get(j); k++) {
                            count += maxvalue.get(j) - remain[k];
                            remain[k] += maxvalue.get(j) - remain[k];
                        }
                    } else {
                        for (int k = 1; k < maxlist.get(j); k++) {
                            count += remain[0] - remain[k];
                            remain[k] += remain[0] - remain[k];
                        }
                    }
                } else {
                    if (maxvalue.get(j - 1) > maxvalue.get(j)) {
                        for (int k = maxlist.get(j - 1) + 1; k < maxlist.get(j); k++) {
                            count += maxvalue.get(j) - remain[k];
                            remain[k] += maxvalue.get(j) - remain[k];
                        }
                    } else {
                        for (int k = maxlist.get(j - 1) + 1; k < maxlist.get(j); k++) {
                            count += maxvalue.get(j - 1) - remain[k];
                            remain[k] += maxvalue.get(j - 1) - remain[k];
                        }
                    }
                }
                if (j == temp_idx - 1) {
                    if (j != 0) {
                        if (maxvalue.get(j - 1) > maxvalue.get(j)) {
                            for (int k = maxlist.get(j - 1) + 1; k < maxlist.get(j); k++) {
                                count += maxvalue.get(j) - remain[k];
                                remain[k] += maxvalue.get(j) - remain[k];
                            }
                        } else {
                            for (int k = maxlist.get(j - 1) + 1; k < maxlist.get(j); k++) {
                                count += maxvalue.get(j - 1) - remain[k];
                                remain[k] += maxvalue.get(j - 1) - remain[k];
                            }
                        }
                    }
                    if (remain[width - 1] > maxvalue.get(j)) {
                        for (int k = maxlist.get(temp_idx - 1) + 1; k < width; k++) {
                            count += maxvalue.get(j) - remain[k];
                            remain[k] += maxvalue.get(j) - remain[k];
                        }
                    } else {
                        for (int k = maxlist.get(temp_idx - 1) + 1; k < width; k++) {
                            count += remain[width - 1] - remain[k];
                            remain[k] += remain[width - 1] - remain[k];
                        }
                    }
                }
            }
        }
        System.out.println("count : " + Integer.toString(count));
    }

    private static class InputData {
        int day;
        int width;
        int[][] blocks;
    }

    private static InputData processStdin() {
        InputData inputData = new InputData();

        try (Scanner scanner = new Scanner(System.in)) {
            inputData.day = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));
            inputData.width = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));

            inputData.blocks = new int[inputData.day][inputData.width];
            for (int i = 0; i < inputData.day; i++) {
                String[] buf = scanner.nextLine().trim().replaceAll("\\s+", " ").split(" ");
                for (int j = 0; j < inputData.width; j++) {
                    inputData.blocks[i][j] = Integer.parseInt(buf[j]);
                }
            }
        } catch (Exception e) {
            throw e;
        }

        return inputData;
    }

    public static void main(String[] args) throws Exception {
        InputData inputData = processStdin();

        solution(inputData.day, inputData.width, inputData.blocks);
    }
}