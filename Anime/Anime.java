import java.util.Scanner;

public class Anime {
	private String nome;
	private String autor;
	private String genero;
	private int numero;
	private String data;
	
	public Anime(String name, String author,String  genre,String date, int number) {
		this.nome = name;
		this.autor = author;
		this.genero = genre;
		this.numero = number;
		this.data = date;
	}
	
	@Override
	public String toString() {
		return String.format("nome=%s;autor=%s;genero=%s;data=%s;", this.nome, this.autor, this.genero, this.data);
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}

	}
	

	

