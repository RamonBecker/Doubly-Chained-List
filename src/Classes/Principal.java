package Classes;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		Scanner leitura = new Scanner(System.in);
		Filme filme = null;
		Lista listaFilme = new Lista();
		Lista diretor = null;
		Lista auxListaFilme = new Lista();
		// String titulo;

		// Inserir Inicio
		if (listaFilme.inserirFilmeInicio(filme, leitura) == true) {
			System.out.println("Filme inserido com sucesso !");
		} else {
			System.err.println("Não foi possível inserir o filme !");
		}

		if (listaFilme.inserirFilmeInicio(filme, leitura) == true) {
			System.out.println("Filme inserido com sucesso !");
		} else {
			System.err.println("Não foi possível inserir o filme !");
		}

		// Inserir no Final
		if (listaFilme.inserirFilmeFinal(filme, leitura) == true) {
			System.out.println("Filme inserido com sucesso !");
		} else {
			System.err.println("Não foi possível inserir o filme !");
		}

		// --- Buscar Por titulo ------
		System.out.println("Buscar por Titulo: "+listaFilme.buscarFilmePorTitulo("c"));
		
	
	}
}
