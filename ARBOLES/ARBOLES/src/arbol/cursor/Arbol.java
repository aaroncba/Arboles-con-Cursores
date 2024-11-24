package arbol.cursor;
import arbol.nodo.Nodo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List; 

public class Arbol {

	public Nodo[] cursor;
	//True si esta siendo usado y false si esta vacio
	public boolean[] espacios = new boolean[100]; 
	public int raiz; 

	public Arbol() {
		this.cursor = new Nodo[100]; 
		for(int i = 0; i<100; i++) {
			this.cursor[i] = new Nodo(); 
		}
		Arrays.fill(this.espacios, false);
		raiz = -1; 
	}
	
	

	
	
	public int getEmptyCell() {
		int vacio = -1; 
		for(int i = 0; i<100; i++) {
			if(this.espacios[i] == false) {
				return i; 
			}
		}
		return vacio; 
	}
	
	
	public int RAIZ() {
		return this.raiz; 
	}
	
	@SuppressWarnings("unchecked")
	public <T> T ETIQUETA(int n) {
		return (T) cursor[n].getDato();
	}
	
	public int PADRE(Nodo n) {
		return n.getNodoPadre();
	}
	
	public int HIJO_MAS_IZQ(int n) {
		if(!cursor[n].isExistenHijos()) return -1; 
		//System.out.println("revisando nodo con etiqueta: " + ETIQUETA(n));
		return (int)cursor[n].getHijos().get(0); 
	}
	
	public int HERMANO_DER(int n) {
		//System.out.println(";alskjf;lajksdf " + cursor[n].getNodoPadre());
		if(cursor[n].getNodoPadre() == -1) return -1; 
		Nodo padre = this.cursor[cursor[n].getNodoPadre()]; 
		
		
		
		int indice =  padre.getHijos().indexOf(n); 
		if(indice == -1 || indice + 1 >= padre.getHijos().size()) return -1; 
		
		return  (int) padre.getHijos().get(indice + 1); 
	}
	
	public void ANULA(Arbol a) {
		this.cursor = new Nodo[100]; 
		for(int i = 0; i<100; i++) {
			this.cursor[i] = new Nodo(); 
		}
		Arrays.fill(this.espacios, false);
		raiz = -1; 
	}
	
	
	
	/*
	 * SECCION PARA LOS CREA 
	 * */
	public  <T> int CREA0(T vertice) {
	    int emptyCell = getEmptyCell();
	    if(emptyCell == -1) System.out.println("No hay espacio en el cursor");
	    Nodo<T> padre = new Nodo<>(); 
	    cursor[emptyCell] = padre;
	    raiz = emptyCell;
	    padre.setDato(vertice);
	    this.espacios[emptyCell] = true; 
	    return emptyCell; 
	}
	
	
	//@SuppressWarnings("unchecked")
	public <T> int CREA1(T vertice, int A1) {
	    int emptyCell = getEmptyCell(); 
	    if (emptyCell == -1) {
	        System.out.println("No hay espacio en el cursor");
	        return -1;
	    }
	    Nodo<T> padre = new Nodo<>();
	    padre.setDato(vertice);
	    cursor[emptyCell] = padre;
	    setHijo(A1, emptyCell);
	    this.espacios[emptyCell] = true;
	    raiz = emptyCell;
	    
	    return emptyCell; 
	}

	
	
	public <T> int CREA2(T vertice, int A1, int A2) {
	    int emptyCell = getEmptyCell(); 
	    if(emptyCell == -1) {System.out.println("No hay espacio en el cursor"); return -1;}
	    Nodo<T> padre = new Nodo<>(); 
	    cursor[emptyCell] = padre;
	    setHijo(A1, emptyCell); 
	    setHijo(A2, emptyCell);
	    raiz = emptyCell;
	    padre.setDato(vertice);
	    this.espacios[emptyCell] = true; 
	    
	    return emptyCell; 
	}
	
	public <T> int CREA3(T vertice, int A1, int A2, int A3) {
	    int emptyCell = getEmptyCell(); 
	    if(emptyCell == -1) {System.out.println("No hay espacio en el cursor"); return -1;}
	    Nodo<T> padre = new Nodo<>(); 
	    cursor[emptyCell] = padre;
	    setHijo(A1, emptyCell); 
	    setHijo(A2, emptyCell);
	    setHijo(A3, emptyCell);
	    raiz = emptyCell;
	    padre.setDato(vertice);
	    this.espacios[emptyCell] = true; 
	    
	    return emptyCell; 
	}
	
