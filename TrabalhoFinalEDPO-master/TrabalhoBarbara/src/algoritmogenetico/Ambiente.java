package algoritmogenetico;

public class Ambiente {

	public char ambiente[][];
	public int lins;
	public int cols;
	public int inicioX;
	public int inicioY;
	public int fimX;
	public int fimY;
	public char mudar;
	public char letra;

	public Ambiente(int lins, int cols, int inicioX, int inicioY, int fimX, int fimY) {
		this.lins = lins;
		this.cols = cols;
		this.inicioX = inicioX;
		this.inicioY = inicioY;
		this.fimX = fimX;
		this.fimY = fimY;
		ambiente = new char[lins][cols];


		for (int i = 0; i < lins; i++) {
			for (int j = 0; j < cols; j++) {
				ambiente[i][j] = ' ';
			}
		}

	}

	//Exibir as cidades visitadas
	public void exibirPercorridos() {

		for (int i = 0; i < lins; i++) {
			for (int j = 0; j < cols; j++) {
				if (ambiente[i][j] == '-') {
					System.out.print(i);
					if( j == 0)
						mudar = 'A';
					if( j == 1)
						mudar = 'B';
					if( j == 2)
						mudar = 'C';
					if( j == 3)
						mudar = 'D';
					if( j == 4)
						mudar = 'E';
					if( j == 5)
						mudar = 'F';
					if( j == 6)
						mudar = 'G';
					if( j == 7)
						mudar = 'H';

					System.out.print(mudar);
					System.out.print(",");
				}
			}
		}

	}
	//Deixar a matriz vazia
	public void limparPercorridos() {

		for (int i = 0; i < lins; i++) {
			for (int j = 0; j < cols; j++) {
				if (ambiente[i][j] == '-') {
					ambiente[i][j] = ' ';
				}
			}
		}
	}

