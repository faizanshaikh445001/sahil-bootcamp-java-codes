class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int answer = 0;
        int prefixSum = 0;
        
        HashMap<Integer, Integer> memo = new HashMap<>();
        
        memo.put(prefixSum, 1);
        
        for(int i=0; i<nums.length; i++){
            prefixSum += nums[i];
            prefixSum = ( ( prefixSum % k ) + k) % k; // For Handling Negative Cases as well
            
            if(memo.containsKey(prefixSum)){
                int j = memo.get(prefixSum);
                answer += j;
                memo.put(prefixSum, j + 1);
            }
            else{
                memo.put(prefixSum, 1);
            }
            
        }
        
        return answer;
        
    }
}
