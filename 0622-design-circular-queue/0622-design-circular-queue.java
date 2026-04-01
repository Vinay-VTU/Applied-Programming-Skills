class MyCircularQueue {
    private int[] data;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    // Initialize the queue with given capacity
    public MyCircularQueue(int k) {
        capacity = k;
        data = new int[k];
        front = 0;
        rear = -1;
        size = 0;
    }

    // Insert element into circular queue
    public boolean enQueue(int value) {
        if (isFull()) return false;
        rear = (rear + 1) % capacity;
        data[rear] = value;
        size++;
        return true;
    }

    // Delete element from circular queue
    public boolean deQueue() {
        if (isEmpty()) return false;
        front = (front + 1) % capacity;
        size--;
        return true;
    }

    // Get front item
    public int Front() {
        if (isEmpty()) return -1;
        return data[front];
    }

    // Get rear item
    public int Rear() {
        if (isEmpty()) return -1;
        return data[rear];
    }

    // Check if queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Check if queue is full
    public boolean isFull() {
        return size == capacity;
    }
}
