public class test {
    public static void main(String[] args) {
        int n = 4;
        int[] arr = { 1, 2, 3, 3 };
        int left = 0;
        int right = 0;
        int left_idx = 0;
        int right_idx = n - 1;
        int pivot = 0;
        left += arr[left_idx];
        right += arr[right_idx];
        while (2 != (right_idx - left_idx)) {
            if (left < right) {
                left += arr[++left_idx];
            }
            if (right < left) {
                right += arr[--right_idx];
            }
        }
        pivot = left_idx + 1;
        System.out.println(Integer.toString(pivot));
    }
}