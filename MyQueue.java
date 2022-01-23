package project4_doubly_linked_lists;

/**
 *This Queue Class is a derivative of the MyDoublyLinked List Class. It features
 * methods enqueue, dequeue, and peek.
 * @author danieltripp
 */
public class MyQueue<T> extends MyDoublyLinkedList{
    
    /** Function: MyQueue
     * Author: Daniel Tripp
     * Description: This is the default constructor. It calls the default 
     * constructor of the parent class. It results in a 
     * Queue with 2 dataless Nodes: a head Node and a tail Node. 
     * The head Node is linked to the tail Node.
     * In addition, it customizes the data fields of the Head and Tail nodes.
     * Inputs: None.
     * Outputs: An empty Queue as described above.
     */
    public MyQueue() {
        super();
        nameVar("FRONT", "BACK");
    }
    
    /** Function: enqueue
     * Author: Daniel Tripp
     * Description: This method adds a new Node to the top of the queue
     * This is done by calling the addToEnd method of the parent class which
     * inserts a Node at the back of the queue The node contains data as 
     * provided in the 
     * data argument.
     * Inputs: value to insert.
     * Outputs: None.
     */
    public void enqueue(T data) {
        super.addToEnd(data);
    }
    
    /** Function: dequeue
     * Author: Daniel Tripp
     * Description: This method deletes the Node at the front of the queue and 
     * returns the Data of that Node. It uses the deleteNode method from the
     * parent class.
     * Inputs: None
     * Outputs: Deleted value.
     */
    public T dequeue() {
        Node<T> deq = new Node(Head.Next.Data);
        super.deleteNode(Head.Next.Data);
        return deq.Data;
    }
    
    /** Function: peek
     * Author: Daniel Tripp
     * Description: This method returns the data of the Node at the front of the 
     * queue without modifying the stack.
     * Inputs: None
     * Outputs: Value at front of queue.
     */
    public T peek() {
        Node<T> deq = new Node(Head.Next.Data);
        return deq.Data;
    }
    
}