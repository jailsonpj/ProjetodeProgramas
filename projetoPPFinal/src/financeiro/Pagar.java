package financeiro;


import usuario.Usuario;

public class Pagar {
	private Usuario user;
	private Divida divida;
	private int totalDivida;
	
	
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

	public void setDivida(Divida divida) {
		this.divida = divida;
	}
	
	
	
	
}
