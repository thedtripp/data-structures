package project5_trees;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author danieltripp
 */
public class WordCount<T> {
    
    WCTree<String> wcTree = new WCTree<>();
    
    protected static class WCTree <T extends Comparable<? super T>> extends AVLTree {
    
    /** Function: printTree
     * Author: Daniel Tripp
     * Description: In-order traversal of tree, printing the Data of each Node.
     * Inputs: Node to start printing from.
     * Outputs: None.
     */
        private void printTree(AVLNode<T> n) {
            if ( this.Root == null )
                System.out.println("Empty tree.");
            if ( n != null) {
                this.printTree(n.left);
                System.out.println(n.Data + " - " + n.count);
                this.printTree(n.right);
            }
        }
    }
    
    /** Function: readFile
     * Author: Daniel Tripp
     * Description: Reads a text file. It processes the text, stripping any
     * punctuation and tokenizing the words. The words are stored in an AVL tree
     * A word count is stored, as well.
     * Inputs: String - file to process.
     * Outputs: None.
     */
    public void readFile(String filename) {
        try {
            File myFile = new File(filename);
            
            Scanner myScanner = new Scanner(myFile);
            while (myScanner.hasNextLine()) {
                String data = myScanner.nextLine();
                String[] words = data.split(" ");
                for (String str : words)
                    
                    wcTree.AVLinsert(str.replaceAll("[^a-zA-Z ]", "").toUpperCase());
            }
            wcTree.AVLremove("");
        }
        catch (FileNotFoundException e) {
            System.out.println("Error: File not found.");
            e.printStackTrace();
        }
    }
    
    /** Function: printCount
     * Author: Daniel Tripp
     * Description: Prints word count AVL tree with in order traversal. 
     * A public interface to a private method.
     * Inputs: None.
     * Outputs: Display of word count structure
     */
    public void printCount() {
        wcTree.printTree(wcTree.Root);
    }
    
    /** Function: height
     * Author: Daniel Tripp
     * Description: Public interface to the private height method.
     * Inputs: None.
     * Outputs: int - height of tree
     */
    public int height() {
        return wcTree.height();
    }
}
