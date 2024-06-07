package Logica;

public class Tabuleiro {
    private char[][] matriz;

    public Tabuleiro() {
        matriz = new char[3][3];
        // Inicializa a matriz com espaços em branco
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matriz[i][j] = ' ';
            }
        }
    }

    public boolean fazerJogada(int linha, int coluna, char simbolo) {
        // Verifica se a posição está vazia
        if (matriz[linha][coluna] == ' ') {
            matriz[linha][coluna] = simbolo;
          //  System.out.println("simbolo "+ simbolo);
            return true;
        } else {
            return false;
        }
    }

    public char verificarVencedor() {
        // Verifica linhas
        for (int i = 0; i < 3; i++) {
            if (matriz[i][0] == matriz[i][1] && matriz[i][1] == matriz[i][2] && matriz[i][0] != ' ') {
                return matriz[i][0];
            }
        }

        // Verifica colunas
        for (int i = 0; i < 3; i++) {
            if (matriz[0][i] == matriz[1][i] && matriz[1][i] == matriz[2][i] && matriz[0][i] != ' ') {
                return matriz[0][i];
            }
        }

        // Verifica diagonal principal
        if (matriz[0][0] == matriz[1][1] && matriz[1][1] == matriz[2][2] && matriz[0][0] != ' ') {
            return matriz[0][0];
        }

        // Verifica diagonal secundária
        if (matriz[0][2] == matriz[1][1] && matriz[1][1] == matriz[2][0] && matriz[0][2] != ' ') {
            return matriz[0][2];
        }

        // Se não houver vencedor
        return ' ';
    }
    public boolean verificarVencedorBool() {
        // Verifica linhas
        for (int i = 0; i < 3; i++) {
            if (matriz[i][0] == matriz[i][1] && matriz[i][1] == matriz[i][2] && matriz[i][0] != ' ') {
                return true;
            }
        }

        // Verifica colunas
        for (int i = 0; i < 3; i++) {
            if (matriz[0][i] == matriz[1][i] && matriz[1][i] == matriz[2][i] && matriz[0][i] != ' ') {
                return true;
            }
        }

        // Verifica diagonal principal
        if (matriz[0][0] == matriz[1][1] && matriz[1][1] == matriz[2][2] && matriz[0][0] != ' ') {
            return true;
        }

        // Verifica diagonal secundária
        if (matriz[0][2] == matriz[1][1] && matriz[1][1] == matriz[2][0] && matriz[0][2] != ' ') {
            return true;
        }

        // Se não houver vencedor
        return false;
    }
    public boolean tabuleiroCheio() {
        // Verifica se há algum espaço em branco na matriz
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (matriz[i][j]== ' ') {
                //	 System.out.println("estou cheioooooooooo");
                    return false;
                }
            }
        }
       
        return true;
    }
}
