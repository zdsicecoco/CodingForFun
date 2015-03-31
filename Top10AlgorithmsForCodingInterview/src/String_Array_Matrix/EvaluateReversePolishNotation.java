package String_Array_Matrix;

import java.util.Stack;

/**
 * Created by wyzhangdongsheng1 on 2014/8/28.
 */
public class EvaluateReversePolishNotation {
    public static void main(String[] args) {
        String[] tokens = new String[] { "2", "1", "+", "3", "*" };
        System.out.println(evalRPN(tokens));
    }

    public static Integer evalRPN(String[] tokens) {
        String operators = "-*+/";
        Stack<String> digits = new Stack<String>();
        for(String t : tokens){
            if(!operators.contains(t)){
                digits.push(t);
            } else{
                int va1 = Integer.valueOf(digits.pop());
                int va2 = Integer.valueOf(digits.pop());
                int index = operators.indexOf(t);
                switch (index) {
                    case 0: digits.push(String.valueOf(va1 - va2)); break;
                    case 1: digits.push(String.valueOf(va1 * va2)); break;
                    case 2: digits.push(String.valueOf(va1 + va2)); break;
                    case 3: digits.push(String.valueOf(va1 / va2)); break;
                    default:break;
                }
            }
        }
        return Integer.valueOf(digits.pop());

    }
}
