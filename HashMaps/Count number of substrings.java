class Solution
{
    long substrCount (String s, int k) {
        return countAtMostKSubs(s, k) - countAtMostKSubs(s, k - 1);
    }
    
    public static long countAtMostKSubs(String str, int k) {
    long answer = 0;
    int release = 0;
    int distinctCount = 0;

    int arr[] = new int[26];

    for (int acquire = 0; acquire < str.length(); acquire++) {
      char currentChar = str.charAt(acquire);
      int currentValue = (int)currentChar - (int)'a';

        if(arr[currentValue] == 0){
            distinctCount++;
        }
        
        arr[currentValue] += 1;
        
      while(release <= acquire && distinctCount > k){
          char disChar = str.charAt(release);
          int prevValue = (int)disChar - (int)'a';
          arr[prevValue] -= 1;
          release++;
          
          if(arr[prevValue] == 0){
              distinctCount--;
          }
          
      }
    
      answer += acquire - release + 1;

    }

    return answer;
  }
    
}



// HashMaps Approach Was Giving TLE on GFG
class Solution
{
    long substrCount (String s, int k) {
        return countAtMostKSubs(s, k) - countAtMostKSubs(s, k - 1);
    }
    
    public static long countAtMostKSubs(String str, int k) {
    long answer = 0;
    int release = 0;

    HashMap<Character, Integer> memo = new HashMap<>();

    for (int acquire = 0; acquire < str.length(); acquire++) {
      char currentChar = str.charAt(acquire);

      if(memo.containsKey(currentChar)){
          memo.put(currentChar, memo.get(currentChar) + 1);
      }
      else{
          memo.put(currentChar, 1);
      }
      
      while(release <= acquire && memo.size() > k){
          char disChar = str.charAt(release);
          memo.put(disChar, memo.get(disChar) - 1);
          release++;
          
          if (memo.get(disChar) == 0) {
            memo.remove(disChar);
          }
          
      }
    
      answer += acquire - release + 1;

    }

    return answer;
  }
    
}

