class Tree
{
    //Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root)
    {
      ArrayList<Integer> answer = new ArrayList<>();
      leftSideView(root, 1, new HashSet<>(), answer);
      return answer;
      
    }
    
    private void leftSideView(Node root, int level, HashSet<Integer> set, ArrayList<Integer> answer){
        
        if(root == null){
            return;
        }
        
        if(!set.contains(level)){
            answer.add(root.data);
            set.add(level);
        }
        
        leftSideView(root.left, level + 1, set, answer);
        leftSideView(root.right, level + 1, set, answer);
        
        return;
        
    }
    
}
