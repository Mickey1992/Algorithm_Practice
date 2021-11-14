package leetcode;

public class FirstUniqueCharacterInAString {
    public static void main(String[] args){
        System.out.println(firstUniqChar("leetcode"));
        System.out.println(firstUniqChar("loveleetcode"));
        System.out.println(firstUniqChar("aabb"));
    }
    public static int firstUniqChar(String s) {
        int[] occurrence = new int[26];
        for(int i = 0 ; i < s.length(); i++){
            occurrence[s.charAt(i)-'a']++;
        }

        for(int i = 0 ; i < s.length(); i++){
            if (occurrence[s.charAt(i)-'a'] == 1)
                return i;
        }
        return -1;
    }
}
