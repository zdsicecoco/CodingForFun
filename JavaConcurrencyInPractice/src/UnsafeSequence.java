/**
 * Created by wyzhangdongsheng1 on 2014/9/23.
 */
public class UnsafeSequence {
    private int value;
    public int getNext(){
        return value++;
    }

    public static void main(String[] args) {
        System.out.println("Single Thread:");
        UnsafeSequence unsafeSequence = new UnsafeSequence();
        for(int i = 0; i < 1000; i++)
            System.out.println(unsafeSequence.getNext());

        System.out.println();
    }
}
