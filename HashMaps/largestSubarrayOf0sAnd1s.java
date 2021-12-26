class Solution {

    // arr[] : the input array containing 0s and 1s
    // N : size of the input array
    
    // return the maximum length of the subarray
    // with equal 0s and 1s
    int maxLen(int[] arr, int n)
    {
        HashMap<Integer, Integer> memo = new HashMap<>();
        int prefixSum = 0;
        int answer = 0;
        
        memo.put(prefixSum, -1);
        
        for(int i = 0; i < n; i++){
            int currentVal = arr[i];
            if(currentVal == 0){
                prefixSum += -1;
            }
            else{
                prefixSum += 1;
            }
            
            if(memo.containsKey(prefixSum)){
                int temp = i - memo.get(prefixSum);
                answer = Math.max(answer, temp);
            }
            else{
                memo.put(prefixSum, i);
            }
        }
        
        return answer;
    }
}
