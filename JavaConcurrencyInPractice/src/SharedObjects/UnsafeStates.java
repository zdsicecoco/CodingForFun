package SharedObjects;

/**
 * Created by wyzhangdongsheng1 on 2014/10/2.
 */
public class UnsafeStates {
    private String[] states = {"AK", "AL", "AM"};

    public String[] getStates(){
        return states;
    }


    public static void main(String[] args) {
        UnsafeStates unsafeStates = new UnsafeStates();
        String[] s = unsafeStates.getStates();
        s[0] = "AA";

        for(int i = 0; i < unsafeStates.getStates().length; i++){
            System.out.println(unsafeStates.getStates()[i]);
        }
    }
}
