import java.util.Scanner;

// Classe Main

public class Main {
	
	private static Jogo jogo;
	private static Scanner input = new Scanner(System.in);
	private static final int NLINHAS = 7;
	private static final int NCOLUNAS = 6;
	private static boolean finalJogo = false;
	private static int vezDeJogar = 1;
	
    
	//Desenha o tabuleiro do Jogo
	private static void imprimeTabuleiro(){
		
		
		Tabuleiro tabuleiro = jogo.getTabuleiro();
		Peca[][] tab = tabuleiro.getTabuleiro();
		System.out.print("|");
		
		
		for(int i = 1; i <= NCOLUNAS; i++)
			System.out.print("\tc"+ i + "\t|");
		System.out.println();
		
		for(int i = 1; i <= NCOLUNAS+1; i++)
			System.out.print("--\t\t");
		System.out.println();
		
		
		for(int i = 0 ; i< tab.length; i++) {
			System.out.print("|");
			for(int j = 0; j < tab[0].length; j++)
			System.out.print( "\t" + tab[i][j].getSimbolo() + "\t|");
			System.out.println("\n");
		}
		
		
		
	}
	
	// Pergunta ao utilizador o nome do jogador com o id
	// recebido no parametro idJogador (1 ou 2)
	private static String pedeNomeJogador(int idJogador){
		System.out.println("Indique o nome do jogador " + idJogador + ": ");
		String nomeJog = input.nextLine();
		return nomeJog;
		
	}
	// Pergunta ao utilizador a cor da Peça do jogador 1
	private static Peca pedeCorPeca(){
		System.out.println("Indique a cor da peça: Vermelho (V) ou Azul(A)");
		char corPeca= input.next().charAt(0);
		input.nextLine();
		Peca pecaJog;
		if (corPeca=='V' || corPeca == 'v')
			pecaJog = Peca.VERMELHA;
		else
			pecaJog = Peca.AZUL;
		return pecaJog;	
	}
	
	// Deriva e devolve a peça do jogador2
	private static Peca deduzPecaJogador2(){
		if (jogo.getJogador1().getPeca() == Peca.VERMELHA)
			return Peca.AZUL;
		else
			return Peca.VERMELHA;
	}
	
	//cria e devolve o jogador do id recebido no parametro 
	// recorrendo a metodos que pedem e devolvem o seu nome
	// e peça de jogo
	private static Jogador criaJogador(int idJogador){
		String nomeJog = pedeNomeJogador(idJogador);
		Peca pecaJog;
		if (idJogador == 1)
			pecaJog = pedeCorPeca();
		else
			pecaJog = deduzPecaJogador2(); 

		return new Jogador(idJogador, nomeJog, pecaJog);
	}
	
	// cria o jogo e define os respetivos jogadores 
	private static void iniciaJogo(){
		jogo = new Jogo(NLINHAS,NCOLUNAS);
		Jogador jogador1 = criaJogador(1);
		jogo.setJogador1(jogador1);
		Jogador jogador2 = criaJogador(2);	
		jogo.setJogador2(jogador2);	
	}
	
	// devolve o nome do próximo jogador a jogar
	private static String getNomeJogadorAJogar(){
		if (vezDeJogar == 1)
			return jogo.getJogador1().getNome();
		else
			return jogo.getJogador2().getNome();
	}
	
	// Pergunta ao proximo utilizador o numero da coluna onde quer jogar
	// e devolve esse numero
	private static int pedeJogada(){
		String nomeJogador = getNomeJogadorAJogar();
		System.out.println(nomeJogador + ", indique pf o nº da coluna onde quer jogar: ");
		int nColuna = input.nextInt();
		return nColuna;
	}
	
	// Muda a vez de Jogar para o outro jogador
	private static void mudaVezDeJogar(){
		  if (vezDeJogar==1)
			  vezDeJogar = 2;
		  else
			  vezDeJogar=1;		  
	}
	
	// Mostra o resultado do jogo.
	private static void apresentaResultadoJogo(){
		if (jogo.getEstado()==Estado.TERMINADO_EMPATE)
			System.out.println("O jogo terminou com um empate.");
		else{
			Jogador vencedor = (vezDeJogar==1)?jogo.getJogador2():jogo.getJogador1();
			System.out.println("Parabéns " + vencedor.getNome() + ". Você é o(a) grande vencedor(a)!");
			}
	}
	
	/* Enquanto o jogo está a decorrer chama metodo para pedir jogada
	   e verifica se a resposta do jogador está dentro dos limites 
	   do tabuleiro. Caso esteja, chama método para executar jogada.
	   Se a jogada é valida, chama método para trocar de jogador, mostra 
	   tabuleiro e volta a repetir o processo, até que o jogo termine. 
	   Caso a jogada seja inválida, apresenta mensagem, e volta a 
	   pedir jogada ao mesmo jogador.
	   */
	private static void executaJogo(){
	   imprimeTabuleiro(); 	
	   do{
			  int nColuna = pedeJogada();
			  boolean jogadaValida;
			  if (nColuna < 1 || nColuna > NCOLUNAS)
				  jogadaValida = false;
			  else
				  // ??? nColuna-1 para ajustar à posicao da array
			      jogadaValida = jogo.executaJogada(vezDeJogar,nColuna-1);
			  	imprimeTabuleiro();
			  if (jogadaValida)
			    mudaVezDeJogar();
			  else  
				 System.out.println("Jogada Inválida."); 
		}while (jogo.getEstado() == Estado.ADECORRER);
	   apresentaResultadoJogo();
	}
	
	/*
	 * Ciclo que inicializa o jogo e depois deste terminar, pergunta
	 * se utilizador quer jogar outra vez.
	 * */
	private static void jogar(){	
		char resposta;
		do{
		  iniciaJogo();	
		  executaJogo();
		  System.out.println("Quer jogar outra vez? (s/n)");	
		  resposta = input.next().charAt(0);
		  input.nextLine();
		}
		while(resposta == 's' || resposta == 'S');
	}
	
	// Inicia o programa, chamando método jogar.
	public static void main(String[] args) {
		jogar();
	}

}