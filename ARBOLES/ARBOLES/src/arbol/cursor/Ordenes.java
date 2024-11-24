package arbol.cursor;

import java.util.ArrayList;

import arbol.nodo.Nodo;

public class Ordenes {

	
	public void OrdenPrevio(Arbol A) {
	    System.out.print("{");
	    System.out.print(A.ETIQUETA(A.RAIZ()).toString());
	    ArrayList<Integer> hijos = (ArrayList<Integer>) A.cursor[A.RAIZ()].getHijos(); 
	    for (int hijo : hijos) {
	        OrdenPrevio(hijo, A, true);
	    }
	    System.out.print("}");
	}

	public void OrdenPrevio(int n, Arbol A, boolean includeComma) {
	    if (includeComma) {
	        System.out.print(", ");
	    }
	    System.out.print(A.cursor[n].getDato().toString());
	    ArrayList<Integer> hijos = (ArrayList<Integer>) A.cursor[n].getHijos(); 
	    for (int i = 0; i < hijos.size(); i++) {
	        OrdenPrevio(hijos.get(i), A, true);
	    }
	}

	
	public void OrdenPost(Arbol A) {
	    System.out.print("{");
	    ArrayList<Integer> hijos = (ArrayList<Integer>) A.cursor[A.RAIZ()].getHijos();
	    for (int i = 0; i < hijos.size(); i++) {
	        if (i > 0) {
	            System.out.print(", ");
	        }
	        OrdenPost(hijos.get(i), A);
	    }
	    if (!hijos.isEmpty()) {
	        System.out.print(", ");
	    }
	    System.out.print(A.ETIQUETA(A.RAIZ()).toString());
	    System.out.print("}");
	}

	public void OrdenPost(int n, Arbol A) {
	    ArrayList<Integer> hijos = (ArrayList<Integer>) A.cursor[n].getHijos();
	    for (int i = 0; i < hijos.size(); i++) {
	        if (i > 0) {
	            System.out.print(", ");
	        }
	        OrdenPost(hijos.get(i), A);
	    }
	    if (!hijos.isEmpty()) {
	        System.out.print(", ");
	    }
	    System.out.print(A.cursor[n].getDato().toString());
	}


	
	public void OrdenSim(Arbol A) {
	    System.out.print("{");
	    ArrayList<Integer> hijos = (ArrayList<Integer>) A.cursor[A.RAIZ()].getHijos();
	    if (!hijos.isEmpty()) {
	        OrdenSim(hijos.get(0), A);
	        System.out.print(", ");
	    }
	    System.out.print(A.ETIQUETA(A.RAIZ()).toString());
	    for (int i = 1; i < hijos.size(); i++) {
	        System.out.print(", ");
	        OrdenSim(hijos.get(i), A);
	    }
	    System.out.print("}");
	}

	public void OrdenSim(int n, Arbol A) {
	    ArrayList<Integer> hijos = (ArrayList<Integer>) A.cursor[n].getHijos();
	    if (!hijos.isEmpty()) {
	        OrdenSim(hijos.get(0), A);
	        System.out.print(", ");
	    }
	    System.out.print(A.cursor[n].getDato().toString());
	    for (int i = 1; i < hijos.size(); i++) {
	        System.out.print(", ");
	        OrdenSim(hijos.get(i), A);
	    }
	}

	
	
	public int SpaceUsed(Arbol A) {
		int count = 0; 
		for(Boolean b: A.espacios ) {
			if(b) count++; 
		}
		return count; 
	}
}
