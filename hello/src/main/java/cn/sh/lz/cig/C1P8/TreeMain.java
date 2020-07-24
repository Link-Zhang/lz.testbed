package cn.sh.lz.cig.C1P8;

/***
 * @author Link
 * @date 2020/07/23
 * @time 12:13
 */
public class TreeMain {
    public static void main(String[] args) {
        Tree tree = new Tree();
        int[] arr = new int[]{3, 4, 5, 1, 2};
        TreeNode root;
        root = tree.getMaxTree(arr);
        tree.print(root);
        tree.preOrder(root);
        System.out.println();
        tree.inOrder(root);
        System.out.println();
        tree.postOrder(root);
        System.out.println();
        tree.levelTraverse(root);
        System.out.println();
        System.out.println(tree.getDepth(root));
        System.out.println(tree.getWidth(root));
        System.out.println(tree.getNodeNumber(root));
        System.out.println(tree.getLeafNodeNumber(root));

        root = tree.getMinTree(arr);
        tree.print(root);
    }
}
