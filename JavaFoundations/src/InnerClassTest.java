/**
 * Created by wyzhangdongsheng1 on 2014/9/4.
 */
public class InnerClassTest {
    public static void main(String[] args) {
        ShadowTest st = new ShadowTest();
        ShadowTest.InnerClassSha ics = st.new InnerClassSha();
        ics.listAll();
    }
}

class ShadowTest{
    private static int x = 0;

   class InnerClassSha{
        private int x = 1;
        public void listAll(){
            System.out.println("x = " + x);
            System.out.println("this.x = " + this.x);
            System.out.println("ShadowTest.this.x = " + ShadowTest.this.x);
        }
    }
}