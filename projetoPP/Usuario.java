package projeto;

import javax.swing.*;
public class Usuario {
	private String nome;
	private int idade;
	private double salario;
	
	public Usuario(){
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	public void cadastraUser(){
		
		this.nome=(JOptionPane.showInputDialog(null,"Seu nome."));
		this.idade = (Integer.parseInt(JOptionPane.showInputDialog(null,"Sua idade")));
		this.salario = (Double.parseDouble(JOptionPane.showInputDialog(null,"Seu salario")));
		
		
	}
	
	
}
