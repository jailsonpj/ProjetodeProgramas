public class Conta {
	private String tipoConta;
	private double valorConta;
	private int codigoConta;
	private String vencimentoConta;
	
	public Conta(){
		
	}
	
	public void setTipoConta(String tipoConta){
		this.tipoConta = tipoConta;
	}
	
	public String getTipoConta(){
		return tipoConta;
	}

	public double getValorConta() {
		return valorConta;
	}

	public void setValorConta(double valorConta) {
		this.valorConta = valorConta;
	}

	public int getCodigoConta() {
		return codigoConta;
	}

	public void setCodigoConta(int codigoConta) {
		this.codigoConta = codigoConta;
	}

	public String getVencimentoConta() {
		return vencimentoConta;
	}

	public void setVencimentoConta(String vencimentoConta) {
		this.vencimentoConta = vencimentoConta;
	}
	
	
}