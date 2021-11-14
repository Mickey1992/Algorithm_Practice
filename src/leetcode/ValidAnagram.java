package leetcode;

import java.util.Arrays;

public class ValidAnagram {
    public static void main(String[] args){
        System.out.println(isAnagram3("anagram", "nagaram"));
        System.out.println(isAnagram3("rat  ", "car"));
    }

    // the same as No383. Ransom Note, Soluition 3
    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;

        int[] lastIndex = new int[26];
        for(int i = 0 ; i < s.length(); i++){
            int index = t.indexOf(s.charAt(i), lastIndex[s.charAt(i)-'a']);
            if (index < 0) return false;
            lastIndex[s.charAt(i)-'a'] = index + 1;
        }
        return true;
    }
    // sort
    public static boolean isAnagram2(String s, String t) {
        if(s.length() != t.length())
            return false;
        char[] charS = s.toCharArray();
        Arrays.sort(charS);

        char[] charT = t.toCharArray();
        Arrays.sort(charT);

        return Arrays.equals(charS, charT);
    }

    // occurrence
    public static boolean isAnagram3(String s, String t) {
        if(s.length() != t.length())
            return false;

        int[] occurrence = new int[26];
        for(int i = 0 ; i < s.length(); i++){
            occurrence[s.charAt(i)- 'a']++;
        }

        for(int i = 0 ; i < t.length(); i++){
            if (--occurrence[t.charAt(i)- 'a'] < 0) return false;
        }
        return true;
    }

    // occurrence2
    public static boolean isAnagram4(String s, String t) {
        if(s.length() != t.length())
            return false;

        int[] occurrenceS = new int[26];
        for(int i = 0 ; i < s.length(); i++){
            occurrenceS[s.charAt(i)- 'a']++;
        }

        int[] occurrenceT = new int[26];
        for(int i = 0 ; i < t.length(); i++){
            occurrenceT[t.charAt(i)- 'a']++;
        }

        for(int i = 0 ; i < 26; i++){
            if(occurrenceT[i] != occurrenceS[i]) return false;
        }
        return true;
    }
}
