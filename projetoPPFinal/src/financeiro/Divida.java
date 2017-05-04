package financeiro;

import java.util.ArrayList;

//import javax.swing.JOptionPane;
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
	
	/*public void cadastraDivida(Conta conta){
		this.mesVencimento = Integer.parseInt(JOptionPane.showInputDialog(null,"mes da divida referente as contas"));
		addConta(conta);
		
	}*/
	
}
