class Solution
{
    ArrayList<Integer> countDistinct(int A[], int n, int k)
    {
        HashMap<Integer, Integer> memo = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        
        int unique = 0;
        
        for(int acq = 0 ; acq < k - 1; acq++){
            int currentVal = A[acq];
            int count = memo.containsKey(currentVal) ? memo.get(currentVal) : 0;
            memo.put(currentVal, count + 1);
            if(count == 0){
                unique++;
            }
        }
       
       int release = 0;
       
        for(int acquire = k-1; acquire < n; acquire++){
            int currentVal = A[acquire];
            
            int count = memo.containsKey(currentVal) ? memo.get(currentVal) : 0;
            memo.put(currentVal, count + 1);
            
            if(count == 0){
                unique++;
            }
            
            list.add(unique);
            
            
            int releaseVal = A[release];
            
            memo.put(releaseVal, memo.get(releaseVal) - 1);
            
            if(memo.get(releaseVal) == 0){
                memo.remove(releaseVal);
                unique--;
            }
            
            release++;

        }
        
        return list;
        
    }
}
