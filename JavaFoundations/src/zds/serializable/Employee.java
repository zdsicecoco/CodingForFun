package zds.serializable;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by wyzhangdongsheng1 on 2014/9/5.
 */
public class Employee implements Serializable{
    private String name;
    public String address;
    public int number;
    public transient int SSN;

    public void mailCheck() {
        System.out.println("Mailing a check to " + name
                + " " + address);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {

        return name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", number=" + number +
                ", SSN=" + SSN +
                '}';
    }

    public static void main(String[] args) {
        System.out.println(new BigDecimal("2.00").subtract(new BigDecimal("1.10")));
    }
}
