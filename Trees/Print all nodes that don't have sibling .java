class Tree
{
    ArrayList<Integer> noSibling(Node node)
    {
        ArrayList<Integer> answer = new ArrayList<>();
        noSiblingFunction(node, answer);
        if(answer.size() == 0){
            answer.add(-1);
        }
        
        Collections.sort(answer);
        return answer;
    }
    
    private void noSiblingFunction(Node root, ArrayList<Integer> answer){
        
        if(root.left != null && root.right != null){
            noSiblingFunction(root.left, answer);
            noSiblingFunction(root.right, answer);
            return;
        }
        
        if(root.left != null){
            answer.add(root.left.data);
            noSiblingFunction(root.left, answer);
        }
        
        if(root.right != null){
            answer.add(root.right.data);
            noSiblingFunction(root.right, answer);
        }
        
        return;
        
    }
}
