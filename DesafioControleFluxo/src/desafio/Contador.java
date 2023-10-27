package desafio;

import java.util.Scanner;

public class Contador {

	public static void main(String[] args) {
		Scanner terminal = new Scanner(System.in);
		System.out.println("Digite o primeiro número: ");
		int paramUm = terminal.nextInt();
		System.out.println("Digite o segundo número: ");
		int paramDois = terminal.nextInt();
		try {
			contar(paramUm, paramDois);
		} catch (ParametrosInvalidosException exception) {
			System.err.println("O segunda parametro deve ser maior que o primeiro.");
		}
		
	}

	static void contar(int paramUm, int paramDois) throws ParametrosInvalidosException {
		if(paramUm >= paramDois) {
			throw new ParametrosInvalidosException();
		}
		
		int contador = paramDois - paramUm;
		
		for(int i = 0; i < contador; i++) 
			System.out.println("Imprimindo número " + i);
		
	}
}
