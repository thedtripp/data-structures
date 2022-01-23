/*
 * @author danieltripp
 * This is the BigDecimal class. It stores Char objects in a vector and acts 
 * like the double type. It has several constructors, mutators, and accessors 
 * described below. Notably, it supports addition and subtraction with other
 * big decimal types. It has methods to convert to string and double, as well.
 */
package pkgchar;
import java.util.ArrayList;

public class BigDecimal {
    
    /**
     * Private Data
     */
    
    private ArrayList<Char> data = new ArrayList<Char>();
    
    /* Function: BigDecimal
    *  Author: Daniel Tripp
    *  Description: A no arg constructor
    *  Inputs: None.
    *  Outputs: None.
    */
    public BigDecimal() {
        
        Char ch1 = new Char('0');
        Char ch2 = new Char('.');
        Char ch3 = new Char('0');
        
        this.data.add(ch1);
        this.data.add(ch2);
        this.data.add(ch3);
    }
    
    /* Function: BigDecimal
    *  Author: Daniel Tripp
    *  Description: A constructor that takes a single String argument
    *  Inputs: A string
    *  Outputs: None.
    */
    public BigDecimal(String value) throws BigDecimalException {
        
        for (char c: value.toCharArray()) {
            if (!Character.isDigit(c) && c != '.') {
                throw new BigDecimalException("Invalid Character");
            }
            Char ch = new Char(c);
            this.data.add(ch);
        }
    }
    
    /* Function: equals
    *  Author: Daniel Tripp
    *  Description: Takes a character argument, stores it in a Char object,
    *  and appends it to the Big Decimal
    *  Inputs: A character
    *  Outputs: None.
    */
    public void equals(char ch) {
        Char chh;
        if (Character.isDigit(ch) || ch == '.') {
            chh = new Char(ch);
            this.data.add(chh);
        } else {
            System.out.println("Error: Invalid Character:" + ch);
        }   
    }
    
    /* Function: equals
    *  Author: Daniel Tripp
    *  Description: Takes a String argument, stores each character
    *  in a Char object, and appends them to the Big Decimal
    *  Inputs: A String
    *  Outputs: None.
    */
    public void equals(String value) {
        this.data.clear();
        int periodCount = 0;
        for (char c: value.toCharArray()) {
            if (c == '.') {
                periodCount ++;
            }
            if (periodCount > 1) {
                System.out.println("Too many '.'s.");
                break;
            }
            this.equals(c);
        }
        
    }
    
    /* Function: add
    *  Author: Daniel Tripp
    *  Description: Computes the sum of the calling object and the argument
    *  Inputs: A Big Decimal
    *  Outputs: Sum as a Big Decimal.
    */
    public BigDecimal add(BigDecimal b) {
        String dbl = String.valueOf(this.toDouble() + b.toDouble());
        try {
            return new BigDecimal(dbl);
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return new BigDecimal();
        }
        // FIX FLOATING POINT PRECISION ERROR
    }
    
    /* Function: sub
    *  Author: Daniel Tripp
    *  Description: Computes the difference of the calling object and
    *  the argument
    *  Inputs: A Big Decimal
    *  Outputs: Difference as a Big Decimal.
    */
    public BigDecimal sub(BigDecimal b) {
        String dbl = String.valueOf(this.toDouble() - b.toDouble());
        try {
            return new BigDecimal(dbl);
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return new BigDecimal();
        }
    }
    
    /* Function: toDouble
    *  Author: Daniel Tripp
    *  Description: Converts the calling object to double type
    *  Inputs: None.
    *  Outputs: A double representation of the calling object.
    */
    public double toDouble() {
        return Double.parseDouble(this.toString());
        // HANDLE NUMBER FORMAT EXCEPTION
    }
    
    /* Function: toString
    *  Author: Daniel Tripp
    *  Description: Converts the calling object to String type
    *  Inputs: None.
    *  Outputs: A String representation of the calling object.
    */
    public String toString() {
        String str = "";
        for (int i = 0; i < data.size(); i ++) {
            str += data.get(i).toChar();  
        }
        return str;
    }
    
    /* Function: at
    *  Author: Daniel Tripp
    *  Description: Returns the Char at a specified position in the
    *  Big Decimal
    *  Inputs: Integer.
    *  Outputs: A Char as described above
    */
    public Char at(int index) {
        return this.data.get(index);
        //CHECK IF INDEX > DATA.SIZE()
        //THROW EXCEPTION
    }
    
    /* Function: wholeNumber
    *  Author: Daniel Tripp
    *  Description: returns the integer portion of the Big Decimal
    *  Inputs: None.
    *  Outputs: An integer representation of all digits before the decimal.
    */
    public int wholeNumber() {
        return Integer.parseInt(this.toString().split("\\.")[0]);
    }
    
    /* Function: fraction
    *  Author: Daniel Tripp
    *  Description: returns the fractional portion of the Big Decimal
    *  Inputs: None.
    *  Outputs: An integer representation of all digits after the decimal.
    */
    public double fraction() {
        String str = "0.";
        str += this.toString().split("\\.")[1];
        return Double.parseDouble(str);
    }
    
}
