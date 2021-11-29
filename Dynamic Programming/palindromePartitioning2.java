class Solution {
    public int minCut(String s) {
        return minimumCuts(s, 0, s.length() - 1, new HashMap<String, Integer>());
    }
    public int minimumCuts(String s, int start, int end, HashMap<String, Integer> memo){
        
        if(isPalindrome(s, start, end) == true || start == end)
            return 0;
        
        if(start > end){
            return 0;
        }
        
        String currentKey = start + "_" + end;
        if(memo.containsKey(currentKey))
            return memo.get(currentKey);
        
        int ans  = 100000;
        
        for(int currentCut = start; currentCut < end; currentCut++){
            if(isPalindrome(s, start, currentCut) == true){
            int rightHalf = minimumCuts(s, currentCut + 1, end, memo);
            ans = Math.min(ans, 1 + rightHalf);
            }
        }
        
        memo.put(currentKey, ans);
        
        return memo.get(currentKey);
        
    }
    public boolean isPalindrome(String s, int start, int end){
        while(start < end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