	public <T> int CREA4(T vertice, int A1, int A2, int A3, int A4) {
	    int emptyCell = getEmptyCell(); // Get an empty cell to place the new node
	    
	    if (emptyCell == -1) {
	        System.out.println("No hay espacio en el cursor");
	        return -1; // If no empty cell is available, return -1
	    }
	    
	    Nodo<T> padre = new Nodo<>(); // Create a new node (padre)
	    cursor[emptyCell] = padre; // Store the new node at the empty cell
	    
	    // Set the children for the new node
	    setHijo(A1, emptyCell);
	    setHijo(A2, emptyCell);
	    setHijo(A3, emptyCell);
	    setHijo(A4, emptyCell);
	    
	    raiz = emptyCell; // Set the new node as the root of the tree
	    padre.setDato(vertice); // Set the data for the new node
	    
	    this.espacios[emptyCell] = true; // Mark the cell as occupied
	    
	    return emptyCell; // Return the index of the newly created node
	}
	
	public <T> int CREA5(T vertice, int A1, int A2, int A3, int A4, int A5) {
	    int emptyCell = getEmptyCell(); // Get an empty cell to place the new node
	    
	    if (emptyCell == -1) {
	        System.out.println("No hay espacio en el cursor");
	        return -1; // If no empty cell is available, return -1
	    }
	    
	    Nodo<T> padre = new Nodo<>(); // Create a new node (padre)
	    cursor[emptyCell] = padre; // Store the new node at the empty cell
	    
	    // Set the children for the new node
	    setHijo(A1, emptyCell);
	    setHijo(A2, emptyCell);
	    setHijo(A3, emptyCell);
	    setHijo(A4, emptyCell);
	    setHijo(A5, emptyCell);
	    
	    raiz = emptyCell; // Set the new node as the root of the tree
	    padre.setDato(vertice); // Set the data for the new node
	    
	    this.espacios[emptyCell] = true; // Mark the cell as occupied
	    
	    return emptyCell; // Return the index of the newly created node
	}
	
	public <T> int CREA6(T vertice, int A1, int A2, int A3, int A4, int A5, int A6) {
	    int emptyCell = getEmptyCell(); // Get an empty cell to place the new node
	    
	    if (emptyCell == -1) {
	        System.out.println("No hay espacio en el cursor");
	        return -1; // If no empty cell is available, return -1
	    }
	    
	    Nodo<T> padre = new Nodo<>(); // Create a new node (padre)
	    cursor[emptyCell] = padre; // Store the new node at the empty cell
	    
	    // Set the children for the new node
	    setHijo(A1, emptyCell);
	    setHijo(A2, emptyCell);
	    setHijo(A3, emptyCell);
	    setHijo(A4, emptyCell);
	    setHijo(A5, emptyCell);
	    setHijo(A6, emptyCell);
	    
	    raiz = emptyCell; // Set the new node as the root of the tree
	    padre.setDato(vertice); // Set the data for the new node
	    
	    this.espacios[emptyCell] = true; // Mark the cell as occupied
	    
	    return emptyCell; // Return the index of the newly created node
	}

	
	public <T> int CREA7(T vertice, int A1, int A2, int A3, int A4, int A5, int A6, int A7) {
	    int emptyCell = getEmptyCell(); // Get an empty cell to place the new node
	    
	    if (emptyCell == -1) {
	        System.out.println("No hay espacio en el cursor");
	        return -1; // If no empty cell is available, return -1
	    }
	    
	    Nodo<T> padre = new Nodo<>(); // Create a new node (padre)
	    cursor[emptyCell] = padre; // Store the new node at the empty cell
	    
	    // Set the children for the new node
	    setHijo(A1, emptyCell);
	    setHijo(A2, emptyCell);
	    setHijo(A3, emptyCell);
	    setHijo(A4, emptyCell);
	    setHijo(A5, emptyCell);
	    setHijo(A6, emptyCell);
	    setHijo(A7, emptyCell);
	    
	    raiz = emptyCell; // Set the new node as the root of the tree
	    padre.setDato(vertice); // Set the data for the new node
	    
	    this.espacios[emptyCell] = true; // Mark the cell as occupied
	    
	    return emptyCell; // Return the index of the newly created node
	}

	
	
