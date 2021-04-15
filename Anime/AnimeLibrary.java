import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
public class AnimeLibrary {
	private List<Anime> animes =new ArrayList<Anime>();
	
	
	 public void List() {
		for(Anime anime : this.animes) {
			System.out.println(anime.toString());
		}
	}
	 
	 public void Add() {
		 
		 String name = "";
		 String author = "";
		 String genre = "";
		 String date = "";
		 int number = 0;
		 Scanner entrada = new Scanner(System.in);
		 	System.out.println("Nome do Anime: ");
			name= entrada.nextLine();
			System.out.println("Autor do Anime: ");
			author = entrada.nextLine();
			System.out.println("Genero do Anime: ");
			genre = entrada.nextLine();
			System.out.println("Número do Anime: ");
			number = Integer.parseInt(entrada.nextLine());
			System.out.println("Data do Anime: ");
			date = entrada.nextLine();
		 
			Anime newAnime = new Anime(name, author, genre, date, number);
			
		 this.animes.add(newAnime);
		 this.List();
	 
			        }
		 
	 public void Edit() {
		 String name = "";
		 String author = "";
		 String genre = "";
		 String date = "";
		 int number = 0;
		 Scanner entrada = new Scanner(System.in);
		 System.out.println("Nome do Anime: ");
		 name= entrada.nextLine();
		 for (Anime anime : this.animes) {
			
		        if (name.equals(anime.getNome())) {
					System.out.println("Autor do Anime: ");
					author = entrada.nextLine();
					anime.setAutor(author);
					System.out.println("Genero do Anime: ");
					genre = entrada.nextLine();
					anime.setGenero(genre);
					System.out.println("Número do Anime: ");
					number = Integer.parseInt(entrada.nextLine());
					anime.setNumero(number);
					System.out.println("Data do Anime: ");
					date = entrada.nextLine();
					anime.setData(date);
					break; 
		        }
		 }	  
	 }		 
	 
	 public void Remove() {
		 if(animes.size() == 0) {
			 System.out.println("Ainda nao existem animes na biblioteca");
			 return;
		 }
		 String name = "";
	       Scanner entrada = new Scanner(System.in);
	       System.out.println("Nome do Anime: ");
			 name= entrada.nextLine();
		int eliminados = 0;  
		 for (int i = 0; i < animes.size(); i++) {  
			 if (animes.get(i).getNome().equals(name))  { 
		        animes.remove(i);
		        System.out.println("Anime eliminado");
		        eliminados ++;
		        break;
			 }
		    } 
		 if(eliminados == 0)
			 System.out.println("Anime não encontrado");
		}
	}	 
	 	 
		
	


