
public enum Peca {
	
	
	 // Representa a cor das pe�as dos jogadores: vermelhas e azuis . 
	 
	 // Uma vez que o jogo ser� desenvolvido apenas em modo de texto, e n�o em modo gr�fico, 
	 //� requisito associar a cada elemento enumerado, o atributo simbolo, que representa o caracter 
	 // das pe�as de cada jogador. 
	  
	
	
	VERMELHA('X'), 
	AZUL('O'), 
	VAZIA(' ');

	private char simbolo;

	/* TODO corrigir bug
	 * Para al�m do construtor privado deste tipo enumerado,
	 */
	Peca(char simbolo){
		//if(simbolo)
		//System.out.println(":::"+this.simbolo+"::::");
		this.simbolo = simbolo;
	
	}
	
	/*
	 *  deve incluir tamb�m o m�todo getSimbolo().
	 */
	public char getSimbolo(){

		return this.simbolo;
	}
	
   
}


