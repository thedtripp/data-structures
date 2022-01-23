/*
 * @author danieltripp
 * This is the Char class. It functions like a wrapper class for the char
 * data type. It has several constructors, mutators, and accessors described
 * below.
 */
package pkgchar;
import pkgchar.CharException;


public final class Char {

    private char data;
   
   /**
    * Char class Constructors
    */
    
    /* Function: Char
    *  Author: Daniel Tripp
    *  Description: This is a no arg constructor.
    *  Inputs: None
    *  Outputs: Char object
    */
    public Char() {
        this(0);
    }
    
    /* Function: Char
    *  Author: Daniel Tripp
    *  Description: This is a single arg constructor.
    *  Inputs: A character
    *  Outputs: Char object
    */
    public Char(char c) {
        this.equals(c);
    }
    
    /* Function: Char
    *  Author: Daniel Tripp
    *  Description: This is a single arg constructor.
    *  Inputs: An integer
    *  Outputs: Char object
    */
    public Char(int c) {
        this((char)c);
    }
    
    /* Function: Char
    *  Author: Daniel Tripp
    *  Description: This is a single arg constructor.
    *  Inputs: A Char
    *  Outputs: Char object
    */
    public Char(final Char c) {
        this.equals(c.toChar());
    }
    
    /* Function: Char
    *  Author: Daniel Tripp
    *  Description: This is a single arg constructor.
    *  Inputs: A String
    *  Outputs: Char object containing the first character of the input String
    */
    public Char(String c) {
        this.equals(c.charAt(0));
    }
    
    
    /* Function: equals
    *  Author: Daniel Tripp
    *  Description: Sets the value of the character to the value of the argument
    *  Inputs: A Char
    *  Outputs: None.
    */
    public void equals(final Char c) throws CharException {
        if (c.toInt() < 32 || c.toInt() > 127) {
            throw new CharException();
        } else {
        this.equals(c.toChar());
        }
    }
    
    /* Function: equals
    *  Author: Daniel Tripp
    *  Description: Sets the value of the character to the value of the argument
    *  Inputs: A character
    *  Outputs: None.
    */
    public void equals(char c) {
        this.data = c;
    }
    
    /* Function: equals
    *  Author: Daniel Tripp
    *  Description: Sets the value of the character to the value of the argument
    *  Inputs: An integer
    *  Outputs: None.
    */
    public void equals(int c) {
        this.equals((char)c);
    }
    

    /* Function: toChar
    *  Author: Daniel Tripp
    *  Description: Gets the value of the Char and returns it as a character
    *  Inputs: None.
    *  Outputs: The value of the Char as a character.
    */
    public char toChar() {
        return this.data;
    }
    
    /* Function: toInt
    *  Author: Daniel Tripp
    *  Description: Gets the value of the Char and returns it as an integer
    *  Inputs: None.
    *  Outputs: The value of the Char as a integer.
    */
    public int toInt() {
        return Character.getNumericValue(this.data);
    }
    
    /* Function: toString
    *  Author: Daniel Tripp
    *  Description: Gets the value of the Char and returns it as a String
    *  Inputs: None.
    *  Outputs: The value of the Char as a String.
    */
    @Override
    public String toString() {
        return String.valueOf(this.data);
    }
    
    /* Function: toHexString
    *  Author: Daniel Tripp
    *  Description: Gets the value of the Char and returns it as a String
    *  representation of hexidecimal
    *  Inputs: None.
    *  Outputs: The value of the Char as a hexidecimal.
    */
    public String toHexString() {
        return Integer.toHexString(Character.getNumericValue(this.data));
    }
    
    
    /* Function: add
    *  Author: Daniel Tripp
    *  Description: Appends the character argument to the value of the char
    *  and returns the result as a String
    *  Inputs: Character
    *  Outputs: String with the value of the calling object and the parameter
    */
    public String add(char c) {
        String str = "";
        str += this.data;
        str += c;
        return str;
    }
    
    /* Function: add
    *  Author: Daniel Tripp
    *  Description: Appends the value of the Char argument to the value of 
    *  the char and returns the result as a String
    *  Inputs: Char
    *  Outputs: String with the value of the calling object and the parameter
    */
    public String add(final Char c) {
        return this.add(c.toChar());
    }
}
