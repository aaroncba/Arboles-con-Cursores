package arbol.nodo;

import java.util.ArrayList;
import java.util.List;

public class Nodo<T> {
    private T dato; // Información del nodo
    private int nodoPadre; // Índice del nodo nodonodoPadre en el árbol
    private List<Integer> hijos; // Lista de índices de los hijos
    private boolean existenHijos = false; 

    // Constructor sin parámetros
    public Nodo() {
        this.dato = null;
        this.nodoPadre = -1; // -1 indica que no tiene nodoPadre (puede ser la raíz o no inicializado)
        this.hijos = new ArrayList<>();
    }

    // Constructor con dato inicial
    public Nodo(T dato, int nodoPadre) {
        this.dato = dato;
        this.nodoPadre = nodoPadre;
        this.hijos = new ArrayList<>();
    }

    // Getters y Setters
    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public int getNodoPadre() {
        return nodoPadre;
    }

    public void setNodoPadre(int nodoPadre) {
        this.nodoPadre = nodoPadre;
    }

    public List<Integer> getHijos() {
        return hijos;
    }

    // Métodos para gestionar hijos
    public void agregarHijo(int hijo) {
    	this.existenHijos = true; 
        hijos.add(hijo);
    }

    public void eliminarHijo(int hijo) {
        hijos.remove((Integer) hijo);
    }

    // Verificar si el nodo es una hoja (sin hijos)
    public boolean esHoja() {
        return hijos.isEmpty();
    }

	public boolean isExistenHijos() {
		return existenHijos;
	}

	public void setExistenHijos(boolean existenHijos) {
		this.existenHijos = existenHijos;
	}
}
