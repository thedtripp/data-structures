package project_02_generics_templates;
import java.util.ArrayList; // import the ArrayList class
/** The PairList class is  a derivative of the ArrayList. It has added
 * functionality, which makes it adept in storing and managing Objects of
 * the Pair class. Methods are described below.
 *
 * @author danieltripp
 */
//public class PairList extends java.util.ArrayList{
public class PairList <F extends Comparable<F>, S extends Comparable <S>>
    extends java.util.ArrayList {
    
    private ArrayList<Pair> pairs = new ArrayList<Pair>();
    
    
    /** Function: toString
     * Author: Daniel Tripp
     * Description: Formats and prints the data stored in the PairList object
     * in a human readable format. I decided to override the toString method
     * because, I think every object should have a working toString method.
     * Inputs: None.
     * Outputs: A String as described above.
     */
    @Override
    public String toString() {
        String str = "";
        for (Pair p: pairs) {
            str += "( " + p.getFirst() + ", " + p.getSecond() + " )  ";
        } return str.trim();
    }
    
    /** Function: printList
     * Author: Daniel Tripp
     * Description: Function is the same as toString method. It actually calls
     * the toString method.
     * Inputs: None.
     * Outputs: A String as described above.
     */
    public String printList() {
        return this.toString();
    }
    
    /** Function: addPair
     * Author: Daniel Tripp
     * Description: This function allows for addition of a Pair to the 
     * PairList. Pair is specified by first and second values. The function
     * constructs a new Pair, and uses the ArrayList add method to append to
     * PairList.
     * Inputs: F first, S second.
     * Outputs: None.
     */
    public void addPair (F first, S second) {
        Pair <F, S> p = new Pair <F, S> (first, second);
        pairs.add(p);
    }
    
    /** Function: getFirst
     * Author: Daniel Tripp
     * Description: Linear searches the PairList for the second value and returns
     * the first value in the pair. If the value is not found, return -1.
     * Inputs: S second
     * Outputs: F first value associated with the specified second value
     */
    public Comparable<F> getFirst(S second) {
        for (int i = 0; i < pairs.size(); i ++) {
            if (pairs.get(i).getSecond().equals(second)) {
                //System.out.println("Mathch found: " + pairs.get(i).getFirst() + ": " + pairs.get(i).getSecond());
                return pairs.get(i).getFirst();
            }
        }
        Pair <Integer, Integer> p = new Pair <Integer, Integer> (-1, -1);
        //return p.getFirst();
        //System.out.println(second.toString() + ": Entry not found. Code: " + (Comparable<F>)p.getFirst());
        return (Comparable<F>)p.getFirst();
    }

    /** Function: getSecond
     * Author: Daniel Tripp
     * Description: Linear searches the PairList for the first value and returns
     * the second value in the pair. If the value is not found, return -1.
     * Inputs: F first
     * Outputs: S second value associated with the specified first value
     */
    public Comparable<S> getSecond(F first) {
        for (int i = 0; i < pairs.size(); i ++) {
            if (pairs.get(i).getFirst().equals(first)) {
                return pairs.get(i).getSecond();
            }
        }
        Pair <Integer, Integer> p = new Pair <Integer, Integer> (-1, -1);
        //System.out.println(first.toString() + ": Entry not found. Code: " + (Comparable<F>)p.getSecond());
        return (Comparable<S>)p.getSecond();
    }
    
    /** Function: contains
     * Author: Daniel Tripp
     * Description: Determines whether a Pair is in the PairList. It calls the
     * indexOf method and returns a boolean based on whether that method 
     * found the pair.
     * Inputs: first and second values to search for.
     * Outputs: boolean indicating whether the Pair was found.
     */
    public boolean contains(F first, S second) {
        if (this.indexOf(first, second) >= 0) {
            return true;
        }
        return false;
    }
    
    /** Function: indexOf
     * Author: Daniel Tripp
     * Description: Linear searches the PairList for the first value and
     * second value in the pair. If value if found, returns the index of the
     * value. If the value is not found, return -1.
     * Inputs: first and second values to search for.
     * Outputs: Integer index of the value or -1 if not found.
     */
    public int indexOf(F first, S second) {
        for (int i = 0; i < pairs.size(); i ++) {
            if(pairs.get(i).getFirst().equals(first) && pairs.get(i).getSecond().equals(second)) {
                return i;
            }
        }
        return -1;
    }
    
    /** Function: deletePair
     * Author: Daniel Tripp
     * Description: Calls indexOf method which linear searches for the desired
     * element. If found, call remove method from ArrayList to delete the pair.
     * If not found, display a message.
     * Inputs: first and second values to search and delete.
     * Outputs: None, or error message.
     */
    public void deletePair(F first, S second) {
        int position = this.indexOf(first, second);
        if (position >= 0 && position < pairs.size()) {
            pairs.remove(position);
        } else {
            System.out.println("Cannot delete. Element not found.");
        } 
    }
}