package graph;

import java.util.LinkedList;

public class GraphMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
//        System.out.println("Nomer 2");
//        Graph no2 = new Graph(7);
//        no2.addVertex('A');
//        no2.addVertex('B');
//        no2.addVertex('C');
//        no2.addVertex('D');
//        no2.addVertex('F');
//        no2.addVertex('G');
//        no2.addVertex('H');
//        
//        no2.addEdge('A', 'B', 5);
//        no2.addEdge('A', 'D', 7);
//        no2.addEdge('A', 'F', 4);
//        no2.addEdge('B', 'C', 7);
//        no2.addEdge('B', 'D', 6);
//        no2.addEdge('C', 'D', 6);
//        no2.addEdge('C', 'G', 9);
//        no2.addEdge('C', 'H', 15);
//        no2.addEdge('D', 'G', 5);
//        no2.addEdge('F', 'G', 9);
//        no2.addEdge('G', 'H', 8);
//        
//        System.out.println(no2.toString());
//        System.out.println(no2.show());
//        no2.DFS();
//        System.out.println("");
//        System.out.println("");
//        System.out.println("Nomer 3");
//        Graph no3 = new Graph(10);
//        no3.addVertex('a');
//        no3.addVertex('b');
//        no3.addVertex('c');
//        no3.addVertex('d');
//        no3.addVertex('e');
//        no3.addVertex('f');
//        no3.addVertex('g');
//        no3.addVertex('h');
//        no3.addVertex('i');
//        no3.addVertex('j');
//        
//        no3.addEdge('a', 'b', 5);
//        no3.addEdge('a', 'c', 5);
//        no3.addEdge('b', 'd', 4);
//        no3.addEdge('b', 'e', 9);
//        no3.addEdge('c', 'd', 4);
//        no3.addEdge('c', 'f', 7);
//        no3.addEdge('d', 'e', 8);
//        no3.addEdge('d', 'f', 6);
//        no3.addEdge('e', 'f', 10);
//        no3.addEdge('e', 'g', 10);
//        no3.addEdge('e', 'h', 8);
//        no3.addEdge('e', 'i', 9);
//        no3.addEdge('f', 'g', 3);
//        no3.addEdge('g', 'h', 6);
//        no3.addEdge('g', 'j', 7);
//        no3.addEdge('h', 'i', 4);
//        no3.addEdge('h', 'j', 6);
//        no3.addEdge('i', 'j', 7);
        
        //System.out.println(no3.show());
//        System.out.println(no3.toString());
        //no3.DFS();
//        no3.Prim();
        
        System.out.println("Nomer 4");
        Graph no4 = new Graph(5);
        no4.addVertex('A');
        no4.addVertex('B');
        no4.addVertex('C');
        no4.addVertex('D');
        no4.addVertex('E');
        
        no4.addEdge('A', 'B', 5);
        no4.addEdge('A', 'D', 10);
        no4.addEdge('B', 'D', 6);
        no4.addEdge('B', 'C', 2);
        no4.addEdge('B', 'E', 7);
        no4.addEdge('C', 'E', 3);
        no4.addEdge('C', 'D', 8);
        no4.addEdge('D', 'E', 5);
        
        int total = 0;
        LinkedList<Edge> edges = no4.getKruskalEdges();
        System.out.println("Kruskal Algorithm");
        for (Edge edge : edges) {
            System.out.println(edge);
            total += edge.getWeight();
        }
        System.out.println("Total weight is " + total);
        
    }
    
}
