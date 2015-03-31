package zds.serializable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * Created by wyzhangdongsheng1 on 2014/9/5.
 */
public class DeserializeDemo {
    public static void main(String[] args) {
        Employee e = null;
        try {
            FileInputStream fileInputStream = new FileInputStream("E:\\GEEK\\IDEA\\CodingForFun\\JavaFoundations\\src\\zds\\serializable\\employee.ser");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            e = (Employee)objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }
        System.out.println("Deserialized Employee...");
        System.out.println("Name: " + e.getName());
        System.out.println("Address: " + e.address);
        System.out.println("SSN: " + e.SSN);
        System.out.println("Number: " + e.number);
        e.mailCheck();
    }
}
