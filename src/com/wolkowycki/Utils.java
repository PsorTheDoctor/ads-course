package com.wolkowycki;

import javafx.util.Pair;

import java.util.*;

class Utils {

    static Vector<Point> arrayToPointVector(int[][] array) {

        Vector<Point> points = new Vector<>();

        for (int i = 0; i < array.length; i++) {
            Point point = new Point(array[i][0], array[i][1]);
            points.add(point);
        }
        return points;
    }

    static Set<Set<Point>> arrayToNestedPointSet(int[][][] array) {

        Set<Set<Point>> quadruples = new HashSet<>();

        for (int i = 0; i < array.length; i++) {
            Set<Point> points = new HashSet<>();

            for (int j = 0; j < array[0].length; j++) {
                Point point = new Point(array[i][j][0], array[i][j][1]);
                points.add(point);
            }
            quadruples.add(points);
        }
        return quadruples;
    }

    private static Vector<Pair<Float, Integer>> sort(Vector<Pair<Float, Integer>> v) {

        v.sort(new Comparator<Pair<Float, Integer>>() {
            @Override
            public int compare(Pair<Float, Integer> p1, Pair<Float, Integer> p2) {
                return (int) (p1.getKey() - p2.getKey());
            }
        });
        return v;
    }

    static Set<Set<Point>> findCollinear(Vector<Point> points) {

        int n = points.size();
        // Collinear points will be stored here
        // I used nested sets due to being unordered
        Set<Set<Point>> collinear = new HashSet<>();
        // Assigns each param A to each index of a point
        Vector<Pair<Float, Integer>> aWithIndices = new Vector<>();
        // Indices of collinear points quadruples
        Set<Vector<Integer>> indices = new HashSet<>();

        for (int i = 0; i < n; i++) {
            aWithIndices.clear();

            for (int j = 0; j < n; j++) {
                if (i != j) {
                    float a = calculateA(points.get(i), points.get(j));
                    aWithIndices.add(new Pair<>(a, j));
                }
            }
            sort(aWithIndices);

            for (int k = 0; k < n - 3; k++) {

                float a1 = aWithIndices.get(k).getKey();
                float a2 = aWithIndices.get(k + 1).getKey();
                float a3 = aWithIndices.get(k + 2).getKey();

                // checking if points are collinear by using their A params
                if (a1 == a2 && a1 == a3) {
                    // storing each index to particular quadruple
                    Vector<Integer> tempIndices = new Vector<>();
                    tempIndices.add(i);
                    tempIndices.add(aWithIndices.get(k).getValue());
                    tempIndices.add(aWithIndices.get(k + 1).getValue());
                    tempIndices.add(aWithIndices.get(k + 2).getValue());

                    Collections.sort(tempIndices);
                    indices.add(tempIndices);
                    // tempIndices.clear();
                }
            }
        }
        // Iterate over a set
        for (Vector<Integer> index : indices) {
            Set<Point> quadruple = new HashSet<>();

            for (int i = 0; i < index.size(); i++) {

                int x = points.get(index.get(i)).getX();
                int y = points.get(index.get(i)).getY();
                quadruple.add(new Point(x, y));
            }
            collinear.add(quadruple);
        }
        return collinear;
    }

    // Calculates param A of the linear function
    private static float calculateA(Point p1, Point p2) {

        int x1 = p1.getX();
        int y1 = p1.getY();
        int x2 = p2.getX();
        int y2 = p2.getY();
        // return (float) Math.abs(y1 - y2) / Math.abs(x1 - x2);
        return (float) Math.atan2(y1 - y2, x1 - x2);
    }

    static void print(Set<Set<Point>> quadruples) {

        StringBuilder sb = new StringBuilder();

        if (quadruples.size() > 0) {
            for (Set<Point> quadruple : quadruples) {
                for (Point point : quadruple) {
                    String s = "{" + point.getX() + "," + point.getY() + "} ";
                    sb.append(s);
                }
                sb.append("\n");
            }
        } else {
            sb.append("{}\n");
        }
        System.out.println(sb);
    }
}