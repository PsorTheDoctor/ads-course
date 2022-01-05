package com.wolkowycki.trees;

class BinaryTree {
    Node root;

    BinaryTree() {
        root = null;
    }

    private void preorder(Node node) {
        if (node != null) {
            System.out.println(node.key + " ");
            preorder(node.left);
            preorder(node.right);
        }
    }

    private void inorder(Node node) {
        if (node != null) {
            inorder(node.left);
            System.out.println(node.key + " ");
            inorder(node.right);
        }
    }

    private void postorder(Node node) {
        if (node != null) {
            postorder(node.left);
            postorder(node.right);
            System.out.println(node.key + " ");
        }
    }

    void preorder() { preorder(root); }
    void inorder() { inorder(root); }
    void postorder() { postorder(root); }
}
