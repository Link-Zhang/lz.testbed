package cn.sh.lz.cig.C1P8;

import java.util.*;

/***
 * @author Link
 * @date 2020/07/23
 * @time 11:01
 */
public class Tree {
    private void popStackAndSetMap(Stack<TreeNode> stack, HashMap<TreeNode, TreeNode> map) {
        TreeNode popTreeNode = stack.pop();
        if (stack.isEmpty()) {
            map.put(popTreeNode, null);
        } else {
            map.put(popTreeNode, stack.peek());
        }
    }

    private TreeNode buildTree(TreeNode[] nArr, boolean flag, HashMap<TreeNode, TreeNode> lMap, HashMap<TreeNode, TreeNode> rMap) {
        TreeNode root = null;
        for (int i = 0; i < nArr.length; i++) {
            TreeNode cur = nArr[i];
            TreeNode left = lMap.get(cur);
            TreeNode right = rMap.get(cur);
            if (null == left && right == null) {
//              root
                root = cur;
            } else if (null == left) {
//              左孩子为空
                if (null == right.getLeft()) {
                    right.setLeft(cur);
                } else {
                    right.setRight(cur);
                }
            } else if (null == right) {
//              右孩子为空
                if (null == left.getLeft()) {
                    left.setLeft(cur);
                } else {
                    left.setRight(cur);
                }
            } else {
//                左右都有
                TreeNode parent;
                if (flag) {
                    parent = left.getData() < right.getData() ? left : right;
                } else {
                    parent = left.getData() > right.getData() ? left : right;
                }
                if (null == parent.getLeft()) {
                    parent.setLeft(cur);
                } else {
                    parent.setRight(cur);
                }
            }
        }
        return root;
    }

