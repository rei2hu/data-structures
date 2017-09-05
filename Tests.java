class Tests {

    public static void main(String[] args) throws Exception {

        // insert tests here

        // trie tests
        Trie t = new Trie();
        t.insert("Hello");
        assert t.contains("Hello");
        assert t.contains("hello");
        assert t.contains("hell") == false;
        t.insert("helloagain");
        assert t.contains("hello");
        assert t.contains("HELLOAGAIN");
        t.insert("abc");
        t.insert("abcd");
        assert t.contains("ABC");
        assert t.contains("AbcD");
        t.remove("abc");
        assert t.contains("ABc") == false;
        t.insert("abcdefghijklmnopqrstuvwxyz");
        assert t.contains("abcd");
        assert t.contains("abcdefghijklmnopqrstuvwxyz");
        t.remove("abcdefghijklmnopqrstuvwxyz");
        assert t.contains("abcdefghijklmnopqrstuvwxyz") == false;
        t.remove("Hello");
        assert t.contains("hello") == false;
        t.remove("helloagain");
        // end trie tests

        // graph tests
        Graph g = new Graph();
        assert g.addEdge("Here", "There") == 2;
        assert g.pathExists("Here", "There");
        assert g.pathExists("There", "Here") == false;
        assert g.addEdge("There", "Here") == 0;
        assert g.pathExists("There", "Here");
        assert g.addEdge("Home", "Here") == 1;
        assert g.pathExists("Home", "There");
        assert g.pathExists("Home", "Nonexistant") == false;
        assert g.addEdge("Nowhere", "Home") == 1;
        assert g.pathExists("Nowhere", "There");
        assert g.pathExists("There", "Nowhere") == false;
        // end graph tests

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
