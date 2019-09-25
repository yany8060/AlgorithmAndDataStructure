package com.yany.datastructures.tree;

import com.alibaba.fastjson.JSON;

import java.util.Stack;

/**
 * 二叉树
 * Created by yanyong on 2016/12/14.
 */
public class BinaryTree {
    private TreeNode root = null;

    public BinaryTree() {
        root = new TreeNode(1, "A");
    }

    /**
     * 创建一棵二叉树
     * <pre>
     *           A
     *     B          C
     *  D     E            F
     *  </pre>
     *
     * @param root
     * @author WWX
     */
    public void createBinTree(TreeNode root) {
        TreeNode newNodeB = new TreeNode(2, "B");
        TreeNode newNodeC = new TreeNode(3, "C");
        TreeNode newNodeD = new TreeNode(4, "D");
        TreeNode newNodeE = new TreeNode(5, "E");
        TreeNode newNodeF = new TreeNode(6, "F");

        System.out.println(JSON.toJSONString(newNodeB));

        root.setLeftChild(newNodeB);
        root.setRightChild(newNodeC);
        root.getLeftChild().setLeftChild(newNodeD);
        root.getLeftChild().setRightChild(newNodeE);
        root.getRightChild().setRightChild(newNodeF);

    }

    /**
     * 前序遍历
     *
     * @param subTree
     */
    public void preOrder(TreeNode subTree) {
        if (subTree != null) {
            visted(subTree);
            preOrder(subTree.getLeftChild());
            preOrder(subTree.getRightChild());
        }
    }

    /**
     * 中序遍历
     *
     * @param subTree
     */
    public void inOrder(TreeNode subTree) {
        if (subTree != null) {
            inOrder(subTree.getLeftChild());
            visted(subTree);
            inOrder(subTree.getRightChild());
        }
    }

    /**
     * 后序遍历
     *
     * @param subTree
     */
    public void postOrder(TreeNode subTree) {
        if (subTree != null) {
            postOrder(subTree.getLeftChild());
            postOrder(subTree.getRightChild());
            visted(subTree);
        }

    }

    /**
     * 先序遍历
     *
     * @param subTree
     */
    public void nonRecPreOrder(TreeNode subTree) {
        Stack<TreeNode> stack = new Stack<>();
        if (subTree != null) {
            stack.push(subTree);
            while (!stack.isEmpty()) {
                subTree = stack.pop();
                visted(subTree);
                if (subTree.getRightChild() != null) {
                    stack.push(subTree.getRightChild());
                }
                if (subTree.getLeftChild() != null) {
                    stack.push(subTree.getLeftChild());
                }
            }
        }
    }

    /**
     * 中序遍历
     *
     * @param subTree
     */
    public void nonRecInOrder(TreeNode subTree) {
        Stack<TreeNode> stack = new Stack<>();

        while (subTree != null || !stack.isEmpty()) {
            while (subTree != null) {
                stack.push(subTree);
                subTree = subTree.getLeftChild();
            }
            if (!stack.isEmpty()) {
                subTree = stack.pop();
                visted(subTree);
                subTree = subTree.getRightChild();
            }
        }
    }

    public void noRecPostOrder(TreeNode subTree) {
        Stack<TreeNode> stack = new Stack<>();

        TreeNode tmp = subTree;

        while (subTree != null) {
            //左子树入栈
            for (; subTree.getLeftChild() != null; subTree = subTree.getLeftChild()) {
                stack.push(subTree);
            }
            //当前结点无右子树或右子树已经输出
            while (subTree != null && (subTree.getRightChild() == null || subTree.getRightChild() == tmp)) {
                visted(subTree);
                tmp = subTree;
                if (stack.isEmpty()) {
                    return;
                }
                subTree = stack.pop();
            }
            stack.push(subTree);
            subTree = subTree.getRightChild();
        }

    }


    public void visted(TreeNode subTree) {
        System.out.println("--name:" + subTree.getData());
    }

    /**
     * 插入节点
     *
     * @param node
     * @param root
     * @return
     */
    public TreeNode addNode(TreeNode node, TreeNode root) {
        if (root == null) {
            root = node;
        } else if (node.getKey() < root.getKey()) {
            addNode(node, root.getLeftChild());
        }

        if (node.getKey() >= root.getKey()) {
            addNode(node, root.getRightChild());
        }
        return root;
    }


    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.createBinTree(binaryTree.root);

        System.out.println("*******(前序遍历)[ABDECF]遍历*****************");
        binaryTree.preOrder(binaryTree.root);

        System.out.println("*******(中序遍历)[DBEACF]遍历*****************");
        binaryTree.inOrder(binaryTree.root);

        System.out.println("*******(后序遍历)[DEBFCA]遍历*****************");
        binaryTree.postOrder(binaryTree.root);

        System.out.println("***非递归实现****(前序遍历)[ABDECF]遍历*****************");
        binaryTree.nonRecPreOrder(binaryTree.root);

        System.out.println("***非递归实现****(中序遍历)[DBEACF]遍历*****************");
        binaryTree.nonRecInOrder(binaryTree.root);

        System.out.println("***非递归实现****(后序遍历)[DEBFCA]遍历*****************");
        binaryTree.noRecPostOrder(binaryTree.root);


    }


}
