public class minCostClimbingStairs {

    public int minCostClimbingStairs(int[] cost){
        int step1 = 0;
        int step2 = 0;

        // this is the bottom up approach here
        for(int i = cost.length-1; i>=0; i--){
            int curStep = cost[i] + Math.min(step1, step2);
            step1 = step2;
            step2 = curStep;
        }
        return Math.min(step1, step2);
    }
}
