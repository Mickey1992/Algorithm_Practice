package point_to_offer.chapter2;

// Question: 在一个长度为n的数组中，所有数字的取值范围都在[0,n-1]，但不知道有几个数字重复或重复几次，找出其中任意一个重复的数字。
// Solution: 借助哈希表，记录数字是否出现
//           时间复杂度O(n), 空间复杂度O(n)
public class Q03_DuplicationInArray_Ex1_S1 {
    public static void main(String[] args){
        int [] data = {2, 3, 5, 4, 3, 2, 5, 7};
        System.out.println(getDuplication(data));

        int [] data2 = {0, 1, 2, 3, 4, 5, 6};
        System.out.println(getDuplication(data2));

    }
    private static int getDuplication(int[] arr){
        int [] count = new int[arr.length];
        int duplication = -1;
        for(int i = 0; i<arr.length; i++){
            if (count[arr[i]] == 1) {
                duplication =  arr[i];
                break;
            }
            count[arr[i]] = 1;
        }
        return duplication;
    }
}
