package avoid_creating_unnecessary_objects;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * Created by wyzhangdongsheng1 on 2014/9/9.
 */
public class EliminateObsoleteObjectReferences {
}

class MyStack{
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    public MyStack() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }
    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }


    public Object popMemoryLeak() {
        if (size == 0)
            throw new EmptyStackException();
        return elements[--size];
    }
    //This is Key!
    public Object popGood(){
        if (size == 0)
            throw new EmptyStackException();
        Object obj = elements[--size];
        elements[size] = null;
        return obj;
    }
    /**
     * Ensure space for at least one more element, roughly
     * doubling the capacity each time the array needs to grow.
     */
    private void ensureCapacity() {
        if (elements.length == size)
            elements = Arrays.copyOf(elements, 2 * size + 1);
    }
}