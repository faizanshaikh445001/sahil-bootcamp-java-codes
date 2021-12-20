class Node{
    int val;
    Node next;
    Node prev;
    Node(){}
    Node(int val){
        this.val = val;
        this.next = null;
        this.prev = null;
    }
}


class MyLinkedList {
        Node head;
    public MyLinkedList() {
        head = new Node();
        head = null;
    }
    
    public int get(int index) {
        if(head == null){
            return -1;
        }
        Node current = head;
        int count = 0;
        
        while(current != null && count < index){
            current = current.next;
            count += 1;
            if(current == null){
                return -1;
            }
        }
        
        if(count == index){
            return current.val;
        }
        return -1;
        
    }
    
    public void addAtHead(int val) {
        Node newNode = new Node(val);
        
        if(head == null){
            head = newNode;
        }
        else{
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        return;
        
    }
    
    public void addAtTail(int val) {
        
        if(head == null){
            Node newNode = new Node(val);
            head = newNode;
            return;
        }
        
        Node current = head;
        while(current.next != null){
            current = current.next;
        }
        
        Node newNode = new Node(val);
        newNode.prev = current;
        current.next = newNode;
        
        return;
        
    }
    
    public void addAtIndex(int index, int val) {
        Node current = head;
        Node newNode = new Node(val);
        int count = 0;
        
        while(current != null && count < index){
            current = current.next;
            count += 1;
        }
        
        if(current == null && count == index){
            addAtTail(val);
            return;
        }
        
        if(count == index){
            addNodeBeforeNode(current, newNode);

            return;
        }
        
       return;
        
    }
    
    public void deleteAtIndex(int index) {
        if(head == null){
            return ;
        }
        if(index == 0){
            deleteNodeFromStart();
            return;
        }
        
        Node current = head;
        for(int i=0; i < index; i++){
            current = current.next;
            if(current == null){
                return;
            }
        }
        
        if(current.next == null){
            deleteNodeFromEnd();
            return;
        }
        
        Node prevNode = current.prev;
        Node nextNode = current.next;
        
        nextNode.prev = prevNode;
        prevNode.next = nextNode;
        
        current.prev = null;
        current.next = null;
        return;
        
    }
    
    public void addNodeBeforeNode(Node currentNode, Node newNode){
        if(currentNode.prev == null){
            newNode.next = currentNode;
            currentNode.prev = newNode;
            head = newNode;
            return;
        }
        
        newNode.next = currentNode;
        newNode.prev = currentNode.prev;
        currentNode.prev.next = newNode;
        currentNode.prev = newNode;
        
        return;
    }
    
    public void deleteNodeFromStart(){
        if(head == null || head.next == null){
            head = null;
            return;
        }
        
        Node current = head;
        current.next.prev = null;
        head = current.next;
        
        current.next = null;
        return ;
    }
    
    public void deleteNodeFromEnd(){
        if(head == null || head.next == null){
            head = null;
            return;
        }
        
        Node current = head;
        while(current.next != null){
            current = current.next;
        }
        
        current.prev.next = null;
        current.prev = null;
        return;
        
    }
    
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
