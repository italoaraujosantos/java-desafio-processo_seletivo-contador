package candidatura;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {

	public static void main(String[] args) {
		String [] candidatos = {"MONICA","FABRICIO", "MIRELA", "DANIELA","JORGE"};
		for(String candidato: candidatos) {
			entrandoEmContato(candidato);
		}
		
	}
	
	static void entrandoEmContato(String candidato) {
		int tentativasRealizadas = 1;
		boolean continuarTentando = true;
		boolean atendeu = false;
		do {
			atendeu = atender();
			continuarTentando = !atendeu;
			if(continuarTentando) {
				tentativasRealizadas++;
			} else {
				System.out.println("Contato realizado com sucesso!");
			}
		} while(continuarTentando && tentativasRealizadas < 3);
		if(atendeu) {
			System.out.println("Conseguimos contato com "+candidato+" na "+tentativasRealizadas+" tentativa(as)");
		} else {
			System.out.println("Não conseguimos contato com "+candidato+" númeno máximo de tentativas "+tentativasRealizadas+" tentativas.");
		}
	}
	
	static boolean atender() {
		return new Random().nextInt(3)==1;
	}
	
	static void imprimirSelecionados() {
		String [] candidatos = {"MONICA","FABRICIO", "MIRELA", "DANIELA","JORGE"};
		System.out.println("Imprimindo a lista de candidatos selecionados");
		for(String candidato: candidatos) {
			System.out.println("O Candidato selecionado foi: "+candidato);
		}
	}
	
	static void selecaoCandidato() {
		String [] candidatos = {"FELIPE", "MARCIA", "JULIA", "AUGUSTO", "MONICA","FABRICIO", "MIRELA", "DANIELA","JORGE"};
		int candidatosSelecionados = 0;
		int candidatoAtual = 0;
		double salarioBase = 2000.0;
		while (candidatosSelecionados < 5 && candidatoAtual < candidatos.length) {
			String candidato = candidatos[candidatoAtual];
			double salarioPretendido = valorPretendido();
			System.out.println("O candidato "+candidato + " solicitou este valor pretendido R$"+salarioPretendido);
			if(salarioBase >= salarioPretendido) {
				System.out.println("O candidato "+candidato+" foi aprovado!");
				candidatosSelecionados++;
			}
			candidatoAtual++;
		}
	}
	
	static double valorPretendido() {
		return ThreadLocalRandom.current().nextDouble(1800.0, 2200.0);
	}

	static void analisarCandidato(double salarioPretendido) {
		double salarioBase = 2000.0;
		if(salarioBase > salarioPretendido) {
			System.out.println("Ligar para o candidato!");
		} else if (salarioBase == salarioPretendido) {
			System.out.println("Ligar para o candidato com contraproposta.");
		} else {
			System.out.println("Aguardando o resultado dos demais candidatos.");
		}
	}
}
