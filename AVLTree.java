package project5_trees;
/** This AVL Tree class allows for storage of sorted data and accessibility
 * in logarithmic time. It is self balancing to ensure efficiency in look ups.
 * @author danieltripp
 */
public class AVLTree<T extends Comparable<? super T>> {
    
    public AVLNode<T> Root;
    private static final int ALLOWED_IMBALANCE = 1;
    
    /** Function: AVLTree
     * Author: Daniel Tripp
     * Description: Default constructor. Sets all values to null.
     * Inputs: None.
     * Outputs: None.
     */
    public AVLTree() {
        Root = null;
    }
    
    /** Function: AVLTree
     * Author: Daniel Tripp
     * Description: 1 arg constructor. Sets Data field.
     * Inputs: Data.
     * Outputs: None.
     */
    public AVLTree(T d) {
        this.Root = new AVLNode<T>(d);
    }
    

    /** Function: BinaryTree
     * Author: Daniel Tripp
     * Description:
     * Inputs: None.
     * Outputs: None.
     */
    protected static class AVLNode<T> {// extends Node<T>{
        public T Data;
        public AVLNode<T> left;
        public AVLNode<T> right;
        public int height;
        public int count;
        public AVLNode(T d, AVLNode<T> r, AVLNode<T> l) {
            this.left = l;
            this.right = r;
            this.Data = d;
            this.height = 0;
            this.count = 1;
        }
        
        /** Function: AVLTree
        * Author: Daniel Tripp
         * Description: Default constructor. Sets all values to null.
         * Inputs: None.
         * Outputs: None.
         */
        public AVLNode() {
            this(null, null, null);
        }
        
        /** Function: AVLTree
        * Author: Daniel Tripp
        * Description: 1 arg constructor. Sets Data field.
        * Inputs: Data.
        * Outputs: None.
        */
        public AVLNode(T d) {
            this(d, null, null);
        }
        
      /** Function: toString
        * Author: Daniel Tripp
        * Description: Allow for display of tree data.
       * Inputs: None.
       * Outputs: String as described above.
       */
        //@Override
        public String toString() {
            String str = "";
            str += this.Data;
            return str;
        }
    }
    
    /** Function: height
     * Author: Daniel Tripp
     * Description: Returns height of the tree.
     * Inputs: None.
     * Outputs: Int - height.
     */
    public int height() {
        return height(Root);
    }
    
    /** Function: height
     * Author: Daniel Tripp
     * Description: A public interface to a private method. Returns height of
     * the tree.
     * Inputs: None.
     * Outputs: Int - height.
     */
    public int height(AVLNode<T> n) {
        return (n == null) ? -1 : n.height;
    }
    
    /** Function: AVLinsert
     * Author: Daniel Tripp
     * Description: A public interface to a private method. Inserts the specified
     * data into the tree in the appropriate location.
     * Inputs: Data to insert.
     * Outputs: None.
     */
    public void AVLinsert(T d) {
        Root = AVLinsert(d, Root);
    }
    
    /** Function: AVLinsert
     * Author: Daniel Tripp
     * Description: Insert the specified data into the tree in the appropriate
     * location. A recursive method
     * Inputs: Value to insert, root node.
     * Outputs: None.
     */
    private AVLNode<T> AVLinsert(T d, AVLNode<T> n) {
        if (n == null)
            return new AVLNode<>(d);
        int comparison = d.compareTo(n.Data);
        if (comparison < 0 )
            n.left = AVLinsert(d, n.left);
        else if (comparison > 0)
            n.right = AVLinsert(d, n.right);
        
        if (comparison == 0)
            n.count++; //duplicate count
        return balance(n);
    }
    
    /** Function: AVLremove
     * Author: Daniel Tripp
     * Description: A public interface to the private method. Removes the
     * specified value from the tree.
     * Inputs: Value to search and remove
     * Outputs: None.
     */
    public void AVLremove(T d) {
        Root = remove(d, Root);
    }

    /** Function: remove
     * Author: Daniel Tripp
     * Description: This function recursively searches for the specified node
     * and removes if from the tree.
     * Inputs: Value to remove, Root node.
     * Outputs: Root of the new tree.
     */
    private AVLNode<T> remove(T d, AVLNode<T> n) {
        if (n == null )
            return n;
        int comparison = d.compareTo(n.Data);
        if( comparison < 0 )
            n.left = remove( d, n.left );
        else if( comparison > 0)
            n.right = remove( d, n.right );
        else if( n.left != null && n.right != null )
        {
            n.Data = this.findMin(n.right).Data;
            n.right = remove( n.Data, n.right );
        }
        else
            n = ( n.left != null ) ? n.left : n.right;
        return balance( n ); 
    }
    
    /** Function: findMin
     * Author: Daniel Tripp
     * Description: Finds and returns the smallest value in the tree.
     * Inputs: Root node.
     * Outputs: Min value.
     */
    private AVLNode<T> findMin( AVLNode<T> n ) {
        if (n == null )
            return n;
        while (n.left != null)
            n = n.left;
        return n;
    }
    
    /** Function: findMax
     * Author: Daniel Tripp
     * Description: Finds and returns the largest value in the tree.
     * Inputs: Root node.
     * Outputs: Max value.
     */
    private AVLNode<T> findMax( AVLNode<T> n ) {
    if (n == null )
        return n;
    while (n.right != null)
        n = n.right;
    return n;
    }
    
