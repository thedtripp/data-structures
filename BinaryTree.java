package project5_trees;

/** This Binary Tree class allows for storage of sorted data and accessibility
 * in logarithmic time.
 * @author danieltripp
 */
public class BinaryTree<T extends Comparable<? super T>> {
    /**
     * This is the Node Class. Nodes are the basic elements that comprise
     * a Binary Tree.
     */
    protected static class Node<T> { 
        
        public T Data;
        public Node<T> left;
        public Node<T> right;

        /** Function: Node
         * Author: Daniel Tripp
         * Description: This is the working constructor. It sets the Data, 
         * Left, and Right fields of the BinaryNode class to the argument values.
         * Inputs: T d: the Data, BinaryNode<T> a node to point left and right.
         * Outputs: None.
         */
        public Node(T d, Node<T> l, Node<T> r) {
            Data = d;
            left = l;
            right = r;
        }
        /** Function: Node
         * Author: Daniel Tripp
         * Description: This is the no arg constructor. It calls the working
         * constructor and sets the Data, Left and Right fields of the Node class 
         * to null.
         * Inputs: None.
         * Outputs: None.
         */
        public Node() {
            this(null, null, null);
        }
        
        /** Function: Node
         * Author: Daniel Tripp
         * Description: This is the 1 arg constructor. It calls the working
         * constructor and sets the Data of the Node class to the argument 
         * value.
         * Inputs: T d.
         * Outputs: None.
         */
        public Node(T d) {
            this(d, null, null);
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
            String str = "";
            str += this.Data;
            return str;
        }
    }
    Node<T> Root;
    
    
    /** Function: BinaryTree
     * Author: Daniel Tripp
     * Description: Default constructor. Sets all values to null.
     * Inputs: None.
     * Outputs: None.
     */
    public BinaryTree() {
        this.Root = null;
    }
    
    /** Function: BinaryTree
     * Author: Daniel Tripp
     * Description: 1 arg constructor. Sets Data field.
     * Inputs: Data.
     * Outputs: None.
     */
    public BinaryTree(T d) {
        this.Root = new Node(d);
    }
     
    /** Function: toString
     * Author: Daniel Tripp
     * Description: Allow for display of tree data.
     * Inputs: None.
     * Outputs: String as described above.
     */
    @Override
    public String toString()  {
        if (!this.isEmpty()) {
            String str = "";
            str += (String) Root.Data;
            return str;
        }
        else
            return "Root is Null";
    }
    
    /** Function: isEmpty
     * Author: Daniel Tripp
     * Description: Check if the tree is empty
     * Inputs: None.
     * Outputs: Boolean indicating if tree is empty.
     */
    public boolean isEmpty() {
        return this.Root == null;
    }
    
    /** Function: insert
     * Author: Daniel Tripp
     * Description: Insert the specified data into the tree in the appropriate
     * location. A recursive method
     * Inputs: Value to insert, root node.
     * Outputs: None.
     */
    private void insert(T d, Node<T> n) {
        if ( n == null ) {
            this.Root = new Node(d);
            return;
        }
        int comparison = d.compareTo( n.Data );
        if (comparison < 0) {
            if (n.left != null)
                insert(d, n.left);
            else
                n.left = new Node(d);
        } else if ( comparison > 0) {
            if (n.right != null)
                insert(d, n.right);
            else
                n.right = new Node(d);
        }
        //If comparison = 0, item is already in the tree.
        //Do nothing. No duplicates allowed.
    }
    
    /** Function: insert
     * Author: Daniel Tripp
     * Description: A public interface to a private method. Inserts the specified
     * data into the tree in the appropriate location.
     * Inputs: Data to insert.
     * Outputs: None.
     */
    public void insert (T d) {
        this.insert(d, this.Root);
    }
    
    /** Function: remove
     * Author: Daniel Tripp
     * Description: This function recursively searches for the specified node
     * and removes if from the tree.
     * Inputs: Value to remove, Root node.
     * Outputs: Root of the new tree.
     */
    private Node<T> remove(T d, Node<T> n) {
        if ( n == null) {
            System.out.println("End of tree. Do nothing");
            return n; //do nothing
        }
        int comparison = d.compareTo( n.Data );
        if ( comparison < 0 )
            n.left = this.remove(d, n.left);
        else if ( comparison > 0 )
            n.right = this.remove(d, n.right);
        else if (n.left != null && n.right != null) {
            n.Data = findMin(n.right);
            remove(n.Data, n.right);
        }
        else {
            n = (n.left != null) ? n.left : n.right;
        }
        
        return n;
    }
    
    /** Function: remove
     * Author: Daniel Tripp
     * Description: A public interface to the private method. Removes the
     * specified value from the tree.
     * Inputs: Value to search and remove
     * Outputs: None.
     */
    public void remove (T d) {
        this.remove(d, this.Root);
    }
    
    /** Function: findMin
     * Author: Daniel Tripp
     * Description: Finds and returns the smallest value in the tree.
     * Inputs: Root node.
     * Outputs: Min value.
     */
    private T findMin(Node<T> n) {
        if (n.left == null)
            return n.Data;
        else
            return findMin(n.left);
    }
    
    /** Function: findMin
     * Author: Daniel Tripp
     * Description: A public interface to a private method. Finds and returns
     * smallest value in the tree.
     * Inputs: None.
     * Outputs: Min value.
     */
    public T findMin() {
        return this.findMin(this.Root);
    }
    
    /** Function: findMax
     * Author: Daniel Tripp
     * Description: Finds and returns the largest value in the tree.
     * Inputs: Root node.
     * Outputs: Max value.
     */
    private T findMax(Node<T> n) {
        if (n.right == null)
            return n.Data;
        else
            return findMax(n.right);
    }
    
    /** Function: findMax
     * Author: Daniel Tripp
     * Description: A public interface to the private method. Finds and returns
     * the largest value in the tree.
     * Inputs: None.
     * Outputs: Max value.
     */
    public T findMax() {
        return this.findMax(this.Root);
    }
    
    /** Function: contains
     * Author: Daniel Tripp
     * Description: Traverse tree in search of a node containing the specified data.
     * Returns a boolean.
     * Inputs: Data to search for. Node at which to start tree traversal.
     * Outputs: Boolean indicating whether the data is in the tree.
     */
    private boolean contains(T d, Node<T> n) {
        if (n == null)
            return false;
        int comparison = d.compareTo( n.Data );
        if ( comparison < 0 )
            return contains(d, n.left);
        else if ( comparison > 0 )
            return contains(d, n.right);
        else
            return true;    
    }
    
    /** Function: contains
     * Author: Daniel Tripp
     * Description: A public interface to the private method.
     * Inputs: Data to search for.
     * Outputs: Boolean indicating whether the data is in the tree.
     */
    public boolean contains(T d) {
        return this.contains(d, this.Root);
    }
    
    /** Function: printTree
     * Author: Daniel Tripp
     * Description: In-order traversal of tree, printing the data of each node.
     * Inputs: Node to start printing from.
     * Outputs: None.
     */
    private void printTree(Node<T> n) {
        if ( this.Root == null )
            System.out.println("Empty tree.");
        if ( n != null) {
            this.printTree(n.left);
            System.out.println(n.Data);
            this.printTree(n.right);
        }
    }
    
     /** Function: printTree
     * Author: Daniel Tripp
     * Description: Print the tree, a public interface to the private method.
     * Inputs: None.
     * Outputs: None.
     */
    public void printTree() {
        this.printTree(this.Root);
    }
}