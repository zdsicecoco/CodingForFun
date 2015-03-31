package classes_and_interfaces;

/**
 * Created by wyzhangdongsheng1 on 2014/10/20.
 */
public final class Complex {
    private final double re;
    private final double im;

    private Complex(double re, double im){
        this.re = re;
        this.im  = im;
    }

    public static Complex valueOf(double re, double im){
        return new Complex(re, im);
    }
}
