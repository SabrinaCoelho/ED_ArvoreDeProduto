package br.edu.univas.si3.ed.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import br.edu.univas.si3.ed.model.Arvore;
import br.edu.univas.si3.ed.model.No;
import br.edu.univas.si3.ed.model.Produto;

public class StartApp {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner in = new Scanner(System.in);
		List<Produto> componentes = new ArrayList();
		Arvore a1 = null;
		
		while(true) {
			String tipo = in.next();
			if(tipo.equals("f")) {
				leConsole(in,  componentes);
			}else if(tipo.equals("p")){
				if(a1 == null) {//ainda nao tem arvore -> cria o 1° comp
					leConsole(in,  componentes);
					Produto prodFinal = componentes.remove(componentes.size() - 1);
					prodFinal.setSubPecas(componentes);
					a1 = new Arvore();
					a1.cadastrarProduto(prodFinal);
					
				}else {
					a1.cadastrarComponente(in.next(), componentes);
				}
				componentes = new ArrayList();
			}else if(tipo.equals("fim")){
				System.out.println("Encerrado");
				break;
			}
			
		}
		//a1.impressao();
		System.out.printf("Custo total do produto: %.2f.\n", a1.custoTotal());
		System.out.println("\tNós folha:");
		for(No noFolha: a1.buscaComponentesFolha()) {
			System.out.println(noFolha.getProduto().getNome());
		}
		
		in.close();
		
	}
	public static void leConsole(Scanner in, List<Produto> componentes) {
		String comp = in.next();
		float vU = in.nextFloat();
		float q = in.nextFloat();
		Produto novoProd = new Produto(comp, vU, q);
		componentes.add(novoProd);
	}
}
