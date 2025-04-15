import java.util.Random;
import java.util.Scanner;

public class JogaJogoDaVelha {
    public static void main(String[] args) {
        System.out.println("Bem-vindo ao teste do Jogo da Velha!");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite 1 para jogar ou 0 para sair: ");
        int opcao = scanner.nextInt();
        Random random = new Random();
        while (opcao!=0) {
            System.out.println("Digite um número inteiro para a dimensão do tabuleiro: ");
            int dimensao = scanner.nextInt();
            JogoDaVelha jogo = new JogoDaVelha(dimensao);
            int i, j;
            while (jogo.vencedor() == 2) {
                i = random.nextInt(0, dimensao);
                j = random.nextInt(0, dimensao);
                try {
                    jogo.poePeca(i, j);
                } catch (IllegalArgumentException e) {
                    continue;
                }
//                System.out.println(jogo.toString());
            }
            if (jogo.vencedor() == 1) {
                System.out.println("Jogador X venceu!");
            } else if (jogo.vencedor() == -1) {
                System.out.println("Jogador O venceu!");
            } else {
                System.out.println("Empate!");
            }
            System.out.println(jogo.toString());
            System.out.println("Deseja jogar novamente? (1-sim, 0-nao): ");
            opcao = scanner.nextInt();
        }
        scanner.close();
    }
    
}
