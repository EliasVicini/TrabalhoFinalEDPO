package algoritmogenetico;


import java.util.ArrayList;
import java.util.Random;

public class Dna {

	ArrayList<Integer> listadna;
	int max;
	int erros = 0;
	int tentativas = 0;
	boolean sucesso = false;

	public Dna(int max) {
		this.listadna = new ArrayList<Integer>();
		this.max = max;
		gerarDna();
	}

	//Gerar aleatoriamente numeros de 0 a 7 para ser o DNA
	//N�meros s�o gerados de acordo com a quantidade de DNA escolhido pelo usu�rio
	public void gerarDna() {
		Random random = new Random();
		int numeroTemporario = 0;
		for (int i = 0; i < max; i++) {
			numeroTemporario = random.nextInt(8);
			listadna.add(numeroTemporario);

		}
	}

	//Zera as tentativas, erros e sucessos
	public void reset() {
		tentativas = 0;
		erros = 0;
		sucesso = false;
	}

	//Realiza a troca de um DNA por outro da lista
	public Dna crossover(Dna x) {
		Dna dnaTemporario = new Dna(max);
		for(int i = 0; i < max; i ++){
			if(seleciona() == 0){
				dnaTemporario.listadna.set(i,listadna.get(i));
			}else{
				dnaTemporario.listadna.set(i,x.listadna.get(i));

			}

		}

		return dnaTemporario;
	}
	//muda o valor de um DNA aleat�riamente	
	public void mutaciona() {
		listadna.set(selecionaPos(),mudaValor());

	}
	//Exibi o grupo com o melhor DNA
	public void exibir() {
		System.out.println("-------------------");
		for (int i = 0; i < max; i++) {
			System.out.print(listadna.get(i) + "|");
		}
		System.out.println("\n|-------------------|");

	}

	//Responsavel por dizer se realiza crossover ou numero (quando agarra)
	public int seleciona(){
		Random random = new Random();
		int  numeroTemporario = random.nextInt(2);
		return numeroTemporario;

	}

	//Selecione uma posicao aleatoria para mutacionar
	public int selecionaPos(){
		Random random = new Random();
		int  numeroTemporario = random.nextInt(max);
		return numeroTemporario;

	} 
	//Realiza a troca de um DNA por outro /Mutaciona  
	public int mudaValor(){
		Random random = new Random();
		int  numeroTemporario = random.nextInt(8);
		return numeroTemporario;
	}


}