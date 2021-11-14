package leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main (String[] args){
        String s1 = "dvdf";
        System.out.println(lengthOfLongestSubstring4(s1));

        String s2 = "bbbbb";
        System.out.println(lengthOfLongestSubstring4(s2));

        String s3 = "pwwkew";
        System.out.println(lengthOfLongestSubstring4(s3));

        String s4 = "";
        System.out.println(lengthOfLongestSubstring4(s4));

        String s5 = " ";
        System.out.println(lengthOfLongestSubstring4(s5));
    }

    public static int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        for(int i = 0; i < s.length(); i++){
            int length = 1;
            Set<Character> chk = new HashSet<>();
            chk.add(s.charAt(i));
            for(int j = i+1 ; j < s.length(); j++){
                if(chk.contains(s.charAt(j))) break;
                chk.add(s.charAt(j));
                length++;
            }
            maxLength = Math.max(maxLength, length);
        }
        return maxLength;
    }

    public static int lengthOfLongestSubstring2(String s) {
        if (s.length() == 0) return 0;
        boolean[] occurrence = new boolean[256];
        Queue<Character> substr = new LinkedList<>();
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(occurrence[ch]) {
                maxLength = Math.max(maxLength, substr.size());
                while(substr.element() != ch){
                    occurrence[substr.element()] = false;
                    substr.remove();
                }
                substr.remove();
            }
            occurrence[ch] = true;
            substr.add(ch);
        }
        return Math.max(maxLength, substr.size());
    }

    public static int lengthOfLongestSubstring3(String s) {
        if (s.length() == 0) return 0;
        boolean[] occurrence = new boolean[256];
        int maxLength = 0;
        int startPos = 0;
        int endPos = 0;
        for (; endPos < s.length(); endPos++) {
            char ch = s.charAt(endPos);
            if(occurrence[ch]) {
                maxLength = Math.max(maxLength, endPos - startPos);
                while(s.charAt(startPos) != ch){
                    occurrence[s.charAt(startPos)] = false;
                    startPos++;
                }
                startPos++;
            }
            occurrence[ch] = true;
        }
        return Math.max(maxLength, endPos - startPos);
    }

    public static int lengthOfLongestSubstring4(String s) {
        if (s.length() == 0 || s.length() == 1) return s.length();
        int maxLength = 0;
        int startPos = 0;
        int endPos = 0;
        for (; endPos < s.length(); endPos++) {
            if(s.length() - startPos < maxLength) return maxLength;
            char ch = s.charAt(endPos);
            int firstIndex = s.indexOf(ch, startPos);
            if(firstIndex < endPos) {
                maxLength = Math.max(maxLength, endPos - startPos);
                startPos = firstIndex + 1;
            }
        }
        return Math.max(maxLength, endPos - startPos);
    }

//    public static int lengthOfLongestSubstring(String s) {
//        if (s.length() == 0) return 0;
//        int max = 0;
//        int[] lastIndex = new int[256];
//        for(int i = 0; i < lastIndex.length; i++){
//            lastIndex[i] = -1;
//        }
//
//        for(int i = 0; i < s.length(); i++){
//            int ascii = s.charAt(i);
//            if(lastIndex[ascii] >= 0){
//                max = Math.max(i-lastIndex[ascii], max);
//            }
//            lastIndex[ascii] = i;
//        }
//        return max == 0 ? s.length() : max;
//    }
}
