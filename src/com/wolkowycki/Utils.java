package com.wolkowycki;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

class Utils {

    static List<Point> convertToPointList(int[][] input) {

        int n = input.length;
        List<Point> points = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            Point point = new Point(input[i][0], input[i][1]);
            points.add(point);
        }
        return points;
    }

    static Set<Set<Point>> findCollinear(List<Point> points) {

        int n = points.size();
        Set<Set<Point>> collinear = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    for (int l = 0; l < n; l++) {

                        if (i != j && i != k && i != l && j != k && j != l && k != l) {
                            Point p1 = points.get(i);
                            Point p2 = points.get(j);
                            Point p3 = points.get(k);
                            Point p4 = points.get(l);

                            if (areCollinear(p1, p2, p3, p4)) {
                                Set<Point> quadruple = new HashSet<>();
                                quadruple.add(p1);
                                quadruple.add(p2);
                                quadruple.add(p3);
                                quadruple.add(p4);
                                collinear.add(quadruple);
                            }
                        }
                    }
                }
            }
        }
        return collinear;
    }

    private static float calculateA(Point p1, Point p2) {

        int x1 = p1.getX();
        int y1 = p1.getY();
        int x2 = p2.getX();
        int y2 = p2.getY();

        return (float) Math.abs(y1 - y2) / Math.abs(x1 - x2);
    }

    private static boolean areCollinear(Point p1, Point p2, Point p3, Point p4) {

        boolean collinear = false;
        float a12 = calculateA(p1, p2);
        float a13 = calculateA(p1, p3);
        float a14 = calculateA(p1, p4);
        float a23 = calculateA(p2, p3);
        float a24 = calculateA(p2, p4);
        float a34 = calculateA(p3, p4);

        if (a12 == a13 && a12 == a14 && a12 == a23 && a12 == a24 && a12 == a34)
            collinear = true;
        return collinear;
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
            sb.append("{}");
        }
        System.out.println(sb);
    }
}