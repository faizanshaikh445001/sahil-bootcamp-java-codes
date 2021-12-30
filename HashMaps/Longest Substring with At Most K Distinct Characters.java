public class Solution {
    /**
     * @param s: A string
     * @param k: An integer
     * @return: An integer
     */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        return longestSubstring(s, k);
    }

    public static int longestSubstring(String str, int k) {
    int answer = 0;
    int release = 0;
    int distinctCount = 0;

    HashMap<Character, Integer> memo = new HashMap<>();

    for (int acquire = 0; acquire < str.length(); acquire++) {
      char currentChar = str.charAt(acquire);

      if(memo.containsKey(currentChar)){
          memo.put(currentChar, memo.get(currentChar) + 1);
      }
      else{
          memo.put(currentChar, 1);
          distinctCount++;
      }
      
      while(release <= acquire && distinctCount > k){
          char disChar = str.charAt(release);
          memo.put(disChar, memo.get(disChar) - 1);
          release++;
          
          if (memo.get(disChar) == 0) {
            memo.remove(disChar);
            distinctCount--;
          }
          
      }
    
      answer = Math.max(answer, acquire - release + 1);

    }

    return answer;
  }

    
}
