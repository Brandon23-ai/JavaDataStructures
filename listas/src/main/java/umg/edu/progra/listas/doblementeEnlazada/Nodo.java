/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package umg.edu.progra.listas.doblementeEnlazada;

/**
 *
 * @author btmor
 */
public class Nodo {
    
    	int data;
	Nodo prev;
	Nodo next;

    public Nodo(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
    
}
