package co.edu.unbosque.model;

public class ArbolBinario {
	
	private Nodo raiz;
	private String orden;
	
	public ArbolBinario() {
		this.raiz = null;
		this.orden = "";
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
	
	public Nodo buscarNodo(int v) {
		if(raiz == null) return null;
		Nodo aux = raiz;
        while(aux.getValor() != v) {
            if(v < aux.getValor()) {
                aux = aux.getHijoIzq();
            } else {
                aux = aux.getHijoDer();
            }
            if(aux == null) {
                return null;
            }
        }
        return aux;
    }

    public boolean eliminar(int v) {
    	if(raiz == null) return false;
    	Nodo aux = raiz;
        Nodo padre = raiz;
        boolean izq = true;
        while(aux.getValor() != v) {
            padre = aux;
            if(v < aux.getValor()) {
                izq = true;
                aux = aux.getHijoIzq();
            } else {
                izq = false;
                aux = aux.getHijoDer();
            }
            if(aux == null) {
                return false;
            }
        }
        if(aux.getHijoIzq() == null && aux.getHijoDer() == null) {
            if(aux == raiz) {
                raiz = null;
            } else if(izq){
                padre.setHijoIzq(null);
            } else {
                padre.setHijoDer(null);
            }
        } else if(aux.getHijoDer() == null) {
            if(aux == raiz) {
                raiz = aux.getHijoIzq();
            } else if(izq){
                padre.setHijoIzq(aux.getHijoIzq());
            } else {
                padre.setHijoDer(aux.getHijoIzq());
            }
        } else if(aux.getHijoIzq() == null) {
            if(aux == raiz) {
                raiz = aux.getHijoDer();
            } else if(izq){
                padre.setHijoIzq(aux.getHijoDer());
            } else {
                padre.setHijoDer(aux.getHijoDer());
            }
        } else {
            Nodo reemplazo = obtenerReemplazo(aux);
            if(aux == raiz) {
                raiz = reemplazo;
            } else if(izq) {
                padre.setHijoIzq(reemplazo);
            } else {
                padre.setHijoDer(reemplazo);
            }
            reemplazo.setHijoIzq(aux.getHijoIzq());
        }
        return true;
    }

    public Nodo obtenerReemplazo(Nodo n) {
        Nodo r = n;
        Nodo reemplazo = n;
        Nodo aux = n.getHijoDer();
        while(aux != null) {
            r = reemplazo;
            reemplazo = aux;
            aux = aux.getHijoIzq();
        }
        if(reemplazo != n.getHijoDer()) {
            r.setHijoIzq(reemplazo.getHijoDer());
            reemplazo.setHijoDer(n.getHijoDer());
        }
        return reemplazo;
    }

    public void inOrden(Nodo n) {

        if(n != null) {
            inOrden(n.getHijoIzq());
            orden+= n.getValor()+"\t  \t";
            inOrden(n.getHijoDer());
        }
    }

    public void preOrden(Nodo n) {
    	
        if(n != null) {
            orden+= n.getValor()+"\t  \t";
            inOrden(n.getHijoIzq());
            inOrden(n.getHijoDer());
        }
   
    }

    public void posOrden(Nodo n) {

        if(n != null) {
            inOrden(n.getHijoIzq());
            inOrden(n.getHijoDer());
            orden+= n.getValor()+"\t  \t";
        }
    }
	
	public boolean esVacio() {
		return raiz == null;
	}

	public Nodo getRaiz() {
		return raiz;
	}

	public String getOrden() {
		return orden;
	}

	public void setOrden(String orden) {
		this.orden = orden;
	}
	
	
	
}
