package dev.joaonogueira.jogodavelha;

import java.util.Random;

public class ComputadorFacil extends Computador { //herda de Computador
	//Dificuldade F�cil: o Computador de dificuldade F�cil gera posi��es aleat�rias para fazer a jogada
	public void jogar(Tabuleiro tab) { //o m�todo jogar recebe o tabuleiro como par�metro para alterar valores na matriz
		tentativa = true;
		while (tentativa) { //enquanto tentativa for true, a jogada n�o est� conclu�da e o programa continuar� tentando
			Random random = new Random();
			int linha = random.nextInt(3);
			int coluna = random.nextInt(3);
			if (tab.posicaoDisponivel(linha, coluna)) {//se a posi��o destino estiver vazia, realizar a jogada
				tab.mat[linha][coluna] = -1;
				tentativa = false;//se a jogada foi conclu�da com sucesso, tentativa vira false e interrompe o loop da jogada
			}			
		}
	}
}