package offer.alc;

import java.util.HashMap;
import java.util.Map;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如，给出
 * 前序遍历 preorder=[3,9,20,15,7]
 * 中序遍历 inorder=[9,3,15,20,7]
 * 返回如下的二叉树：
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 限制：
 * 0 <= 节点个数 <= 5000
 * @link ：https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author daixulin
 * @version : v1.0
 * @project :LeetCode
 * @create 2021-04-22 下午2:39 周四
 */
public class BuildTree {

    private static Map<Integer, Integer> indexMap;

    /**
     * 根据前序遍历数组的 [preL, preR] 和 中序遍历数组的 [inL, inR] 重新组建二叉树
     *
     * @param preorderLeft 前序遍历数组的区间左端点
     * @param preorderRight 前序遍历数组的区间右端点
     * @param inorderLeft  中序遍历数组的区间左端点
     * @param inorderRight  中序遍历数组的区间右端点
     * @return 构建的新二叉树的根结点
     */
    public static TreeNode myBuildTree(int[] preorder, int[] inorder, int preorderLeft, int preorderRight, int inorderLeft, int inorderRight) {
        //时间复杂度：O(n)，其中 n 是树中的节点个数。
        //空间复杂度：O(n)，除去返回的答案需要的 O(n) 空间之外，我们还需要使用 O(n) 的空间存储哈希映射，以及 O(h)（其中 h 是树的高度）的空间表示递归时栈空间。这里 h<n，所以总空间复杂度为 O(n)。

        // 递归终止条件
        if (preorderLeft > preorderRight) {
            return null;
        }

        // 前序遍历中的第一个节点就是根节点位置
        int preorderRoot = preorderLeft;

        // 建立根节点
        TreeNode root = new TreeNode(preorder[preorderRoot]);

        // 获取中序遍历根节点位置 划分根节点、左子树、右子树
        int inorderRoot = indexMap.get(preorder[preorderRoot]);

        // 左子树节点数目
        int leftSubtreeSize = inorderRoot - inorderLeft;

        // 递归地构造左子树，并连接到根节点
        // 先序遍历中「从 左边界+1 开始的 leftSubtreeSize」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
        root.left = myBuildTree(preorder, inorder, preorderLeft + 1, preorderLeft + leftSubtreeSize, inorderLeft, inorderRoot - 1);
        // 递归地构造右子树，并连接到根节点
        // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
        root.right = myBuildTree(preorder, inorder, preorderLeft + leftSubtreeSize + 1, preorderRight, inorderRoot + 1, inorderRight);

        return root;
    }


    public static TreeNode build(int[] preorder, int[] inorder) {
        int n = preorder.length;
        indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            // 存放中序遍历结果
            indexMap.put(inorder[i], i);
        }
        return myBuildTree(preorder, inorder, 0, n-1, 0, n-1);
    }

    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};

        System.out.println(build(preorder, inorder));
    }
}
