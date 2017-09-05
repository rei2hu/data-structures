import java.util.*;


// graph for things with edges with equal weight
public class Graph {

    Map<String, Vertex> verticies = new HashMap<String, Vertex>();

    private class Vertex {
    
        Map<String, Vertex> adjacencies = new HashMap<String, Vertex>();
        String name;
        boolean visited; // for the traversals

        public Vertex(String name) {
            this.name = name;                
        }

        // for easy chaining purposes
        public Vertex addAdjacency(Vertex to) {
            adjacencies.put(to.name, to);
            return this;
        }

        public boolean removeAdjacency(Vertex to) {
            Vertex to2 = adjacencies.remove(to.name);
            return to2 != null;
        }

        public boolean equals(Vertex other) {
            return this.name.equals(other.name);
        }
    }

    public Graph() {

    }

    // one way edge
    // for debugging purposes
    // return 0 if both verticies alreayd existed
    // return 1 if only 1 vertex existed
    // return 2 if had to add both vertices
    public int addEdge(String from, String to) {
        int i = 0;
        // check if theyre in the graph yet
        Vertex fr = verticies.get(from);
        Vertex to2 = verticies.get(to);
        if (fr == null) {
            verticies.put(from, new Vertex(from));
            i++;
        } 
        if (to2 == null) {
            verticies.put(to, new Vertex(to));
            i++;
        }
        fr = verticies.get(from);
        fr.addAdjacency(verticies.get(to));
        return i;
    }
    
    // return true if the edge actually existed
    // false if it doesnt
    public boolean removeEdge(String from, String to) {
        Vertex fr = verticies.get(from);
        if (fr == null) return false;
        Vertex to2 = verticies.get(to);
        if (to2 == null) return false;
        return fr.removeAdjacency(to2);
    }
    
    public boolean pathExists(String from, String to) {
        Vertex check1 = verticies.get(from);
        Vertex check2 = verticies.get(to);
        if (check1 == null || check2 == null) return false;
        
        // none visited
        for (Vertex vertex : verticies.values()) {
            vertex.visited = false;
        }

        Vertex initial = verticies.get(from);
        List<Vertex> things = new ArrayList<Vertex>();
        things.add(initial);
        while (things.size() > 0) {
            Vertex check = things.remove(0);
            if (check.name.equals(to)) return true;
            for (Vertex adj : check.adjacencies.values()) {
                if (adj.visited) continue;
                things.add(adj); // check for already visited..
                adj.visited = true;
            }
        }
        return false;
    }
    
}








