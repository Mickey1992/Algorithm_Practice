package point_to_offer.chapter2;

// Question: 在一个长度为n+1的数组中，所有数字的取值范围都在[1,n]，数组中至少有一个数字是重复的，找出任意一个
//           不能改变原来的数组
// Solution: 将[1,n]分成两个部分，分别计算每一部分数字出现的总次数，个数大于元素个数的一组内有重复的数字，继续分组
public class Q03_DuplicationInArray_Ex2_S2 {
    public static void main(String[] args) {
        int[] data = {1, 2, 2};
        System.out.println(getDuplication(data));

        int[] data1 = {2, 3, 5, 4, 3, 2, 6, 7};
        System.out.println(getDuplication(data1));

        int[] data2 = {1, 2, 3, 4, 5, 6, 6};
        System.out.println(getDuplication(data2));

        int[] data3 = {};
        System.out.println(getDuplication(data3));

    }

    private static int getDuplication(int[] arr) {
        if(arr.length ==0) return -1;
        int start = 1;
        int end = arr.length - 1;
        int mid = start + (end - start) / 2;
        while (start < end) {
            int leftAppearance = countRange(arr, start, mid);
            if (leftAppearance > mid - start + 1) {
                end = mid;
            } else {
                start = mid + 1;
            }
            mid = start + (end - start) / 2;
        }
        return start;
    }

    private static int countRange(int[] arr, int start, int end) {
        int count = 0;
        for (int value : arr) {
            if (value >= start && value <= end) {
                count++;
            }
        }
        return count;
    }
}
