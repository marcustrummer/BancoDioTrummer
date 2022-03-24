package BANCOTRUMMER;

import java.text.DecimalFormat;
import java.util.Scanner;

public abstract class Conta implements IConta {
	
	Scanner entrada = new Scanner(System.in);
	static DecimalFormat df = new DecimalFormat("###.##");
	
	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;

	protected int agencia;
	protected int numero;
	protected double saldo;
	protected Cliente cliente;
	protected double valorInvestido;

	public Conta(Cliente cliente) {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
	}

	@Override
	public void sacar(double saldo) {
		
		double valorSaque;         // DECLARAO DE VARIAVEIS
		int verifica = 0;
		
		
		System.out.println("Digite o valor do saque: ");
		valorSaque = entrada.nextDouble();
		System.out.println("Confirma valor do saque: " + valorSaque);
		System.out.println("[1-Sim]           [2-Não]");
		verifica = entrada.nextInt();
		
		if(saldo < valorSaque) {
			System.out.println("Saque não autorizado!! Realize um depósito, por favor!");
		}else if(verifica == 1) {
			    this.saldo = saldo - valorSaque;
			    System.out.println("Saque concluído!");
			    System.out.println("Saldo atualizado: " + this.saldo);
			    }else{
			      System.out.println("Operação cancelada.");
			      }
	}

	@Override
	public void depositar(double valor) {
		
		double valorDeposito=0;
		System.out.println("============================================================");
		System.out.println("||              Digite o valor do depósito:               ||");
		System.out.println("============================================================");
		valorDeposito = entrada.nextDouble();
		saldo += valorDeposito;
		System.out.println("Depósito realizado!");
	}

	@Override
	public void transferir(double valor, IConta contaDestino) {
		this.sacar(valor);
		contaDestino.depositar(valor);
	}	

	@Override
	public void imprimirExtrato() {
		System.out.println("============================================================");
		System.out.println("||                 Saldo disponível: "+ df.format(saldo) + "                  ||");
		System.out.println("============================================================");
		
	}


	@Override
	public void emprestimo(double renda) {
		double emprestimoDisponivel =0;
		emprestimoDisponivel = renda * 0.6;            // 60 % da renda do cliente
		
		double taxaGen = 1.1788;      //17.88%
		double valorSolicitado=0;
		int resposta = 0;
		
		System.out.println("============================================================");
		System.out.println("||        Você deseja realizar um empréstimo?             ||");
		System.out.println("||         [1-Sim]                   [2-Não]              ||");
		System.out.println("============================================================");
		resposta = entrada.nextInt();
		
		
		if(resposta==1) {
			System.out.println("Disponibilizamos um empréstimo de até: R$ " + emprestimoDisponivel);
			System.out.println("Cobramos uma taxa de: " + (taxaGen+16.7012) + "% para pessoa física\n");
			System.out.println("Digite o valor que deseja: ");
			valorSolicitado = entrada.nextDouble();
			if(valorSolicitado > emprestimoDisponivel) {
				System.out.println("Valor acima do limite disponível.");
				
			}else{
			emprestimoDisponivel = emprestimoDisponivel - valorSolicitado;
			this.saldo = saldo + valorSolicitado;
			System.out.println("Empréstimo concedido com sucesso!!! Valor a pagar: R$" + Math.round(valorSolicitado*taxaGen)+ ",00");
			System.out.println("Data limite de pagamento: 12 de Agosto de 2022" );
			}
		}	
	}
	
	@Override
	public void investir() {
		double investimento=1.0576;    //  5.76% CDI 
		double valorAInvestir = 0;
		System.out.println("============================================================");
		System.out.println("||    Bem vindo ao Centro de Investimentos Generation     ||");
		System.out.println("============================================================");
		System.out.println("\n");
		System.out.println("Aqui seu investimento rende : 5,76 % do CDI ao ano.");
		
		System.out.println("Quanto gostaria de investir?");
		valorAInvestir = entrada.nextDouble();
		if(valorAInvestir > saldo) {
			System.out.println("Valor acima do seu saldo...Operação não realizada!");
		}else {
			this.saldo = saldo - valorAInvestir;
			valorInvestido = valorAInvestir;
			System.out.println("Obrigado por investir conosco! :) ");
			System.out.println("Seu dinheiro vai render: R$ " + df.format((valorAInvestir*investimento)) + " até agosto de 2022");
		}
	}
	
	
	public void login(String cpf, String senha) {
		Scanner entrada = new Scanner(System.in);
		String cpfDigitado = " ";    // Para o eu esquecido, cpfDigitado e senha NAO EH IGUAL AO CPFDIG E SENHA DO MAIN
		String senhaDigitada = " ";
		int c=0;
		do {

			System.out.println("Digite o seu CPF, por favor.");
			cpfDigitado = entrada.nextLine();
			System.out.println("Digite sua senha , por favor.");
			senhaDigitada = entrada.nextLine();
			if(cpfDigitado.equals(cpf) && senhaDigitada.equals(senha)) {
				 System.out.println("CPF e senhas corretos iniciando funções do banco principal...");
				 c++;
			}else{
				System.out.println("CPF ou senha inválida, tente novamente!!");
				}
			
			
			try {   
				Thread.sleep(2000);// ----------------------TEMPO PARA LEITURA -----------------------------------------------------
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			for(int i=0;i<60;i++) {System.out.println("");}//---------------------LIMPANDO TELA PARA DIGITAR NOVAMENTE-------------------------------
		}while(c != 1);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//-----------------------------------------------



	public double getValorInvestido() {
		return valorInvestido;
	}

	public void setValorInvestido(double valorInvestido) {
		this.valorInvestido = valorInvestido;
	}

	public int getAgencia() {
		return agencia;
	}

	public int getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}

	protected void imprimirInfosComuns() {
		System.out.println(String.format("Titular: %s", this.cliente.getNome()));
		System.out.println(String.format("Agencia: %d", this.agencia));
		System.out.println(String.format("Numero: %d", this.numero));
		System.out.println(String.format("Saldo: %.2f", this.saldo));
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	
}
