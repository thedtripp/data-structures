package project9_final;

/**
 * This Palindrome checker class can determine if a String is a palindrome. 
 * It uses a stack and a queue. Algorithm provided by Dr. Glenn Stevenson.
 */
public class PalindromeChecker {
    
    private MyStack ms = new MyStack();
    private MyQueue mq = new MyQueue();
    
    /** Function: check
     * Author: Daniel Tripp
     * Description: This method checks is a string is a palindrome.
     * The algorithm is as follows: 1. enqueue and push each character into the 
     * queue and stack. 2. pop and dequeue each character and compare them.
     * 3. if queue and stack are empty and all characters are the same, return 
     * true. 4. if two characters don't match, return false. Recommend using 
     * in conjunction with format method below.
     * Inputs: String.
     * Outputs: Boolean indicating whether String is a palindrome.
     */
    public boolean check(String data) {
        ms.clearList();
        mq.clearList();
        char[] ch = data.toCharArray();
        for (char c : ch) {
            ms.push(c);
            mq.enqueue(c);
        }
        while (ms.getSize() > 0 && mq.getSize() > 0) {
            if (!ms.pop().equals(mq.dequeue())) {
                return false;
            }
        }
        return true;
    }
    
    /** Function: format
     * Author: Daniel Tripp
     * Description: Strips punctuation and whitespace from a String. Converts
     * all characters to lowercase. Based on code from tutorialspoint.com 
     * and stckoverflow.com
     * Inputs: String.
     * Outputs: String formatted as described above
     */
    public String format(String line) {
        String word = "";
        word = line.toLowerCase().replaceAll("\\s+", "").replaceAll("[^a-zA-Z]", "");
        return word;
    }
}
