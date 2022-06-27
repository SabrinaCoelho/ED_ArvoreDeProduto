package br.edu.univas.si3.ed.model;

import java.util.ArrayList;
import java.util.List;

public class Produto {
	private String nome; 
	private float valorUnitario;
	private float quantidade;
	private List<Produto> subPecas = new ArrayList();
	//
	public Produto(String nome, float valorUnitario, float quantidade, List<Produto> subPecas) {
		this.nome = nome;
		this.valorUnitario = valorUnitario;
		this.quantidade = quantidade;
		this.subPecas = subPecas;
	}
	public Produto(String nome, float valorUnitario, float quantidade) {
		this.nome = nome;
		this.valorUnitario = valorUnitario;
		this.quantidade = quantidade;
		
	}
	//
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public float getValorUnitario() {
		return valorUnitario;
	}
	public void setValorUnitario() {
		if(this.subPecas.size() != 0) {
			float vU = 0;
			for(Produto p : this.subPecas) {
				vU += p.valorUnitario * p.quantidade;
			}
			
			this.valorUnitario = vU;
			
		}
	}
	public float getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(float quantidade) {
		this.quantidade = quantidade;
	}
	public List<Produto> getSubPecas() {
		return subPecas;
	}
	public void setSubPecas(List<Produto> subPecas) {
		this.subPecas = subPecas;
	}
	
	
}
