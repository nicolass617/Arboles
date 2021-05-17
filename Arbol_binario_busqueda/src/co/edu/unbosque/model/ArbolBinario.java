package co.edu.unbosque.model;

public class ArbolBinario {
	
	private Nodo raiz;
	
	public ArbolBinario() {
		raiz = null;
	}
	
	public ArbolBinario(Nodo r) {
		this.raiz = r;
	}
	
	public void insertarNodo(int valor) {
		Nodo nuevo = new Nodo(valor);
		if(esVacio()) {
			raiz = nuevo;
		} else {
			Nodo aux = raiz;
			Nodo padre;
			while(true) {
				padre = aux;
				if(valor < aux.getValor()) {
					aux = aux.getHijoIzq();
					if(aux == null) {
						padre.setHijoIzq(nuevo);
						return;
					}
				} else {
					aux = aux.getHijoDer();
					if(aux == null) {
						padre.setHijoDer(nuevo);
						return;
					}
				}
			}
		}
	}
	
	
	
	public boolean esVacio() {
		return raiz == null;
	}

	public Nodo getRaiz() {
		return raiz;
	}
	
}
