/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project3_linkedlists;

/**
 *
 * @author danieltripp
 */
public class MyLinkedList<T> {
    
    /**
     * This is the Node Class. Nodes are the basic elements that comprise
     * a Linked List.
     */
    protected static class Node<T> { 
        
        public T Data;
        //public Node<T> Prev;
        public Node<T> Next;

        /** Function: Node
         * Author: Daniel Tripp
         * Description: This is the working constructor. It sets the Data and 
         * Next fields of the Node class to the argument values.
         * Inputs: T d: the Data, Node<T> a node to point Next.
         * Outputs: None.
         */
        public Node(T d, Node<T> n) {
            Data = d;
            //Prev = p;
            Next = n;
        }
        /** Function: Node
         * Author: Daniel Tripp
         * Description: This is the no arg constructor. It calls the working
         * constructor and sets the Data and Next fields of the Node class 
         * to null.
         * Inputs: None.
         * Outputs: None.
         */
        public Node() {
            this(null, null);
        }
        
        /** Function: Node
         * Author: Daniel Tripp
         * Description: This is the 1 arg constructor. It calls the working
         * constructor and sets the Data and of the Node class to the argument 
         * value. It sets the Next field to null.
         * Inputs: T d: the Data.
         * Outputs: None.
         */
        public Node(T d) {
            this(d, null);
        }
        
    /** Function: toString
     * Author: Daniel Tripp
     * Description: Formats and prints the data stored in the Node object in 
     * Human readable format.
     * Inputs: None.
     * Outputs: A String as described above.
     */
        @Override
        public String toString() {
            return (String) Data;
        }
    }
          
    private int theSize;
    private final Node<T> Head;
    private final Node<T> Tail;
    
    /** Function: MyLinkedList
     * Author: Daniel Tripp
     * Description: This is the default constructor. It results in a 
     * Linked List with 2 dataless Nodes: a head Node and a tail Node. 
     * The head Node is linked to the tail Node.
     * Inputs: None.
     * Outputs: A Pair List as described above.
     */
    public MyLinkedList() {
        Head = new Node<>(null, null);
        Tail = new Node<>(null, null);
        //Head.Data = (T)"Head";
        //Tail.Data = (T)"Tail";
        Head.Next = Tail;
        theSize = 0;
    }
    
    /** Function: addToEnd
     * Author: Daniel Tripp
     * Description: This method traverses the list to the end and inserts a Node
     * just before the tail Node. The node contains data as provided in the 
     * second argument.
     * Inputs: head Node, value to insert.
     * Outputs: None.
     */
    public void addToEnd(Node Head, T data) {
        Node p = Head;
        while(p.Next.Next != null) {
            p = p.Next;
        }
        Node n = new Node(data);
        n.Next = p.Next;
        p.Next = n;
        theSize++;
    }
    
    /** Function: insert
     * Author: Daniel Tripp
     * Description: This method traverses the list and checks whether the Data
     * section of each Node matches the first argument passed. If it matches, the
     * a Node containing data as specified in the second argument will be inserted
     * after the searched Node.
     * Inputs: Value to search, value to insert.
     * Outputs: None.
     */
    public void insert(T search, T data) {
        Node p = Head;
        while(!p.Next.Data.equals(search) && p.Next != null) {
            p = p.Next;
        }
        Node n = new Node(data);
        n.Next = p.Next.Next;
        p.Next.Next = n;
        theSize++;
    }
    
    /** Function: deleteNode
     * Author: Daniel Tripp
     * Description: This method traverses the list and checks whether the Data
     * section of each Node matches the argument passed. If it matches, the
     * Node is deleted.
     * Inputs: Value to search and delete.
     * Outputs: None.
     */
    public void deleteNode(T search) {
        Node p = Head;
        if (p.Next == null) {return;}
        while(!p.Next.Data.equals(search)) {
            p = p.Next;
        }
        p.Next = p.Next.Next;
        theSize--;
    }
    
    /** Function: printList
     * Author: Daniel Tripp
     * Description: This function traverses the list and prints the Data section of
     * each node.
     * Inputs: None.
     * Outputs: None.
     */
    public void printList() {
        Node p = Head;
        while(p.Next != null) {
            if(p.Data != null) {
                System.out.print("( " + p.Data + " )");
                if(p.Next.Data != null) {
                    System.out.print(" -> ");
                }
            }
            p = p.Next;
        }
        System.out.println();
        //System.out.println("Size: " + theSize);
    }

    /** Function: contains
     * Author: Daniel Tripp
     * Description: Determines whether a Node is in the MyLinkedList. It
     * traverses the list and checks whether the Data section of each Node
     * matches the argument passed.
     * Inputs: Value to search for.
     * Outputs: boolean indicating whether the Node was found.
     */
    public boolean contains(T search) {
        Node p = Head;
        while(p != null) {
            if(p.Data != null && p.Data.equals(search)) {
                return true;
            }
            p = p.Next;
        } return false;
    }
    
    /** Function: getHead
     * Author: Daniel Tripp
     * Description: returns the head Node of the List.
     * Inputs: None.
     * Outputs: Node Head.
     */
    public Node<T> getHead() {
        return Head;
    }
    
    
    /** Function: getSize
     * Author: Daniel Tripp
     * Description: returns the size of the calling object (number of items in
     * the List).
     * Inputs: None.
     * Outputs: int theSize
     */
    public int getSize() {
        return theSize;
    }
}
