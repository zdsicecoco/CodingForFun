package SpringMvc.controller;

import com.sun.swing.internal.plaf.synth.resources.synth_sv;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.springframework.web.servlet.mvc.LastModified;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by wyzhangdongsheng1 on 15-1-5.
 */
public class HelloWorldLastModifiedCacheController extends AbstractController implements LastModified{
    private long lastModified;
    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.getWriter().write("<a href=>this</a>");
        return null;
    }

    @Override
    public long getLastModified(HttpServletRequest request) {
        if(lastModified == 0L){
            lastModified = System.currentTimeMillis();
            System.err.println("1");
        }
        System.err.println("2");
        System.err.println("lastModified:"+lastModified);
        return lastModified;
    }
}
