public class JogoDaVelha {
    protected static final int X = 1, O = -1;
    protected static final int VAZIO = 0;
    protected int tabuleiro[][];
    protected int jogador;
    protected int dimensao;

    public JogoDaVelha(int dimensao) {
        limpaTabuleiro();
        this.tabuleiro = new int[dimensao][dimensao];
        this.dimensao = dimensao;
    }

    public void limpaTabuleiro() {
        for (int i = 0; i < dimensao; i++) {
            for (int j = 0; j < dimensao; j++) {
                tabuleiro[i][j] = VAZIO;
            }
        }
        jogador = X;
    }

    public void poePeca(int i, int j) {
        if (i < 0 || i > dimensao - 1 || j < 0 || j > dimensao - 1) {
            throw new IllegalArgumentException("Posição Inválida");
        }
        if (tabuleiro[i][j] != VAZIO)
            throw new IllegalArgumentException("Posição Ocupada");
        tabuleiro[i][j] = jogador;
        jogador = -jogador;
    }

    public boolean descVencedor(int marca) {
        int somaLinha;
        int somaDiagonal1;
        int somaDiagonal2;
        for (int i = 0; i < dimensao; i++) {
            somaLinha = 0;
            somaDiagonal1 = 0;
            somaDiagonal2 = 0;
            for (int j = 0; j < dimensao; j++) {
                somaLinha += tabuleiro[i][j];
                if (i == j) {
                    somaDiagonal1 += tabuleiro[i][j];
                }

                if (i + j == 2) {
                    somaDiagonal2 += tabuleiro[i][j];
                }
            }
            if (somaLinha == marca * dimensao) {
                return true;
            }

            if (somaDiagonal1 == marca * dimensao) {
                return true;
            }

            if (somaDiagonal2 == marca * dimensao) {
                return true;
            }
        }

        int somaColuna;
        for (int j = 0; j < dimensao; j++) {
            somaColuna = 0;
            for (int i = 0; i < dimensao; i++) {
                somaColuna += tabuleiro[i][j];
            }
            if (somaColuna == marca * dimensao) {
                return true;
            }
        }

        return false;
    }

    public int vencedor() {
        // Implemente este método que deve retornar o vencedor ou
        // zero em caso de empate e 2 se o jogo não acabou.
        if (descVencedor(X)) {
            return 1;
        } else if (descVencedor(O)) {
            return -1;
        } else {
            for (int i = 0; i < dimensao; i++) {
                for (int j = 0; j < dimensao; j++) {
                    if (tabuleiro[i][j] == VAZIO) {
                        return 2;
                    }
                }
            }
        }

        return 0;
    }

    public String toString() {
        /**
         * Implementar o método to String que deve retornar
         * uma string com o tabuleiro do jogo da velha com as peças
         * nas posições corretas.
         */
        String retorno = "";
        for (int i = 0; i < dimensao; i++) {
            for (int j = 0; j < dimensao; j++) {
                if (tabuleiro[i][j] == X) {
                    retorno += ("X");
                } else if (tabuleiro[i][j] == O) {
                    retorno += ("O");
                } else {
                    retorno += (" ");
                }
                if (j < dimensao - 1) {
                    retorno += ("|");
                }
            }
            // System.out.println();
            if (i < dimensao - 1) {
                String tracos = "-".repeat(dimensao * 2 - 1);
                retorno += "\n" + tracos + "\n";
            }

        }
        return retorno;
    }
}