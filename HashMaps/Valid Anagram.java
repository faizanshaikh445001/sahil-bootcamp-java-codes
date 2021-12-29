class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        
        HashMap<Character, Integer> memo = new HashMap<>();
        
        for(int i=0;i<s.length();i++){
            char currentValue = s.charAt(i);
            
            memo.put(currentValue, memo.getOrDefault(currentValue, 0) + 1);
            
        }
        
        for(int i=0;i<t.length();i++){
            char currentValue = t.charAt(i);
            
            if(memo.containsKey(currentValue)){
                int prevCount = memo.get(currentValue);
                if(prevCount == 1){
                    memo.remove(currentValue);
                }
                else{
                    memo.put(currentValue, prevCount - 1);
                }
            }
            else{
                return false;
            }
        }
        
        return memo.size() == 0;
    
    }
}
