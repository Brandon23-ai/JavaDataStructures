package umg.edu.progra.listas;

/**
 *
 * @author Walter Cordova
 */
public class Principal {

    public static void main(String[] args) {
        // Crear una lista e insertar elementos en la cabeza
        Lista lista = new Lista();
        lista.insertarCabezaLista(1);
        lista.insertarCabezaLista(2);
        lista.insertarCabezaLista(3);
        lista.insertarCabezaLista(4);
        lista.insertarCabezaLista(5);
        lista.insertarCabezaLista(6);
        lista.insertarCabezaLista(6);
        lista.visualizar();        

        // Mostrar el primer elemento
        System.out.println("\n");
        System.out.println("primero: " + lista.leerPrimero());
        
        // Eliminar un elemento
        lista.eliminar(3);
        System.out.println("Lista despues de eliminar 3: " + lista);
        
        // Buscar un elemento
        Nodo dato = lista.buscarLista(4);  
        System.out.println("Dato encontrado: " + dato);
        lista.insertarLista(dato, 10);
        System.out.println("Lista despues de insertar 10: " + lista);
        
        // Buscar y modificar un dato
        dato = lista.buscarLista(5);        
        System.out.println("Dato encontrado: " + dato);
        lista.insertarLista(dato, 600);
        System.out.println("Lista despues de insertar 600: " + lista);
        
        // Visualizar la lista después de los cambios
        lista.visualizar();
        System.out.println("\n");
        
        // Invertir la lista
        lista.invertirLista();
        
        // 1. Obtener el elemento en la posición n desde el final
        Nodo elemento = lista.obtenerElementoDesdeElFinal(2);  // Ejemplo: obtener el 2do elemento desde el final
        if (elemento != null) {
            System.out.println("El elemento en la posicion 2 desde el final es: " + elemento.dato);
        }
        System.out.println("\n");

        // 2. Eliminar duplicados
        lista.eliminarDuplicados();
        System.out.println("Lista despues de eliminar duplicados: " + lista);
        System.out.println("\n");

        // 3. Obtener el tamaño de la lista
        int tamaño = lista.obtenerTamaño();
        System.out.println("El tamanioo de la lista es: " + tamaño);
        
        // Resolver ejercicios
        // Ejercicio 1: Ordenar la lista de forma ascendente
        Lista lista1 = new Lista();
        Lista lista2 = new Lista();
        
        // Agregar elementos a las listas
        lista1.insertarCabezaLista(3);
        lista1.insertarCabezaLista(1);
        lista1.insertarCabezaLista(4);
        lista1.insertarCabezaLista(2);
        lista2.insertarCabezaLista(5);
        lista2.insertarCabezaLista(7);
        lista2.insertarCabezaLista(6);
        lista2.insertarCabezaLista(8);

        // Mostrar las listas originales
        System.out.println("Lista original 1: " + lista1);
        System.out.println("Lista original 2: " + lista2);

        // Ordenar la lista de forma ascendente
        lista1.ordenarAscendente();
        System.out.println("Lista ordenada ascendente: " + lista1);

        // Unir dos listas
        lista1.unirListas(lista2);
        System.out.println("Lista unida: " + lista1);

        // Separar números pares e impares en dos listas diferentes
        Lista pares = new Lista();
        Lista impares = new Lista();
        lista1.separarParesImpares(pares, impares);
        System.out.println("Lista de pares: " + pares);
        System.out.println("Lista de impares: " + impares);
    }

}
