/**
 * Created by wyzhangdongsheng1 on 2014/9/3.
 */
public class EnumTestDay {
    Day day;

    public EnumTestDay(Day day) {
        this.day = day;
    }

    public void tellItLikeItIs() {
        switch (day) {
            case MONDAY:
                System.out.println("Mondays are bad.");
                break;

            case FRIDAY:
                System.out.println("Fridays are better.");
                break;

            case SATURDAY:
            case SUNDAY:
                System.out.println("Weekends are best.");
                break;

            default:
                System.out.println("Midweek days are so-so.");
                break;
        }
    }

    public static void main(String[] args) {
//        EnumTestDay firstDay = new EnumTestDay(Day.MONDAY);
//        firstDay.tellItLikeItIs();
//        EnumTestDay secondDay = new EnumTestDay(Day.TUESDAY);
//        secondDay.tellItLikeItIs();
        for(int i = 0; i < 1000; i++){
            for(int k = 0; k < 1000; k++){
                System.out.print("zds:" + i * k);
            }
            System.out.println();
        }
    }
}
