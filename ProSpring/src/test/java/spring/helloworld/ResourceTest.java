package spring.helloworld;

import junit.framework.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.*;
import spring.helloworld.resourceloader.ResourceBean;
import spring.helloworld.resourceloader.ResourceBean3;
import sun.misc.URLClassPath;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by wyzhangdongsheng1 on 14-12-2.
 */
public class ResourceTest {
    @Test
    public void testByteArrayResource() {
        Resource resource = new ByteArrayResource("Hello World!".getBytes());
        if (resource.exists()) {
            dumpStream(resource);
        }
    }

    @Test
    public void testInputSteamResource(){
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream("Hello World!".getBytes());
        Resource resource = new InputStreamResource(byteArrayInputStream);
        if(resource.exists()){
            dumpStream(resource);
        }

        Assert.assertEquals(true, resource.isOpen());
    }

    @Test
    public void testFileResource(){
        File file = new File("d:/test.txt");
        Resource resource = new FileSystemResource(file);
        if(resource.exists()){
            dumpStream(resource);
        }
        Assert.assertEquals(false, resource.isOpen());
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

    @Test
    public void testResourceLoad(){
        ResourceLoader loader = new DefaultResourceLoader();

        Resource resource = loader.getResource("classpath:spring/helloworld/test.txt");
        Assert.assertEquals(ClassPathResource.class, resource.getClass());

        Resource resource2 = loader.getResource("file:spring/helloworld/test.txt");
        Assert.assertEquals(UrlResource.class, resource2.getClass());

        Resource resource3 = loader.getResource("spring/helloworld/test.txt");
        Assert.assertTrue(resource3 instanceof ClassPathResource);
    }

    @Test
    public void testResourceLoaderAware(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("resourceloader.xml");
        ResourceBean resourceBean = applicationContext.getBean(ResourceBean.class);
        ResourceLoader resourceLoader = resourceBean.getResourceLoader();
        Assert.assertTrue(resourceLoader instanceof ApplicationContext);
    }

    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("resourceInject.xml");
        ResourceBean3 resourceBean1 = context.getBean("resourceBean1", ResourceBean3.class);
        ResourceBean3 resourceBean2 = context.getBean("resourceBean2", ResourceBean3.class);

        Assert.assertTrue(resourceBean1.getResource() instanceof ClassPathResource);
        Assert.assertTrue(resourceBean2.getResource() instanceof ClassPathResource);
    }
}
