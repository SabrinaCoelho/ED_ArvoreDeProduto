package br.edu.univas.si3.ed.model;

import java.util.ArrayList;
import java.util.List;

public class Arvore {
	private No produtoFinal;
	
	private static List<No> folhas = new ArrayList();
	
	public No getProdutoFinal() {
		return produtoFinal;
	}
	public void setProdutoFinal(No produtoFinal) {
		this.produtoFinal = produtoFinal;
	}
	
	public No cadastrarProduto(Produto produto) {//produto final 
		No novoNo = new No(produto);
		this.produtoFinal = novoNo;
		return this.produtoFinal;
	}
	public No cadastrarComponente(String nomeProd, List<Produto> componentes) {
		No res = buscaComponente(nomeProd);//No pai encontrado
		//
		if(res != null) {
			res.getProduto().setSubPecas(componentes);
			res.getProduto().setValorUnitario();//atualiza
			
			List<No> teste = No.componentesParaSubNo(componentes);
			res.setComponentes(teste);
		}
		return res;
	}
	//
	public List<No> buscaComponentesFolha() { 
		buscaComponentesFolhaAux(this.produtoFinal.getComponentes());
		return this.folhas;
	}
	//
	public void buscaComponentesFolhaAux(List<No> aSerComparado) {//busca dos folhaS
			for(No n : aSerComparado) {
				if(aSerComparado.get(aSerComparado.indexOf(n)).getComponentes().size() != 0) {
					buscaComponentesFolhaAux(aSerComparado.get(aSerComparado.indexOf(n)).getComponentes());
				}else {
					folhas.add(n);
				}
			}
	}
	public float custoTotal() {
		custoTotalAux(this.produtoFinal);
		this.produtoFinal.getProduto().setValorUnitario();
		return this.produtoFinal.getProduto().getValorUnitario();
	}
	public void custoTotalAux(No noDaVez) {
		List<No> aSerComparado = noDaVez.getComponentes();
		for(No n : aSerComparado) {
			if(aSerComparado.get(aSerComparado.indexOf(n)).getComponentes().size() > 0) {
				
				custoTotalAux(aSerComparado.get(aSerComparado.indexOf(n)));
				n.getProduto().setValorUnitario();
			}
		}
		return;
	}
	
	public No buscaComponente(String compProcurado) {//busca folha
		No res = buscaComponenteAux(compProcurado, this.produtoFinal.getComponentes());
		return res;
	}
	public No buscaComponenteAux(String compProcurado, List<No> aSerComparado) {//busca folha para adicao

		No res = null;
		for(No comparado: aSerComparado) {
			if(comparado.getProduto().getNome().equalsIgnoreCase(compProcurado)) {
				return comparado;
			}
		}
		for(No n : aSerComparado) {
			if(aSerComparado.get(aSerComparado.indexOf(n)).getComponentes().size() > 0) {
				res = buscaComponenteAux(compProcurado, aSerComparado.get(aSerComparado.indexOf(n)).getComponentes());
			}
			if(res != null) {
				break;
			}
		}
		return res;
		
	}
	
	public void impressao() {//busca folha
		impressaoAux(this.produtoFinal.getComponentes());
	}
	public void impressaoAux(List<No> aSerComparado) {
		for(No comparado: aSerComparado) {
			System.out.println("---------------------");
			System.out.println(comparado.getProduto().getNome());
		}
		for(No n : aSerComparado) {
			if(aSerComparado.get(aSerComparado.indexOf(n)).getComponentes().size() > 0) {
				impressaoAux(aSerComparado.get(aSerComparado.indexOf(n)).getComponentes());
			}
		}
	}
}
