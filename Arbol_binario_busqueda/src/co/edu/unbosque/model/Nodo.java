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

	@Override
	public String toString() {
		return "Nodo [valor=" + valor + ", hijoIzq=" + hijoIzq + ", hijoDer=" + hijoDer + "]";
	}
	
}
