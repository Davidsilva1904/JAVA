
public class Jogo {
	
	//Attributos
	Jogador jogador1;
	Jogador jogador2;
	Tabuleiro tabuleiro;
	Estado estado;
	

	public Jogo(int nLinhas, int nColunas){
		/*
		 * TODO ???
		 * Este construtor s� tem que fazer a atribui��o dos parametros recebidos aos respetivos atributos. 
		 */
	    tabuleiro = new Tabuleiro(nLinhas,nColunas);
	//	System.out.println(tabuleiro.toString());
		/*
		 * Adicionalmente dever� atribuir ao estado o valor Estado.ADECORRER.
		 */
		estado = Estado.ADECORRER;
		
		
	}
	
	//OK getters
	public Tabuleiro getTabuleiro(){
		return tabuleiro;
		
	}
	public Jogador getJogador1(){
		return jogador1;
		
	}
	public Jogador getJogador2(){
		return jogador2;
		
	}
	public Estado getEstado(){
		return estado;
	}
	
	//OK setters
	public void setJogador1(Jogador value){
		jogador1 = value;
	}
	
	public void setJogador2(Jogador value){
		jogador2 = value;
	}
	public void setEstado(Estado value){
		estado = value;
	}
	
	public void atualizaEstadoJogo(Peca peca){
		
		/*OK
		 * Este metodo dever� atualizar o atributo estado, que pode ver na tabela de atributos, 
		 * com o valor retornado pelo m�todo atualizaEstadoJogo(peca) do objeto tabuleiro, 
		 * tamb�m visivel na tabela de atributos. 
		 * Este m�todo dever� ter apenas uma �nica linha de c�digo.
		 */
		estado = tabuleiro.actualizaEstadoJogo(peca);
	}
	
	public boolean executaJogada(int idJogador, int nColuna){
		
		
		/* OK // pelo menos parece
		 * L�gica do m�todo: caso o idJogador seja 1 o m�todo dever� atribuir a uma nova variavel jogador
		 *  (criada localmente neste m�todo), o jogador1 (atrituto do objeto jogo). */

		Jogador jogador;
		

		/*
		 *   Se n�o, o m�todo dever� atribuir a essa nova vari�vel o jogador2. 
		 */
		if(idJogador == 1){
			jogador = jogador1;
		} else {
			jogador = jogador2;
		}
		
		/*
		 *  Depois dever� chamar o metodo poePeca do objeto tabuleiro, passando-lhe os argumentos, 
		 *  jogador e nColuna (recebidos nos proprios parametros deste m�todo). 
		 *  Ou seja, estamos a solicitar ao objeto tabuleiro, para por a pe�a do jogador na coluna
		 *   especificada no parametro. 
		 *   
		 *   O valor booleano retornado pelo m�todo dever� ser guardado 
		 *   numa nova variavel declarada internamente neste metodo. */
		
		//System.out.println("::::"+nColuna);
		boolean jogada = tabuleiro.poePeca(jogador,nColuna);
		
		Peca pecaJogada; //???
		
		/*  
		 * Se o metodo poePeca, retornar true, 
		 *   ent�o este metodo dever� chamar o metodo atualizaEstadoJogo, passando-lhe como argumento a 
		 *   pe�a do jogador (use o respetivo getter do objeto jogador). */
		
		if(jogada == true){
			atualizaEstadoJogo(jogador.getPeca());
		}
		
		
		/*No final o m�todo dever� 
		 *   retornar o valor da vari�vel booleana.
		 */
		return jogada;
	}
	
}
