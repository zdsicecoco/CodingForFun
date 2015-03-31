package reflect;

/**
 * Created by wyzhangdongsheng1 on 2014/8/28.
 */
public class ChinaMan implements China {
    private String sex;

    public ChinaMan() {
    }

    public ChinaMan(String sex) {
        this.sex = sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSex() {

        return sex;
    }

    @Override
    public void sayChina() {
        System.out.println("hello, china");
    }

    @Override
    public void sayHello(String skin, int hei) {
        System.out.println(skin + "\t" + hei);
    }
}
