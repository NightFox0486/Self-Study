package truck_on_briedge;

public class main1 {
    public static void main(String[] args) {
        int bridge_length = 100;
        int weight = 100;
        int[] truck_weights = { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 };
        Solution solution = new Solution();
        System.out.println(solution.solution(bridge_length, weight, truck_weights));
    }
}
