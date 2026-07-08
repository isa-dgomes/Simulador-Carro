package Encapsulamento2;

import java.util.Scanner;

public class Carro {
	Scanner scan = new Scanner(System.in);	

	
	private int marcha;
	private String direcao;
	private int velocidade;
	private boolean ligado;
	
	public Carro() {
		ligado = false;
		marcha = 0;
		velocidade = 0;
	}
	
	//getters
	public int getMarcha() {
		return marcha;
	}
	
	public String getDirecao() {
		return direcao;
	}
	
	public int getVelocidade() {
		return velocidade;
	}
	
	public boolean isLigado() {
		return ligado;
	}
	
	//setters
	public void setMarcha(int marcha) {
		this.marcha = marcha;
	}
	
	public void setDirecao(String direcao) {
		this.direcao = direcao;
	}
	
	public void setVelocidade(int velocidade) {
		this.velocidade = velocidade;
	}
	
	public void setLigado(boolean ligado) {
		this.ligado = ligado;
	}
	
	//metodos
	public void ligar() {
		if(ligado) {
			System.out.println("\nSeu carro ja esta ligado");
		}else {
			this.ligado=true;
			System.out.println("\nCarro ligado!\n");
		}
	}
	
	public void desligar() {
		if(!ligado) {
			System.out.println("\nSeu carro ja esta desligado");
		}else if( velocidade == 0 && marcha == 0) {
			this.ligado = false;
			System.out.println("\nCarro desligado!\n");
		}else {
			System.out.println("\nSeu carro precisa estar parado e em ponto morto pra desligar\n");
		}
		
	}
	
	public void acelerar() {
		
		if(!ligado) {
			System.out.println("\nO carro esta desligado!\n");
			return;
		}
		
		if(marcha == 0) {
			System.out.println("\nSuba de marcha primeiro");
			return;
		}
		
		while(true) {
			
			int limite = 0;
			
			switch(marcha) {
			case 1:
				limite = 20;
				break;
			case 2:
				limite = 40;
				break;
			case 3:
				limite = 60;
				break;
			case 4:
				limite = 80;
				break;
			case 5:
				limite = 100;
				break;
			case 6:
				limite = 120;
				break;
			}
			
			
			while(velocidade < limite) {
				velocidade++;
				System.out.println("Velocidade: " + velocidade + " Km/h\n");
			}
			
			if(marcha == 6) {
				velocidade = 120;
				System.out.println("\nVelocidade maxima atingida!");
				break;
			}
			
			
			System.out.println("\nLimite da " + marcha + " marcha atingida. ");
			System.out.println("Deseja subir para a " + (marcha+1) + " marcha ?");
			System.out.println("1 - sim");
			System.out.println("2 - nao\n");
			int opcao = scan.nextInt();
			scan.nextLine();
			
			if(opcao == 1) {
				marcha++;
				System.out.println("\nMarcha alterada para " + marcha);
			}else if(opcao == 2) {
				System.out.println("\nMantendo a marcha atual");
				return;
			}else {
				System.out.println("\nOpcao invalida");
				return;
			}
			
		}	
	}
	
	public void frear() {
		
		if(!ligado) {
			System.out.println("\nO carro esta desligado!");
			return;
		}
		
		if(marcha == 0 && velocidade ==0) {
			System.out.println("\nVoce esta parado!");
			return;
		}else {
			boolean continuar = true;
			while(continuar) {
				
				int minimo=0;
				
				switch(marcha) {
				case 1:
					minimo = 0;
					break;
				case 2:
					minimo = 21;
					break;
				case 3:
					minimo = 42;
					break;
				case 4:
					minimo = 61;
					break;
				case 5:
					minimo = 81;
					break;
				case 6:
					minimo = 101;
					break;
				}
				
				
				while(velocidade > minimo) {
					velocidade--;
					System.out.println("Velocidade: " + velocidade + " Km/h");
				}
				
				if(marcha==1 && velocidade ==0) {
					System.out.println("\nO carro esta parado");
					continuar=false;
				}else {
					
					System.out.println("\nDeseja reduzir a marcha para: " + (marcha - 1) + " ?" );
					System.out.println("1 - sim");
					System.out.println("2 - nao");
					int escolha = scan.nextInt();
					scan.nextLine();
					
					if(escolha==1) {
						marcha--;
						System.out.println("\nMarcha atual: " + marcha);
					}else {
						System.out.println("\nVelocidade mantida em: " + velocidade + " Km/h");
						continuar = false;
					}
					
				}
				
				
				
			}
		}
		
		
		
		
	}
		
	
	
	public void subirMarcha() {
		if(!ligado) {
			System.out.println("\nLigue o carro primeiro!");
			return;
		}
		
		if(marcha == 6) {
			System.out.println("\nLimite de marcha atingido!");
			return;
		}else {
			marcha++;
		}
	}
	
	public void reduzirMarcha() {
		if(!ligado) {
			System.out.println("\nLigue o carro primeiro!");
			return;
		}
		
		if(marcha==0) {
			System.out.println("\nVoce ja esta em ponto morto!");
			return;
		}else {
			marcha--;
		}
		
	}
	
	
	
	
	
	

}
