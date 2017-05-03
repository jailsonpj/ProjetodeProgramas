package projeto;

import java.util.ArrayList;
public class Divida {
	private int mesVencimento;
	private ArrayList<Conta>conta ;
	
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
	
	public void addConta(Conta cont){
		conta.add(cont);
	}
	
}
