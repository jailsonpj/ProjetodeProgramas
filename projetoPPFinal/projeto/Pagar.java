package projeto;

import java.util.ArrayList;

//import javax.swing.JOptionPane;

public class Pagar {
	private Usuario user;
	private ArrayList<Divida>divida;
	//private int totalDivida;
	
	public Pagar(){
		divida = new ArrayList<Divida>();
	}
	
	public Usuario getUser() {
		return user;
	}
	public void setUser(Usuario user) {
		this.user = user;
	}
	public ArrayList<Divida> getDivida() {
		return divida;
	}
	public void setDivida(ArrayList<Divida> divida) {
		this.divida = divida;
	}
	/*public int getTotalDivida() {
		return totalDivida;
	}
	public void setTotalDivida(int totalDivida) {
		this.totalDivida = totalDivida;
	}*/
	
	public void addDivida(Divida div){
		divida.add(div);
	}
	
	public String mostraDivida (){
		
		String mostra = "";
		for (int i=0;i< this.divida.size();i++){
			mostra += this.divida.get(i).getMesVencimento()+"\n";
		}
		
		return mostra;
	}
	
	
	
	
	
}
