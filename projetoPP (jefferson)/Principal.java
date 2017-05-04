import javax.swing.*;
import java.util.ArrayList;

public class Principal {

	public static void main(String[] args) {
		ArrayList<Pagar> instancia = new ArrayList<Pagar>();

		/* Já foi feito
		usuario.setIdade(20);
		usuario.setNome("jaja");
		usuario.setSalario(600.5);
		*/

		/*
		cont.setCodigoConta(12121);
		cont.setTipoConta("Agua");
		cont.setValorConta(354);
		cont.setVencimentoConta("12/04/2017");
		
		div.setMesVencimento(4);
		div.addConta(cont);
		
		paga.setUser(usuario);
		paga.setDivida(div);
		
		instancia.add(paga);

		String aux = "Nome do usuário";
		for(int i=0; i<instancia.size();i++) {
			if (aux.equals(instancia.get(i).getUser().getNome())) {
				System.out.println(instancia.get(i).getDivida().getConta().get(i).getTipoConta());
				System.out.println(instancia.get(i).getDivida().getConta().get(i).getValorConta());
			}
		}
		*/

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

		// Varia que auxilia na escolha das opcoes
		String option;
		//int contaPosicao = 0;
		do {
			option = JOptionPane.showInputDialog(null, "Informe a operação:\n" +
					"[1] Fazer cadastro\n" +
					"[2] Adicionar conta (em dívida)\n" +
					"[3] ///Contas do mês\n" +
					"[4] !BLablabla\n" +
					"[5] !Encerrar\n" +
					"[0] Teste Mostrar");

			if (option.charAt(0) == '1') {

				Usuario usuario = new Usuario();
				Divida div = new Divida();
				Pagar paga = new Pagar();
				Conta cont = new Conta();

				usuario.setNome(JOptionPane.showInputDialog(null, "Informe seu nome por favor."));
				usuario.setId(Integer.parseInt(
						JOptionPane.showInputDialog(
								null, "Agora informe sua idade.")));
				usuario.setSalario(Double.parseDouble(
						JOptionPane.showInputDialog(
								null, "Agora nos informe seu salário.")));
				cont.setCodigoConta(Integer.parseInt(
						JOptionPane.showInputDialog(
								null, "Informe o código da conta.")));
				cont.setTipoConta(JOptionPane.showInputDialog(null,
						"Informe o tipo de conta"));
				cont.setValorConta(Double.parseDouble(
						JOptionPane.showInputDialog(
								null, "Infrorme o valor da conta.")));
				cont.setVencimentoConta(JOptionPane.showInputDialog(
						null, "Informe o vencimento da conta (XX/XX/XXXX)."));

				div.setMesVencimento(Integer.parseInt(
						JOptionPane.showInputDialog(null, "Informe o vencimento da divida.")));

				div.addConta(cont);
				paga.setUser(usuario);
				paga.addDivida(div);
				instancia.add(paga);

				int aux = 0; // variavel que serve como flag
				while (aux != 1) {

					String novaConta = JOptionPane.showInputDialog(null,
							"Deseja cadastrar mais contas neste usuário? [y] ou [n]");

					if (novaConta.equals("y")) {

						Conta cont2 = new Conta();

						cont2.setCodigoConta(Integer.parseInt(
								JOptionPane.showInputDialog(
										null, "Informe o código da conta.")));
						cont2.setTipoConta(JOptionPane.showInputDialog(null,
								"Informe o tipo de conta"));
						cont2.setValorConta(Double.parseDouble(
								JOptionPane.showInputDialog(
										null, "Infrorme o valor da conta.")));
						cont2.setVencimentoConta(JOptionPane.showInputDialog(
								null, "Informe o vencimento da conta (XX/XX/XXXX)."));
						div.setMesVencimento(Integer.parseInt(
								JOptionPane.showInputDialog(null, "Informe o vencimento da divida.")));

						div.addConta(cont2);
						paga.addDivida(div);
						instancia.add(paga);

					} else if (novaConta.equals("n")) {
						aux = 1;
						JOptionPane.showMessageDialog(null, "Contas cadastradas.");
					}
				}
			}
			if (option.charAt(0) == '2') {

				Pagar paga = new Pagar();
				Divida novaDiv = new Divida();
				Conta novaConta = new Conta();


				String us = JOptionPane.showInputDialog(null,
						"Informe o usuário: ");

				for (int i = 0; i < instancia.size(); i++) {
					if (us.equals(instancia.get(i).getUser().getNome())) {
						String nova = JOptionPane.showInputDialog(null,
								"Deseja cadastrar mais contas neste usuário? [y] ou [n]");

						if (nova.equals("y")) {

							novaConta.setCodigoConta(Integer.parseInt(
									JOptionPane.showInputDialog(
											null, "Informe o código da conta.")));
							novaConta.setTipoConta(JOptionPane.showInputDialog(null,
									"Informe o tipo de conta"));
							novaConta.setValorConta(Double.parseDouble(
									JOptionPane.showInputDialog(
											null, "Infrorme o valor da conta.")));
							novaConta.setVencimentoConta(JOptionPane.showInputDialog(
									null, "Informe o vencimento da conta (XX/XX/XXXX)."));
							novaDiv.setMesVencimento(Integer.parseInt(
									JOptionPane.showInputDialog(null, "Informe o vencimento da divida.")));

							novaDiv.addConta(novaConta);
							paga.addDivida(novaDiv);
							instancia.add(paga);

						} else if (nova.equals("n")) {
							JOptionPane.showMessageDialog(null, "Contas cadastradas.");
							break;
						}
						JOptionPane.showMessageDialog(null, "Contas cadastradas.");
					}
				}


			}

			if (option.charAt(0) == '3') {

			}
			if (option.charAt(0) == '4') {

			}
			if (option.charAt(0) == '0') {
				String aux = JOptionPane.showInputDialog(null, "Informe seu nome");
				String abcd = "";
				for (int i = 0; i < instancia.size(); i++) {
					if (aux.equals(instancia.get(i).getUser().getNome())) {
						abcd += "Usuário: " + instancia.get(i).getUser().getNome() + "\n" + "Tipo da conta: " + instancia.get(i).getDivida().get(i).getConta().get(i).getTipoConta() + "\n" +
								"Valor: " + instancia.get(i).getDivida().get(i).getConta().get(i).getValorConta();
					}
				}
				JOptionPane.showMessageDialog(null, abcd);
			}
		}while(option.charAt(0) != '5');

		JOptionPane.showMessageDialog(null, "Até logo!");
		System.exit(0);
	}
}
