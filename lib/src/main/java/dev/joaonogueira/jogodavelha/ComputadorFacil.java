package dev.joaonogueira.jogodavelha;

import java.util.Random;

public class ComputadorFacil extends Computador { //herda de Computador
	//Dificuldade Fácil: o Computador de dificuldade Fácil gera posições aleatórias para fazer a jogada
	public void jogar(Tabuleiro tab) { //o método jogar recebe o tabuleiro como parâmetro para alterar valores na matriz
		tentativa = true;
		while (tentativa) { //enquanto tentativa for true, a jogada não está concluída e o programa continuará tentando
			Random random = new Random();
			int linha = random.nextInt(3);
			int coluna = random.nextInt(3);
			if (tab.posicaoDisponivel(linha, coluna)) {//se a posição destino estiver vazia, realizar a jogada
				tab.mat[linha][coluna] = -1;
				tentativa = false;//se a jogada foi concluída com sucesso, tentativa vira false e interrompe o loop da jogada
			}			
		}
	}
}