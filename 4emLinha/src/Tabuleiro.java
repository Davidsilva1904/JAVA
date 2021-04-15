class Tabuleiro {
	
	int nLinhas;
	int nColunas;
	int NUMEROEMLINHA;
	Peca[][] tabuleiro;
	
	public Tabuleiro(int nLinhas, int nColunas){
		
		/* OK
		 * A variável NUMEROEMLINHA representa o numero de peças que têm que estar seguidas, 
		 * para se vencer um jogo. Ao declarar esta variável atribua o valor 4.
		 */
		NUMEROEMLINHA = 4;
		
		/* 
		 * Deverá ter como parametros o numero de linhas e de colunas do tabuleiro. 
		 * É neste método que deverá criar o seu array (new…) atribuindo-o à variável tabuleiro 
		 * (que consta da lista de atributos do objeto). 
		 */
		
		// ????
		this.nLinhas = nLinhas;
		this.nColunas = nColunas;

		//System.out.println("Debug::tabuleiro::"+nLinhas+"::"+nColunas);
		tabuleiro = new Peca[nLinhas][nColunas];
		/*
		 * Este método deverá chamar o metodo inicializaTabuleiro(), 
		 * cuja especificação e logica encontra descritas de seguida.
		 */
		//System.out.println("Debug::inicializa");
		inicializaTabuleiro();
	}
	
	public void inicializaTabuleiro(){
		
		
		 // Este método é responsável por inserir em todas as posições da matriz tabuleiro a peça VAZIA.
		 //Este método não tem parâmetros e deverá devolver void, ou seja, nada. 
		 // Percorra todas as posições do tabuleiro com um ciclo for, e insera a PECA.VAZIA
		 
		
		 
		
		for(int i = 0; i < tabuleiro.length; i++){
			//System.out.println("Debug::inicializa::matriz horizontal"+i); AKA linhas
			for(int j = 0; j < tabuleiro[0].length; j++){
				//System.out.println("Debug::inicializa::matriz vertical"+j); ALA colunas
				//System.out.println("::");
				tabuleiro[i][j] = Peca.VAZIA;
			}
		}
	}
	
	public boolean poePeca(Jogador jogador, int nCol){
		
		 // Este método representa a inserção de uma peça do jogador recebido no primeiro parametro, 
		 //no coluna cujo numero é recebido no segundo parametro.
		 // A peça deverá ficar na primeira posição livre a contar de baixo do tabuleiro, ou seja,
		 // na primeira linha VAZIA, a contar do fim.
		 
		
		
	
			for (int c = nLinhas-1; c >= 0; c--) {
				//for (int i = 0; (nCol + i) < tabuleiro.length - 1 && (c + i + 1) < tabuleiro[0].length; i++) {
					if (tabuleiro[c][nCol] == Peca.VAZIA){
						tabuleiro[c][nCol] = jogador.peca;
						return true;
					}
						
					/*else {
						
					}
					if (nPecasSeguidas == NUMEROEMLINHA)
						return true;*/
				//}
			}

		
		if(nCol > 1) 
			return true;
		else 
			return false;
		
	}
	

	public Peca[][] getTabuleiro(){
		//OK
		//Este método é o getter standard para devolver o tabuleiro do jogo.

		return tabuleiro;
	}

	
	private boolean emLinha(Peca peca) {
		/* OK
		 * Depois de cada jogada este método é chamado para validar se o jogador fez um 4 em Linha, 
		 * ou seja, se possui 4 peças seguidas, numa qualquer linha do tabuleiro. O método apresenta 
		 * o parametro peca (do ultimo jogador que jogou) para procurar em todas as linhas da matriz, 
		 * as 4 peças seguidas iguais à reciba nesse parametro. Caso encontre, o método devolve true, 
		 * caso contrário devolve false.
		 */
		int nPecasSeguidas = 0;
		for (int l = 0; l < tabuleiro.length; l++) {
			nPecasSeguidas = 1;
			for (int c = 0; c < tabuleiro[0].length - 1; c++) {
				if (peca == tabuleiro[l][c] && tabuleiro[l][c] == tabuleiro[l][c + 1])
					nPecasSeguidas++;
				else
					nPecasSeguidas = 1;
				if (nPecasSeguidas == NUMEROEMLINHA)
					return true;
			}
		}
		return false;
	}

	private boolean emColuna(Peca peca) {
		
		//OK
		//Igual ao anterior, mas para colunas.
		int nPecasSeguidas = 0;
		for (int c = 0; c < tabuleiro[0].length; c++) {
			nPecasSeguidas = 1;
			for (int l = 0; l < tabuleiro.length - 1; l++) {
				if (peca == tabuleiro[l][c] && tabuleiro[l][c] == tabuleiro[l + 1][c])
					nPecasSeguidas++;
				else
					nPecasSeguidas = 1;
				if (nPecasSeguidas == NUMEROEMLINHA)
					return true;
			}
		}
		return false;
	}

	private boolean emDiagonalDireita(Peca peca) {
		
		//OK
		//Igual ao anterior, mas para as diagonais direitas.
		int nPecasSeguidas = 1;
		for (int l = 0; l < tabuleiro.length - 1; l++) {
			for (int c = 0; c < tabuleiro[0].length - 1; c++) {
				nPecasSeguidas = 1;
				for (int i = 0; (l + i) < tabuleiro.length - 1 && (c + i + 1) < tabuleiro[0].length; i++) {
					if (tabuleiro[l + i][c + i] != Peca.VAZIA
							&& tabuleiro[l + i][c + i] == tabuleiro[l + i + 1][c + i + 1])
						nPecasSeguidas++;
					else {
						nPecasSeguidas = 1;
					}
					if (nPecasSeguidas == NUMEROEMLINHA)
						return true;
				}
			}
		}
		return false;
	}

	
	private boolean emDiagonalEsquerda(Peca peca) {
		//OK
		//Igual ao anterior, mas para as diagonais esquerdas.
		int nPecasSeguidas = 1;
		for (int l = 0; l < tabuleiro.length - 1; l++) {
			for (int c = tabuleiro[0].length - 1; c >= 0; c--) {
				nPecasSeguidas = 1;
				for (int i = 0; (l + i) < tabuleiro.length - 1 && (c - i - 1) >= 0; i++) {
					if (tabuleiro[l + i][c - i] != Peca.VAZIA
							&& (tabuleiro[l + i][c - i] == tabuleiro[l + i + 1][c - i - 1]))
						nPecasSeguidas++;

					else
						nPecasSeguidas = 1;
					if (nPecasSeguidas == NUMEROEMLINHA)
						return true;
				}
			}
		}
		return false;
	}
	
	public boolean existeVencedor(Peca peca){
		/* OK
		 * Este método é chamado após cada jogada e deverá verificar se existe um vencedor. 
		 * Para isso deve usar a seguinte lógica: caso algum dos métodos, emLinha, emColuna, 
		 * emDiagonalDireita ou emDiagonalEsquerda, devolva true, então o método deverá devolver true, 
		 * caso contrário devolve false.
		 */
		if (emLinha(peca) == true || emColuna(peca) == true || emDiagonalDireita(peca) == true || emDiagonalEsquerda(peca) == true){
			return true;
		} else {
			return false;
		}
	}
	
	public boolean empate(){
		
		/* 
		 * Este método é chamado após cada jogada e deverá verificar se existe um empate no jogo. 
		 * Um empate existe caso a sua matriz não tenha qualquer peça VAZIA. 
		 * Nesse caso o método devolve true, 
		 * caso contrário devolve false.  */
		

		/*
		 * TODO check a este loop
		 * Crie um for dentro de um for, para percorrer todas as posições 
		 * da sua matriz tabuleiro,
		 */
		
		for (int l = 0; l < tabuleiro.length - 1; l++) {
			for (int c = tabuleiro[0].length - 1; c >= 0; c--) {
				for (int i = 0; (l + i) < tabuleiro.length - 1 && (c - i - 1) >= 0; i++) {
					
					/* e verificar se existe alguma posição com a peça Peca.FAZIA. 
					 * Caso exista o metodo deve devolver false, caso contrario true.
					 */	
					
					if (tabuleiro[l + i][c - i] == Peca.VAZIA) {
						return false;
					}
				}
			}
		}
		
		return true;
	}
	
	public Estado actualizaEstadoJogo(Peca peca){
		/*
		 * Este método é chamado após cada jogada e devolve o estado do jogo após essa jogada. 
		 * Para isso chama o método existeVencedor(peca). Caso exista, o método devolve o estado Estado.
		 * TERMINADO_COM_VENCEDOR. Dentro deste método deverá também fazer a chamada ao método empate(). 
		 * Caso este devolva true, o método deverá devolver Estado.TERMINADO_EMPATE. 
		 * Caso contrário deverá devolver Estado.ADECORRER.
		 */
		if(existeVencedor(peca)==true){
			return Estado.TERMINADO_COM_VENCEDOR;
		} else if(empate()==true){
			return Estado.TERMINADO_EMPATE;
		} else {
			return Estado.ADECORRER;
		}
	}
	
	

}
