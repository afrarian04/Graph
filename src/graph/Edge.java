/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

/**
 *
 * @author Afra Rian
 */
public class Edge implements Comparable<Edge>{
    private int vertexSource;
    private int vertexDestination;
    private int weight;
    
    public Edge(int vertexSource, int vertexDestination, int weight) {
        this.vertexDestination = vertexDestination;
        this.vertexSource = vertexSource;
        this.weight = weight;
    }

    public int getVertexSource() {
        return vertexSource;
    }

    public void setVertexSource(int vertexSource) {
        this.vertexSource = vertexSource;
    }

    public int getVertexDestination() {
        return vertexDestination;
    }

    public void setVertexDestination(int vertexDestination) {
        this.vertexDestination = vertexDestination;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "(" +vertexSource + ", " + vertexDestination + ") weight : " + weight;
    }

    @Override
    public int compareTo(Edge o) {
        return (this.weight < o.weight) ? -1 : 1;
    }
    
    
}
