package part3;

public class Main3 {

    public static void main(String[] args) {
        MyBoundedBlockedBuffer buffer;
        buffer = new MyBoundedBlockedBuffer(10);
        Thread producer = new Thread(new MyIntProducer(buffer, 1));
        Thread consumer = new Thread(new Consumer(buffer));
        producer.start();
        consumer.start();
    }
}