package point_to_offer.chapter2;

public class Q04_S1 {
    public static void main(String args[]) {
        int[][] data = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        System.out.println(_find(data, 5));
        System.out.println(_find(data, 7));
    }

    private static boolean _find(int[][] arr, int n) {
        return _find(arr, n, 0, 0, arr.length - 1, arr[0].length - 1);
    }

    private static boolean _find(int[][] arr, int n, int startX, int startY, int endX, int endY) {
        int midX = startX + (endX - startX) / 2;
        int midY = startY + (endY - startY) / 2;
        if (arr[startX][startY] == n || arr[endX][endY] == n) return true;
        boolean exists = false;
        if (arr[startX][startY] <= n && arr[midX][midY] >= n) {
            exists = exists || _find(arr, n, startX, startY, midX, midY);
        }
        if (arr[startX][midY + 1] <= n && arr[midX][endY] >= n) {
            exists = exists || _find(arr, n, startX, midY + 1, midX, endY);
        }
        if (arr[midX + 1][startY] <= n && arr[endX][midY] >= n) {
            exists = exists || _find(arr, n, midX + 1, startY, endX, midY);
        }
        if (arr[midX + 1][midY + 1] <= n && arr[endX][endY] >= n) {
            exists = exists || _find(arr, n, midX + 1, midY + 1, endX, endY);
        }
        return exists;
    }
}
