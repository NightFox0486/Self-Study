package truck_on_briedge;

public class main1 {
    public static void main(String[] args) {
        int bridge_length = 3;
        int weight = 10;
        int[] truck_weights = { 7, 4, 5, 6 };
        Solution solution = new Solution();
        System.out.println(solution.solution(bridge_length, weight, truck_weights));
    }
}
