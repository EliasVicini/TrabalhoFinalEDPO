package algoritmogenetico;

import java.util.Scanner;

public class AlgoritmoGenetico {

	public static void main(String[] args) {

		int linhas = 8 ;
		int colunas = 8;
		int inix = -1;
		int iniy = -1;
		int fimx = -1;
		int fimy = -1;
		int qtdeDna;
		int maxDna;
		char partidaL;
		char chegadaL;
		Scanner entrada;
		entrada = new Scanner(System.in);


		//-----------LER DO USUARIO A quantidade de DNA
		System.out.println("Digite a quantidade de DNA em uma geracao ");
		qtdeDna = Integer.parseInt(entrada.next());	
		System.out.println("Digite a quantidade de geracoes ");
		maxDna = Integer.parseInt(entrada.next());
		Populacao j = new Populacao(qtdeDna, linhas, colunas, inix, iniy, fimx, fimy, 100);
		System.out.println("\n");
		System.out.println("Matriz a Percorrer");
		j.ambiente.exibir();


		//-----------LER DO USUARIO A PARTIDA INICIAL
		System.out.println("Digitide o numero de partida: ");
		do{
			try{
				inix = Integer.parseInt(entrada.next());
				if((inix < 0)||(inix>7))
					System.out.println("Numero invalido, digite outro:");
			}catch (NumberFormatException e){
				System.out.println("numero invalido, digite outro:");

			}
		}while((inix <0) || (inix >7));

		System.out.println("Digitide a Letra de partida: ");
		partidaL = entrada.next().charAt(0);
		if(partidaL == 'a' || partidaL == 'A')
			iniy=0;
		if(partidaL == 'b' || partidaL == 'B')
			iniy=1;
		if(partidaL == 'c' || partidaL == 'C')
			iniy=2;
		if(partidaL == 'd' || partidaL == 'D')
			iniy=3;
		if(partidaL == 'e' || partidaL == 'E')
			iniy=4;
		if(partidaL == 'f' || partidaL == 'F')
			iniy=5;
		if(partidaL == 'g' || partidaL == 'G')
			iniy=6;
		if(partidaL == 'h' || partidaL == 'H')
			iniy=7;

		while((partidaL != 'a')&& (partidaL != 'A') && (partidaL != 'b') && (partidaL != 'B') 
				&& (partidaL != 'c') && (partidaL != 'C') && (partidaL != 'd') && (partidaL != 'D') 
				&& (partidaL != 'e') && (partidaL != 'E') && (partidaL != 'f') && (partidaL != 'F') 
				&& (partidaL != 'g') && (partidaL != 'G') && (partidaL != 'h') && (partidaL != 'H'))
		{
			System.out.println("Letra Invalida, digite outra: ");
			partidaL = entrada.next().charAt(0);

			//-----------TRANSFORMA A LETRA ESCOLHIDA PELO N� DA MATRIZ
			if(partidaL == 'a' || partidaL == 'A')
				iniy=0;
			if(partidaL == 'b' || partidaL == 'B')
				iniy=1;
			if(partidaL == 'c' || partidaL == 'C')
				iniy=2;
			if(partidaL == 'd' || partidaL == 'D')
				iniy=3;
			if(partidaL == 'e' || partidaL == 'E')
				iniy=4;
			if(partidaL == 'f' || partidaL == 'F')
				iniy=5;
			if(partidaL == 'g' || partidaL == 'G')
				iniy=6;
			if(partidaL == 'h' || partidaL == 'H')
				iniy=7;
		}


		//-----------LER DO USU�IO O DESTINO

		System.out.println("Digitide o numero de chegada: ");
		do{
			try{
				fimx = Integer.parseInt(entrada.next());
				if((fimx < 0)||(fimx>7))
					System.out.println("Numero invalido, digite outro:");
			}catch (Exception e){
				System.out.println("Numero invalido, digite outro:");
			}
		}while((fimx <0) || (fimx >7));

		System.out.println("Digitide a Letra do destino: ");
		chegadaL = entrada.next().charAt(0);
		if(chegadaL == 'a' || chegadaL == 'A')
			fimy=0;
		if(chegadaL == 'b' || chegadaL == 'B')
			fimy=1;
		if(chegadaL == 'c' || chegadaL == 'C')
			fimy=2;
		if(chegadaL == 'd' || chegadaL == 'D')
			fimy=3;
		if(chegadaL == 'e' || chegadaL == 'E')
			fimy=4;
		if(chegadaL == 'f' || chegadaL == 'F')
			fimy=5;
		if(chegadaL == 'g' || chegadaL == 'G')
			fimy=6;
		if(chegadaL == 'h' || chegadaL == 'H')
			fimy=7;
		while((chegadaL != 'a') && (chegadaL != 'A') && (chegadaL != 'b') && (chegadaL != 'B') 
				&& (chegadaL != 'c') && (chegadaL != 'C') && (chegadaL != 'd') && (chegadaL != 'D') 
				&& (chegadaL != 'e') && (chegadaL != 'E') && (chegadaL != 'f') && (chegadaL != 'F') 
				&& (chegadaL != 'g') && (chegadaL != 'G') && (chegadaL != 'h') && (chegadaL != 'H'))
		{
			System.out.println("Letra Invalida digite outra: ");
			chegadaL = entrada.next().charAt(0);

			//-----------TRANSFORMA A LETRA ESCOLHIDA PELO N� DA MATRIZ
			if(chegadaL == 'a' || chegadaL == 'A')
				fimy=0;
			if(chegadaL == 'b' || chegadaL == 'B')
				fimy=1;
			if(chegadaL == 'c' || chegadaL == 'C')
				fimy=2;
			if(chegadaL == 'd' || chegadaL == 'D')
				fimy=3;
			if(chegadaL == 'e' || chegadaL == 'E')
				fimy=4;
			if(chegadaL == 'f' || chegadaL == 'F')
				fimy=5;
			if(chegadaL == 'g' || chegadaL == 'G')
				fimy=6;
			if(chegadaL == 'h' || chegadaL == 'H')
				fimy=7;
		}

		Populacao p = new Populacao(qtdeDna, linhas, colunas, inix, iniy, fimx, fimy, maxDna);
		p.apurarDnas();

		System.out.print("\n");
		System.out.println("DNAS = " + p.qtdeDna);
		System.out.println("Tentativas = " + p.mediaTentativa());
		System.out.println("Melhor Grupo de DNA = "); p.exibeBestDna();


	}
}
