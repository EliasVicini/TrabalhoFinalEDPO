package algoritmogenetico;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

public class Populacao {

	ArrayList<Dna> listadna = new ArrayList();
	Ambiente ambiente;
	public int lins;
	public int cols;
	public int inicioX;
	public int inicioY;
	public int fimX;
	public int fimY;
	public int qtdeDna;// quantidade de Dnas
	public int maxDna;//tamanho do DNA
	public char matriz[][];

	public Populacao(int qtdeDna, int lins, int cols, int inicioX, int inicioY,
			int fimX, int fimY, int maxDna) {

		for (int i = 0; i < qtdeDna; i++) {
			Dna dnaAux = new Dna(maxDna);
			listadna.add(dnaAux);

		}

		this.lins = lins;
		this.cols = cols;
		this.inicioX = inicioX;
		this.inicioY = inicioY;
		this.fimX = fimX;
		this.fimY = fimY;
		this.qtdeDna = qtdeDna;
		this.maxDna = maxDna;



		ambiente = new Ambiente(lins, cols, inicioX, inicioY, fimX, fimY);         
	}

	public void crossover() {//cruza um dna com o outro da populacao!

		int aux = listadna.size();
	Dna pai, mae, filho;
	for (int i = 0; i < aux; i++) {
		pai = listadna.get(i);
		mae = listadna.get(i + 1);
		filho = pai.crossover(mae);
		listadna.add(filho);
	}
	}

	//Realiza a troca de um valor de DNA por outro aleatório
	public void mutaciona(int qtdIndividos) {
		for (int i = 0; i <= qtdIndividos; i++) {
			listadna.get(seleciona()).mutaciona();
		}
	}

	//Exibir a porcentagem de erros, tentativas e sucessos.
	public void exibeIndicadores() {
		mediaErros();
		mediaTentativa();
		porcentagemSucesso();
	}

	//Limpar os DNAs
	public void reset() {
		for (int i = 0; i < listadna.size(); i++) {
			listadna.get(i).reset();
		}
	}

	//Faz a ordenação do grupo com menos tentativas para chegar ao destino
	public void ordena() {
		Dna dnaAux;
		for (int x = 0; x < listadna.size(); x++) {
			for (int y = x + 1; y < listadna.size(); y++) {
				if (listadna.get(x).tentativas > listadna.get(y).tentativas) {
					dnaAux = listadna.get(x);
					listadna.set(x, listadna.get(y));
					listadna.set(y, dnaAux);
				}
			}
		}
	}

	//Remove o grupo de DNA com mais tentativas
	public void removeRuins(int qtdRuins) {
		for (int i = 0; i < qtdRuins; i++) {
			listadna.remove(listadna.size() - 1);
		}
	}

	//Apura se os DNAs são bons para a aplicar
	public void apurarDnas() {
		//Enquanto a porcentagem de sucesso (cehgou até o final) for menor que a metade de todas as gerações realiza as ações abaixo
		while (porcentagemSucesso() < 0.5) {
			for (int i = 0; i < qtdeDna; i++) {
				ambiente.aplicaDna(listadna.get(i), false);
			}
			ordena();
			removeRuins(listadna.size() / 2);
			crossover();
			mutaciona(listadna.size() / 2);       

			//Após a ação executada acima a o grupo de DNA que sobra é o melhor.
		}
		ambiente.aplicaDna(listadna.get(0), true);

	}

	//Exibir o grupo de melhor DNA
	public void exibeBestDna() {
		listadna.get(0).exibir();


	}

	//Selecione uma posição aleatória da lista de DNA para mutacionar
	public int seleciona() {
		Random random = new Random();
		int numeroTemporario = random.nextInt(listadna.size());
		return numeroTemporario;

	}

	//Retorna a porcentagem de sucesso do grupo de DNA.
	public double porcentagemSucesso() {
		double soma = 0;
		for (int i = 0; i < listadna.size(); i++) {
			if (listadna.get(i).sucesso) {
				soma++;
			}
		}
		return soma / (double) listadna.size();
	}

	//Retornar a media de erros de passos\ DNA ruins
	double mediaErros() {
		int soma = 0;
		for (int i = 0; i < qtdeDna; i++) {
			soma = soma + listadna.get(i).erros;
		}
		return soma / qtdeDna;
	}

	//Exibi a quantidade de tentativas para o melhor grupo de DNA
	double mediaTentativa() {
		int soma = 0;
		for (int i = 0; i < qtdeDna; i++) {
			soma = soma + listadna.get(i).tentativas;
		}
		return soma;
		//return soma / qtdeDna;
	}
}
