import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub         
			AnimeLibrary library = new AnimeLibrary();
			
			
			
			int menu = 0;
			Scanner entrada = new Scanner (System.in);
			
			while(true) {
				printMenu();
				System.out.print("Introduza a sua variavel:");
				menu = entrada.nextInt();
				switch(menu) {
				case 1: 
					library.Add();
					break;
				case 2: 
					library.Edit();
					library.List();
					break;
				case 3: 
					library.Remove();
					library.List();
					break;
				case 4:
					library.List();
					break;
				case 5:
					System.out.println("Até à proxima");
					System.exit(0);
					break;
				default: 
					System.out.println("Opçao inválida");
					continue;
				}
				
				}
			
			
			

			
	
	}
	
	private static void printMenu() {
			String[] options = {"Inserir Anime", "Editar Anime", "Eliminar Anime", "Lista de Anime", "Sair"};
			
			String os =  System.getProperty("os.name").toLowerCase();
			System.out.println(os);
			System.out.println("---Biblioteca de Anime---");
			
			/* if(os.contains("windows"))
				Runtime.exec("cls");
			else if(os.contains("linux") || os.contains("mac"))
				Runtime.exec("clear"); */
			for(int i = 0; i < options.length; i++) {
				
				System.out.println(i + 1 + "- " + options[i]);
			}
		
	}
}	
	