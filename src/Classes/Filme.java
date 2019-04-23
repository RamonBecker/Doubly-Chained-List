package Classes;

public class Filme {
	String titulo, diretor, protagonista, anoLancamento, genero;
	Filme proximo;
	
	public Filme() {
	}

	public Filme(String titulo, String diretor, String protagonista, String anoLancamento, String genero) {
		this.titulo = titulo;
		this.diretor = diretor;
		this.protagonista = protagonista;
		this.anoLancamento = anoLancamento;
		this.genero = genero;
		this.proximo = null;
	}
	
	@Override
	public String toString() {
		return "Filme [titulo=" + titulo + ", diretor=" + diretor + ", protagonista=" + protagonista
				+ ", anoLancamento=" + anoLancamento + ", genero=" + genero + "]";
	}	
}
