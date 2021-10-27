package com.wolkowycki;

import java.util.List;
import java.util.Set;

public class Main {
    private static final int[][] input1 = {{7,1},{12,3},{14,6},{9,4},{1,6},{1,1},{2,2},{3,3},{4,4},{1,2},{2,4},{3,6},{4,7}};
    private static final int[][] input2 = {{7,1},{12,5},{14,6},{9,4},{1,6},{2,2},{3,3},{4,4},{1,2},{2,4},{3,6},{4,7}};
    private static final int[][] input3 = {{7,1},{12,3},{14,6},{9,4},{1,6},{2,1},{1,4},{1,5},{4,4},{1,2},{2,5},{3,6},{4,8}};
    private static final int[][] input4 = {{2,2},{3,3},{4,4},{7,1},{14,6},{9,4},{1,1},{1,4},{1,5},{1,2},{2,4}};

    public static void main(String[] args) {

        List<Point> points = Utils.convertToPointList(input1);
        Set<Set<Point>> collinear = Utils.findCollinear(points);
        Utils.print(collinear);
    }
}
