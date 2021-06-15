package dev.joaonogueira.jogodavelha;

import java.util.Scanner;

public class Jogador {
	private boolean tentativa; //variável que controla se a tentativa de jogada foi bem sucedida
	public void jogar(Tabuleiro tab) { //o método jogar recebe o tabuleiro como parâmetro para alterar valores na matriz
		tentativa = true; 
		while (tentativa) { //enquanto tentativa for true, a jogada não está concluída e o programa continuará tentando
			Scanner teclado = new Scanner(System.in);
			System.out.println("Informe a linha da sua jogada, de 1 a 3:");
			int linhaEntrada = teclado.nextInt();
			System.out.println("Informe a coluna da sua jogada, de 1 a 3:");
			int colunaEntrada = teclado.nextInt();
			int linha = linhaEntrada-1; //correção da entrada do usuário (1-3) para posições na matriz do sistema (0-2)
			int coluna = colunaEntrada-1; //correção da entrada do usuário (1-3) para posições na matriz do sistema (0-2)
			if (posicaoValida(linha, coluna) && tab.posicaoDisponivel(linha, coluna)) {//se as posições da entrada forem válidas (0-2) e se a posição destino estiver vazia, realizar a jogada
				tab.mat[linha][coluna] = 1;
				tentativa = false; //se a jogada foi concluída com sucesso, tentativa vira false e interrompe o loop da jogada
			}
			else {
				System.out.println("Esta posição já está preenchida ou é inválida, informe outra."); //caso alguma condição não seja cumprida
			}
		}
		
	}
	private boolean posicaoValida(int linha, int coluna) { //verifica se a posição está dentro do limite da matriz do sistema (0-2 linhas e colunas)
		if ((linha>=0&&linha<=2)&&(coluna>=0&&coluna<=2)) {
			return true;
		}
		return false;
	}
}
