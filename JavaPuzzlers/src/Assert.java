/**
 * Created by wyzhangdongsheng1 on 15-1-15.
 */
public abstract class Assert {
    public static void isTrue(boolean expression, String message) {
        if (!expression) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void main(String[] args) {
    }
}
