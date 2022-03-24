package BANCOTRUMMER;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		Cliente cliente = new Cliente();
		
		cliente.setNome("Venilton");

		Conta cc = new ContaCorrente(cliente);
		Conta poupanca = new ContaPoupanca(cliente);

		int saques = 0;		
		int resposta =0;
		int verifica = 0;
		String cpfDigitado = " ";
		String senhaDigitada = " ";
		String nomeDigitado = " ";
		
		
		
		
		
		cc.setValorInvestido(0);
		
		// ----------------------------CADASTRO INICIAL-------------------------------------------------------------------------
		
		System.out.println("==========================================================");
		System.out.println("||                                                      ||");
		System.out.println("||               Bem vindo a Gen Bank                   ||");
		System.out.println("||               Vamos abrir uma conta?                 ||");
		System.out.println("||         [1-Sim]                   [2-Não]            ||");
		System.out.println("==========================================================");
		resposta = entrada.nextInt();
		if(resposta == 1) {
		System.out.println("Nos informa o seu primeiro nome abaixo: ");
		do {
		nomeDigitado = entrada.nextLine();
		cliente.setNome(nomeDigitado);
		}while(nomeDigitado.length() < 2); //VERIFICANDO O TAMANHO DO NOME, SE MENOR DO QUE 2 LETRAS DIGITAR NOVAMENTE!! 
		
		do{
		System.out.println("Digite o seu CPF, por favor.");
		cpfDigitado = entrada.nextLine();
		cliente.setCpf(cpfDigitado);
		}while(cpfDigitado.length() < 11); // VERIFICANDO CPF, SE MENOR DO QUE 11 DIGITOS, DIGITAR NOVAMENTE!!
		
		
		for(int i=0;i<0;i++) {System.out.println("");} //-----------LIMPANDO A TELA DO CONSOLE------------------------------------------------------------

		
		do {
	    System.out.println("Cadastre sua senha");
	    senhaDigitada = entrada.nextLine();
	    cliente.setSenha(senhaDigitada);
		}while(senhaDigitada.length() < 4); //VERIFICANDO SENHA, SE MENOR DO QUE 4 DIGITOS, DIGITAR NOVAMENTE!!
	    
	    
		System.out.println("Cadastro realizado com sucesso!!!");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=0;i<10;i++) {System.out.println("");}
		//----------------------------------------------------------------------------------------------------------------------------------------------
		                              //CONFIRMACAO DA ABERTURA CONTA NO GENBANK
		double valorDepositado = 0;
		double renda= 0;
		do {
		System.out.println("============================================================");
		System.out.println("||                                                        ||");
		System.out.println("||         Para efetivar a abertura da sua conta,         ||");
		System.out.println("||         realize seu deposito                           ||");
		System.out.println("||                                                        ||");
		System.out.println("============================================================");
		System.out.println("Valor: ");
		valorDepositado = entrada.nextDouble();
		cc.setSaldo(valorDepositado);

		} while( valorDepositado < 0 || valorDepositado > 10000);      // Iae
		for(int i=0; i<30; i++) {System.out.println("");}
		
		System.out.println("Falta pouco...");
		
		
		do {

			System.out.println("Nos informe sua renda anual: ");

		renda = entrada.nextDouble();
		cliente.setRenda(renda);
		}while(renda < 0);
		
		
		
		
		
		
		cc.login(cliente.getCpf(), cliente.getSenha());
		}else {
			System.out.println("Que pena :( Estaremos sempre aqui");
		}
		
	

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		do {
			System.out.println("============================================================");
			System.out.println("|| Digite a opção desejada:                               ||");
			System.out.println("|| [1] --> Saque                                          ||");
			System.out.println("|| [2] --> Extrato                                        ||");
			System.out.println("|| [3] --> Depósito                                       ||");
			System.out.println("|| [4] --> Empréstimo                                     ||");
			System.out.println("|| [5] --> GenInvest                                      ||");
			System.out.println("============================================================");
			verifica = entrada.nextInt();
			System.out.println();

			switch (verifica) {
			case 1:
				if (saques < 3) {

					cc.sacar(cc.getSaldo());
				} else {
					System.out.println("Limite de saques atingido! Tente novamente amanhã..");
				}
				break;
			case 2:
				cc.imprimirExtrato();
				break;
			case 3:
				cc.depositar(cc.getSaldo());
				break;
			case 4:
				cc.emprestimo(cliente.getRenda());
				break;
			 case 5:
			 cc.investir();
			 break;
			}
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for (int i = 0; i < 60; i++) {
				System.out.println(" ");
			}
		} while (verifica != 0);
		System.out.println("============================================================");
		System.out.println("||     Obrigado por usar o GenBank, volte sempre! :)      ||");
		System.out.println("============================================================");

	}
}
