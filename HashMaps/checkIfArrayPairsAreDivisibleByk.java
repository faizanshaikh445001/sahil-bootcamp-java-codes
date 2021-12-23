class Solution {
    public boolean canArrange(int[] arr, int k) {
        
        HashMap<Integer, Integer> memo = new HashMap<>();
        
        for(int i=0; i<arr.length; i++){
            int currentVal = arr[i];
            int currentRem = ((currentVal % k) + k) % k;
            
            int count = memo.containsKey(currentRem) ? memo.get(currentRem) : 0;
            memo.put(currentRem, count + 1);
        }
        
        for(int key: memo.keySet()){
            if(key == 0){
                if(memo.get(key)%2 != 0){
                    return false;
                }
            }
            else if(memo.containsKey(k - key) == false){
                return false;
            }
            else if(memo.get(key).equals(memo.get(k - key)) == false){
                return false;
            }
        }
        
        return true;
        
    }
}
