
public class Jogo {
	
	//Attributos
	Jogador jogador1;
	Jogador jogador2;
	Tabuleiro tabuleiro;
	Estado estado;
	

	public Jogo(int nLinhas, int nColunas){
		/*
		 * TODO ???
		 * Este construtor só tem que fazer a atribuição dos parametros recebidos aos respetivos atributos. 
		 */
	    tabuleiro = new Tabuleiro(nLinhas,nColunas);
	//	System.out.println(tabuleiro.toString());
		/*
		 * Adicionalmente deverá atribuir ao estado o valor Estado.ADECORRER.
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
		 * Este metodo deverá atualizar o atributo estado, que pode ver na tabela de atributos, 
		 * com o valor retornado pelo método atualizaEstadoJogo(peca) do objeto tabuleiro, 
		 * também visivel na tabela de atributos. 
		 * Este método deverá ter apenas uma única linha de código.
		 */
		estado = tabuleiro.actualizaEstadoJogo(peca);
	}
	
	public boolean executaJogada(int idJogador, int nColuna){
		
		
		/* OK // pelo menos parece
		 * Lógica do método: caso o idJogador seja 1 o método deverá atribuir a uma nova variavel jogador
		 *  (criada localmente neste método), o jogador1 (atrituto do objeto jogo). */

		Jogador jogador;
		

		/*
		 *   Se não, o método deverá atribuir a essa nova variável o jogador2. 
		 */
		if(idJogador == 1){
			jogador = jogador1;
		} else {
			jogador = jogador2;
		}
		
		/*
		 *  Depois deverá chamar o metodo poePeca do objeto tabuleiro, passando-lhe os argumentos, 
		 *  jogador e nColuna (recebidos nos proprios parametros deste método). 
		 *  Ou seja, estamos a solicitar ao objeto tabuleiro, para por a peça do jogador na coluna
		 *   especificada no parametro. 
		 *   
		 *   O valor booleano retornado pelo método deverá ser guardado 
		 *   numa nova variavel declarada internamente neste metodo. */
		
		//System.out.println("::::"+nColuna);
		boolean jogada = tabuleiro.poePeca(jogador,nColuna);
		
		Peca pecaJogada; //???
		
		/*  
		 * Se o metodo poePeca, retornar true, 
		 *   então este metodo deverá chamar o metodo atualizaEstadoJogo, passando-lhe como argumento a 
		 *   peça do jogador (use o respetivo getter do objeto jogador). */
		
		if(jogada == true){
			atualizaEstadoJogo(jogador.getPeca());
		}
		
		
		/*No final o método deverá 
		 *   retornar o valor da variável booleana.
		 */
		return jogada;
	}
	
}
