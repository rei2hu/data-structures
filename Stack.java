public class Stack {

    private class Node {
        
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }

    }

    Node top;
    int size;

    public Stack() {
    
    }

    public int push(int data) {
        if (size == 0) {
            top = new Node(data);
        } else {
            Node oldTop = top;
            top = new Node(data);
            top.next = oldTop;
        }
        size++;
        return data;
    }

    public int peek() throws Exception {
        if (size == 0) throw new Exception("empty stack");
        return top.data;
    }

    public int pop() throws Exception {
        if (size == 0) throw new Exception("empty stack");
        Node temp = top;
        top = top.next;
        return temp.data;
    }

    public int size() {
        return size;
    }
}
