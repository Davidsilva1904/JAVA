public class Jogador{
	
	/*
	 * Parece OK
	 */
	
	
	/*
	 * Métodos a desenvolver: construtor, getters e setters, cujo nome siga a convenção. 
	 * Exemplo: getId() para o getter do atributo id. 
	 * 
	 * Adicionalmente desenvolva também o metodo toString.
	 */
	
	int id;
	String nome;
	int nJogadas;
	Peca peca;

	public Jogador(int id, String nome, Peca peca){
		
		/*
		 * vamos criar o jogador
		 */
		
		this.id = id;
		this.nome = nome;
		this.peca = peca;
		
	}
	
	//getters
	public int getId(){
		return id;
	}
	
	public String getNome(){
		return nome;
	}
	
	public int getNjogadas(){
		return nJogadas;
	}
	
	public Peca getPeca(){
		return peca;
	}
	
	//setters
	
	public void setId(int value){
		id = value;
	}
	
	public void setNome(String value){
		nome = value;
	}
	public void setNjogadas(int value){
		nJogadas = value;
		
	}
	public void setPeca(Peca value){
		peca = value;
	}
	
	//metodo toString
	public String toString(){
		
		
		return id+" "+nome+" "+nJogadas+" "+peca;
	}
	
	
}
