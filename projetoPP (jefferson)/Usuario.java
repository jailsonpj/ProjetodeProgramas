import javax.swing.*;

public class Usuario {
	private String nome;
	private int id;
	private double salario;
	
	public Usuario(){
		
	}

	/*
	public void cadastrarUsuario(Usuario novo) {

		novo.setNome(JOptionPane.showInputDialog(null, "Informe seu nome por favor."));
		novo.setIdade(Integer.parseInt(
				JOptionPane.showInputDialog (
						null, "Agora informe sua idade.")));
		novo.setSalario(Double.parseDouble(
				JOptionPane.showInputDialog(
						null, "Agora nos informe seu salário.")));
	}
*/
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}
}
