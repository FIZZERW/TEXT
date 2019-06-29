public class Resource {
    int num = 0;
    int size = 10;

    //消费资源
    public synchronized void remove() {
        while (num == 0) {
            try {
                System.out.println("消费者进入等待");
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        num--;
        System.out.println("消费者线程为:" + Thread.currentThread().getName() + "--资源数量:" + num);
        this.notify();
    }
    //生产资源
    public synchronized void put() {

        while (num == size) {
            try {
                System.out.println("生产者进入等待");
                this.wait();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        num++;
        System.out.println("生产者线程为:" + Thread.currentThread().getName() + "--资源数量:" + num);
        this.notify();
    }
}
