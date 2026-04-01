class MyCircularDeque {
    private int[] data;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    // Initialize the deque with given capacity
    public MyCircularDeque(int k) {
        capacity = k;
        data = new int[k];
        front = 0;
        rear = -1;
        size = 0;
    }

    // Add item at the front
    public boolean insertFront(int value) {
        if (isFull()) return false;
        front = (front - 1 + capacity) % capacity;
        data[front] = value;
        size++;
        if (size == 1) rear = front; // first element
        return true;
    }

    // Add item at the rear
    public boolean insertLast(int value) {
        if (isFull()) return false;
        rear = (rear + 1) % capacity;
        data[rear] = value;
        size++;
        if (size == 1) front = rear; // first element
        return true;
    }

    // Delete item from the front
    public boolean deleteFront() {
        if (isEmpty()) return false;
        front = (front + 1) % capacity;
        size--;
        return true;
    }

    // Delete item from the rear
    public boolean deleteLast() {
        if (isEmpty()) return false;
        rear = (rear - 1 + capacity) % capacity;
        size--;
        return true;
    }

    // Get front item
    public int getFront() {
        if (isEmpty()) return -1;
        return data[front];
    }

    // Get rear item
    public int getRear() {
        if (isEmpty()) return -1;
        return data[rear];
    }

    // Check if deque is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Check if deque is full
    public boolean isFull() {
        return size == capacity;
    }
}
