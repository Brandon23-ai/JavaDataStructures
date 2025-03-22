package umg.edu.progra.listas;

/**
 *
 * @author Walter Cordova
 */
public class Nodo {

    int dato;
    Nodo enlace;
    

    @Override
    public String toString() {
        return dato + "=>" +  enlace;
    }

    public Nodo(int x) {
        dato = x;
        enlace = null;
    }

    public Nodo(int x, Nodo n) {
        dato = x;
        enlace = n;
    }

    public int leerDato() {
        return dato;
    }

    public Nodo siguiente() {
        return enlace;
    }
}
