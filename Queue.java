public class Queue {
    
    private class Node {
        
        int data;
        Node after;

        public Node(int data) {
            this.data = data;
        }

    }

    private Node head;
    private Node tail;
    private int size = 0;

    public Queue() { 
    
    }

    public int size() {
        return size;
    }

    public int enqueue(int data) {
        // if its empty
        if (head == null) {
            head = tail = new Node(data);
        // if 1 element
        } else if (size == 1) {
            head.after = tail = new Node(data);
        } else {
            Node oldTail = tail;
            oldTail.after = tail = new Node(data);
        }
        size++;
        return data;
    }

    public int dequeue() throws Exception {
        if (head == null) throw new Exception("empty q");
        Node temp = head;
        head = head.after;
        size--;
        return temp.data;
    }

    public int peek() throws Exception {
        if (head == null) throw new Exception("Empty q");
        return head.data;
    }
}
