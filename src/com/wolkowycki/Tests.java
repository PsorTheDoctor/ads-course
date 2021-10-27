package com.wolkowycki;

import java.util.List;
import java.util.Set;

class Tests {

    private static final int[][] input1 = {{7,1},{12,3},{14,6},{9,4},{1,6},{1,1},{2,2},{3,3},{4,4},{1,2},{2,4},{3,6},{4,7}};
    private static final int[][] input2 = {{7,1},{12,5},{14,6},{9,4},{1,6},{2,2},{3,3},{4,4},{1,2},{2,4},{3,6},{4,7}};
    private static final int[][] input3 = {{7,1},{12,3},{14,6},{9,4},{1,6},{2,1},{1,4},{1,5},{4,4},{1,2},{2,5},{3,6},{4,8}};
    private static final int[][] input4 = {{2,2},{3,3},{4,4},{7,1},{14,6},{9,4},{1,1},{1,4},{1,5},{1,2},{2,4}};

    private static final int[][][] output1 = {{{1,1},{2,2},{3,3},{4,4}}};
    private static final int[][][] output2 = {};
    private static final int[][][] output3 = {{{1,2},{1,4},{1,5},{1,6}}};
    private static final int[][][] output4 = {{{1,1},{1,2},{1,4},{1,5}}, {{1,1},{2,2},{3,3},{4,4}}, {{4,4},{9,4},{1,4},{2,4}}};

    static void test() {

        List<Point> points = Utils.arrayToPointList(input1);
        Set<Set<Point>> result = Utils.findCollinear(points);
        Set<Set<Point>> output = Utils.arrayToNestedPointSet(output1);
        print(result, output);

        points = Utils.arrayToPointList(input2);
        result = Utils.findCollinear(points);
        output = Utils.arrayToNestedPointSet(output2);
        print(result, output);

        points = Utils.arrayToPointList(input3);
        result = Utils.findCollinear(points);
        output = Utils.arrayToNestedPointSet(output3);
        print(result, output);

        points = Utils.arrayToPointList(input4);
        result = Utils.findCollinear(points);
        output = Utils.arrayToNestedPointSet(output4);
        print(result, output);
    }

    private static void print(Set<Set<Point>> result, Set<Set<Point>> output) {

        System.out.print("Result: ");
        Utils.print(result);
        System.out.print("Output: ");
        Utils.print(output);
    }
}
