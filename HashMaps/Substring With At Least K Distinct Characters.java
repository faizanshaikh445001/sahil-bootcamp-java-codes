public class Solution {
    /**
     * @param s: a string
     * @param k: an integer
     * @return: the number of substrings there are that contain at least k distinct characters
     */
    public long kDistinctCharacters(String s, int k) {
        long n = s.length();
        long total = n * (n + 1)/2;
        return total - countAtMostKSubs(s, k-1);
    }

    public static long countAtMostKSubs(String str, int k) {
    long answer = 0;
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
    
      answer += acquire - release + 1;

    }

    return answer;
  }


}
