import java.util.*;

public class Main {

    public static int solution(int[] arr) {
        // write your code here
        int answer = 0;
        HashMap<String, Integer> memo = new HashMap<>();
        int countZeroes = 0;
        int countOnes = 0;
        int countTwos = 0;
        
        String str = ( countOnes - countZeroes ) + "_" + (countTwos - countOnes);
        memo.put(str, -1);
        
        for(int i=0; i<arr.length; i++){
            if(arr[i] == 0){
                countZeroes++;
            }
            else if(arr[i] == 1){
                countOnes++;
            }
            else{
                countTwos++;
            }
            
            str = ( countOnes - countZeroes ) + "_" + (countTwos - countOnes);
            
            if(memo.containsKey(str)){
                answer = Math.max(answer, i - memo.get(str));
            }
            else{
                memo.put(str, i);
            }
        }

        return answer;
    }
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        System.out.println(solution(arr));
    }

}
