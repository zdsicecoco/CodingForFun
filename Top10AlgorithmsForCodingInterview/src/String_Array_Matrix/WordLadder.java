package String_Array_Matrix;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * Created by wyzhangdongsheng1 on 2014/9/1.
 */
public class WordLadder {
    public static boolean isAccessible(String s1, String s2) {
        int num = 0;
        if(s1.length() != s2.length()) return false;
        for (int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i) != s2.charAt(i))
                num++;
            if(num > 1) return false;
        }
        if(num == 1) return true;
        else return false;
    }

    public static int wordLadderHelper(String start, String end, Set<String> set){
        if(start.equals(end)) return 0;
        for(String str : set){
            if(isAccessible(start, str)) {
                set.remove(str);
                return wordLadderHelper(str, end, set) + 1;
            }
        }
        return 0;
    }

    public static int wordLadder(String start, String end, Set<String> set){
        return wordLadderHelper(start, end, set);
    }

    public static int ladderLength(String start, String end, Set<String> dict){
        if (dict.size() == 0)
            return 0;

        LinkedList<String> wordQueue = new LinkedList<String>();
        LinkedList<Integer> distanceQueue = new LinkedList<Integer>();

        wordQueue.add(start);
        distanceQueue.add(1);


        while(!wordQueue.isEmpty()){
            String currWord = wordQueue.pop();
            Integer currDistance = distanceQueue.pop();

            if(currWord.equals(end)){
                return currDistance;
            }

            for(int i=0; i<currWord.length(); i++){
                char[] currCharArr = currWord.toCharArray();
                for(char c='a'; c<='z'; c++){
                    currCharArr[i] = c;

                    String newWord = new String(currCharArr);
                    if(dict.contains(newWord)){
                        wordQueue.add(newWord);
                        distanceQueue.add(currDistance+1);
                        dict.remove(newWord);
                    }
                }
            }
        }

        return 0;
    }
    public static void main(String[] args) {
        String start = "a";
        String end = "c";
        Set<String> set = new HashSet<String>();
        set.add("a");
        set.add("b");
        set.add("c");
        System.out.println(ladderLength(start, end, set));
    }
}
