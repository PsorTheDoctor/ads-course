package com.wolkowycki.portfolio2;

public class Main {

    static class Tree {
        private Node<Field> root;

        public void insert(Field element) {
            root = insert(element, root);
        }

        public void remove(Field element) {
            root = remove(element, root);
        }

        public Field findMin() {
            return findMin(root).element;
        }

        public Field findMax() {
            return findMax(root).element;
        }

        public boolean isEmpty() {
            return root == null;
        }

        public void printTree() {
            if (isEmpty()) {
                System.out.println("Empty tree");
            } else {
                printTree(root);
            }
        }

        static class Node<Field> {
            Field element;
            Node<Field> left;
            Node<Field> right;

            Node(Field element) {
                this.element = element;
            }

            Node(Field element, Node<Field> left, Node<Field> right) {
                this.element = element;
                this.left = left;
                this.right = right;
            }
        }

        private Node<Field> insert(Field element, Node<Field> node) {

            if (node == null)
                return new Node<>(element);

//            int compareResult = element.compareTo(node.element);
//
//            if (compareResult < 0) {
//                node.left = insert(element, node.left);
//            } else if (compareResult > 0) {
//                node.right = insert(element, node.right);
//            }
            node.left = insert(element, node.left);
            return node;
        }

        private Node<Field> remove(Field element, Node<Field> node) {

            if (node == null)
                return node;

//            int compareResult = element.compareTo(node.element);
//
//            if (compareResult < 0) {
//                node.left = remove(element, node.left);
//            } else if (compareResult > 0) {
//                node.right = remove(element, node.right);
//            } else if (node.left != null && node.right != null) { // Two children
//                node.element = findMin(node.right).element;
//                node.right = remove(node.element, node.right);
//            } else {
//                node = (node.left != null) ? node.left : node.right;
//            }
            node.left = remove(element, node.left);
            return node;
        }

        private Node<Field> findMin(Node<Field> node) {
            if (node == null) {
                return null;
            } else if (node.left == null) {
                return node;
            }
            return findMin(node.left);
        }

        private Node<Field> findMax(Node<Field> node) {
            if (node != null) {
                while (node.right != null)
                    node = node.right;
            }
            return node;
        }

        private void printTree(Node<Field> node) {
            if (node != null) {
                printTree(node.left);
                System.out.println("x=" + node.element.x + " y=" + node.element.y);
                printTree(node.right);
            }
        }
    }

    static class Field {

        private int x, y, dist;

        Field(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }

        // Returns 1 if the first element is greater than second,
        // 2 if the second, 0 otherwise
        int compareTo(Field element) {
            if (this.x == element.x) {
                if (this.y == element.y) {
                    if (this.dist == element.dist) {
                        return 0;
                    } else if(this.dist > element.dist) {
                        return 1;
                    } else {
                        return -1;
                    }
                } else if (this.y > element.y) {
                    return 1;
                } else {
                    return -1;
                }
            } else if (this.x > element.x) {
                return 1;
            } else {
                return -1;
            }
        }
    }

    static boolean isInside(int x, int y, int boardWidth, int boardHeight) {

        boolean inside = false;
        if (x >= 1 && x <= boardWidth && y >= 1 && y <= boardHeight) {
            inside = true;
        }
        return inside;
    }

    static int minimumSteps(int boardHeight, int boardWidth,
                            int startXPosition, int startYPosition,
                            int endXPosition, int endYPosition) {

        // x and y direction, where a knight can move
        int possibleXMoves[] = {-2, -1, 1, 2, -2, -1, 1, 2};
        int possibleYMoves[] = {-1, -2, -2, -1, 1, 2, 2, 1};

        // Structure for storing states of knight in a board
        Tree tree = new Tree();
        // Push starting position of knight with 0 distance
        tree.insert(new Field(startXPosition, startYPosition,0));

        Field temp;
        int x, y;
        boolean visited[][] = new boolean[boardWidth + 1][boardHeight + 1];

        // Make all fields unvisited
        for (int i = 1; i <= boardWidth; i++) {
            for (int j = 1; j <= boardHeight; j++) {
                visited[i][j] = false;
            }
        }
        // Visit starting state
        visited[startXPosition][startYPosition] = true;

        // Loop until we have one element in a structure
        while (!tree.isEmpty()) {
            temp = tree.findMin();
            tree.remove(temp);

            // If current field is equal to target field return its distance
            if (temp.x == endXPosition && temp.y == endYPosition)
                return temp.dist;

            // For all reachable states
            for (int i = 0; i < 8; i++) {
                x = temp.x + possibleXMoves[i];
                y = temp.y + possibleYMoves[i];

                // If reachable state is not yet visited and inside a board
                // push it into a structure
                if (isInside(x, y, boardWidth, boardHeight) && !visited[x][y]) {
                    visited[x][y] = true;
                    tree.insert(new Field(x, y, temp.dist + 1));
                }
            }
            tree.printTree();
        }
        return Integer.MAX_VALUE;
    }

    public static void main(String[] args) {

        int test1 = minimumSteps(8, 8, 4, 4, 4, 5);
        int test2 = minimumSteps(8, 8, 0, 0, 7, 7);
        int test3 = minimumSteps(8, 8, 0, 0, 0, 7);
        int test4 = minimumSteps(20, 10, 0, 4, 9, 15);
        int test5 = minimumSteps(100, 10, 4, 4, 9, 99);
        int test6 = minimumSteps(8, 8, 4, 4, 4, 4);
        int test7 = minimumSteps(100, 100, 50, 50, 57, 57);

        System.out.println("Test 1: " + test1);
        System.out.println("Test 2: " + test2);
        System.out.println("Test 3: " + test3);
        System.out.println("Test 4: " + test4);
        System.out.println("Test 5: " + test5);
        System.out.println("Test 6: " + test6);
        System.out.println("Test 7: " + test7);
    }
}
