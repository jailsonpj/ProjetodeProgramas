package projeto;

import java.util.ArrayList;


public class Principal {

	public static void main(String[] args) {
		ArrayList<Pagar> instancia = new ArrayList<Pagar>();
		
		Pagar paga = new Pagar ();
		Usuario usuario = new Usuario();
		Divida div = new Divida();
		Conta cont = new Conta();
		
		usuario.setIdade(20);
		usuario.setNome("jaja");
		usuario.setSalario(600.5);
		
		cont.setCodigoConta(12121);
		cont.setTipoConta("Agua");
		cont.setValorConta(354);
		cont.setVencimentoConta("12/04/2017");
		
		div.setMesVencimento(4);
		div.addConta(cont);
		
		paga.setUser(usuario);
		paga.setDivida(div);
		
		instancia.add(paga);
		
		String aux = "jaja";
		for(int i=0; i<instancia.size();i++){
			if(aux.equals(instancia.get(i).getUser().getNome())){
				System.out.println(instancia.get(i).getDivida().getConta().get(i).getTipoConta() +"\n");
				System.out.println(instancia.get(i).getDivida().getConta().get(i).getValorConta() +"\n");
			}
		}
		
		System.exit(0);

	}

}
