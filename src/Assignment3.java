package assignment3;

/**
 *
 * @author George
 * @since 11/20/2016
 */
public class Assignment3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // read postfix expression into tree1.expression
       ExprTree tree1 = new ExprTree();
       
       // create an expression tree from tree1, stored in tree1.root
       tree1.createExprTree(tree1.expression);
       
       // Evaluate expression tree held in root
       System.out.println(tree1.expression + " = " 
               + tree1.evaluateExpression(tree1.root) + "\n");
       
       // Create second expression tree
       ExprTree tree2 = new ExprTree();
       tree2.createExprTree(tree2.expression);
       System.out.println(tree2.expression + " = " 
               + tree2.evaluateExpression(tree2.root) + "\n");
       
       // Create third expression tree
       ExprTree tree3 = new ExprTree();
       tree3.createExprTree(tree3.expression);
       System.out.println(tree3.expression + " = " 
               + tree3.evaluateExpression(tree3.root) + "\n");
    }
    
}
