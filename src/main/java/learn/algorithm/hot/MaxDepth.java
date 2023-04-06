package learn.algorithm.hot;

import learn.algorithm.tree.TreeNode;
import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author daixulin
 * @version : v1.0
 * @date 2020-07-06 11:11 上午 周一
 */
public class MaxDepth {
    public static int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        } else {
            int left = dfs(node.getLeft());
            int right = dfs(node.getRight());
            return Math.max(left, right) + 1;
        }
    }

    public static int dfsV2(TreeNode node) {
        Queue<Pair<TreeNode, Integer>> stack = new LinkedList<>();
        if (node != null) {
            stack.add(new Pair<>(node, 1));
        }

        int depth = 0;
        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> current = stack.poll();
            node = current.getKey();
            int currentDepth = current.getValue();
            if (node != null) {
                depth = Math.max(depth, currentDepth);
                stack.add(new Pair<>(node.getLeft(), currentDepth + 1));
                stack.add(new Pair<>(node.getRight(), currentDepth + 1));
            }
        }

        return depth;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.setLeft(new TreeNode(2));
        root.setRight(new TreeNode(3));
        root.getLeft().setLeft(new TreeNode(4));

        System.out.println(dfs(root));
        System.out.println(dfsV2(root));
    }
}
