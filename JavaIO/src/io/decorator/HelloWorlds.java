package io.decorator;

/**
 * Created by wyzhangdongsheng1 on 2014/10/17.
 */
public class HelloWorlds {
    public static void main(String[] args) {
        for(int i = 0; i < 10; i++){
            int k = i;
            while(k-- != 0){
                System.out.print(" ");
            }
            System.out.println("hello world.");
        }
        for(int i = 0; i < 10; i++){
            int k = i;
            while(k++ != 9){
                System.out.print(" ");
            }
            System.out.println("hello world.");
        }
    }
}
