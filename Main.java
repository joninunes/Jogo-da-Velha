import java.util.Scanner;

public class Main {
    private static char[][] tabuleiro = new char[3][3];
    private static char jogadorAtual = 'X';

    public static void main(String[] args) {
        inicializarTabuleiro();
        exibirTabuleiro();

        while (!verificarFimDeJogo()) {
            realizarJogada();
            exibirTabuleiro();
            trocarJogador();
        }
    }

    private static void inicializarTabuleiro() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tabuleiro[i][j] = '-';
            }
        }
    }

    private static void exibirTabuleiro() {
        System.out.println("Tabuleiro:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(tabuleiro[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static boolean verificarFimDeJogo() {
        return verificarVitoria() || verificarEmpate();
    }

    private static boolean verificarVitoria() {
        return verificarLinhas() || verificarColunas() || verificarDiagonais();
    }

    private static boolean verificarLinhas() {
        for (int i = 0; i < 3; i++) {
            if (tabuleiro[i][0] == jogadorAtual && tabuleiro[i][1] == jogadorAtual && tabuleiro[i][2] == jogadorAtual) {
                return true;
            }
        }
        return false;
    }

    private static boolean verificarColunas() {
        for (int j = 0; j < 3; j++) {
            if (tabuleiro[0][j] == jogadorAtual && tabuleiro[1][j] == jogadorAtual && tabuleiro[2][j] == jogadorAtual) {
                return true;
            }
        }
        return false;
    }

    private static boolean verificarDiagonais() {
        return (tabuleiro[0][0] == jogadorAtual && tabuleiro[1][1] == jogadorAtual && tabuleiro[2][2] == jogadorAtual) ||
                (tabuleiro[0][2] == jogadorAtual && tabuleiro[1][1] == jogadorAtual && tabuleiro[2][0] == jogadorAtual);
    }

    private static boolean verificarEmpate() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tabuleiro[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    private static void realizarJogada() {
        Scanner scanner = new Scanner(System.in);
        int linha, coluna;
        do {
            System.out.print("Jogador " + jogadorAtual + ", digite a linha (1 a 3) e coluna (1 a 3) da sua jogada: ");
            linha = scanner.nextInt() - 1;
            coluna = scanner.nextInt() - 1;
        } while (linha < 0 || linha > 2 || coluna < 0 || coluna > 2 || tabuleiro[linha][coluna] != '-');

        tabuleiro[linha][coluna] = jogadorAtual;
    }

    private static void trocarJogador() {
        if (jogadorAtual == 'X') {
            jogadorAtual = 'O';
        } else {
            jogadorAtual = 'X';
        }
    }
}
