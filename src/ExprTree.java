
package assignment3;

import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author George
 */
public class ExprTree {
    protected String expression;
    protected TreeNode root;
    
    Scanner scan = new Scanner(System.in);
    
    /**
    * Constructor.  Creates a new expression
    * @param postfix expression to evaluate
    */
    public ExprTree(String postfix){
        expression = postfix;
        root = null;
    }
    
    /**
     * Constructor.  Creates a new expression via scanned input
     */
    public ExprTree(){
        System.out.println((char)27 + "[37;44mPlease enter postfix expression: " 
                        + (char)27 + "[0m");
        expression = scan.nextLine();        
        
        System.out.println("You have entered the postfix expression: " 
                        + expression + "\n");
    }
    
    
    /**
    * Checks if symbol is an operator
    * @param x symbol to evaluate
    * @return true if operator, otherwise false
    */
    public boolean isStrOperator(String x){
        return(x.equals("+") || 
                x.equals("-") || 
                x.equals("*") || 
                x.equals("/") );
    }
    
    /**
     * Creates an expression tree from a postfix expression.
     * 1)  Parses a String expression into a String[]
     * 2)  Iterates through the String[]
     * 3)  If [i] is a number, push the number onto a Stack<TreeNode>
     * 4)  If [i] is an operator, create an expression tree out of the
     *      previous two number TreeNode
     * 5)  At end of iteration, an entire expression tree is created
     * @param expression postfix expression
     */
    public void createExprTree(String expression){
        Stack<TreeNode> nodeStack = new Stack<TreeNode>();
        
        String[] expressionArray = expression.split("\\s+");
        
        for(int i = 0; i < expressionArray.length; i++){
            String symbol = expressionArray[i];
            
            if (isStrOperator(symbol)){
                TreeNode right = nodeStack.pop();
                TreeNode left = nodeStack.pop();
                nodeStack.push( new TreeNode(symbol, left, right));
            } 
            else{
                nodeStack.push(new TreeNode (symbol, null, null));
                }
        }
        root = nodeStack.pop();
    }
    
    
    /**
     * Evaluates an expression between two operands and one operator
     * @param operator Operator used between operands
     * @param operand1 First operand
     * @param operand2 Second operand
     * @return answer The calculated result
     */
    public static double compute(String operator, double operand1, double operand2){
        double answer = 0;
        
        switch(operator){
            case "+": answer = operand1 + operand2; break;
            case "-": answer = operand1 - operand2; break;
            case "*": answer = operand1 * operand2; break;  
            case "/": answer = operand1 / operand2; break;
        }
        return answer;
    }
    
    /**
     * Recursively evaluates an entire Expression Tree
     * 1)  Returns 0 if the expression tree is empty
     * 2)  Recursively evaluates the left tree, right tree, and compute()
     *      using the root node operator and operands of the evaluated 
     *      left and right tree
     * 3)  If the node is a branch, compute the value of the branch
     * 4)  If the node is a leaf, return the value of the leaf
     * @param root Root node of Expression Tree to evaluate
     * @return The calculation of the entire expression tree
     */
    public double evaluateExpression(TreeNode root){
        double operand1, operand2, answer = 0;
        String operator;
        
        if (root == null) {
            answer = 0;
        }
        else if (root.isLeaf()){
            answer = Double.parseDouble(root.data);
            System.out.println("Leaf: " + answer);
        }
        else if ( root.right.isLeaf() && root.left.isLeaf() ){
            operator = root.data;
            operand1 = Double.parseDouble(root.left.data);
            operand2 = Double.parseDouble(root.right.data);
            System.out.println("Branch: " + compute(operator, operand1, operand2));
            answer = compute(operator, operand1, operand2);
        }
        else{
            operand1 = evaluateExpression(root.left);
            operand2 = evaluateExpression(root.right);
            answer = compute(root.data, operand1, operand2);
        }
        return answer;
    }
    
}
