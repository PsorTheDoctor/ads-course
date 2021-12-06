package com.wolkowycki.exam2;

public class Main {
    // Problem 2
    private static int isSumDivisibleBy3(int n) {
        return 0;
    }

    private static String problem4(int z) {
        int x = 0;
        int y = 0;
        for (int i = 2; i < z; i++) {
            for (int j = 2; j < Math.sqrt(z); j++) {
                if (z == Math.pow(i, j)) {
                    x = i;
                    y = j;
                }
            }
        }
        return z + "=" + x + "^" + y;
    }

    // Problem 5
    private static void findMinimumSpanningTree() {

        int V = 4; // number of vertices
        int E = 5; // number of edges
        Graph graph = new Graph(V, E);

        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;
        graph.edge[0].weight = 10;

        graph.edge[1].src = 0;
        graph.edge[1].dest = 2;
        graph.edge[1].weight = 6;

        graph.edge[2].src = 0;
        graph.edge[2].dest = 3;
        graph.edge[2].weight = 5;

        graph.edge[3].src = 1;
        graph.edge[3].dest = 3;
        graph.edge[3].weight = 15;

        graph.edge[4].src = 2;
        graph.edge[4].dest = 3;
        graph.edge[4].weight = 4;

        graph.KruskalMST();
    }

    public static void main(String[] args) {
        // System.out.println(isSumDivisibleBy3(12));
        System.out.println(problem4(6561));

        findMinimumSpanningTree();
    }
}
