/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package umg.edu.progra.listas.doblementeEnlazada;

/**
 *
 * @author btmor
 */
public class DoblementeEnlazada {
    private Nodo head;
	private Nodo tail;

	public DoblementeEnlazada() {
		this.head = null;
		this.tail = null;
	}

	public void insertAtEnd(int data) {
		Nodo newNode = new Nodo(data);
		if (tail == null) {
			head = tail = newNode;
		} else {
			tail.next = newNode;
			newNode.prev = tail;
			tail = newNode;
		}
	}

	public void insertAtBeginning(int data) {
		Nodo newNode = new Nodo(data);
		if (head == null) {
			head = tail = newNode;
		} else {
			newNode.next = head;
			head.prev = newNode;
			head = newNode;
		}
	}

	public boolean delete(int data) {
		Nodo current = head;
		while (current != null) {
			if (current.data == data) {
				if (current == head) {
					head = current.next;
					if (head != null)
						head.prev = null;
				} else if (current == tail) {
					tail = current.prev;
					if (tail != null)
						tail.next = null;
				} else {
					current.prev.next = current.next;
					current.next.prev = current.prev;
				}
				return true;
			}
			current = current.next;
		}
		return false;
	}

	public boolean search(int data) {
		Nodo current = head;
		while (current != null) {
			if (current.data == data) {
				return true;
			}
			current = current.next;
		}
		return false;
	}

	public void displayForward() {
		Nodo current = head;
		while (current != null) {
			System.out.print(current.data + " <-> ");
			current = current.next;
		}
		System.out.println("null");
	}

	public void displayBackward() {
		Nodo current = tail;
		while (current != null) {
			System.out.print(current.data + " <-> ");
			current = current.prev;
		}
		System.out.println("null");
	}
	
	
        
        /**
         * Método 1: Contar el número de nodos en la lista
         */
        
        public int contarNumeroNodos(){
            Nodo current = head;
            int contador = 0;
            while (current != null){
                current = current.next;
               contador++;         
            }
            return contador;
                    
        }
        
        /**
         * Método 2: Insertar un nodo después de un valor específico
         */
        
        public void insertarDespuesValor(int data) {
            Nodo current = head;
            // Recorremos la lista hasta encontrar el nodo con el valor 'data'
            while (current != null) {
                if (current.data == data) {
                    Nodo newNode = new Nodo(data);

                    // Si el nodo encontrado es el último nodo
                    if (current.next == null) {
                        current.next = newNode;
                        newNode.prev = current;
                        tail = newNode; // Actualiza el tail
                    } else { // Si el nodo encontrado no es el último nodo
                        newNode.next = current.next;
                        newNode.prev = current;
                        current.next.prev = newNode; // Actualiza el puntero prev del siguiente nodo
                        current.next = newNode; // Inserta el nuevo nodo
                    }
                    return; // Terminamos la función después de insertar
                }
                current = current.next; // Avanzamos al siguiente nodo
            }
            System.out.println("Valor no encontrado"); // Si no encontramos el valor
        }

        
        
	// Método 3: Revertir la lista doblemente enlazada
        public void revertirLista() {
            Nodo current = head;
            Nodo temp = null;

            while (current != null) {
                // Intercambiar next y prev en el nodo actual
                temp = current.prev;
                current.prev = current.next;
                current.next = temp;
                // Mover al siguiente nodo (que ahora está en "prev")
                current = current.prev;
               
            }

            // Al final, actualizar head y tail
            if (temp != null) {
                
                head = temp.prev;
                System.out.print("null ");
            }
            
        }

    
}
