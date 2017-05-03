package projeto;

import java.util.ArrayList;

//classe divida
public class Divida {
	//atributos
	private int mesVencimento; //mes vencimento das dividas 
	private ArrayList<Conta>conta ; //array de Conta,recebe mais de uma conta 
	
	public Divida (){
		//this.mesVencimento = mesVencimento;
		conta = new ArrayList<Conta>();
	}



	public int getMesVencimento() {
		return mesVencimento;
	}

	public void setMesVencimento(int mesVencimento) {
		this.mesVencimento = mesVencimento;
	}

	public ArrayList<Conta> getConta() {
		return conta;
	}

	public void setConta(ArrayList<Conta> conta) {
		this.conta = conta;
	}
	
	public void addConta(Conta cont){ //método que adiciona uma conta ao array de conta 
		conta.add(cont);
	}
	
}
