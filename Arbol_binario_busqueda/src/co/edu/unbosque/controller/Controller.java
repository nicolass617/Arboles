package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import co.edu.unbosque.model.ArbolBinario;
import co.edu.unbosque.model.Nodo;
import co.edu.unbosque.view.View;

public class Controller implements ActionListener {
   
	private View view;
	private ArbolBinario arbolBinario;
	
		
		public Controller() {
			view = new View();
			arbolBinario = new ArbolBinario();
			setActionListeners();
		}
		
		private void setActionListeners() {
			view.getPanelMenu().getBtnAgregar().addActionListener(this);
			view.getPanelMenu().getBtnBuscar().addActionListener(this);
			view.getPanelMenu().getBtnEliminar().addActionListener(this);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource() == view.getPanelMenu().getBtnAgregar()) {
				
				if(view.getPanelMenu().getTxtAgregar().getText().equals("") || !view.getPanelMenu().getTxtAgregar().getText().matches("^[+-]?[0-9]*")) {
					JOptionPane.showMessageDialog(null,"Datos Inválidos");
				}else {
					int valorNodo = Integer.parseInt(view.getPanelMenu().getTxtAgregar().getText()); 
					
					arbolBinario.insertarNodo(valorNodo);
					
					
					arbolBinario.setOrden("");
					arbolBinario.preOrden(arbolBinario.getRaiz());
					view.getPanelMenu().getPreOrden().setText("PreOrden: "+arbolBinario.getOrden());
					arbolBinario.setOrden("");
					arbolBinario.inOrden(arbolBinario.getRaiz());
					view.getPanelMenu().getInOrden().setText("InOrden: "+arbolBinario.getOrden());
					arbolBinario.setOrden("");
					arbolBinario.posOrden(arbolBinario.getRaiz());
					view.getPanelMenu().getPostOrden().setText("PostOrden "+arbolBinario.getOrden());
					
					
					view.getPanelArbol().setObjArbol(arbolBinario.getRaiz());
					
				}
			}
			
			if(e.getSource() == view.getPanelMenu().getBtnEliminar()) {
				
				if(view.getPanelMenu().getTxtEliminar().getText().equals("") || !view.getPanelMenu().getTxtEliminar().getText().matches("^[+-]?[0-9]*")) {
					JOptionPane.showMessageDialog(null,"Datos inválidos");
				}else {
					int valorNodo = Integer.parseInt(view.getPanelMenu().getTxtEliminar().getText());
					boolean eliminado = arbolBinario.eliminar(valorNodo);
					if(eliminado) {
						view.getPanelArbol().setObjArbol(arbolBinario.getRaiz());
						
						arbolBinario.setOrden("");
						arbolBinario.preOrden(arbolBinario.getRaiz());
						view.getPanelMenu().getPreOrden().setText("PreOrden: "+arbolBinario.getOrden());
						arbolBinario.setOrden("");
						arbolBinario.inOrden(arbolBinario.getRaiz());
						view.getPanelMenu().getInOrden().setText("InOrden: "+arbolBinario.getOrden());
						arbolBinario.setOrden("");
						arbolBinario.posOrden(arbolBinario.getRaiz());
						view.getPanelMenu().getPostOrden().setText("PostOrden "+arbolBinario.getOrden());
					}
					else {
						JOptionPane.showMessageDialog(null,"No se puede eliminar, el nodo de valor "+valorNodo+" no existe");
					}
				}
			}
			
			if(e.getSource() == view.getPanelMenu().getBtnBuscar()) {
				if(view.getPanelMenu().getTxtBuscar().getText().equals("") || !view.getPanelMenu().getTxtBuscar().getText().matches("^[+-]?[0-9]*")) {
					JOptionPane.showMessageDialog(null,"Datos Inválidos");
				}else {
					int valorNodo = Integer.parseInt(view.getPanelMenu().getTxtBuscar().getText());
					Nodo nodoBuscado = arbolBinario.buscarNodo(valorNodo);
					
					if(nodoBuscado==null) {
						JOptionPane.showMessageDialog(null,"El nodo "+valorNodo+" no existe en el Árbol");
					}else
					{
						Nodo hijoIzq = nodoBuscado.getHijoIzq();
						Nodo hijoDer = nodoBuscado.getHijoDer();
						if(hijoIzq==null && hijoDer == null) {
							JOptionPane.showMessageDialog(null,"El nodo "+nodoBuscado.getValor()+"si existe en el árbol");
						}else if(hijoDer==null) {
							JOptionPane.showMessageDialog(null,"El nodo "+nodoBuscado.getValor()+"si existe en el árbol"
									+"\n"+"Hijo Izquierdo: "+nodoBuscado.getHijoIzq().getValor());
						}else if(hijoIzq==null) {
							JOptionPane.showMessageDialog(null,"El nodo "+nodoBuscado.getValor()+"si existe en el árbol"
									+"\n"+"Hijo Derecho: "+nodoBuscado.getHijoDer().getValor());
						}else {
							JOptionPane.showMessageDialog(null,"El nodo "+nodoBuscado.getValor()+"si existe en el árbol"
									+"\n"+"Hijo Izquierdo: "+nodoBuscado.getHijoIzq().getValor()+"\n"
									+"Hijo Derecho: "+nodoBuscado.getHijoDer().getValor());
						}
						
						
					}
					
				}
			}
			
		}
		
}