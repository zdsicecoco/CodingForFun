package String_Array_Matrix;

/**
 * Created by wyzhangdongsheng1 on 2014/8/28.
 */
public class FindingTheLongestPalindromicSubstring {
    public static void main(String[] args) {
        String test1 = "qesabdbase";
        System.out.println(longestPalindrom2(test1));
    }

    /**
     * Time complexity:O(n3)
     * @param s
     * @return
     */
    public static String longestPalindrom1(String s) {
        int starIndex = 0;
        int endIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                if (isPalindrom(s.substring(i, j))) {
                    if ((j - i) > (endIndex - starIndex)) {
                        starIndex = i;
                        endIndex = j;
                    }
                }
            }
        }
        return s.substring(starIndex, endIndex );
    }

    /**
     * dynamic programming
     *
     * start condition:
     * table[i][i] == 1;
     * table[i][i+1] == 1  =>  s.charAt(i) == s.charAt(i+1)
     * changing condition:
     * table[i][j] == 1  =>  table[i+1][j-1] == 1 && s.charAt(i) == s.charAt(j);
     *
     * time complexity:O(n2)
     * @param s
     * @return
     */
    public static String longestPalindrom2(String s){
        int[][] table = new int[s.length()][s.length()];
        int starIndex = 0;
        int endIndex = 0;
        for(int i = 0; i < s.length() - 1; i++){
            table[i][i] = 1;
            if(s.charAt(i) == s.charAt(i + 1)) {
                table[i][i + 1] = 1;
                if(endIndex - starIndex == 0){
                    starIndex = i;
                    endIndex = i + 1;
                }
            }
        }
        table[s.length() - 1][s.length() - 1] = 1;

        for(int l = 3; l < s.length(); l++){
            for(int i = 0; i < s.length() - l; i++){
                if(s.charAt(i + 1) == s.charAt(i + l - 1) && s.charAt(i) == s.charAt(i + l)){
                    table[i][i + l] = 1;
                    if(endIndex - starIndex < l)
                    {
                        starIndex = i;
                        endIndex = i + l + 1;
                    }
                }
            }
        }
        printTable(table);
        return s.substring(starIndex,endIndex);
    }

    public static void printTable(int[][] table){
        System.out.println("-------------------------");
        for(int i = 0; i < table.length; i++){
            for(int j = 0; j < table[i].length; j++){
                System.out.print(table[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("-------------------------");
    }

    public static boolean isPalindrom(String s) {
        for (int i = 0; i < s.length() / 2 + 1; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i))
                return false;
        }
        return true;
    }


    /**
     *
     * @param s
     * @return
     */
    public String longestPalindrome3(String s) {
        if (s.isEmpty()) {
            return null;
        }

        if (s.length() == 1) {
            return s;
        }

        String longest = s.substring(0, 1);
        for (int i = 0; i < s.length(); i++) {
            // get longest palindrome with center of i
            String tmp = helper(s, i, i);
            if (tmp.length() > longest.length()) {
                longest = tmp;
            }

            // get longest palindrome with center of i, i+1
            tmp = helper(s, i, i + 1);
            if (tmp.length() > longest.length()) {
                longest = tmp;
            }
        }

        return longest;
    }

    // Given a center, either one letter or two letter,
// Find longest palindrome
    public String helper(String s, int begin, int end) {
        while (begin >= 0 && end <= s.length() - 1 && s.charAt(begin) == s.charAt(end)) {
            begin--;
            end++;
        }
        return s.substring(begin + 1, end);
    }
}