    /** Function: findMin
     * Author: Daniel Tripp
     * Description: A public interface to a private method. Finds and returns
     * smallest value in the tree.
     * Inputs: None.
     * Outputs: Min value.
     */
    public T findMin() {
        return findMin( Root ).Data;
    }
    
    /** Function: findMax
     * Author: Daniel Tripp
     * Description: A public interface to the private method. Finds and returns
     * the largest value in the tree.
     * Inputs: None.
     * Outputs: Max value.
     */
    public T findMax() {
        return findMax( Root ).Data;
    }
    
    /** Function: balance
     * Author: Daniel Tripp
     * Description: Method balances the tree by performing rotations as 
     * appropriate. Returns the root of the balanced tree.
     * Inputs: AVLNode to balance.
     * Outputs: Root of balanced tree.
     */
    protected AVLNode<T> balance(AVLNode<T> t) {
        if (t == null )
            return t;
        if( height( t.left ) - height( t.right ) > ALLOWED_IMBALANCE )
            if( height( t.left.left ) >= height( t.left.right ) )
                t = rotateWithLeftChild( t );
            else
                t = doubleWithLeftChild( t );
        else
        if( height( t.right ) - height( t.left ) > ALLOWED_IMBALANCE )
            if( height( t.right.right ) >= height( t.right.left ) )
                t = rotateWithRightChild( t );
            else
                t = doubleWithRightChild( t );

        t.height = Math.max( height( t.left ), height( t.right ) ) + 1;
        return t;
    }
    
    /** Function: checkBalance
     * Author: Daniel Tripp
     * Description: Ensures that Tree is balanced. If tree is not balanced, 
     * output a message "Tree is not balanced."
     * Inputs: None.
     * Outputs: int - height of node .
     */
    private int checkBalance ( AVLNode<T> n ) {
        if( n == null )
            return -1;
        
        else if( n != null )
        {
            int hl = checkBalance( n.left );
            int hr = checkBalance( n.right );
            if( Math.abs( height( n.left ) - height( n.right ) ) > 1 ||
                    height( n.left ) != hl || height( n.right ) != hr )
                System.out.println( "Tree is not balanced." );
        }
        return height( n );
    }
    
    /** Function: checkBalance
     * Author: Daniel Tripp
     * Description: A public interface to private method which checks if the
     * AVLTree is in compliance with balance rules.
     * Inputs: None.
     * Outputs: None.
     */
    public void checkBalance() {
        checkBalance( Root );
    }
    
    /** Function: rotateWithLeftChild
     * Author: Dr. Glenn Stevenson
     * Description: Rotate AVL Tree Node with left child.
     * Inputs: Node.
     * Outputs: Node.
     */
    private AVLNode<T> rotateWithLeftChild(AVLNode<T> k2) {
        AVLNode<T> k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        k2.height = Math.max( height( k2.left ), height( k2.right ) ) + 1;
        k1.height = Math.max( height( k1.left ), k2.height ) + 1;
        return k1;
    }
    
    /** Function: rotateWithRightChild
     * Author: Dr. Glenn Stevenson
     * Description: Rotate AVL Tree Node with right child.
     * Inputs: Node.
     * Outputs: Node.
     */
    private AVLNode<T> rotateWithRightChild(AVLNode<T> k1) {
        AVLNode<T> k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;
        k1.height = Math.max( height( k1.left ), height( k1.right ) ) + 1;
        k2.height = Math.max( height( k2.right ), k1.height ) + 1;
        return k2;
    }
    
    /** Function: doubleWithLeftChild
     * Author: Dr. Glenn Stevenson
     * Description: Double rotate AVL Tree Node
     * Inputs: Node.
     * Outputs: Node.
     */
    private AVLNode<T> doubleWithLeftChild(AVLNode<T> k3) {
        k3.left = rotateWithRightChild( k3.left );
        return rotateWithLeftChild( k3 );
    }
    
    /** Function: doubleWithRightChild
     * Author: Dr. Glenn Stevenson
     * Description: Double rotate AVL Tree Node
     * Inputs: Node.
     * Outputs: Node.
     */
    private AVLNode<T> doubleWithRightChild(AVLNode<T> k1) {
        k1.right = rotateWithLeftChild( k1.right );
        return rotateWithRightChild( k1 );
    }
    
    /** Function: printTree
     * Author: Daniel Tripp
     * Description: In-order traversal of tree, printing the data of each node.
     * Inputs: Node to start printing from.
     * Outputs: None.
     */
    private void printTree(AVLNode<T> n) {
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
    
    /** Function: AVLcontains
     * Author: Daniel Tripp
     * Description: A public interface to the private method. Checks if specified
     * data is in the tree.
     * Inputs: Data to search.
     * Outputs: boolean indicating is data is in tree.
     */
    public boolean AVLcontains(T d) {
        return this.AVLcontains(d, Root);
    }
    
    /** Function: AVLcontains
     * Author: Daniel Tripp
     * Description: Recursive method determines specified data is in the tree.
     * Inputs: Data to search, root node.
     * Outputs: boolean indicating is data is contained in tree.
     */
    private boolean AVLcontains(T d, AVLNode<T> n) {
        if (n == null)
            return false;
        int comparison = d.compareTo( n.Data );
        if ( comparison < 0 )
            return AVLcontains(d, n.left);
        else if ( comparison > 0 )
            return AVLcontains(d, n.right);
        else
            return true;    
    }
}
