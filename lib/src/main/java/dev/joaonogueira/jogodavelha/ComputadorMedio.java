package dev.joaonogueira.jogodavelha;

public class ComputadorMedio extends Computador { //herda de Computador
	//Dificuldade Média: o Computador de dificuldade média tenta preencher o tabuleiro diretamente em ordem
	public void jogar(Tabuleiro tab) { //o método jogar recebe o tabuleiro como parâmetro para alterar valores na matriz
		tentativa = true;
		while (tentativa) { //enquanto tentativa for true, a jogada não está concluída e o programa continuará tentando
			for (int linha=0; linha<=2; linha++) {
				for (int coluna=0; coluna<=2; coluna++) {
					if (tab.posicaoDisponivel(linha, coluna)) { //se a posição destino estiver vazia, realizar a jogada
						tab.mat[linha][coluna] = -1;
						tentativa = false; //se a jogada foi concluída com sucesso, tentativa vira false e interrompe o loop da jogada
						return;
					}
				}
			}			
		}
	}
}
