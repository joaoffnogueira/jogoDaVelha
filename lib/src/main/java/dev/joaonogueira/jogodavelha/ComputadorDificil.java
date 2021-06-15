package dev.joaonogueira.jogodavelha;

public class ComputadorDificil extends Computador { //herda de Computador
	//Dificuldade Dif�cil: o Computador de dificuldade dif�cil possu� estrat�gias definidas de jogada.
	public void jogar(Tabuleiro tab) { //o m�todo jogar recebe o tabuleiro como par�metro para alterar valores na matriz
		tentativa = true;
		while (tentativa) { //enquanto tentativa for true, a jogada n�o est� conclu�da e o programa continuar� tentando
			if (tab.posicaoDisponivel(1, 1)) { //come�a preenchendo o centro do tabuleiro; 
				tab.mat[1][1] = -1;
				tentativa = false;
			}
			else if (tab.posicaoDisponivel(0, 0) && tab.posicaoDisponivel(2, 2)) {//depois tenta fazer as diagonais, 
				tab.mat[0][0] = -1;
				tentativa = false;
			}
			else if ((tab.mat[0][0]==-1) && tab.posicaoDisponivel(2, 2)) {//diagonais,
				tab.mat[2][2] = -1;
				tentativa = false;
			}
			else if (tab.posicaoDisponivel(0, 2) && tab.posicaoDisponivel(2, 0)) {//diagonais,
				tab.mat[0][2] = -1;
				tentativa = false;
			}
			else if ((tab.mat[0][2]==-1) && tab.posicaoDisponivel(2, 0)) {//diagonais,
				tab.mat[2][0] = -1;
				tentativa = false;
			}
			else {
				for (int linha=0; linha<=2; linha++) {//se n�o conseguir, tenta completar a linha do meio. 
					if (tab.posicaoDisponivel(linha, 1)) {
						tab.mat[linha][1] = -1;
						tentativa = false;
						return;
					}
				}
				for (int coluna=0; coluna<=2; coluna++) {//se n�o conseguir, tenta completar a coluna do meio. 
					if (tab.posicaoDisponivel(1, coluna)) {
						tab.mat[1][coluna] = -1;
						tentativa = false;
						return;
					}
				}
				for (int linha=0; linha<=2; linha++) {//Caso nenhuma dessas estrat�gias esteja dispon�vel, por causa das jogadas do jogador, ele simplesmente buscar� uma posi��o vazia qualquer.
					for (int coluna=0; coluna<=2; coluna++) {
						if (tab.posicaoDisponivel(linha, coluna)) {
							tab.mat[linha][coluna] = -1;
							tentativa = false;
							return;
						}
					}
				}
			}
		}
	}
}
