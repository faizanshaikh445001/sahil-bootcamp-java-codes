class Solution {
    public int longestkSubstr(String s, int k) {
        int answer = -1;
        int left = 0;
        
        HashMap<Character, Integer> memo = new HashMap<>();
        
        for(int right = 0; right < s.length(); right++){
            char currentChar = s.charAt(right);
            
            if(memo.containsKey(currentChar)){
                memo.put(currentChar, memo.get(currentChar) + 1);
            }
            else{
                memo.put(currentChar, 1);
            }
            
            while(left <= right && memo.size() > k){
                char disChar = s.charAt(left);
                memo.put(disChar, memo.get(disChar) - 1);
                left++;
                
                if(memo.get(disChar) == 0){
                    memo.remove(disChar);
                }
            }
            
            if(memo.size() == k){
                answer = Math.max(answer, right - left + 1);
            }
            
        }
        
        return answer;
        
    }
}
