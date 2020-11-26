package perceptron;

import java.util.Scanner;

public class Rede {

	Scanner entrada = new Scanner(System.in);
	int qtdAtributos;
	int qtdExemplos;
	Neuronio mcp;
	
	int[][] exemplos = { {1,0 },{ 0,1 }, {1,0 }, { 1,1 } };
	int[] saidaDesejada = { 0, 1, 1, 1};

	public static void main(String[] args) {
		Rede perceptron = new Rede();
		perceptron.iniciarRede();
		perceptron.treinarRede();
		perceptron.executarRede();
	}

	public void iniciarRede() {	
		System.out.println("INICIANDO REDE NEURAL");
		qtdExemplos = exemplos.length;
		qtdAtributos = exemplos[0].length;
		mcp = new Neuronio(qtdAtributos); 
	}

	public void treinarRede() {
		double erro;
		int iteracao = 1;
		
		do {
			System.out.println("ITERACAO " + iteracao++);
			erro = 0;
			for (int i = 0; i < qtdExemplos; i++) {
				for (int j = 0; j < qtdAtributos; j++) {
					mcp.setEntrada(j, exemplos[i][j]);
				}
				mcp.setSaidaDesejada(saidaDesejada[i]);
				mcp.calcSaidaNeuronio();
				mcp.setErro();
				erro = erro + Math.abs(mcp.getErro()); 
			}
		} while (erro > 0);
		
	}

	public void executarRede() {
		do {
			
			System.out.println("ENTRE COM OS ATRIBUTOS DO PADRAO ");
			for (int j = 0; j < qtdAtributos; j++) {
				mcp.setEntrada(j, entrada.nextInt());
			}
			mcp.calcSaidaNeuronio();
			System.out.println("PADRAO PERTENCE A CLASSE: " + mcp.getSaida());
			System.out.println("DIGITE 9 PARA CONTINUAR");
		} while (entrada.nextInt() == 9);
		
	}

}
