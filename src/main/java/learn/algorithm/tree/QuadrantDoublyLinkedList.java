package learn.algorithm.tree;

public class QuadrantDoublyLinkedList<T> {
  
    // 辅助函数：用于在给定节点和值的情况下创建并链接一个新节点  
    private QuadrantNode<T> createAndLinkNode(QuadrantNode<T> current, QuadrantNode<T> newNode, Direction direction) {  
        switch (direction) {  
            case UP:  
                if (current.up == null) {  
                    current.up = newNode;  
                    newNode.down = current;  
                }  
                break;  
            case DOWN:  
                if (current.down == null) {  
                    current.down = newNode;  
                    newNode.up = current;  
                }  
                break;  
            case LEFT:  
                if (current.left == null) {  
                    current.left = newNode;  
                    newNode.right = current;  
                }  
                break;  
            case RIGHT:  
                if (current.right == null) {  
                    current.right = newNode;  
                    newNode.left = current;  
                }  
                break;  
            default:  
                throw new IllegalArgumentException("Invalid direction");  
        }  
        return newNode;  
    }  
  
    // 枚举类型用于表示方向  
    enum Direction {  
        UP, DOWN, LEFT, RIGHT  
    }  
  
    // 生成n x n的多维四向链表  
    public QuadrantNode<T> generateQuadrantGrid(int n, T initialValue) {  
        if (n <= 0) {  
            throw new IllegalArgumentException("n must be a positive integer");  
        }  
  
        QuadrantNode<T>[][] grid = new QuadrantNode[n][n];  
  
        // 初始化网格  
        for (int i = 0; i < n; i++) {  
            for (int j = 0; j < n; j++) {  
                grid[i][j] = new QuadrantNode<>(initialValue);  
            }  
        }  
  
        // 链接节点  
        for (int i = 0; i < n; i++) {  
            for (int j = 0; j < n; j++) {  
                QuadrantNode<T> current = grid[i][j];  
  
                // 上  
                if (i > 0) {  
                    createAndLinkNode(current, grid[i - 1][j], Direction.UP);  
                }  
                // 下  
                if (i < n - 1) {  
                    createAndLinkNode(current, grid[i + 1][j], Direction.DOWN);  
                }  
                // 左  
                if (j > 0) {  
                    createAndLinkNode(current, grid[i][j - 1], Direction.LEFT);  
                }  
                // 右  
                if (j < n - 1) {  
                    createAndLinkNode(current, grid[i][j + 1], Direction.RIGHT);  
                }  
            }  
        }  
  
        // 返回左上角的节点作为入口点  
        return grid[0][0];  
    }  
  
    // 示例主函数  
    public static void main(String[] args) {  
        QuadrantDoublyLinkedList<Integer> qdll = new QuadrantDoublyLinkedList<>();  
        QuadrantNode<Integer> root = qdll.generateQuadrantGrid(5, 0); // 创建一个5x5的网格，初始值为0  
        System.out.println(root);
        // 这里可以添加遍历网格的代码来验证结果  
    }  
}