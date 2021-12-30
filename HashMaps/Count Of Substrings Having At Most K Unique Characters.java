import java.util.*;

public class Main {

	public static int solution(String str, int k) {
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
    
      answer += acquire - release + 1;

    }

    return answer;
  }

	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
        String str = scn.next();
        int k = scn.nextInt();
		System.out.println(solution(str,k));
	}

}
