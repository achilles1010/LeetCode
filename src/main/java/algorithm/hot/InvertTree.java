package algorithm.hot;


import algorithm.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 汉明问题
 *
 * @author daixulin
 * @version : v1.0
 * @date 2020 -07-02 1:59 下午 周四
 */
public class InvertTree {
    public static TreeNode invertV1(TreeNode node) {
        //递归函数的终止条件，节点为空时返回
        if (node == null) {
            return null;
        }

        //下面三句是将当前节点的左右子树交换
        TreeNode tmp = node.getRight();
        node.setRight(node.getLeft());
        node.setLeft(node.getRight());

        //递归交换当前节点的 左子树
        invertV1(node.getLeft());
        //递归交换当前节点的 右子树
        invertV1(node.getRight());
        return node;
    }

    public static TreeNode invertV2(TreeNode node) {
        if (node == null) {
            return null;
        }

        //将二叉树中的节点逐层放入队列中，再迭代处理队列中的元素
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            //每次都从队列中拿一个节点，并交换这个节点的左右子树
            TreeNode current = queue.poll();
            TreeNode temp = current.getLeft();
            current.setLeft(current.getRight());
            current.setRight(temp);

            //如果当前节点的左子树不为空，则放入队列等待后续处理
            if (current.getLeft() != null) {
                queue.add(current.getLeft());
            }

            //如果当前节点的右子树不为空，则放入队列等待后续处理
            if (current.getRight() != null) {
                queue.add(current.getRight());
            }
        }

        return node;
    }

    public static void main(String[] args) {
        TreeNode x = new TreeNode(1);
        x.setLeft(new TreeNode(2));
        x.setRight(new TreeNode(3));
        x.getLeft().setLeft(new TreeNode(4));
        System.out.println(x);
//        System.out.println(invertV1(x));
        System.out.println(invertV2(x));
    }
}
