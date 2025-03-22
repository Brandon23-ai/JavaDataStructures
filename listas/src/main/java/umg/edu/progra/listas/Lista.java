package umg.edu.progra.listas;

/**
 *
 * @author Walter Cordova
 */
public class Lista {

    private Nodo primero;

    @Override
    public String toString() {
        return "=>" + primero;
    }

    /**
     * Constructor para inicializar una lista
     */
    public Lista() {
        primero = null;
    }

    /**
     * Devuelve el nodo inicial
     *
     * @return
     */
    public Nodo leerPrimero() {
        return primero;
    }

    /**
     * Inserta valores a la lista
     *
     * @param entrada
     */
    public void insertarCabezaLista(int entrada) {
        Nodo nuevo;
        nuevo = new Nodo(entrada);
        nuevo.enlace = primero;
        primero = nuevo;

    }

    /**
     * inserta un elemento a partir de anterior
     *
     * @param anterior
     * @param entrada
     */
    public void insertarLista(Nodo anterior, int entrada) {
        Nodo nuevo;
        nuevo = new Nodo(entrada);
        nuevo.enlace = anterior.enlace;
        anterior.enlace = nuevo;

    }

    /**
     * elimina el elemento entrada
     *
     * @param entrada
     */
    public void eliminar(int entrada) {
        Nodo actual, anterior;
        boolean encontrado;
        actual = primero;
        anterior = null;
        encontrado = false;
        // Bucle de búsqueda
        while ((actual != null) && !(actual.dato == entrada)) {
            if (!(actual.dato == entrada)) {
                anterior = actual;
                actual = actual.enlace;
            }
        }
        if (actual != null) {
            // Se distingue entre que el nodo sea el cabecera
            // o del resto de la lista
            if (actual == primero) {
                primero = actual.enlace;
            } else {
                anterior.enlace = actual.enlace;
            }
            actual = null;
        }
    }

    /**
     * busca el elemento destino
     *
     * @param destino
     * @return
     */
    public Nodo buscarLista(int destino) {
        Nodo indice;
        for (indice = primero; indice != null; indice = indice.enlace) {
            if (indice.dato == destino) {
                return indice;
            }
        }
        return null;
    }

    /**
     * recorre la lista y muestra cada dato
     */
    public void visualizar() {
        Nodo n;
        n = primero;
        while (n != null) {
            System.out.print(n.dato + " ");
            n = n.enlace;
        }
    }
    
	/**
	* Crear los metodos que se solicitan
    /**
     * 1 - Método para invertir la lista enlazada
     */
    
    public void invertirLista (){
        
        Nodo actual = primero;  
        Nodo anterior = null;   
        Nodo siguiente = null;  

        // Recorrer la lista
        while (actual != null) {
            siguiente = actual.enlace;  // Guardar el siguiente nodo (porque lo vamos a modificar)
            actual.enlace = anterior;   // Invertir la referencia: hacer que el nodo actual apunte al nodo anterior
            anterior = actual;             // Mover "anterior" a la posición actual
            actual = siguiente;            // Mover "actual" al siguiente nodo
        }

        primero = anterior;    
            System.out.println("invertido: " + primero);
    }

    
    /**
     * 2 - Método para obtener el elemento en la posición n desde el final
     */
    public Nodo obtenerElementoDesdeElFinal(int n) {
        Nodo p1 = primero;  // Puntero 1
        Nodo p2 = primero;  // Puntero 2

        // Mover el puntero p2 n posiciones adelante
        for (int i = 0; i < n; i++) {
            if (p2 == null) {
                // Si p2 es null antes de moverlo n posiciones, la lista no tiene suficiente longitud
                System.out.println("La lista es más corta que " + n + " elementos.");
                return null;  // O lanzar una excepción si prefieres
            }
            p2 = p2.enlace;
        }

        // Mover ambos punteros hasta que p2 llegue al final
        while (p2 != null) {
            p1 = p1.enlace;
            p2 = p2.enlace;
        }

        // p1 ahora está en la posición n desde el final
        return p1;  // Devolver el nodo que está en la posición n desde el final
    }

    /**
     * 3 - Método para eliminar duplicados en una lista enlazada
     */
    public void eliminarDuplicados() {
    Nodo actual = primero;
    
    while (actual != null && actual.enlace != null) {
        Nodo anterior = actual;
        Nodo siguiente = actual.enlace;

        while (siguiente != null) {
            if (actual.dato == siguiente.dato) {
                // Si los datos son iguales, eliminar el nodo siguiente
                anterior.enlace = siguiente.enlace;  // Salta el nodo duplicado
            } else {
                // Si no son iguales, mover el anterior y siguiente
                anterior = siguiente;
            }
            siguiente = siguiente.enlace;  // Avanzar al siguiente nodo
        }
        actual = actual.enlace;  // Avanzar al siguiente nodo en la lista principal
    }
}  


    /**
     * 4 - Método para obtener el tamaño de la lista enlazada
     */
    public int obtenerTamaño() {
        int tamaño = 0;
        Nodo actual = primero;
        while (actual != null) {
            tamaño++;
            actual = actual.enlace;
        }
        return tamaño;
        
    }
    
    /**
     * 5 - Metodo para ordenar la lsita de forma ascendente
     */
    public void ordenarAscendente() {
    if (primero == null) return; // Si la lista está vacía, no hacer nada.

    boolean cambiado;
        do {
            Nodo actual = primero;
            Nodo anterior = null;
            Nodo siguiente = primero.enlace;
            cambiado = false;

            while (siguiente != null) {
                if (actual.dato > siguiente.dato) {
                    // Intercambiar los valores de 'actual' y 'siguiente'
                    int temp = actual.dato;
                    actual.dato = siguiente.dato;
                    siguiente.dato = temp;
                    cambiado = true;
                }
                anterior = actual;
                actual = siguiente;
                siguiente = siguiente.enlace;
            }
        } while (cambiado);  // Continuar si hubo cambios.
    }

    public void unirListas(Lista otraLista) {
        if (otraLista.primero == null) return; // Si la segunda lista está vacía, no hacer nada.
    
        // Llegar al final de la lista actual
        Nodo actual = primero;
        while (actual.enlace != null) {
            actual = actual.enlace;
        }
    
        // Unir el último nodo de la lista actual con el primero de la otra lista
        actual.enlace = otraLista.primero;
    }
    
    public void separarParesImpares(Lista pares, Lista impares) {
        Nodo actual = primero;
        while (actual != null) {
            if (actual.dato % 2 == 0) {
                pares.insertarCabezaLista(actual.dato);  // Si el número es par, agregar a la lista de pares.
            } else {
                impares.insertarCabezaLista(actual.dato);  // Si el número es impar, agregar a la lista de impares.
            }
            actual = actual.enlace;
        }
    }


   
    
}