	// Aplicar o DNA e Andar na matriz
	public void aplicaDna(Dna x, boolean exibir) {
		x.reset();
		limparPercorridos();
		int auxX = inicioX;
		int auxY = inicioY;

		for (int i = 0; i < x.max; i++) {
			x.tentativas++;
			if (auxX == fimX && auxY == fimY) {
				System.out.println("\n");

				x.sucesso = true;
				ambiente[auxX][auxY] = '-';
				System.out.print("Melhor Caminho:");
				break;
			}
			ambiente[inicioX][inicioY] = '-';
			if (x.listadna.get(i) == 0) {

    // X linha Y Coluna
    // -1 (X) Esquerda
    // -1 (Y) baixo
    // +1 (X) Direita
    // +1 (Y) cima
				if (podeAndar(auxX - 1, auxY + 2)) {
					auxX = auxX - 1;
					auxY = auxY + 2;
					ambiente[auxX][auxY] = '-';

					exibirAmbiente();
					System.out.println("\n");
					System.out.print("Caminho Visitado Agora: ");
					if (auxY == 0)
						letra = 'A';
					if (auxY == 1)
						letra = 'B';
					if (auxY == 2)
						letra = 'C';
					if (auxY == 3)
						letra = 'D';
					if (auxY == 4)
						letra = 'E';
					if (auxY == 5)
						letra = 'F';
					if (auxY == 6)
						letra = 'G';
					if (auxY == 7)
						letra = 'H';
					System.out.print(auxX);
					System.out.println(letra);
				} else {
					x.erros++;
					exibirAmbiente();
					System.out.println("\n");
					System.out.println("DNA Ruim, sem saida:\n Quantidade de DNA ruim dessa Geracao: " + x.erros);
                                                                            // criou o filho mais nao vai
				}

			} else if (x.listadna.get(i) == 1) {
				if (podeAndar(auxX + 1, auxY + 2)) {
					auxX = auxX + 1;
					auxY = auxY  + 2;
					ambiente[auxX][auxY] = '-';
					exibirAmbiente();
					System.out.println("\n");
					System.out.print("Caminho Visitado Agora: ");
					System.out.print(auxX);
					if (auxY == 0)
						letra = 'A';
					if (auxY == 1)
						letra = 'B';
					if (auxY == 2)
						letra = 'C';
					if (auxY == 3)
						letra = 'D';
					if (auxY == 4)
						letra = 'E';
					if (auxY == 5)
						letra = 'F';
					if (auxY == 6)
						letra = 'G';
					if (auxY == 7)
						letra = 'H';
					System.out.println(letra);
				} 
				else {
					x.erros++;
					exibirAmbiente();
					System.out.println("\n");
					System.out.println("DNA Ruim, sem saida:\n Quantidade de DNA ruim dessa Geracao: " + x.erros);
				}
			} else if (x.listadna.get(i) == 2) {
				if (podeAndar(auxX - 1, auxY - 2)) {
					auxX = auxX - 1;
					auxY = auxY - 2;
					ambiente[auxX][auxY] = '-';
					exibirAmbiente();
					System.out.println("\n");
					System.out.print("Caminho Visitado Agora: ");
					System.out.print(auxX);
					if (auxY == 0)
						letra = 'A';
					if (auxY == 1)
						letra = 'B';
					if (auxY == 2)
						letra = 'C';
					if (auxY == 3)
						letra = 'D';
					if (auxY == 4)
						letra = 'E';
					if (auxY == 5)
						letra = 'F';
					if (auxY == 6)
						letra = 'G';
					if (auxY == 7)
						letra = 'H';
					System.out.println(letra);
				} else {
					x.erros++;
					exibirAmbiente();
					System.out.println("\n");
					System.out.println("DNA Ruim, sem saida:\n Quantidade de DNA ruim dessa Geracao: " + x.erros);
				}
			} else if (x.listadna.get(i) == 3) {
				if (podeAndar(auxX + 1, auxY - 2)) {
					auxX = auxX + 1;
					auxY = auxY - 2;
					ambiente[auxX][auxY] = '-';
					exibirAmbiente(); 
					System.out.println("\n");
					System.out.print("Caminho Visitado Agora: ");
					System.out.print(auxX);
					if (auxY == 0)
						letra = 'A';
					if (auxY == 1)
						letra = 'B';
					if (auxY == 2)
						letra = 'C';
					if (auxY == 3)
						letra = 'D';
					if (auxY == 4)
						letra = 'E';
					if (auxY == 5)
						letra = 'F';
					if (auxY == 6)
						letra = 'G';
					if (auxY == 7)
						letra = 'H';
					System.out.println(letra);
				} else {
					x.erros++;
					exibirAmbiente();
					System.out.println("\n");
					System.out.println("DNA Ruim, sem saida:\n Quantidade de DNA ruim dessa Geracao: " + x.erros);
				}
			} else if (x.listadna.get(i) == 4) {
				if (podeAndar(auxX - 2, auxY + 1)) {
					auxX = auxX - 2;
					auxY = auxY + 1;
					ambiente[auxX][auxY] = '-';
					exibirAmbiente();
					System.out.println("\n");
					System.out.print("Caminho Visitado Agora: ");
					System.out.print(auxX);
					if (auxY == 0)
						letra = 'A';
					if (auxY == 1)
						letra = 'B';
					if (auxY == 2)
						letra = 'C';
					if (auxY == 3)
						letra = 'D';
					if (auxY == 4)
						letra = 'E';
					if (auxY == 5)
						letra = 'F';
					if (auxY == 6)
						letra = 'G';
					if (auxY == 7)
						letra = 'H';
					System.out.println(letra);
				} else {
					x.erros++;
					exibirAmbiente();
					System.out.println("\n");
					System.out.println("DNA Ruim, sem saida:\n Quantidade de DNA ruim dessa Geracao: " + x.erros);
				}
			} else if (x.listadna.get(i) == 5) {
				if (podeAndar(auxX + 2, auxY + 1)) {
					auxX = auxX + 2;
					auxY = auxY + 1;
					ambiente[auxX][auxY] = '-';
					exibirAmbiente();
					System.out.println("\n");
					System.out.print("Caminho Visitado Agora: ");
					System.out.print(auxX);
					if (auxY == 0)
						letra = 'A';
					if (auxY == 1)
						letra = 'B';
					if (auxY == 2)
						letra = 'C';
					if (auxY == 3)
						letra = 'D';
					if (auxY == 4)
						letra = 'E';
					if (auxY == 5)
						letra = 'F';
					if (auxY == 6)
						letra = 'G';
					if (auxY == 7)
						letra = 'H';
					System.out.println(letra);
				} else {
					x.erros++;
					exibirAmbiente();
					System.out.println("\n");
					System.out.println("DNA Ruim, sem saida:\n Quantidade de DNA ruim dessa Geracao: " + x.erros);
				}
			} else if (x.listadna.get(i) == 6) {
				if (podeAndar(auxX - 2, auxY - 1)) {
					auxX = auxX - 2;
					auxY = auxY - 1;
					ambiente[auxX][auxY] = '-';
					exibirAmbiente();
					System.out.println("\n");
					System.out.print("Caminho Visitado Agora: ");
					System.out.print(auxX);
					if (auxY == 0)
						letra = 'A';
					if (auxY == 1)
						letra = 'B';
					if (auxY == 2)
						letra = 'C';
					if (auxY == 3)
						letra = 'D';
					if (auxY == 4)
						letra = 'E';
					if (auxY == 5)
						letra = 'F';
					if (auxY == 6)
						letra = 'G';
					if (auxY == 7)
						letra = 'H';
					System.out.println(letra);
				} else {
					x.erros++;
					exibirAmbiente();
					System.out.println("\n");
					System.out.println("DNA Ruim, sem saida:\n Quantidade de DNA ruim dessa Geracao: " + x.erros);
				}
			} else if (x.listadna.get(i) == 7) {
				if (podeAndar(auxX + 2, auxY - 1)) {
					auxX = auxX + 2;
					auxY = auxY - 1;
					ambiente[auxX][auxY] = '-';
					exibirAmbiente();
					System.out.println("\n");
					System.out.print("Caminho Visitado Agora: ");
					System.out.print(auxX);
					if (auxY == 0)
						letra = 'A';
					if (auxY == 1)
						letra = 'B';
					if (auxY == 2)
						letra = 'C';
					if (auxY == 3)
						letra = 'D';
					if (auxY == 4)
						letra = 'E';
					if (auxY == 5)
						letra = 'F';
					if (auxY == 6)
						letra = 'G';
					if (auxY == 7)
						letra = 'H';
					System.out.println(letra);
				} else {
					x.erros++;
					exibirAmbiente();
					System.out.println("\n");
					System.out.println("DNA Ruim, sem saida:\n Quantidade de DNA ruim dessa Geracao: " + x.erros);

				}
			}   
		}
		if (exibir) {
			exibirAmbiente();


		}


	}

	//Exibi a matriz com os pontos percorridos
	public void exibirAmbiente() {
		System.out.println("\n");
		System.out.println("|-----------------------|");
		int numeroL = 0;
		for (int i = 0; i < lins; i++) {
			System.out.print(numeroL);
			for (int j = 0; j < cols; j++) {
				System.out.print("[" + ambiente[i][j] + "]");
			}
			numeroL++;
			System.out.println();
		}
		System.out.println("- A  B  C  D  E  F  G  H ");
		System.out.print("Cidades Visitadas: ");
		exibirPercorridos();

	}


	//Exibi a matriz vazia
	public void exibir() {
		System.out.println("--------------------------------------------");
		int numeroL = 0;
		for (int i = 0; i < lins; i++) {
			System.out.print(numeroL);
			for (int j = 0; j < cols; j++) {
				System.out.print("[" +" " + "]");
			}
			numeroL++;
			System.out.println(" ");
		}
		System.out.println("- A  B  C  D  E  F  G  H ");
		System.out.println(" ");

	}

	//Verifica se pode andar
	boolean podeAndar(int x, int y) {
		if (x >= 0 && x < lins && y >= 0 && y < cols) {
			if (ambiente[x][y] == ' ') {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
}
