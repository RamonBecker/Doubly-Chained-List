package Classes;

import java.util.Scanner;

public class Lista {

	public Filme inicio;

	public Lista() {
		this.inicio = null;
	}

	public boolean inserirPorIndice(int indice) {

		Filme auxFilmeAntecessor = this.inicio;
		Filme auxFilmeAtual = null;
		int auxIndice = 0;
		boolean valida = false;

		if (inicio == null) {
			return inserirFilmeInicio(auxFilmeAtual, new Scanner(System.in));
		}

		if (indice == 0) {
			return inserirFilmeInicio(auxFilmeAtual, new Scanner(System.in));
		}

		while (auxFilmeAntecessor.proximo != null && auxIndice < indice - 1) {
			auxIndice++;
			auxFilmeAntecessor = auxFilmeAntecessor.proximo;
		}

		if (auxFilmeAntecessor != null) {
			auxFilmeAtual = inserirFilme(auxFilmeAtual, new Scanner(System.in));
			auxFilmeAtual.proximo = auxFilmeAntecessor.proximo;
			auxFilmeAntecessor.proximo = auxFilmeAtual;
			valida = true;
		}

		return valida;
	}

	public Filme inserirFilme(Filme filme, Scanner leitura) {

		String titulo, diretor, protagonista, anoLancamento, genero;

		System.out.println("Digite o titulo: ");
		titulo = leitura.next();

		System.out.println("Digite o diretor: ");
		diretor = leitura.next();

		System.out.println("Digite o protagonista: ");
		protagonista = leitura.next();

		System.out.println("Digite o Ano do Lançamento: ");
		anoLancamento = leitura.next();

		System.out.println("Digite o genero: ");
		genero = leitura.next();

		filme = new Filme(titulo, diretor, protagonista, anoLancamento, genero);

		return filme;

	}

	public boolean inserirFilmeInicio(Filme filme, Scanner leitura) {

		filme = inserirFilme(filme, leitura);
		filme.proximo = this.inicio;
		this.inicio = filme;

		return true;
	}

	public boolean inserirFilmeFinal(Filme filme, Scanner leitura) {

		if (inicio == null) {
			return inserirFilmeInicio(filme, leitura);
		}

		Filme auxFilme = this.inicio;

		while (auxFilme.proximo != null) {
			auxFilme = auxFilme.proximo;
		}

		filme = inserirFilme(filme, leitura);

		auxFilme.proximo = filme;

		return true;
	}

	public boolean removerFilmePorIndice(int indice) {

		Filme aux1 = this.inicio;
		Filme aux2 = null;
		int auxIndice = 0;
		boolean valida = true;

		if (this.inicio == null) {
			valida = false;
		}

		if (valida == true) {
			if (indice == 0) {
				inicio = aux1.proximo;
				aux1 = null;
				valida = true;

			} else {

				while (aux1 != null) {
					if (auxIndice == indice) {
						break;
					}
					auxIndice++;
					aux2 = aux1;
					aux1 = aux1.proximo;
				}
				if (aux1 != null) {
					aux2.proximo = aux1.proximo;
					aux1 = null;
				} else {
					valida = false;
				}
			}
		}
		return valida;
	}

	public boolean removerFilmeTitulo(String titulo) {
		Filme aux1 = this.inicio;
		Filme aux2 = null;
		boolean valida = true;

		if (this.inicio == null) {
			valida = false;
		}

		if (valida == true) {

			if (aux1.titulo.equals(titulo)) {
				this.inicio = aux1.proximo;
				aux1 = null;
			} else {
				while (aux1 != null) {
					if (aux1.titulo.equals(titulo)) {
						break;
					}
					aux2 = aux1;
					aux1 = aux1.proximo;
				}

				if (aux1 != null) {
					aux2.proximo = aux1.proximo;
					aux1 = null;

				} else {
					valida = false;
				}
			}

		}
		return valida;
	}

	public int TamanhoLista() {
		int indice = 0;
		Filme auxFillme = inicio;

		while (auxFillme != null) {
			indice++;
			auxFillme = auxFillme.proximo;
		}
		return indice;
	}

	public int descobrirIndice(String titulo) {
		int indice = 0;
		Filme auxFilme = this.inicio;

		while (auxFilme != null) {
			if (auxFilme.titulo.equals(titulo)) {
				break;
			}
			indice++;
			auxFilme = auxFilme.proximo;
		}

		if (auxFilme != null) {
			return indice;
		} else {
			return -1;
		}

	}

	public Filme buscarFilmePorTitulo(String titulo) {
		Filme auxFilme = this.inicio;

		while (auxFilme != null) {
			if (auxFilme.titulo.equals(titulo)) {
				break;
			}
			auxFilme = auxFilme.proximo;
		}

		if (auxFilme != null) {
			return auxFilme;
		} else {
			return null;
		}
	}

	public Filme buscarFilmePorIndice(int indice) {
		Filme auxFilme = this.inicio;
		int auxIndice = 0;

		while (auxFilme != null && auxIndice < indice) {
			auxIndice++;
			auxFilme = auxFilme.proximo;
		}

		if (auxFilme != null) {
			return auxFilme;
		} else {
			return null;
		}
	}

	public Lista buscarFilmeCaracteristica(String diretor) {
		Filme auxFilme = this.inicio;
		Filme elemento = null;
		
		Lista listaDiretor = new Lista();
		
		
		while (auxFilme != null) {
			if (auxFilme.diretor.equals(diretor)) {
				elemento = new Filme(auxFilme.titulo, auxFilme.diretor, auxFilme.protagonista, auxFilme.anoLancamento, auxFilme.genero);
				elemento.proximo = listaDiretor.inicio;
				listaDiretor.inicio = elemento;
			}
			auxFilme = auxFilme.proximo;
		}
		
		return listaDiretor;
	
	}

	@Override
	public String toString() {
		String concatenaFilme = "";
		Filme auxFilme = this.inicio;

		while (auxFilme != null) {
			concatenaFilme += auxFilme;
			auxFilme = auxFilme.proximo;
		}
		return concatenaFilme;
	}

}
