package struct.algorithm.stu.linerfile;

public class QueueTest {
    private int maxSize;
    //预留一个空间作为约定
    private int front; //队列头 实
    private int rear;//队列尾 空
    private int[] arrays;

    private LinkedNode linkedFront;
    private LinkedNode linkedRear;

    public QueueTest() {
        linkedFront = new LinkedNode(0);//size 头指针
        linkedRear = linkedFront;
    }

    public QueueTest(int maxSize) {
        this.maxSize = maxSize;
        this.arrays = new int[maxSize];
        front = 0;
        rear = 0;
    }

    public boolean isFull(){
        return (rear + 1) % maxSize == front;
    }
    public boolean isEmpty(){
        return front == rear;
    }// (rear + maxSize - front) % maxSize

    public void offer(int num){
        if (isFull())return;
        arrays[rear] = num;
        rear = (rear + 1) % maxSize;
    }
    public int poll(){
        if (isEmpty())throw new RuntimeException("队列空");
        int value = arrays[front];
        front = (front + 1) % maxSize;
        return value;
    }

    private class LinkedNode{
        private int value;
        private LinkedNode next;

        public LinkedNode(int value) {
            this.value = value;
            next = null;
        }

        public LinkedNode(int value, LinkedNode next) {
            this.value = value;
            this.next = next;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public LinkedNode getNext() {
            return next;
        }

        public void setNext(LinkedNode next) {
            this.next = next;
        }
    }


}
