package dev.joaonogueira.jogodavelha;

import java.util.Scanner;

public class Jogador {
	private boolean tentativa; //vari�vel que controla se a tentativa de jogada foi bem sucedida
	public void jogar(Tabuleiro tab) { //o m�todo jogar recebe o tabuleiro como par�metro para alterar valores na matriz
		tentativa = true; 
		while (tentativa) { //enquanto tentativa for true, a jogada n�o est� conclu�da e o programa continuar� tentando
			Scanner teclado = new Scanner(System.in);
			System.out.println("Informe a linha da sua jogada, de 1 a 3:");
			int linhaEntrada = teclado.nextInt();
			System.out.println("Informe a coluna da sua jogada, de 1 a 3:");
			int colunaEntrada = teclado.nextInt();
			int linha = linhaEntrada-1; //corre��o da entrada do usu�rio (1-3) para posi��es na matriz do sistema (0-2)
			int coluna = colunaEntrada-1; //corre��o da entrada do usu�rio (1-3) para posi��es na matriz do sistema (0-2)
			if (posicaoValida(linha, coluna) && tab.posicaoDisponivel(linha, coluna)) {//se as posi��es da entrada forem v�lidas (0-2) e se a posi��o destino estiver vazia, realizar a jogada
				tab.mat[linha][coluna] = 1;
				tentativa = false; //se a jogada foi conclu�da com sucesso, tentativa vira false e interrompe o loop da jogada
			}
			else {
				System.out.println("Esta posi��o j� est� preenchida ou � inv�lida, informe outra."); //caso alguma condi��o n�o seja cumprida
			}
		}
		
	}
	private boolean posicaoValida(int linha, int coluna) { //verifica se a posi��o est� dentro do limite da matriz do sistema (0-2 linhas e colunas)
		if ((linha>=0&&linha<=2)&&(coluna>=0&&coluna<=2)) {
			return true;
		}
		return false;
	}
}
