/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment3;

/**
 *
 * @author gnguyen34
 */
public class TreeNode<E> {
    
    public final String data;
    protected final TreeNode<E> left;
    protected final TreeNode<E> right;
    
    /**
     * Constructor.  Creates a new Binary Tree
     * @param newData, Symbol for this node to hold
     * @param newLeft, Reference to the left node
     * @param newRight, Reference to the right node
     */
    public TreeNode(String newData, TreeNode<E> newLeft, TreeNode<E> newRight){
        data = newData;
        left = newLeft;
        right = newRight;
    }
    
    /**
     * Default Constructor.  Creates a new empty Binary Tree
     */
    public TreeNode(){
        data = null;
        left = null;
        right = null;
    }
    
    /**
     * Accesses the operand or operator from this node
     * @return data Operand or operator
     */
    public String getData(){
        return data;
    }
    
    /**
     * Checks if this node is a leaf node (the very last node)
     * @return True if leaf, otherwise false
     */
    public boolean isLeaf(){
        return (left == null) && (right == null);
    }
    
    /**
     * Displays the expression tree in order
     */
    public void inorderPrint(){
        if (left != null)
            left.inorderPrint();
            
        System.out.println(data);
        
        if (right != null)
            right.inorderPrint();
    }
    
    
    /**
     * Displays an expression tree graphically, including lines and branches
     * @param depth Height of tree to display
     */
    public void print(int depth){
        // Printing indentation and data from current node
        for (int i = 1; i <= depth; i++) 
            System.out.print("    ");
        System.out.println(data);
        
        // printing left subtree or -- if there is a right child and no left child
        if (left != null){
            left.print(depth + 1);
        }
        else if (right != null) {
            for (int i = 1; i <= depth + 1; i++){
                System.out.print("    ");
            }
            System.out.println("--");
        }
        
        // printing right subtree or -- is there is a left child but not right child
        if (right != null){
            right.print(depth + 1);
        }
        else if (left != null) {
            for (int i = 1; i <= depth; i++){
                System.out.print("    ");
            }
            System.out.println("--");
        }
    }

}
