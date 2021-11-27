class Solution{
    int maximumPath(int n, int matrix[][])
    {
        int cost = 0;
        int[][] memo = new int[n][n];
        for(int i=0;i<matrix[0].length;i++){
            cost = Math.max(cost, maxCost(0, i, matrix, n, memo));
        }
        return cost;
    }
    public int maxCost(int currentRow, int currentCol, int[][] matrix, int n, int[][] memo){
        
        if(currentRow < 0 || currentRow >= n || currentCol < 0 || currentCol >= n )
        return 0;
        
        if(currentRow==n-1){
            return matrix[currentRow][currentCol];
        }
        
        String currentKey = currentRow + "_" + currentCol;
        if(memo[currentRow][currentCol]!=0){
            return memo[currentRow][currentCol];
        }
        
        int downMove = matrix[currentRow][currentCol] + maxCost(currentRow + 1, currentCol, matrix, n, memo);
        
        int diagLeftMove = matrix[currentRow][currentCol] + maxCost(currentRow + 1, currentCol - 1, matrix, n, memo);
        
        int diagRightMove = matrix[currentRow][currentCol] + maxCost(currentRow + 1, currentCol + 1, matrix, n, memo);
        
        memo[currentRow][currentCol] =  Math.max(downMove, Math.max(diagLeftMove, diagRightMove));
        
        return memo[currentRow][currentCol];
    }
}
