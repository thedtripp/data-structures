package project4_doubly_linked_lists;
/**
 *This Stack Class is a derivative of the MyDoublyLinked List Class. It features
 * methods push, pop, and peek.
 * @author danieltripp
 */
public class MyStack<T> extends MyDoublyLinkedList{
    
    /** Function: MyStack
     * Author: Daniel Tripp
     * Description: This is the default constructor. It calls the default 
     * constructor of the parent class. It results in a 
     * Stack with 2 dataless Nodes: a head Node and a tail Node. 
     * The head Node is linked to the tail Node.
     * In addition, it customizes the data fields of the Head and Tail nodes.
     * Inputs: None.
     * Outputs: An empty Stack as described above.
     */
    public MyStack() {
        super();
        nameVar("TOP", "BOTTOM");
    }

    /** Function: push
     * Author: Daniel Tripp
     * Description: This method adds a new Node to the top of the stack
     * This is done by calling the addToFront method of the parent class which
     * traverses the stack from the bottom to the top and inserts a Node
     * just before the tail(TOP) Node. The node contains data as provided in the 
     * data argument.
     * Inputs: value to insert.
     * Outputs: None.
     */
    public void push(T data) {
        super.addToFront(this.Head, data);
    }

    /** Function: pop
     * Author: Daniel Tripp
     * Description: This method deletes the Node at the top of the stack and 
     * returns the Data of that Node. It uses the deleteNode method from the
     * parent class.
     * Inputs: None
     * Outputs: Deleted value.
     */
    public T pop() {
        Node<T> del = new Node(Head.Next.Data);
        super.deleteNode(Head.Next.Data);
        return del.Data;
    }
    
    /** Function: peek
     * Author: Daniel Tripp
     * Description: This method returns the data of the Node at the top of the 
     * stack without modifying the stack.
     * Inputs: None
     * Outputs: Value at top of Stack.
     */
    public T peek() {
        Node<T> peek = new Node(Head.Next.Data);
        return peek.Data;
    }

    /** Function: printList
     * Author: Daniel Tripp
     * Description: This method enhances the printList() method somewhat.
     * Outputs the size of the stack.
     * Inputs: None
     * Outputs: Size of stack
     */
    @Override
    public void printList() {
        super.printList();
        System.out.println("Size: " + this.theSize);
    }
}
