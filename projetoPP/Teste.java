import javax.swing.*;
import java.util.ArrayList;

public class Principal {

	public static void main(String[] args) {
		ArrayList<Pagar> instancia = new ArrayList<Pagar>();

		Pagar paga = new Pagar ();
		Divida div = new Divida();
		Conta cont = new Conta();

		/*
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

		do{
			option = JOptionPane.showInputDialog(null,"Informe a operação:\n" +
					"[1] Cadastrar usuário\n" +
					"[2] Adicionar conta\n" +
					"[3] Listar contas a pagar\n" +
					"[4] Contas do mês\n" +
					"[5] Encerrar\n" +
					"[X] Teste Mostrar");

			if (option.charAt(0) == '1') {

				Usuario usuario = new Usuario();

				usuario.setNome(JOptionPane.showInputDialog(null, "Informe seu nome por favor."));
				usuario.setIdade(Integer.parseInt(
						JOptionPane.showInputDialog (
								null, "Agora informe sua idade.")));
				usuario.setSalario(Double.parseDouble(
						JOptionPane.showInputDialog(
								null, "Agora nos informe seu salário.")));

			}
			if (option.charAt(0) == '2') {

			}
			if (option.charAt(0) == '3') {

			}
			if (option.charAt(0) == '4') {

			}
		} while(option.charAt(0) != '5');



		JOptionPane.showMessageDialog(null, "Até logo!");
		System.exit(0);
	}

}
