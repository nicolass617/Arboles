package co.edu.unbosque.model;

public class Nodo {
	
	private int valor;
	private Nodo hijoIzq;
	private Nodo hijoDer;
	
	public Nodo(int v) {
		this.valor = v;
		this.hijoDer = null;
		this.hijoIzq = null;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public Nodo getHijoIzq() {
		return hijoIzq;
	}

	public void setHijoIzq(Nodo hijoIzq) {
		this.hijoIzq = hijoIzq;
	}

	public Nodo getHijoDer() {
		return hijoDer;
	}

	public void setHijoDer(Nodo hijoDer) {
		this.hijoDer = hijoDer;
	}
	
	
	 public int nodosCompletos(Nodo n) {
	        if (n == null)
	            return 0;
	        else {
	            if (n.getHijoIzq() != null && n.getHijoDer() != null)
	                return nodosCompletos(n.getHijoIzq()) + nodosCompletos(n.getHijoDer()) + 1;
	            return nodosCompletos(n.getHijoIzq()) + nodosCompletos(n.getHijoDer());
	        }
	    }

	@Override
	public String toString() {
		return "Nodo [valor=" + valor + ", hijoIzq=" + hijoIzq + ", hijoDer=" + hijoDer + "]";
	}
	
}
