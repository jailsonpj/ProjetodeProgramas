import java.util.ArrayList;

public class Pagar {
	private Usuario user;
	private ArrayList<Divida> divida;
	private int totalDivida;
	
	public Pagar() {
		divida = new ArrayList<Divida>();
	}

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

	public ArrayList<Divida> getDivida() {
		return divida;
	}

	public void setDivida(ArrayList<Divida> divida) {
		this.divida = divida;
	}

	public void addDivida(Divida div){
		divida.add(div);
	}

}
