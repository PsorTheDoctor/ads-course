package com.wolkowycki.portfolio2;

import java.util.Vector;

public class Main {

    static class Field {

        private int x, y;
        private int dist;

        Field(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    // TODO!!
    static class Node<Field> {

        Field node;
        Node<Field> left;
        Node<Field> right;

        Node(Field element) {
            node = element;
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
        Vector<Field> v = new Vector<>();
        // Push starting position of knight with 0 distance
        v.add(new Field(startXPosition, startYPosition,0));

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
        while (!v.isEmpty()) {
            temp = v.firstElement();
            v.remove(0);

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
                    v.add(new Field(x, y, temp.dist + 1));
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
