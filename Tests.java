class Tests {

    public static void main(String[] args) throws Exception {

        // insert tests here
        // queue tests
        Queue q = new Queue();
        q.enqueue(1);
        q.enqueue(2);
        assert q.peek() == 1;
        assert q.dequeue() == 1;
        assert q.peek() == 2;
        assert q.dequeue() == 2;
        // end queue tests

        // stack tests
        Stack s = new Stack();
        s.push(1);
        assert s.peek() == 1;
        s.push(2);
        assert s.peek() == 2;
        assert s.pop() == 2;
        assert s.pop() == 1;
        // end stack tests


    }
}