package dev.joaonogueira.jogodavelha;

public class Tabuleiro {
	public int mat[][] = new int[3][3]; //criação da matriz do tabuleiro
	public int vencedor; //propriedade que indica o vencedor
	public int vez; //propriedade que indica de qual jogador é a vez de jogar
	//Jogador humano - valor na matriz (1) - símbolo de exibição (X)
	//Computador - valor na matriz (-1) - símbolo de exibição (O)
	//Espaco vazio - valor na matriz (0) - símbolo de exibição (-)
	public int situacao() { //verifica a sitação do tabuleiro: 0-continuar //1-vitória//2-empate
		if (verificaLinha() || verificaColuna() || verificaDiagonal()) { //verifica a vitória checando linhas, colunas e diagonais
			return 1;
		}
		else if (tabuleiroCheio()) { //caso não haja vitória, mas o tabuleiro já está cheio, retorna empate
			return 2;
		}
		else { // se nenhum dos anteriores, continuar o jogo
			return 0;
		}
	}
	
	public boolean posicaoDisponivel(int x, int y) { //testar se determinada posição está vazia para receber jogada
		if (this.mat[x][y] == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void visualizar() { //exibir o estado atual do tabuleiro
		for (int i = 0; i < mat.length; i++) {//linhas
			for (int j = 0; j < mat.length; j++) {//colunas
				if(mat[i][j]==1) {
					System.out.print("X ");
				}
				else if(mat[i][j]==-1) {
					System.out.print("O ");
				}
				else {
					System.out.print("- ");
				}
			}
			System.out.println();
		}	
	}
	
	private boolean tabuleiroCheio() { //verificar se o tabuleiro está preenchido
		for (int i = 0; i < mat.length; i++) {//linhas
			for (int j = 0; j < mat.length; j++) {//colunas
				if(mat[i][j]==0) {
					return false;
				}
			}
		}	
		return true;
	}	
	
	private boolean verificaLinha() { //verificar se qualquer linha está preenchida com valores de um mesmo jogador
		for (int i = 0; i < mat.length; i++) {//linhas
			if ((mat[i][0] == mat[i][1] && mat[i][1] == mat[i][2]) && mat[i][0]!=0) {
				vencedor = mat[i][0];
				return true;
			}
		}
		return false;
	}
	
	private boolean verificaColuna() { //verificar se qualquer coluna está preenchida com valores de um mesmo jogador
		for (int j = 0; j < mat.length; j++) {//colunas
			if ((mat[0][j] == mat[1][j] && mat[1][j] == mat[2][j]) && mat[0][j]!=0) {
				vencedor = mat[0][j];
				return true;
			}
		}
		return false;		
	}
	private boolean verificaDiagonal() { //verificar se qualquer diagonal está preenchida com valores de um mesmo jogador
		if (((mat[0][0] == mat[1][1] && mat[1][1] == mat[2][2]) || (mat[0][2] == mat[1][1] && mat[1][1] == mat[2][0])) && mat[1][1]!=0) {
			vencedor = mat[1][1];
			return true;
		}
		return false;	
	}
}
