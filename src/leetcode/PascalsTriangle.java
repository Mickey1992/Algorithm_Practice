package leetcode;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public static void main(String[] args){
        System.out.println(generate(5));
    }
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int row = 0; row < numRows; row++){
            List<Integer> curRow = new ArrayList<>();
            for(int col = 0; col < row; col++){
                int element = col == 0  ? 1 : result.get(row -1).get(col - 1) + result.get(row -1).get(col);
                curRow.add(element);
            }
            curRow.add(1);
            result.add(curRow);
        }
        return result;
    }
}
