package String_Array_Matrix;

/**
 * Created by wyzhangdongsheng1 on 2014/9/9.
 */
public class RegularExpressionMatchingInJava {
    public boolean isMatch(String s, String p) {
        if (p.length() == 0)
            return s.length() == 0;
        if (p.length() == 1 || p.charAt(1) != '*') {
            if (s.length() < 1 || (p.charAt(0) != '.' && s.charAt(0) != p.charAt(0)))
                return false;
            return isMatch(s.substring(1), p.substring(1));
        } else {
            int len = s.length();
            int i = -1;
            while (i < len && (i < 0 || p.charAt(0) == '.' || p.charAt(0) == s.charAt(i))) {
                if (isMatch(s.substring(i + 1), p.substring(2)))
                    return true;
                i++;
            }
            return false;
        }
    }
}
