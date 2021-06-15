package dev.joaonogueira.jogodavelha;

import java.util.Scanner;

public class Jogo {

	public static void main(String[] args) { //método main de início do jogo
		Tabuleiro tab =new Tabuleiro(); //criação do tabuleiro
		Jogador jogador = new Jogador(); //criação do jogador
		
		Scanner teclado = new Scanner(System.in); //leitura da opção de dificuldade
		System.out.println("Jogo da velha");
		System.out.println("Escolha a dificuldade 1,2 ou 3:");
		int opcao = teclado.nextInt();
		Computador comp = null;
		if(opcao==1) { //para cada opção será criado um objeto Computador de classe diferente, relativo ao comportamento
			comp = new ComputadorFacil();
			tab.vez=1; //no fácil, o jogador recebe a primeira vez de jogar
		}
		else if (opcao==2) {
			comp = new ComputadorMedio();
			tab.vez=2; //no médio e no difícil, o computador joga primeiro pra ter uma vantagem
		}
		else { //se for selecionada a opção 3, ou qualquer outra opção não listada, criar computador Difícil
			comp = new ComputadorDificil();
			tab.vez=2; //no médio e no difícil, o computador joga primeiro pra ter uma vantagem
		}
		tab.visualizar(); //visualizar o tabuleiro vazio
		
		while(tab.situacao()==0) { //verifica a situação do tabuleiro, enquanto retornar 0, continuar o jogo, alternando os jogadores
			if(tab.vez==1) { //Jogador Humano
				System.out.println("Sua vez (X):");
				jogador.jogar(tab);
				tab.vez=2; 
			}
			else if(tab.vez==2) { //Computador
				System.out.println("Jogada do Computador (O):");
				comp.jogar(tab);
				tab.vez=1;
			}
			tab.visualizar(); //após qualquer jogada, exibir o tabuleiro novamente
		}
		
		if (tab.situacao()==1 && tab.vencedor==1) { //se a situação for de vitória, indicar qual o vencedor
			System.out.println("Você venceu! Parabéns!!!");
			teclado.close();
		}
		else if (tab.situacao()==1 && tab.vencedor==-1) {
			System.out.println("Você perdeu para o Computador.");
			teclado.close();
		}
		else if (tab.situacao()==2) { //se a situação for de empate
			System.out.println("Empate.");
			teclado.close();
		}

	}

}
