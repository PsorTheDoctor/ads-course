/**
 * Algorithms and Data Structures 2nd Portfolio
 * Author: Adam Wolkowycki
 * Email: adwol21@student.sdu.dk
 *
 * The program calculates minimum number of moves it takes
 * for a knight at a given position to reach another position.
 * The method works for arbitrary sizes of chessboards.
 *
 * To see how it works please run a KnightProblemTree.java file.
 */
package com.wolkowycki.portfolio2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class Tree {
    private int boardHeight;
    private int boardWidth;

    private Node root;

    public Tree(int boardHeight, int boardWidth, int rootXPosition, int rootYPosition) {
        this.boardHeight = boardHeight;
        this.boardWidth = boardWidth;
        this.root = new Node(rootXPosition, rootYPosition);
    }

    public int getBoardHeight() {
        return boardHeight;
    }

    public int getBoardWidth() {
        return boardWidth;
    }

    public Node getRoot() {
        return root;
    }

    public class Node {
        private int xPosition;
        private int yPosition;
        private int distance;
        private boolean isVisited;
        private Node parent;

        // x and y direction, where a knight can move
        private static final int POSSIBLE_MOVES_COUNT = 8;
        private final int[] possibleXMoves = {-2, -1, 1, 2, -2, -1, 1, 2};
        private final int[] possibleYMoves = {-1, -2, -2, -1, 1, 2, 2, 1};

        public Node(int xPosition, int yPosition) {
            this.xPosition = xPosition;
            this.yPosition = yPosition;
        }

        public Node(int xPosition, int yPosition, Node parent) {
            this(xPosition, yPosition);
            this.parent = parent;
        }

        public void setNodeAsVisited() {
            isVisited = true;
        }

        public List<Node> getAllChildren() {
            List<Node> children = new ArrayList<>();

            // For all reachable states
            for (int i = 0; i < POSSIBLE_MOVES_COUNT; ++i) {
                int newXPosition = xPosition + possibleXMoves[i];
                int newYPosition = yPosition + possibleYMoves[i];

                // If reachable state is not yet visited and inside a board
                // push it into a structure
                if (isPositionInsideBoard(newXPosition, newYPosition)) {
                    Node child = new Node(newXPosition, newYPosition, this);
                    children.add(child);
                }
            }
            return children;
        }

        private boolean isPositionInsideBoard(int xPosition, int yPosition) {
            return xPosition >= 0 && yPosition >= 0 && xPosition <= boardWidth && yPosition <= boardHeight;
        }

        public int getXPosition() {
            return xPosition;
        }

        public void setXPosition(int xPosition) {
            this.xPosition = xPosition;
        }

        public int getYPosition() {
            return yPosition;
        }

        public void setYPosition(int yPosition) {
            this.yPosition = yPosition;
        }

        public int getDistance() {
            return distance;
        }

        public void setDistance(int distance) {
            this.distance = distance;
        }

        public boolean isVisited() {
            return isVisited;
        }

        public void setVisited(boolean visited) {
            isVisited = visited;
        }

        public Node getParent() {
            return parent;
        }

        public void setParent(Node parent) {
            this.parent = parent;
        }
    }
}

public class KnightProblemTree {
    static boolean isNodeAlreadyChecked(Queue<Tree.Node> nodeQueue, Tree.Node node) {
        return nodeQueue.stream()
                .anyMatch(n -> n.getXPosition() == node.getXPosition() && n.getYPosition() == node.getYPosition());
    }

    static int minimumSteps(int boardHeight, int boardWidth,
                            int startXPosition, int startYPosition,
                            int endXPosition, int endYPosition) {
        Tree chessTree = new Tree(boardHeight, boardWidth, startXPosition, startYPosition);
        Tree.Node root = chessTree.getRoot();

        // Structure for storing states of knight in a board
        Queue<Tree.Node> nodeQueue = new ArrayDeque<>();
        nodeQueue.add(root);

        while (!nodeQueue.isEmpty()) {
            Tree.Node target = nodeQueue.poll();

            // If current field is equal to target field return its distance
            if (target.getXPosition() == endXPosition && target.getYPosition() == endYPosition) {
                return target.getDistance();
            }

            List<Tree.Node> children = target.getAllChildren();

            for (Tree.Node child : children) {
                if (!isNodeAlreadyChecked(nodeQueue, child)) {
                    child.setDistance(child.getDistance() + 1);
                    nodeQueue.add(child);
                }
            }
        }
        return Integer.MAX_VALUE;
    }

    public static void main(String[] args) {
        int steps = minimumSteps(8, 8, 4, 4, 3, 2);
        System.out.println(steps);
    }
}
