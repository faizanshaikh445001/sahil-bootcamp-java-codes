class Solution 
{ 
    long getSubstringWithEqual012(String str) 
    { 
        long answer = 0;
        HashMap<String, Integer> memo = new HashMap<>();
        int countZeroes = 0;
        int countOnes = 0;
        int countTwos = 0;
        
        String s = ( countOnes - countZeroes ) + "_" + (countTwos - countOnes);
        memo.put(s, 1);
        
        for(int i=0; i<str.length(); i++){
            int currentValue = Character.getNumericValue(str.charAt(i));
            if(currentValue == 0){
                countZeroes++;
            }
            else if(currentValue == 1){
                countOnes++;
            }
            else{
                countTwos++;
            }
            
            s = ( countOnes - countZeroes ) + "_" + (countTwos - countOnes);
            
            if(memo.containsKey(s)){
                int j = memo.get(s);
                answer += j;
                memo.put(s, j + 1);
            }
            else{
                memo.put(s, 1);
            }
        }

        return answer;
    }
} 
