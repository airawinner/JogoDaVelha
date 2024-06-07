package Logica;

public class Jogo {
    private Tabuleiro tabuleiro;
    private Jogador jogadorX;
    private Jogador jogadorO;
    private Jogador jogadorAtual;
    
    

    public Tabuleiro getTabuleiro() {
		return tabuleiro;
	}
	public void setTabuleiro(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
	}
	public Jogador getJogadorX() {
		return jogadorX;
	}
	public void setJogadorX(Jogador jogadorX) {
		this.jogadorX = jogadorX;
	}
	public Jogador getJogadorO() {
		return jogadorO;
	}
	public void setJogadorO(Jogador jogadorO) {
		this.jogadorO = jogadorO;
	}
	public Jogador getJogadorAtual() {
		return jogadorAtual;
	}
	public void setJogadorAtual(Jogador jogadorAtual) {
		this.jogadorAtual = jogadorAtual;
	}
	public Jogo(String nomeJogadorX, String nomeJogadorO) {
        this.tabuleiro = new Tabuleiro();
        this.jogadorX = new Jogador(nomeJogadorX, 'X');
        this.jogadorO = new Jogador(nomeJogadorO, 'O');
        this.jogadorAtual = jogadorX; // Começa com o jogador X
    }
	 public Jogo(Jogador jogadorX, Jogador jogadorO) {
	        this.jogadorX = jogadorX;
	        this.jogadorO = jogadorO;
	        this.jogadorAtual = jogadorX; // Define o jogador inicial
	        this.tabuleiro = new Tabuleiro();
	    }
    public void adicionarJogador(Jogador jogador1,Jogador jogador2) {
    	this.jogadorO=jogador1;
    	this.jogadorX=jogador2;
    	
    }
    public boolean Empate() {
    	// System.out.println("me valida");
     if (tabuleiro.tabuleiroCheio()==true && verificarVencedorBool()==false ) {
    	
    	 return true;
    	 
     }
     return false;
    }
    public void alternarJogador() {
        if (jogadorAtual == jogadorX) {
            jogadorAtual = jogadorO;
        } else {
            jogadorAtual = jogadorX;
        }
    }

    public boolean fazerJogada(int linha, int coluna) {
      //  System.out.println("Tentando fazer jogada na linha " + linha + ", coluna " + coluna);
        if (tabuleiro.fazerJogada(linha, coluna, jogadorAtual.getSimbolo())) {
            // Jogada bem-sucedida
        
       //     System.out.println("Jogada bem-sucedida: linha " + linha + ", coluna " + coluna);
        	return true;
        } else {
        	
            // Jogada inválida
          //  System.out.println("Jogada inválida: linha " + linha + ", coluna " + coluna);
            return false;
        }
      
    }

    public char verificarVencedor() {
        return tabuleiro.verificarVencedor();
    }
    private boolean verificarVencedorBool() {
    	return tabuleiro.verificarVencedorBool();
    }
}
