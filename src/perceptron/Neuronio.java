package perceptron;

public class Neuronio {
	private int[] x; 
 
	private double[] w;
	
	private double y; 
	
	private double yd; 

	private double e;

	private double n;


	public Neuronio(int quantEntrada) {
		x = new int[quantEntrada];
		w = new double[quantEntrada];
		n = 0.3;
		inicializaPesos();
	}
	

	private void inicializaPesos() {
		for (int i = 0; i < w.length; i++) {
			w[i] = 0;
		}
	}
	

	public void setEntrada(int indice, int valor) {
		x[indice] = valor;
	}
	
	
	public void setSaidaDesejada(int valor) {
		yd = valor;
	}
	

	 
	public void calcSaidaNeuronio() {
		double u = 0;
		
		for (int i = 0; i < w.length; i++) {
			u = u + (x[i] * w[i]);
		}
		System.out.println("U = "+u);
		
		if(u >= 0)
			y = 1;
		else
			y = 0;
		
		System.out.println("Y = "+y);
	}

	
	public void setErro() {
		e = yd - y;
		if (e != 0)
			atualizaPeso();
		System.out.println("e = " + e);
	}

	private void atualizaPeso() {
		for (int i = 0; i < w.length; i++) {
			w[i] = w[i] + n*e*x[i];
			System.out.println("w[" + i + "] = "+w[i]);
		}
	}
	
	public double getErro() {
		return e;
	}
	
	public double getSaida() {
		return y;
	}

}
