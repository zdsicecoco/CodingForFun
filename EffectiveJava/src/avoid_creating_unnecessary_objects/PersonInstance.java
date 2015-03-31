package avoid_creating_unnecessary_objects;

import javax.sound.midi.Soundbank;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.TimeZone;

/**
 * Created by wyzhangdongsheng1 on 2014/9/9.
 */
public class PersonInstance {
    public static void main(String[] args) {
        int testNum = 2;
        Random rd = new Random();

        long start = System.currentTimeMillis();
        System.out.println("Person1 Test:");
        for (int i = 0; i < testNum; i++) {
            Person1 person1 = new Person1(new Date(rd.nextInt(100000)));
            person1.isBabyBoomer();
        }
        System.out.println(System.currentTimeMillis() - start);
        start = System.currentTimeMillis();
        System.out.println("Person2 Test:");
        for (int i = 0; i < testNum; i++) {
            Person2 person2 = new Person2(new Date(rd.nextInt(100000)));
            person2.isBabyBoomer();
        }
        System.out.println(System.currentTimeMillis() - start);
    }
}

class Person1 {
    private final Date birthDate;

    public Person1(Date birthDate) {
        this.birthDate = birthDate;
    }

    //Don't do this
    public boolean isBabyBoomer() {
        Calendar gmtCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        gmtCal.set(1946, Calendar.JANUARY, 1, 0, 0, 0);
        Date boomStart = gmtCal.getTime();
        gmtCal.set(1965, Calendar.JANUARY, 1, 0, 0, 0);
        Date boomEnd = gmtCal.getTime();
        return birthDate.compareTo(boomStart) >= 0 &&
                birthDate.compareTo(boomEnd) < 0;
    }
}

class Person2 {
    private final Date birthDate;
    private static final Date BOOM_START;
    private static final Date BOOM_END;

    static {
        Calendar gmtCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        gmtCal.set(1946, Calendar.JANUARY, 1, 0, 0, 0);
        BOOM_START = gmtCal.getTime();
        gmtCal.set(1965, Calendar.JANUARY, 1, 0, 0, 0);
        BOOM_END = gmtCal.getTime();
    }

    public Person2(Date birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isBabyBoomer() {
        return birthDate.compareTo(BOOM_START) >= 0 &&
                birthDate.compareTo(BOOM_END) < 0;
    }

}