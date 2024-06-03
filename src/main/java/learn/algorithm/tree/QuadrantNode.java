package learn.algorithm.tree;

/**
 * @description:
 * @author: daixulin
 * @date:  2024-06-03 14:18
 * @version V1.0
 */
public class QuadrantNode<T> {
    T data;  
    QuadrantNode<T> up;  
    QuadrantNode<T> down;  
    QuadrantNode<T> left;  
    QuadrantNode<T> right;  
  
    public QuadrantNode(T data) {  
        this.data = data;  
        this.up = null;  
        this.down = null;  
        this.left = null;  
        this.right = null;  
    }  
}