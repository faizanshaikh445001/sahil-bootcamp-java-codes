// It is Available on GFG!
class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int capacity, int weights[], int values[], int n) 
    { 
         return maxProfit(weights,values,capacity,n,0,new HashMap<String,Integer>());
    } 
    public static int maxProfit(int[] weights,int[] values,int capacity,int n,int currentItem,HashMap<String,Integer> memo)
    {
        if(currentItem >= n)
            return 0;
        
        String currentKey = Integer.toString(currentItem) + "_" + Integer.toString(capacity);
        
        if(memo.containsKey(currentKey))
            return memo.get(currentKey);
        
        int consider = 0;
        if(weights[currentItem] <= capacity){
            consider = values[currentItem] + maxProfit(weights, values, capacity - weights[currentItem], n, currentItem + 1,memo);
        } 
        
        int notConsider = maxProfit(weights, values, capacity, n, currentItem + 1,memo);
        
        memo.put(currentKey,Math.max(consider,notConsider));
        
        return memo.get(currentKey);
    }
}
