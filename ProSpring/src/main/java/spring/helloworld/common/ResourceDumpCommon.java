package spring.helloworld.common;

import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by wyzhangdongsheng1 on 14-12-2.
 */
public class ResourceDumpCommon {
    public static void main(String[] args) {
    }
    public void dumpStream(Resource resource) {
        InputStream is = null;
        try {
            is = resource.getInputStream();
            byte[] descBytes = new byte[is.available()];
            is.read(descBytes);
            System.out.println(new String(descBytes));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
            }
        }
    }
}
