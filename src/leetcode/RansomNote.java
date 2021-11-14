package leetcode;

public class RansomNote {
    public static void main(String[] args){
        System.out.println(canConstruct3("a", "b"));
        System.out.println(canConstruct3("aa", "ab"));
        System.out.println(canConstruct3("aa", "aab"));
    }
    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] occurrence = new int[26];
        for(int i = 0 ; i < ransomNote.length(); i++){
            occurrence[ransomNote.charAt(i)-'a']++;
        }

        for(int i = 0 ; i < magazine.length(); i++){
            occurrence[magazine.charAt(i)-'a']--;
        }

        for(int i = 0; i < 26; i++){
            if(occurrence[i] > 0) return false;
        }
        return true;
    }

    public static boolean canConstruct2(String ransomNote, String magazine) {
        if(ransomNote.length() > magazine.length())
            return false;

        int[] occurrence = new int[26];
        for(int i = 0 ; i < magazine.length(); i++){
            occurrence[magazine.charAt(i)-'a']++;
        }

        for(int i = 0 ; i < ransomNote.length(); i++){
            if(--occurrence[ransomNote.charAt(i)-'a'] < 0) return false;
        }

        return true;
    }

    public static boolean canConstruct3(String ransomNote, String magazine) {
        if(ransomNote.length() > magazine.length())
            return false;

        int[] lastIndex = new int[26];
        for(int i = 0 ; i < ransomNote.length(); i++){
            int index = magazine.indexOf(ransomNote.charAt(i), lastIndex[ransomNote.charAt(i)-'a']);
            if (index < 0) return false;
            lastIndex[ransomNote.charAt(i)-'a'] = index + 1;
        }

        return true;
    }
}
