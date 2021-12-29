class Solution
{
    //Function to count subarrays with 1s and 0s.
    static int countSubarrWithEqualZeroAndOne(int arr[], int n)
    {
        HashMap<Integer, Integer> memo = new HashMap<>();
        int prefixSum = 0;
        int ans = 0;
        memo.put(0, 1);
        
        for(int i=0; i<n; i++){
            int currentVal = arr[i];
            if(currentVal == 0){
                prefixSum += -1;
            }
            else{
                prefixSum += 1;
            }
            
            if(memo.containsKey(prefixSum)){
                int j = memo.get(prefixSum);
                ans+=j;
                memo.put(prefixSum, j + 1);
                
            }
            else{
                memo.put(prefixSum, 1);
            }
        }
        
        return ans;
    }
}


