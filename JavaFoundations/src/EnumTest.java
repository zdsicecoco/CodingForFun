import java.util.Scanner;

/**
 * Created by wyzhangdongsheng1 on 2014/9/2.
 */
public class EnumTest {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a size:");
        String input = in.next().toUpperCase();
        Size size = Enum.valueOf(Size.class, input);
        System.out.println("Size:" + size);
        System.out.println("Abbreviation:" + size.getAbbreviation());
        if (size == Size.EXTRA_LARGE)
            System.out.println("Good job.");
    }
}

enum Size{
    SMALL("S"),MEDIA("M"),LARGE("L"),EXTRA_LARGE("XL");
    private String abbreviation;
    private Size(String abbreviation){
        this.abbreviation = abbreviation;
    }
    public String getAbbreviation(){
        return this.abbreviation;
    }
}