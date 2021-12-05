/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class Node{
    int val;
    Node next;
    Node(int data){
        val = data;
        next = null;
    }
}

class GFG {
	public static void main (String[] args) {
	    // Converting Array to a Linked List
	    int arr[] = {1,2,8,4,5};
	    
	    Node dummyNode = new Node(-1);
	    Node head = dummyNode;
	    
	    for(int i=0;i<arr.length;i++){
	        Node newNode = new Node(arr[i]);
	            dummyNode.next = newNode;
	            dummyNode = dummyNode.next;
	    }
	    
	    Node current = head.next;
	    
	    while(current!=null){
	        System.out.print(current.val +" ");
	        current = current.next;
	    }
	}
}
