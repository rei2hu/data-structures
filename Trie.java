
public class Trie {

    Node root = new Node(' ');

    private class Node {

        Node[] letters = new Node[26];
        char letter;
        boolean isEnd;
        int size;

        public Node(char c) {
            letter = c;
        }
    
        // return the new node so easy
        // iteration
        public Node add(char c) {
            if (letters[c - 'a'] == null) {
                letters[c - 'a'] = new Node(c);
                size++;
            }
            return letters[c - 'a'];
        }
    
        public void remove(char c) {
            size--;
            letters[c - 'a'] = null;
            
        }

        public void setEnd(boolean end) {
            this.isEnd = end;
        }

    }

    public Trie() {

    }

    public String insert(String s) {
        s = s.toLowerCase();
        Node here = root;
        for (char c : s.toCharArray()) {
            here = here.add(c);
        }
        here.setEnd(true);
        return s;
    }

    public boolean contains(String s) {
        s = s.toLowerCase();
        Node here = root;
        for (char c : s.toCharArray()) {
            here = here.letters[c - 'a'];
            if (here == null) return false;
        }
        return here.isEnd;
    }

    // not checking if its not in tree but thats ok
    // so one case is if tree has words 
    // abc, abcd
    // and you try to remove abc
    // nothing happens except you remove d
    // if you try to remove abc
    // just change isEnd for c
    public String remove(String s) {
        java.util.Stack<Node> st = new java.util.Stack<Node>();
        s = s.toLowerCase();
        Node here = root;
        for (char c : s.toCharArray()) {
            here = st.push(here.letters[c - 'a']);
        }
        // if the end node is the only one following the previous one
        // remove the end node
        // if there are letters after the end
        // i.e.
        // trie with abcd and abc and you're looking at c
        // which has d after it
        // just change the end to false
        Node end = st.pop();
        end.setEnd(false);
        Node beforeEnd;
        // actually hwo about
        // 1. change isEnd for the last letter
        // 2. move your way back up until you find a point where
        //    the size is greater than 1 or an ending of a different word
        //    then you can disconnect
        // if its part of a larger word then dont even try removing
        if (end.size > 0) 
            return s;
        while (st.size() > 1) { // shouldbe equals 1
            end = st.pop();
            beforeEnd = st.pop();
            // if this is the end of a letter
            // or this prefix is used in more than 1 word
            // chop off here
            if (beforeEnd.isEnd || beforeEnd.size > 1) {
                beforeEnd.remove(end.letter);
                // System.out.println("Removed " + end.letter + " from " + beforeEnd.letter);
                return s;
            }
            st.push(beforeEnd);
        }
        // if you're out here you got to the root i think
        char c = st.pop().letter;
        root.remove(c);

        // System.out.println("Removed " +  c + " from root");
        return s;
    }
}
