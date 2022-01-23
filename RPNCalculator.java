package project4_doubly_linked_lists;

/**
 * This is Reverse Polish Notation Calculator. It takes a postfix expression 
 * and outputs the result of the calculation.
 * @author danieltripp
 */
public class RPNCalculator {
    
    /** Function: RPNCalculator
     * Author: Daniel Tripp
     * Description: This is the default constructor. It calls the solve method
     * on the String input.
     * Inputs: String expression to be evaluated.
     * Outputs: an integer result of the calculation.
     */
    public RPNCalculator(String input) {
        this.solve(input);
    }
    
    /** Function: stripWiteSpace
     * Author: Daniel Tripp
     * Description: This simple function strips whitespace from the input.
     * Inputs: String expression.
     * Outputs: expression with no whitespace.
     */
    public String stripWhiteSpace(String input) {
        return input.replaceAll("\\s+","");
    }

    /** Function: solve
     * Author: Daniel Tripp
     * Description: This method parses the string and attempts to calculate 
     * the expression using a stack to track the intermediate calculations.
     * Inputs: String expression to evaluate.
     * Outputs: int result of calculations
     */
    public int solve(String input) {
    //public int postfixEval(String input) {
        MyStack<Integer> ms = new MyStack();
        //ms.printList();
        int solution = 0;
        String str = stripWhiteSpace(input);
        
        //iterate through string expression
        for (int i = 0; i < str.length(); i ++) {
            
            //if digit, push to stack
            if (Character.isDigit(str.charAt(i))) {
                String num = "" + str.charAt(i);
                int digit = Integer.parseInt(num);
                ms.push(digit);
            }
            //if valid operator, evaluate
            if (str.charAt(i) == '+' || str.charAt(i) == '-' || str.charAt(i) == '*' || str.charAt(i) == '/' ) {
                int result = 0;
                int op1 = (int) ms.pop();
                int op2 = (int) ms.pop();
                if (str.charAt(i) == '+') {
                    result = op2 + op1;
                }
                if (str.charAt(i) == '-') {
                    result = op2 - op1;
                }
                if (str.charAt(i) == '*') {
                    result = op2 * op1;
                }
                if (str.charAt(i) == '/') {
                    result = op2 / op1;
                }

                ms.push(result);
            }
            //ms.printList();
            
            //System.out.println(ms.peek());
            solution = ms.peek();

        }
        return solution;
    }
}
