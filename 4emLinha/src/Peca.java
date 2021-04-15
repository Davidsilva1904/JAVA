
public enum Peca {
	
	
	 // Representa a cor das peças dos jogadores: vermelhas e azuis . 
	 
	 // Uma vez que o jogo será desenvolvido apenas em modo de texto, e não em modo gráfico, 
	 //é requisito associar a cada elemento enumerado, o atributo simbolo, que representa o caracter 
	 // das peças de cada jogador. 
	  
	
	
	VERMELHA('X'), 
	AZUL('O'), 
	VAZIA(' ');

	private char simbolo;

	/* TODO corrigir bug
	 * Para além do construtor privado deste tipo enumerado,
	 */
	Peca(char simbolo){
		//if(simbolo)
		//System.out.println(":::"+this.simbolo+"::::");
		this.simbolo = simbolo;
	
	}
	
	/*
	 *  deve incluir também o método getSimbolo().
	 */
	public char getSimbolo(){

		return this.simbolo;
	}
	
   
}


