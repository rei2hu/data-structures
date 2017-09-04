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

        // start minheap test
        Heap h = new Heap(10);
        h.insert(2);
        h.insert(3);
        h.insert(1);
        h.insert(5);
        h.insert(10);
        h.insert(4);
        assert h.peek() == 1;
        assert h.remove() == 1;
        assert h.remove() == 2;
        assert h.remove() == 3;
        assert h.remove() == 4;
        assert h.remove() == 5;
        assert h.remove() == 10;
        // end minheap tests

        // dont really have a good way to test the avl
        AVLTree avl = new AVLTree();
        avl.insert(1);
        avl.insert(2);
        avl.insert(3);
        assert avl.height() == 1;
        avl.insert(4);
        assert avl.height() == 2;
        avl.insert(5);
        assert avl.height() == 2;
        avl.remove(5);
        assert avl.height() == 2;
        avl.remove(2);
        assert avl.height() == 1;
        avl.remove(1);
        assert avl.height() == 1;
        avl.remove(4);
        assert avl.height() == 0;
        // end avl tree tests


    }
}
