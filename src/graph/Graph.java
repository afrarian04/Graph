/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Stack;

/**
 *
 * @author Afra Rian
 */
public class Graph {

    private Vertex[] vertexList;
    private int[][] adjacencyMatrix;
    private int maxVertex;
    private int count = 0;

    private LinkedList<LinkedList<Integer>> vertexGroups
            = new LinkedList<LinkedList<Integer>>();
    private LinkedList<Edge> kruskalEdges = new LinkedList<Edge>();

    public Graph(int maxVertex) {
        this.maxVertex = maxVertex;
        vertexList = new Vertex[maxVertex];
        adjacencyMatrix = new int[maxVertex][maxVertex];

        for (int i = 0; i < adjacencyMatrix.length; i++) {
            for (int j = 0; j < adjacencyMatrix.length; j++) {
                if (i == j) {
                    adjacencyMatrix[i][j] = 0;
                }
            }
        }
    }

    public void addVertex(char label) {
        if (count < maxVertex) {
            vertexList[count] = new Vertex(label);
            count++;
        }
    }

    public void addEdge(char source, char target, int weight) {
        int indexSource = indexVertex(source);
        int indexTarget = indexVertex(target);

        if (indexSource != -1
                && indexTarget != -1
                && indexSource != indexTarget) {
            adjacencyMatrix[indexSource][indexTarget] = weight;
            adjacencyMatrix[indexTarget][indexSource] = weight;
        }

    }

    public int indexVertex(char label) {
        for (int i = 0; i < vertexList.length; i++) {
            if (vertexList[i].getLabel() == label) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        String hasil = "";
        hasil += String.format("%-3s", "+");
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            hasil += String.format("%-3s", vertexList[i].getLabel());
        }
        hasil += "\n";
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            for (int j = 0; j < adjacencyMatrix.length; j++) {
                if (j == 0) {
                    hasil += String.format("%-3s",
                            vertexList[i].getLabel());
                }
                hasil += String.format("%-3s", adjacencyMatrix[i][j]);
            }
            hasil += "\n";
        }
        return hasil;
    }

    public String show() {
        String show = "";
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            for (int j = 0; j < adjacencyMatrix.length; j++) {
                if (adjacencyMatrix[i][j] != 0) {
                    show += vertexList[i].getLabel() + " terhubung ke "
                            + vertexList[j].getLabel() + " dengan bobot "
                            + adjacencyMatrix[i][j];
                    show += "\n";
                }
            }
        }
        return show;
    }

    public void DFS() {
        int bantu;
        Stack stack = new Stack();
        stack.push(0);
        while (!stack.isEmpty()) {
            bantu = (int) stack.pop();
            if (vertexList[bantu].isFlag() == false) {
                System.out.print(vertexList[bantu].getLabel() + " ");
                vertexList[bantu].setFlag(true);
                for (int i = maxVertex - 1; i >= 0; i--) {
                    if (adjacencyMatrix[bantu][i] != 0
                            && vertexList[i].isFlag() == false) {
                        stack.push(i);
                    }
                }
            }
        }
    }

    public void BFS() {
        int bantu;
        Queue queue = new Queue();
        queue.enqueue(0);
        while (!queue.isEmpty()) {
            bantu = queue.dequeue();
            if (vertexList[bantu].isFlag() == false) {
                System.out.print(vertexList[bantu].getLabel() + " ");
                vertexList[bantu].setFlag(true);
                for (int i = 1; i <= maxVertex - 1; i++) {
                    if (adjacencyMatrix[bantu][i] != 0
                            && vertexList[i].isFlag() == false) {
                        queue.enqueue(i);
                    }
                }
            }
        }
    }

    public void Prim() {
        ArrayList<Edge> primEdges = new ArrayList<>();
        ArrayList<Integer> primVertex = new ArrayList<>();
        primVertex.add(0);
        vertexList[0].setFlag(true);
        while (primVertex.size() < vertexList.length) {
            int termMinWeight = Integer.MAX_VALUE;
            int tempMinIndexVertexI = -1;
            int tempMinIndexVertexJ = -1;
            for (int i = 0; i < primVertex.size(); i++) {
                for (int j = 0; j < vertexList.length; j++) {
                    if ((adjacencyMatrix[primVertex.get(i)][j] != 0)
                            && (vertexList[j].isFlag() == false) && (adjacencyMatrix[primVertex.get(i)][j] < termMinWeight)) {
                        termMinWeight = adjacencyMatrix[primVertex.get(i)][j];
                        tempMinIndexVertexI = primVertex.get(i);
                        tempMinIndexVertexJ = j;
                    }
                }
            }
            primVertex.add(tempMinIndexVertexJ);
            vertexList[tempMinIndexVertexJ].setFlag(true);
            primEdges.add(new Edge(tempMinIndexVertexI,
                    tempMinIndexVertexJ,
                    termMinWeight));

        }
        int totalWeight = 0;
        for (int i = 0; i < primEdges.size(); i++) {
            System.out.println("Sumber: " + vertexList[primEdges.get(i).getVertexSource()].getLabel()
                    + " Tujuan: " + vertexList[primEdges.get(i).getVertexDestination()].getLabel()
                    + " Weight: " + primEdges.get(i).getWeight());
            totalWeight = totalWeight + primEdges.get(i).getWeight();
        }

        System.out.print("Total Weight = " + totalWeight);
    }

    private LinkedList<Integer> getVertexGroup(int vertex) {
        for (LinkedList<Integer> vertexGroup : vertexGroups) {
            if (vertexGroup.contains(vertex)) {
                return vertexGroup;
            }
        }
        return null;
    }

    private void insertEdge(Edge edge) {
        int vertexA = edge.getVertexSource();
        int vertexB = edge.getVertexDestination();

        LinkedList<Integer> vertexGroupA = getVertexGroup(vertexA);
        LinkedList<Integer> vertexGroupB = getVertexGroup(vertexB);

        if (vertexGroupA == null) {
            kruskalEdges.add(edge);
            if (vertexGroupB == null) {
                LinkedList<Integer> htNewVertexGroup = new LinkedList<Integer>();
                htNewVertexGroup.add(vertexA);
                htNewVertexGroup.add(vertexB);
                vertexGroups.add(htNewVertexGroup);
            } else {
                vertexGroupB.add(vertexA);
            }
        } else if (vertexGroupB == null) {
            vertexGroupA.add(vertexB);
            kruskalEdges.add(edge);
        } else if (vertexGroupA != vertexGroupB) {
            vertexGroupA.addAll(vertexGroupB);
            vertexGroups.remove(vertexGroupB);
            kruskalEdges.add(edge);
        }
    }

    public LinkedList<Edge> getKruskalEdges() {
        ArrayList<Edge> edges = new ArrayList();
        for (int i = 0; i < maxVertex; i++) {
            for (int j = 0; j < maxVertex; j++) {
                if (adjacencyMatrix[i][j] > 0) {
                    edges.add(new Edge(i, j, adjacencyMatrix[i][j]));
                }
            }
        }
        
        Collections.sort(edges);
        
        System.out.println("Graph");
        int simpan = 0;
        for (Edge edge : edges) {
            simpan++;
//          System.out.println(edge.toString());
            insertEdge(edge);
        }
        return kruskalEdges;
    }

}
