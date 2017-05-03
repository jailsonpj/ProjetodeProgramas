package projeto;
//classe que faz a associação entre usuário e dividas 
public class Pagar {
	private Usuario user; //atributo do tipo Usuario
	private Divida divida; //atributo do tipo Divida
	private int totalDivida; //variavel para contar o total de dividas a pagar 
	
	
	public int getTotalDivida() {
		return totalDivida;
	}

	public void setTotalDivida(int totalDivida) {
		this.totalDivida = totalDivida;
	}

	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}

	public Divida getDivida() {
		return divida;
	}

	/*public void setDivida(Divida divida) {
		this.divida = divida;
	}*/
	
	
}
