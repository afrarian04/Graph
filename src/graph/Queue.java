/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import java.util.LinkedList;

/**
 *
 * @author Afra Rian
 */
public class Queue {
    LinkedList antrian;

    public Queue() {
        antrian = new LinkedList();
    }
    
    public void enqueue (int elemen){
        antrian.add(elemen);
    }
    
    public int dequeue(){
        return (int) antrian.remove();
    }
    
    public int size(){
        return antrian.size();
    }
    
    public boolean isEmpty(){
        return size()==0;
    }       
}