	public void setHijo(int Hijo, int Padre) {
	    // Verificar que los índices son válidos
	    if (Padre < 0 || Padre >= cursor.length || cursor[Padre] == null) {
	        System.out.println("Error: índice del padre inválido o nodo padre nulo.");
	        return;
	    }
	    if (Hijo < 0 || Hijo >= cursor.length || cursor[Hijo] == null) {
	        System.out.println("Error: índice del hijo inválido o nodo hijo nulo.");
	        return;
	    }
	    
	    // Marcar que el padre tiene hijos
	    cursor[Padre].setExistenHijos(true);
	    
	    // Agregar el índice del hijo a la lista de hijos del padre
	    cursor[Padre].agregarHijo(Hijo);
	    
	    // Establecer al padre del nodo hijo
	    cursor[Hijo].setNodoPadre(Padre);
	}

	
	
	public int getAltura(int nodeIndex) {
	    if (cursor[nodeIndex] == null) {
	        return -1;  // Base case: empty node or invalid index has height -1
	    }

	    // If the node has no children, it is a leaf node
	    if (cursor[nodeIndex].getHijos().isEmpty()) {
	        return 0;  // Leaf nodes have height 0
	    }

	    // Recursive case: get the height of all children and return the max height
	    int maxHeight = 0;
	    List<Integer> hijos = cursor[nodeIndex].getHijos();
	    for (int hijoIndex : hijos) {
	        int childHeight = getAltura(hijoIndex); // Recursively get height of child
	        maxHeight = Math.max(maxHeight, childHeight); // Find max height among children
	    }

	    // Add 1 to account for the current node
	    return maxHeight + 1;
	}

    // Utility function to get the height of the entire tree starting from the root
    public int getAlturaArbol() {
        return getAltura(raiz); // Assuming raiz holds the index of the root node
    }
	
    
    public void imprimirArbol(Arbol a) {
    	System.out.println("Index | Hijo Izquierdo | Nodo             | Hijos Derechos");

    	for (int i = 0; i < 100; i++) {
    	    if (a.cursor[i] == null) continue; // Skip null entries in the cursor

    	    // Print Index
    	    System.out.printf("%-5d | ", i);

    	    // Print Hijo Izquierdo
    	    int hijoIzq = a.HIJO_MAS_IZQ(i);
    	    System.out.printf("%-14s | ", (hijoIzq != -1 ? hijoIzq : "-1"));

    	    // Print Nodo (Dato) with null-check
    	    String dato = (a.cursor[i].getDato() != null) ? a.cursor[i].getDato().toString() : "null";
    	    System.out.printf("%-16s | ", dato);

    	    // Print Hijos Derechos
    	    List<Integer> hijos = a.cursor[i].getHijos();
    	    if (hijos.isEmpty() || hijos.size() == 1) {
    	        // No hijos derechos
    	        System.out.print("-1");
    	    } else {
    	        for (int k = 1; k < hijos.size(); k++) {
    	            System.out.print(hijos.get(k));
    	            if (k < hijos.size() - 1) System.out.print(", "); // Add commas between siblings
    	        }
    	    }

    	    System.out.println(); // New line for the next entry
    	}



    }
    
	public static void main(String[] args) {
        
        
        Arbol a = new Arbol(); 
        
        int a1 = a.CREA0(1);
        int a2 = a.CREA0(2); 
        int a3 = a.CREA0(3); 
        int a4 = a.CREA0(4); 
        
        int a5 = a.CREA1(5, a1);
        int a6= a.CREA1(6, a2); 
        
        
        int a7 = a.CREA3(7, a5, a6, a3); 
        int a8 = a.CREA2(8, a7, a4);
        
        int a9 = a.CREA7(9, a8, a.CREA0(91), a.CREA0(92), a.CREA0(93), a.CREA0(94), a.CREA0(95), a.CREA0(96)); 
        int a10 = a.CREA1(10, a9);
        
        
       // System.out.println("hijo de a10 " + a.cursor[a10].getHijos().toString());
        a.imprimirArbol(a);
        
    }

	
	
}
