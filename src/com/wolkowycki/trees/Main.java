package com.wolkowycki.trees;

class Main {
    public static void main(String[] args) {
        //     1
        //    / \
        //   2   3
        //  / \
        // 4   5

        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.println("Pre-order traversal");
        tree.preorder();
        System.out.println("In-order traversal");
        tree.inorder();
        System.out.println("Post-order traversal");
        tree.postorder();
    }
}
