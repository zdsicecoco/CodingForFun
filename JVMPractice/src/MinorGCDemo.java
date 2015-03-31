/**
 * Created by wyzhangdongsheng1 on 15-2-2.
 */
public class MinorGCDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(15000);
        MemoryObject object = new MemoryObject(1024 * 1024);
        for(int i = 0; i < 2; i++){
            happenMinorGC(11);
            Thread.sleep(2000);
        }
    }
    public static void happenMinorGC(int happenMinorGCIndex) throws InterruptedException {
        for(int i = 0; i < happenMinorGCIndex; i++){
            if(i == happenMinorGCIndex - 1){
                Thread.sleep(2000);
                System.out.println("minor gc should happen");
            }
            new MemoryObject(1024 * 1024);
        }
    }
}

class MemoryObject{
    private byte[] bytes;
    public MemoryObject(int objectSize){
        this.bytes = new byte[objectSize];
    }
}