    public TreeNode getMaxTree(int[] arr) {
        TreeNode[] nArr = new TreeNode[arr.length];
        for (int i = 0; i < arr.length; i++) {
            nArr[i] = new TreeNode(arr[i]);
        }
        Stack<TreeNode> stack = new Stack<>();
//        左边最比自己大的数
        HashMap<TreeNode, TreeNode> lBigMap = new HashMap<>();
//        右边最比自己大的数
        HashMap<TreeNode, TreeNode> rBigMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            TreeNode curTreeNode = nArr[i];
            while (!stack.isEmpty() && stack.peek().getData() < curTreeNode.getData()) {
                popStackAndSetMap(stack, lBigMap);
            }
            stack.push(curTreeNode);
        }
        while (!stack.isEmpty()) {
            popStackAndSetMap(stack, lBigMap);
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            TreeNode curTreeNode = nArr[i];
            while (!stack.isEmpty() && stack.peek().getData() < curTreeNode.getData()) {
                popStackAndSetMap(stack, rBigMap);
            }
            stack.push(curTreeNode);
        }
        while (!stack.isEmpty()) {
            popStackAndSetMap(stack, rBigMap);
        }
        return buildTree(nArr, true, lBigMap, rBigMap);
    }

    public TreeNode getMinTree(int[] arr) {
        TreeNode[] nArr = new TreeNode[arr.length];
        for (int i = 0; i < arr.length; i++) {
            nArr[i] = new TreeNode(arr[i]);
        }
        Stack<TreeNode> stack = new Stack<>();
        HashMap<TreeNode, TreeNode> lSmallMap = new HashMap<>();
        HashMap<TreeNode, TreeNode> rSmallMap = new HashMap<>();
        for (int i = 0; i < nArr.length; i++) {
            TreeNode curTreeNode = nArr[i];
            while (!stack.isEmpty() && stack.peek().getData() > curTreeNode.getData()) {
                popStackAndSetMap(stack, lSmallMap);
            }
            stack.push(curTreeNode);
        }
        while (!stack.isEmpty()) {
            popStackAndSetMap(stack, lSmallMap);
        }
        for (int i = nArr.length - 1; i >= 0; i--) {
            TreeNode curTreeNode = nArr[i];
            while (!stack.isEmpty() && stack.peek().getData() > curTreeNode.getData()) {
                popStackAndSetMap(stack, rSmallMap);
            }
            stack.push(curTreeNode);
        }
        while (!stack.isEmpty()) {
            popStackAndSetMap(stack, rSmallMap);
        }
        return buildTree(nArr, false, lSmallMap, rSmallMap);
    }

    private static void writeArray(TreeNode currNode, int rowIndex, int columnIndex, String[][] res, int treeDepth) {
        if (null == currNode)
            return;
        res[rowIndex][columnIndex] = String.valueOf(currNode.getData());
        int currLevel = ((rowIndex + 1) / 2);
        if (currLevel == treeDepth)
            return;
        int gap = treeDepth - currLevel - 1;
        if (null != currNode.getLeft()) {
            res[rowIndex + 1][columnIndex - gap] = "/";
            writeArray(currNode.getLeft(), rowIndex + 2, columnIndex - gap * 2, res, treeDepth);
        }
        if (null != currNode.getRight()) {
            res[rowIndex + 1][columnIndex + gap] = "\\";
            writeArray(currNode.getRight(), rowIndex + 2, columnIndex + gap * 2, res, treeDepth);
        }
    }

    public void print(TreeNode root) {
        if (null == root) {
            System.out.println();
            return;
        }
        int treeDepth = getDepth(root);
        int arrayHeight = treeDepth * 2 - 1;
        int arrayWidth = (2 << (treeDepth - 2)) * 3 + 1;
        String[][] res = new String[arrayHeight][arrayWidth];
        for (int i = 0; i < arrayHeight; i++) {
            for (int j = 0; j < arrayWidth; j++) {
                res[i][j] = " ";
            }
        }
        writeArray(root, 0, arrayWidth / 2, res, treeDepth);
        for (String[] line : res) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < line.length; i++) {
                sb.append(line[i]);
                if (1 < line[i].length() && i <= line.length - 1) {
                    i += line[i].length() > 4 ? 2 : line[i].length() - 1;
                }
            }
            System.out.println(sb.toString());
        }
    }

    private void visit(TreeNode root) {
        System.out.print(root.getData() + " , ");
    }

    @Deprecated
    public void recursivePreOrder(TreeNode root) {
        if (null != root) {
            visit(root);
            recursivePreOrder(root.getLeft());
            recursivePreOrder(root.getRight());
        }
    }

    public void preOrder(TreeNode root) {
        if (null == root)
            return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            visit(temp);
//              注意，需要先压右边、再压左边
            if (null != temp.getRight())
                stack.push(temp.getRight());
            if (null != temp.getLeft())
                stack.push(temp.getLeft());
        }
    }

    @Deprecated
    public void recursiveInOrder(TreeNode root) {
        if (null != root) {
            recursiveInOrder(root.getLeft());
            visit(root);
            recursiveInOrder(root.getRight());
        }
    }

    public void inOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (null != node || !stack.isEmpty()) {
            while (null != node) {
                stack.push(node);
                node = node.getLeft();
            }
            node = stack.pop();
            visit(node);
            node = node.getRight();
        }
    }

    @Deprecated
    public void recursivePostOrder(TreeNode root) {
        if (null != root) {
            recursivePostOrder(root.getLeft());
            recursivePostOrder(root.getRight());
            visit(root);
        }
    }

    public void postOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        TreeNode preNode = null;
        while (null != node || !stack.isEmpty()) {
            while (null != node) {
                stack.push(node);
                node = node.getLeft();
            }
            node = stack.peek();
            if (null == node.getRight() || preNode == node.getRight()) {
                visit(node);
                preNode = stack.pop();
                node = null;
            } else {
                node = node.getRight();
            }
        }
    }

    public void levelTraverse(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        TreeNode node = root;
        queue.offer(node);
        while (!queue.isEmpty()) {
            node = queue.poll();
            if (null != node) {
                visit(node);
                queue.offer(node.getLeft());
                queue.offer(node.getRight());
            }
        }
    }

    @Deprecated
    public int recursiveGetDepth(TreeNode root) {
        return null == root ? 0 : (1 + Math.max(recursiveGetDepth(root.getLeft()), recursiveGetDepth(root.getRight())));
    }

    public int getDepth(TreeNode root) {
        int depth = 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        TreeNode node = root;
        if (null != node)
            queue.offer(node);
        while (!queue.isEmpty()) {
            depth++;
            int width = queue.size();
            for (int i = 0; i < width; i++) {
                node = queue.poll();
                if (null != node.getLeft())
                    queue.offer(node.getLeft());
                if (null != node.getRight())
                    queue.offer(node.getRight());
            }
        }
        return depth;
    }

    public int getWidth(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        TreeNode node = root;
        int maxWidth = 0;
        if (null != node)
            queue.offer(node);
        while (!queue.isEmpty()) {
            int width = queue.size();
            if (width > maxWidth)
                maxWidth = width;
            for (int i = width; i > 0; i--) {
                node = queue.poll();
                if (null != node.getLeft())
                    queue.offer(node.getLeft());
                if (null != node.getRight())
                    queue.offer(node.getRight());
            }
        }
        return maxWidth;
    }

    @Deprecated
    public int recursiveGetNodeNumber(TreeNode root) {
        return null == root ? 0 : (1 + recursiveGetNodeNumber(root.getLeft()) + recursiveGetNodeNumber(root.getRight()));
    }

    public int getNodeNumber(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        TreeNode node = root;
        int number = 0;
        queue.offer(node);
        while (!queue.isEmpty()) {
            node = queue.poll();
            if (null != node) {
                number++;
                queue.offer(node.getLeft());
                queue.offer(node.getRight());
            }
        }
        return number;
    }

    @Deprecated
    public int recursiveGetLeafNodeNumber(TreeNode root) {
        return null == root ? 0 : null == root.getLeft() && null == root.getRight() ? (1 + recursiveGetLeafNodeNumber(root.getLeft()) + recursiveGetLeafNodeNumber(root.getRight())) : recursiveGetLeafNodeNumber(root.getLeft()) + recursiveGetLeafNodeNumber(root.getRight());
    }

    public int getLeafNodeNumber(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        int number = 0;
        while (null != node || !stack.isEmpty()) {
            while (null != node) {
                stack.push(node);
                node = node.getLeft();
            }
            node = stack.pop();
            if (null == node.getLeft() && null == node.getRight())
                number++;
            node = node.getRight();
        }
        return number;
    }
}
