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
    public Jogo(Jogador jogador1, Jogador jogador2) {
        this.tabuleiro = new Tabuleiro();
        this.jogadorX = jogador1;
        this.jogadorO = jogador2;
        this.jogadorAtual = jogadorX; // Começa com o jogador X
    }

    public void adicionarJogador(Jogador jogador1,Jogador jogador2) {
    	this.jogadorO=jogador1;
    	this.jogadorX=jogador2;
    	
    }
    public void alternarJogador() {
        if (jogadorAtual == jogadorX) {
            jogadorAtual = jogadorO;
        } else {
            jogadorAtual = jogadorX;
        }
    }

    public boolean fazerJogada(int linha, int coluna) {
        return tabuleiro.fazerJogada(linha, coluna, jogadorAtual.getSimbolo());
    }

    public char verificarVencedor() {
        return tabuleiro.verificarVencedor();
    }
}
