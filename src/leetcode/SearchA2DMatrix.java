package leetcode;

public class SearchA2DMatrix {
    public static void main(String[] args) {
        int[][] matrix1 = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        System.out.println(searchMatrix3(matrix1, 3));
        System.out.println(searchMatrix3(matrix1, 13));
    }

    //Search from right-top, O(m+n)
    public static boolean searchMatrix(int[][] matrix, int target) {
        int rightTopX = 0;
        int rightTopY = matrix[0].length - 1;
        while (rightTopX < matrix.length && rightTopY >= 0) {
            if (matrix[rightTopX][rightTopY] == target) {
                return true;
            } else if (matrix[rightTopX][rightTopY] > target) {
                rightTopY--;
            } else {
                rightTopX++;
            }
        }
        return false;
    }

    //Search from leftBottom, O(m+n)
    public static boolean searchMatrix2(int[][] matrix, int target) {
        int leftBottomX = matrix.length - 1;
        int leftBottomY = 0;
        while (leftBottomX >= 0 && leftBottomY < matrix[0].length) {
            if (matrix[leftBottomX][leftBottomY] == target) {
                return true;
            } else if (matrix[leftBottomX][leftBottomY] > target) {
                leftBottomX--;
            } else {
                leftBottomY++;
            }
        }
        return false;
    }

    //Search from right-top, with Binary Search
    public static boolean searchMatrix3(int[][] matrix, int target) {
        int rightTopX = 0;
        int rightTopY = matrix[0].length - 1;

        int midX = (matrix.length - 1) / 2;
        int midY = rightTopY / 2;

        while (rightTopX < matrix.length && rightTopY >= 0) {
            if (matrix[rightTopX][rightTopY] == target || matrix[midX][midY] == target || matrix[rightTopX][midY] == target || matrix[midX][rightTopY] == target) {
                return true;
            }

            if (matrix[rightTopX][midY] > target) {
                rightTopY = midY - 1;
            } else if (matrix[midX][rightTopY] < target) {
                rightTopX = midX + 1;
            } else if (matrix[rightTopX][rightTopY] > target) {
                rightTopY--;
            } else {
                rightTopX++;
            }

            midX = rightTopX + (matrix.length - 1 - rightTopX) / 2;
            midY = rightTopY /2;
        }
        return false;
    }
}
