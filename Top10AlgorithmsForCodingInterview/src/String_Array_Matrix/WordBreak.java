package String_Array_Matrix;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by wyzhangdongsheng1 on 2014/8/29.
 */
public class WordBreak {
    public static boolean wordBreak(String s, Set<String> dict){
        return wordBreakHelper(s, dict, 0);
    }
    public static boolean wordBreakHelper(String s, Set<String> dict, int start){
        if(start == s.length()) return true;
        for(String str : dict){
            int len = str.length();
            if(start + len > s.length()) continue;
            if(s.substring(start, len + start).equals(str))
                if(wordBreakHelper(s, dict, start + len))
                    return true;
        }
        return false;
    }

    public static boolean wordBreakByDynamicTech(String s, Set<String> dict){
        int len = s.length();
        boolean[] state = new boolean[len + 1];
        state[0] = true;
        for(int i = 0; i < s.length(); i++){
            if(!state[i])
                continue;
            for(String a : dict){
                int end = a.length() + i;
                if(end > s.length())
                    continue;;
                if(state[end])
                    continue;
                if(s.substring(i, end).equals(a))
                    state[end] = true;
            }
        }
        return state[s.length()];
    }

    public static void main(String[] args) {
       String s = "programcreek";
       Set<String> dict = new HashSet<String>();
        dict.add("programcree");
        dict.add("program");
        dict.add("creek");
        System.out.println(wordBreak(s, dict));
        System.out.println(wordBreakByDynamicTech(s, dict));
    }
}
