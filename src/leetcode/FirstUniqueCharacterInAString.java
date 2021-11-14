package leetcode;

public class FirstUniqueCharacterInAString {
    public static void main(String[] args){
        System.out.println(firstUniqChar2("leetcode"));
        System.out.println(firstUniqChar2("loveleetcode"));
        System.out.println(firstUniqChar2("aabb"));
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

    public static int firstUniqChar2(String s) {
        int minIndex = s.length();
        for(int i = 0; i < 26; i++){
            int index = s.indexOf('a'+i);
            if(index < 0) continue;
            if(index != s.lastIndexOf('a'+i)) continue;
            minIndex = Math.min(minIndex, index);
        }
        return minIndex == s.length() ? -1 : minIndex;
    }
}
