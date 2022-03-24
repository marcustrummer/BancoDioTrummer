package BANCOTRUMMER;

public interface IConta {
	
	void sacar(double valor);
	
	void depositar(double valor);
	
	void transferir(double valor, IConta contaDestino);
	
	void imprimirExtrato();
	

	void emprestimo(double renda);
	
	void investir();
	
	void login();
}
