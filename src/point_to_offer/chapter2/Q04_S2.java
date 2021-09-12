package point_to_offer.chapter2;

public class Q04_S2 {
    public static void main(String args[]) {
        int[][] data = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        System.out.println(_find(data, 5));
        System.out.println(_find(data, 7));
        System.out.println(_find(data, 1));
        System.out.println(_find(data, 15));
    }

    private static boolean _find(int[][] arr, int n) {

        int startX = 0;
        int startY = 0;
        int endX = arr.length - 1;
        int endY = arr[0].length - 1;

        while (startX <= endX && startY <= endY) {
            if (arr[startX][endY] == n) return true;
            if (arr[startX][endY] > n) {
                endY--;
            } else {
                startX++;
            }
        }
        return false;
    }


}
