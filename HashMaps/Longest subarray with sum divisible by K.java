class Solution{
    int longSubarrWthSumDivByK(int nums[], int n, int k)
    {
        int answer = 0;
        int prefixSum = 0;
        
        HashMap<Integer, Integer> memo = new HashMap<>();
        
        memo.put(prefixSum, -1);
        
        for(int i=0; i<nums.length; i++){
            prefixSum += nums[i];
            prefixSum = ( ( prefixSum % k ) + k) % k; // For Handling Negative Cases as well
            
            if(memo.containsKey(prefixSum)){
                int prevIndex = memo.get(prefixSum);
                answer = Math.max(answer, i - prevIndex );
            }
            else{
                memo.put(prefixSum, i);
            }
            
        }
        
        return answer;
       
    }
 
}
