package part2;

public class Main2 {

    public static void main(String[] args) throws InterruptedException {
        MyBoundedBlockedBuffer buffer = new MyBoundedBlockedBuffer(10);
        Thread prod = new Thread(new IntProducer(buffer, 1));
        Thread consumer = new Thread(new Consumer(buffer));
        prod.start();
        consumer.start();

    }
}