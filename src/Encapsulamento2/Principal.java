package Encapsulamento2;
import java.util.Scanner;


public class Principal {
	static Scanner scan = new Scanner(System.in);	
	static Carro carro = new Carro();
	
	public static void main(String [] args) {
		trabalharCarro();
	}
	
	
	public static void trabalharCarro() {
		
		int escolha=0;
		
		System.out.println("Ola, seu carro esta desligado, em ponto morto e a 0km/h\n");
		System.out.println("");
		do {
			System.out.println("\n==== OPCOES DO CARRO ====\n");
			System.out.println("1 - Ligar");
			System.out.println("2 - Desligar");
			System.out.println("3 - Acelerar");
			System.out.println("4 - Diminuir velocidade");
			System.out.println("5 - Virar esquerda/direita");
			System.out.println("6 - Verificar velocidade");
			System.out.println("7 - Trocar marcha");
			System.out.println("0 - sair");
			System.out.println("Digite sua escolha: ");
			escolha = scan.nextInt();
			scan.nextLine();
			
			verificarEscolha(escolha);
			
		}while(escolha != 0);
			
	}


	private static void verificarEscolha(int escolha) {
		switch(escolha) {
		case 1:
			carro.ligar();
			//System.out.println("\nSeu carro esta: " + carro.isLigado() + "\n");
			break;
		case 2:
			carro.desligar();
			//System.out.println("\nSeu carro esta: " + carro.isLigado() + "\n");
			break;
		case 3:
			carro.acelerar();
			break;
		case 4:
			carro.frear();
			break;
		case 5:
			virar();
			break;
		case 6:
			if(carro.isLigado()) {
				System.out.println("\nSua velocidade e : " + carro.getVelocidade() + " Km/h\n");  

			}else {
				System.out.println("\nLigue o carro primeiro");
			}
			break;
		case 7:
			trocarMarcha();
			break;
		case 0:
			System.out.println("\nSaindo...");
			break;
			default:
				System.out.println("\nEscolha uma opcao valida!!!");
				break;
		}
	}


	private static void virar() {
		if(!carro.isLigado()) {
			System.out.println("\nLigue o carro primeiro!");
			return;
		}
		
		System.out.println("\nPara onde deseja virar?");
		System.out.println("1 - Direita");
		System.out.println("2 - Esquerda");
		
		int opcao = scan.nextInt();
		scan.nextLine();
		
		if(opcao ==1) {
			carro.setDirecao("Direita");
			System.out.println("\nVoce virou para a direita!");
		}else if( opcao == 2) {
			carro.setDirecao("Esquerda");
			System.out.println("\nVoce virou para a esquerda!");
		}else {
			System.out.println("\nEscolha uma opcao valida");
			return;
		}
		
	}


	private static void trocarMarcha() {
		if(!carro.isLigado()) {
			System.out.println("\nLigue o carro primeiro!");
			return;
		}
		
		System.out.println("\n ==== CAMBIO ====\n");

		int opcao=0;
		
		System.out.println("1 - subir");
		System.out.println("2 - reduzir");
			
		opcao = scan.nextInt();
		scan.nextLine();
			
		if(opcao == 1) {
				carro.subirMarcha();
				System.out.println("\nAgora voce esta na " + carro.getMarcha() + " marcha\n");
				
		}else if(opcao == 2) {
			carro.reduzirMarcha();
			System.out.println("\nAgora voce esta na " + carro.getMarcha() +  " marcha\n");
			
			if(carro.getMarcha() ==  0 && carro.getVelocidade() ==0) {
				carro.desligar();					System.out.println("\nCarro foi desligado por estar parado em ponto morto");
			}
			
		}else {
			System.out.println("\nOpcao invalida");
			return;
		}
			
		
	}
	
	

}
