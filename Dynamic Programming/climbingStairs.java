class Solution {
    public int climbStairs(int n) {
        return totalWays(0,n,new HashMap<Integer,Integer>());
    }
    public int totalWays(int currentStair,int targetStair,HashMap<Integer,Integer> memo)
    {
        if(currentStair > targetStair)
            return 0;
        if(currentStair == targetStair)
            return 1;
        
        int currentKey = currentStair;
        
        if(memo.containsKey(currentKey))
            return memo.get(currentKey);
        
        int oneStep = totalWays(currentStair+1,targetStair,memo);
        int twoStep = totalWays(currentStair+2,targetStair,memo);
        memo.put(currentKey,oneStep+twoStep);
        return oneStep + twoStep;
    }
}