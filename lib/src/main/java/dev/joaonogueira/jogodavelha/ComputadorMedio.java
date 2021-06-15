package dev.joaonogueira.jogodavelha;

public class ComputadorMedio extends Computador { //herda de Computador
	//Dificuldade M�dia: o Computador de dificuldade m�dia tenta preencher o tabuleiro diretamente em ordem
	public void jogar(Tabuleiro tab) { //o m�todo jogar recebe o tabuleiro como par�metro para alterar valores na matriz
		tentativa = true;
		while (tentativa) { //enquanto tentativa for true, a jogada n�o est� conclu�da e o programa continuar� tentando
			for (int linha=0; linha<=2; linha++) {
				for (int coluna=0; coluna<=2; coluna++) {
					if (tab.posicaoDisponivel(linha, coluna)) { //se a posi��o destino estiver vazia, realizar a jogada
						tab.mat[linha][coluna] = -1;
						tentativa = false; //se a jogada foi conclu�da com sucesso, tentativa vira false e interrompe o loop da jogada
						return;
					}
				}
			}			
		}
	}
}
