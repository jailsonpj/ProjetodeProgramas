package projeto;

import javax.swing.*;
import java.util.ArrayList;


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
					"[1] Fazer cadastro de usuário\n" +
					"[2] Cadastrar divida do mês\n" +
					"[3] Adicionar conta\n" +
					"[4] Mostrar contas\n" +
					"[5] Mostar total de dividas\n" +
					"[6] Excluir conta\n" +
					"[7] Sair do sistema\n");
			if (option.charAt(0) == '1') {
				Pagar paga = new Pagar();
				Usuario user = new Usuario();
				user.cadastraUser();
				
				paga.setUser(user);
				
				instancia.add(paga);
				
				JOptionPane.showMessageDialog(null, "Cadastrado com sucesso.");
			}
			
			if(option.charAt(0) == '2'){
				
					String nomeUser = (JOptionPane.showInputDialog(null,"Cadastrar dividas de qual usuário?"));
				
					
					for(int i=0;i<instancia.size();i++){
						if(nomeUser.equals(instancia.get(i).getUser().getNome())){
							int mesDiv = Integer.parseInt(JOptionPane.showInputDialog(null,"mes da divida a cadastrar"));
							
							Divida div = new Divida();
							div.setMesVencimento(mesDiv);
							
							Conta cont = new Conta();
							cont.cadastraConta();
							
							div.addConta(cont);
							
							instancia.get(i).addDivida(div);
							System.out.println("foi");
							
							JOptionPane.showMessageDialog(null, "Dívida cadastrada com sucesso.");

						}
					}
			}
			if(option.charAt(0) == '3'){
				String nomeUser = (JOptionPane.showInputDialog(null,"Adicionar Conta em qual usuário?"));
				for(int i=0;i<instancia.size();i++){
					
					if(nomeUser.equals(instancia.get(i).getUser().getNome())){
						
						int mesDiv = Integer.parseInt(JOptionPane.showInputDialog(null,"Em que mês voce quer adicionar uma conta"));
						
						for(int j=0;j<instancia.get(i).getDivida().size();j++){
							
							if(mesDiv == instancia.get(i).getDivida().get(j).getMesVencimento()){
								Conta cont = new Conta();
								cont.cadastraConta();
								
								instancia.get(i).getDivida().get(j).addConta(cont);
								System.out.println("foi");
								
								JOptionPane.showMessageDialog(null, "Adicionado com sucesso.");

							}
						}
					}
				}
			}
			if(option.charAt(0) == '4'){
				String userMostra = JOptionPane.showInputDialog(null,"Mostrar conta de qual usuário?");
				
				for(int i=0;i<instancia.size();i++){
				
					if(userMostra.equals(instancia.get(i).getUser().getNome())){
						int mostraConta = Integer.parseInt(JOptionPane.showInputDialog(null,"Mostrar contas de qual mês?"));
						String mostra ="";
						for(int j=0;j<instancia.get(i).getDivida().size();j++){
							if(mostraConta == instancia.get(i).getDivida().get(j).getMesVencimento()){
								for(int k=0;k<instancia.get(i).getDivida().get(j).getConta().size();k++){
									mostra += instancia.get(i).getDivida().get(j).getConta().get(k).mostraConta();
								}
							}
						}
						JOptionPane.showMessageDialog(null,mostra);								
					}
					//JOptionPane.showMessageDialog(null, mostra);
				}
				//JOptionPane.showMessageDialog(null,mostra);
			}
				
			
			if(option.charAt(0) == '5'){
				/*double totalDividas  = 0;
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
				*/
				
			}
			if(option.charAt(0) == '6'){
				
			String nomeUser = (JOptionPane.showInputDialog(null,"Remover conta para qual usuário?"));
				
				for(int i=0;i<instancia.size();i++){
						if(nomeUser.equals(instancia.get(i).getUser().getNome())){	
							int mes = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe o mês da divida da conta a ser removido."));
							for (int j = 0; j < instancia.get(i).getDivida().size(); j++) {
									if(mes == instancia.get(i).getDivida().get(j).getMesVencimento()){
										int cod = Integer.parseInt(JOptionPane.showInputDialog(null,"Informe o código da conta a remover"));
										for(int k=0;k<instancia.get(i).getDivida().get(j).getConta().size();k++){
											if(cod == instancia.get(i).getDivida().get(j).getConta().get(k).getCodigoConta()){
												instancia.get(i).getDivida().get(j).getConta().remove(k);
												System.out.println("removido");
											}
										}
									}
							}
						
						}	//System.out.println("conta cadastrada");
				}
				
			}

		}while(option.charAt(0) != '7');
		
		
		System.exit(0);

	}

}