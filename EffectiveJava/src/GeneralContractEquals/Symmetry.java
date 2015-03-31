package GeneralContractEquals;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by wyzhangdongsheng1 on 2014/9/11.
 */
public class Symmetry {
    public static void main(String[] args) {
        CaseInsensitiveString cis = new CaseInsensitiveString("Zds");
        String s = "zds";
        System.out.println(cis.equals(s));
        System.out.println(s.equals(cis));

        ArrayList<CaseInsensitiveString> list = new ArrayList<CaseInsensitiveString>();
        list.add(new CaseInsensitiveString("zds"));
        list.add(new CaseInsensitiveString("Zde"));
        System.out.println(list.contains("zds"));

        AtomicInteger counter = new AtomicInteger();
        counter.addAndGet(1);
        System.out.println(counter.get());

    }
}

final class CaseInsensitiveString{
    private final String s;
    public CaseInsensitiveString(String s){
        if(s == null)
            throw new NullPointerException();
        else
            this.s  = s;
    }
    //violates symmetry

    @Override
    public boolean equals(Object obj) {
        return  obj instanceof CaseInsensitiveString && ((CaseInsensitiveString) obj).s.equals(s);
    }
}
