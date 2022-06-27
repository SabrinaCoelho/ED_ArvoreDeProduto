package br.edu.univas.si3.ed.model;

import java.util.ArrayList;
import java.util.List;

public class No {
	private Produto produto;
	private List<No> componentes = new ArrayList();//FILHOS
	//
	public No(Produto produto) {
		this.produto = produto;
		componentesParaSubNo();
	}
	private void componentesParaSubNo() {
		for(Produto p : this.produto.getSubPecas()) {
			No novoNo = new No(p);
			this.componentes.add(novoNo);
		}
	}
	public static List<No> componentesParaSubNo(List<Produto> componentes) {
		List<No> nosComponentes = new ArrayList();
		for(Produto p : componentes) {
			No novoNo = new No(p);
			nosComponentes.add(novoNo);
		}
		return nosComponentes;
	}
	//
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public List<No> getComponentes() {
		return componentes;
	}
	public void setComponentes(List<No> componentes) {
		this.componentes = componentes;
	}
	
}
