package zds.serializable;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Created by wyzhangdongsheng1 on 2014/9/5.
 */
public class SerializeDemo {
    public static void main(String[] args) {
       Employee e = new Employee();
        e.setName("zds");
        e.number = 14;
        e.address = "china";
        e.SSN = 24;

        try {
            FileOutputStream fileOutputStream = new FileOutputStream("E:\\GEEK\\IDEA\\CodingForFun\\JavaFoundations\\src\\zds\\serializable\\employee.ser");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(e);
            objectOutputStream.close();
            fileOutputStream.close();
            System.out.println("Serialized data is saved in : E:\\GEEK\\IDEA\\CodingForFun\\JavaFoundations\\src\\zds\\serializable\\employee.ser");
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
