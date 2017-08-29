/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller2estructuras;

/**
 *
 * @author Carmen_Lucia3
 */
public class node {
    
    node next;
    int[] casillero;
    
    
}


class list {
    node start;
    node end;
    int size;
    
    public list(){
        start=null;
        end=null;
        size=0;
    }
    
    public void fill (int[] casilla){
        node recent=new node();
        recent.casillero=casilla;        
        if (start==null){
            start=recent;
            end=recent;
            start.next=end;
        }
        else{
            end.next=recent;
            end=recent;
        }
        size++;
    }
    
    public int size(){
        return size;
    }
}