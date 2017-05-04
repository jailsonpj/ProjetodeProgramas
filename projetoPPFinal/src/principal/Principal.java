package principal;

import financeiro.Conta;
import financeiro.Divida;
import financeiro.Pagar;
import usuario.Usuario;

import java.util.ArrayList;
import javax.swing.*;

public class Principal {

	public static void main(String[] args) {


		// To  force look and feel (LINUX)
		for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
			if ("com.sun.java.swing.plaf.gtk.GTKLookAndFeel".equals(info.getClassName())) {
				try {
					UIManager.setLookAndFeel(info.getClassName());
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (InstantiationException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (UnsupportedLookAndFeelException e) {
					e.printStackTrace();
				}
				break;
			}
		}

		ArrayList<Pagar> instancia = new ArrayList<Pagar>();
		
		
		String option;
		do {
			option = JOptionPane.showInputDialog(null, "Informe a operação:\n" +
					"[1] Fazer cadastro\n" +
					"[2] Adicionar conta (em dívida ja existente)\n" +
					"[3] Adicionar dívida de um novo mês\n" +
					"[4] Mostrar contas\n" +
					"[5] Mostar total de dividas\n" +
					"[6] Excluir conta\n" +
					"[7] Sair do sistema\n");
			if (option.charAt(0) == '1') {
				Pagar paga = new Pagar ();
				Usuario usuario = new Usuario();
				Divida div = new Divida();
				Conta cont = new Conta();
				
				usuario.cadastraUser();
				div.setMesVencimento(Integer.parseInt(JOptionPane.showInputDialog(null,"Informe o mês da dívida referente as contas")));
				cont.cadastraConta();
				div.addConta(cont);
				
				paga.setUser(usuario);
				paga.setDivida(div);
				
				instancia.add(paga);
				int aux = 0; // variavel que serve como flag
				while (aux != 1) {
					String novaConta = JOptionPane.showInputDialog(null,
							"Deseja cadastrar mais contas neste usuário para o mesmo mês ? [y] ou [n]");
					if(novaConta.equals("y")){
						Conta contAux = new Conta();
						contAux.cadastraConta();
						div.addConta(contAux);
					
						System.out.println("Conta cadastrada com sucesso!");
					
					}else if (novaConta.equals("n")) {
						aux = 1;
						JOptionPane.showMessageDialog(null, "Contas cadastradas com sucesso!.");
					}
				}
			}
			
			if(option.charAt(0) == '2'){
				
					String nomeUser = (JOptionPane.showInputDialog(null,"Adicionar conta para qual usuário?"));
					
					for(int i=0;i<instancia.size();i++){
							if(nomeUser.equals(instancia.get(i).getUser().getNome())){
								int mesAux = Integer.parseInt(JOptionPane.showInputDialog("Em qual mês vc quer adicionar a conta"));
								if(mesAux == instancia.get(i).getDivida().getMesVencimento()){
									Conta contAux = new Conta();
									contAux.cadastraConta();
									instancia.get(i).getDivida().addConta(contAux);			
									
								}else{
									JOptionPane.showMessageDialog(null, "Divivida do mês não cadastrada");
								}
							}
							
							//System.out.println("conta cadastrada");
					}
			}
			if(option.charAt(0) == '3'){
				
					
			}
			if(option.charAt(0) == '4'){
				String userMostra = JOptionPane.showInputDialog(null,"Mostrar conta de qual usuário?");
				
				for(int j=0;j<instancia.size();j++){
				
					if(userMostra.equals(instancia.get(j).getUser().getNome())){
						int mostraConta = Integer.parseInt(JOptionPane.showInputDialog(null,"Mostrar contas de qual mês?"));
						String mostraC = "";
					
							if(mostraConta == instancia.get(j).getDivida().getMesVencimento()){
								for(int i=0;i<instancia.get(j).getDivida().getConta().size();i++){
									
									mostraC += "Codigo: "+instancia.get(j).getDivida().getConta().get(i).getCodigoConta() +"\n"
											+"Tipo: "+instancia.get(j).getDivida().getConta().get(i).getTipoConta() + "\n"+
											"Valor da conta: "+instancia.get(j).getDivida().getConta().get(i).getValorConta()+"\n"+
											"Vencimento da conta: "+instancia.get(j).getDivida().getConta().get(i).getVencimentoConta()+"\n\n";
								}
							}
							JOptionPane.showMessageDialog(null, mostraC);
						}
					}
				//JOptionPane.showMessageDialog(null,mostraC);
			}
				
			
			if(option.charAt(0) == '5'){
				double totalDividas  = 0;
				double aux = 0;
				String userMostra = JOptionPane.showInputDialog(null,"Nome do usuário?");
				for(int i=0;i<instancia.size();i++){
					if(userMostra.equals(instancia.get(i).getUser().getNome())){
						//int aux = i;
						int mesDivida = Integer.parseInt(JOptionPane.showInputDialog(null,"informe o mes para calcular o total das contas a pagar"));
						if(instancia.get(i).getDivida().getMesVencimento() == mesDivida){
							for(int j=0;j<instancia.get(i).getDivida().getConta().size();j++){
								totalDividas += instancia.get(i).getDivida().getConta().get(j).getValorConta();
							}
						}
						aux = instancia.get(i).getUser().getSalario();
					}
				}
				
				if(totalDividas < aux){
					JOptionPane.showMessageDialog(null,"Saldo devedor: positivo");
				}else{
					JOptionPane.showMessageDialog(null,"Saldo devedor negativo: " + (aux - totalDividas));
				}
				JOptionPane.showMessageDialog(null, "Total de contas a pagar: "+totalDividas);
				
				
			}
			if(option.charAt(0) == '6'){
				
				String nomeUser = (JOptionPane.showInputDialog(null,"Removr conta para qual usuário?"));
				
				for(int i=0;i<instancia.size();i++){
						if(nomeUser.equals(instancia.get(i).getUser().getNome())){	
							int code = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe o código da conta."));
							for (int j = 0; j < instancia.get(i).getDivida().getConta().size(); j++) {
								if (code == instancia.get(i).getDivida().getConta().get(j).getCodigoConta()) {
									instancia.get(i).getDivida().getConta().remove(j);
									System.out.println("removido");
								}
							}
						
						}	//System.out.println("conta cadastrada");
				}
				
			}

		}while(option.charAt(0) != '7');
		
		
		System.exit(0);

	}

}
