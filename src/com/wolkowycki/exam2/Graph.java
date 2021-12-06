package com.wolkowycki.exam2;

import java.util.Arrays;

class Graph {
    static class Edge implements Comparable<Edge> {
        int src, dest, weight;

        Edge() {}

        Edge(char src, char dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge compareEdge) {
            return this.weight - compareEdge.weight;
        }
    }

    // A class to represent a subset for union-find
    static class Subset {
        int parent, rank;
    }

    private int V, E;
    Edge[] edge; // collection of all edges

    // Creates a graph with V vertices and E edges
    Graph(int v, int e) {
        V = v;
        E = e;
        edge = new Edge[E];
        for (int i = 0; i < e; ++i)
            edge[i] = new Edge();
    }

    // A function to find set of an element i
    private int find(Subset[] subsets, int i) {
        // Find root and make root as parent of i
        if (subsets[i].parent != i)
            subsets[i].parent = find(subsets, subsets[i].parent);
        return subsets[i].parent;
    }

    // A function that does union of two sets of x and y
    private void Union(Subset subsets[], int x, int y) {
        int xRoot = find(subsets, x);
        int yRoot = find(subsets, y);

        // Attach smaller rank tree under root of high rank tree
        if (subsets[xRoot].rank < subsets[yRoot].rank) {
            subsets[xRoot].parent = yRoot;
        } else if (subsets[xRoot].rank > subsets[yRoot].rank) {
            subsets[yRoot].parent = xRoot;
        } else {
            // If ranks are same, then make one as root
            // and increment its rank by one
            subsets[yRoot].parent = xRoot;
            subsets[xRoot].rank++;
        }
    }

    // A function to construct MST using Kruskal's algorithm
    void KruskalMST() {

        Edge[] result = new Edge[V]; // this will store the resultant MST
        int e = 0; // an index variable, used for result[]
        int i = 0; // an index variable, used for sorted edges

        for (i = 0; i < V; ++i)
            result[i] = new Edge();

        // Step 1: Sort all the edges in non decreasing order of their weight.
        // If we are not allowed to change the given graph, we can create a copy
        // of array of edges.
        Arrays.sort(edge);

        // Allocate memory for creating V subsets
        Subset[] subsets = new Subset[V];
        for (i = 0; i < V; ++i)
            subsets[i] = new Subset();

        // Create V subsets with single elements
        for (int v = 0; v < V; ++v) {
            subsets[v].parent = v;
            subsets[v].rank = 0;
        }
        i = 0; // index used to pick next edge

        // Number of edges to be taken is equal to V-1
        while (e < V - 1) {
            // Step 2: Pick the smallest edge. And increment
            // the index for next iteration
            Edge nextEdge = edge[i++];

            int x = find(subsets, nextEdge.src);
            int y = find(subsets, nextEdge.dest);

            // If including this edge doesn't cause cycle,
            // include it in result and increment the index
            // of result for next edge
            if (x != y) {
                result[e++] = nextEdge;
                Union(subsets, x, y);
            }
            // Else discard the next edge
        }
        // Print the contests of result[] to display the built MST
        System.out.println("Following are the edges in the constructed MST");

        int minimumCost = 0;
        for (i = 0; i < e; ++i) {
            System.out.println(result[i].src + " -- " + result[i].dest
                    + " == " + result[i].weight);
            minimumCost += result[i].weight;
        }
        System.out.println("Minimum Cost Spanning Tree " + minimumCost);
    }
}
