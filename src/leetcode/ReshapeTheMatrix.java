package leetcode;

public class ReshapeTheMatrix {
    public static void main(String args[]){
        int[][] mat1 = {{1,2},{3,4}};
        printMatrix(matrixReshape2(mat1, 1,4));
        System.out.println("==================");
        printMatrix(matrixReshape2(mat1, 2,4));
        System.out.println("==================");

        int[][] mat2 = {{1,2},{3,4}, {5,6}};
        printMatrix(matrixReshape2(mat2, 2,3));
        System.out.println("==================");
        printMatrix(matrixReshape2(mat2, 3,3));
        System.out.println("==================");

    }

    public static int[][] matrixReshape(int[][] mat, int r, int c) {
        if(mat.length * mat[0].length != r * c){
            return mat;
        }

        int[][] result = new int[r][c];

        int curRow = -1;
        int curCol = -1;

        for(int index = 0; index < r * c; index++){
            if(index % c == 0){
                curRow++;
                curCol = 0;
            }
            result[curRow][curCol++] = mat[index / mat[0].length][index % mat[0].length];
        }
        return result;

    }

    public static int[][] matrixReshape2(int[][] mat, int r, int c) {
        if(mat.length * mat[0].length != r * c){
            return mat;
        }

        int[][] result = new int[r][c];

        for(int index = 0; index < r * c; index++){
            result[index/c][index%c] = mat[index / mat[0].length][index % mat[0].length];
        }
        return result;

    }

    public static  void printMatrix(int[][] mat){
        for(int i = 0; i < mat.length; i++){
            printArray(mat[i]);
        }
    }
    public static void printArray(int[] nums){
        System.out.print("[");
        for(int i = 0; i < nums.length -1; i++){
            System.out.print(nums[i]+ ", ");
        }
        System.out.println(nums[nums.length-1] + "]");
    }
}
