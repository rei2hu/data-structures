// not array based because ive done that so many times already
// this one will be commented because i need to actually think about
// the rules again
// min heap btw
public class Heap {

    /*
    private class Node {
        
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }

    }
    */
    
    // Node root;
    int[] elements;
    int size;

    public Heap(int maxSize) {
        elements = new int[maxSize];
    }
    
    // need to find first open spot
    // because this isnt array based heap
    // we cant just simply insert into array
    // but its probably possible to figure out
    // where the next open spot is based on the size
    // L = left
    // R = right
    // 0 - root
    // 1 - L    7 - LLL
    // 2 - R    8 - LLR
    // 3 - LL   9 - LRL
    // 4 - LR  10 - LRR
    // 5 - RL  11 - RLL
    // 6 - RR
    // basically 1 + 2 + 4 + 8 because of permutations
    // then by applying some math
    // ok im actually too lazy for this so im moving to the array
    // which is easy
    public int insert(int data) throws Exception {
        if (size == elements.length) throw new Exception("its full boss");
        elements[size++] = data;  
        int i = size - 1;
        while (i > 0 && elements[(i - 1) / 2] > elements[i]) {
            int temp = elements[(i - 1) / 2];
            elements[(i - 1) / 2] = elements[i];
            elements[i] = temp;
            i = (i - 1) / 2;
        }
        // print();
        return data;
    }

    public int remove() throws Exception {
        if (size == 0) throw new Exception("its empty boss");
        int retVal = elements[0];
        elements[0] = elements[--size];
        int i = 0;
        while ((i * 2 + 1) < size) {
            int smallest = i * 2 + 1;
            if ((i * 2 + 2) < size && elements[i * 2 + 2] < elements[smallest])
                smallest = i * 2 + 2;
            if (elements[i] < elements[smallest])
                break;
            int temp = elements[i];
            elements[i] = elements[smallest];
            elements[smallest] = temp;
            i = smallest;
        }
        return retVal;
    }


    private void print() {
        System.out.println(java.util.Arrays.toString(elements));
    }

    public int peek() throws Exception {
        if (size == 0) throw new Exception("empty heap");
        return elements[0];
    }
    
}
