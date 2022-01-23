package project_02_generics_templates;
import java.util.Comparator;
/**
 * Pair class
 * @author danieltripp
 * This class allows storage of pairs of values. It contains constructors,
 * mutators, and accessors as described below.
 */
public class Pair <F extends Comparable<F>, S extends Comparable <S>>
    implements Comparable <Pair<F, S>>{
    
    /** Function: compareTo
     * Author: Dr. Glenn Stevenson
     * Description: Overriding the compareTo method from the Comparable class
     * to ensure accurate comparisons of the elements. Compares the calling
     * object to another pair.
     * Inputs: first and second values of the Pair to be compared.
     * Outputs: an integer indicating whether the pairs are equal or not.
     */
    @Override
    public int compareTo(Pair<F, S> p) {
        int cmp = this.getFirst().compareTo(p.getFirst());
        if(cmp == 0) {
            cmp = this.getSecond().compareTo(p.getSecond());
        }
        return cmp;
    }
    
    private F first;
    private S second;
    
     /** Function: Pair
     * Author: Daniel Tripp
     * Description: Working constructor which instantiates a pair object from parameters
     * x and y. These generics can be of any complex type.
     * Inputs: first and second values to be stored in Pair object
     * Outputs: None.
     */
    public Pair(F x, S y) {
        this.setFirst(x);
        this.setSecond(y);
        
    }

    /** Function: getFirst
     * Author: Daniel Tripp
     * Description: An accessor method which returns private member data, first.
     * Inputs: None.
     * Outputs: Value of private variable first.
     */
    public F getFirst() {
        return this.first;
    }
    
    
     /** Function: getSecond
     * Author: Daniel Tripp
     * Description: An accessor method that returns private member data, second.
     * Inputs: None.
     * Outputs: Value of private variable second.
     */
    public S getSecond() {
        return this.second;
    }
    
    /** Function: setFirst
     * Author: Daniel Tripp
     * Description: A mutator method which modifies private member data, first.
     * Inputs: Value to set first to.
     * Outputs: None.
     */
    public void setFirst(F first) {
        this.first = first;
    }
    
    /** Function: setSecond
     * Author: Daniel Tripp
     * Description: A mutator method which modifies private member data, second.
     * Inputs: Value to set second to.
     * Outputs: None.
     */
    public void setSecond(S second) {
        this.second = second;
    }
    
    /** Function: toString
     * Author: Daniel Tripp
     * Description: Formats and prints the data stored in the Pair object in 
     * Human readable format.
     * Inputs: None.
     * Outputs: A String as described above.
     */
    @Override
    public String toString() {
        return "" + this.getFirst() + ", " + this.getSecond();
    }
}
