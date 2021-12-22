class Solution{
    //Function to count the frequency of all elements from 1 to N in the array.
    public static void frequencyCount(int arr[], int N, int P)
    {
        HashMap<Integer, Integer> memo = new HashMap<>();
        
        for(int i=0; i<arr.length;i++){
            int count = memo.containsKey(arr[i]) ? memo.get(arr[i]) : 0;
            memo.put(arr[i], count + 1);
        }
        
        int res[] = new int[N];
        
        for(int i=1;i<=N;i++){
            if(memo.containsKey(i)){
            res[i-1] = memo.get(i);
            }
            else
            res[i-1] = 0;
        }
        
        for(int i=0;i<N;i++){
            arr[i] = res[i];
        }
        
    }
}

