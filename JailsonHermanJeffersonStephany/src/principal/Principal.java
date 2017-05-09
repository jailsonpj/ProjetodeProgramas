package principal;

import financeiro.Conta;
import financeiro.Divida;
import financeiro.Pagar;
import usuario.Usuario;

import javax.swing.*;
import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {
        // To  force look and feel (LINUX)
        for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
            if ("com.sun.java.swing.plaf.gtk.GTKLookAndFeel".equals(info.getClassName())) {
                try {
                    UIManager.setLookAndFeel(info.getClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
                    e.printStackTrace();
                }
                break;
            }
        }

        ArrayList<Pagar> instancia = new ArrayList<>();

        String option;
        do {
            option = JOptionPane.showInputDialog(null, "Informe a operação:\n" +
                    "[1] Fazer cadastro de usuário.\n" +
                    "[2] Cadastrar divida do mês.\n" +
                    "[3] Adicionar conta.\n" +
                    "[4] Mostrar contas.\n" +
                    "[5] Mostar total de dividas.\n" +
                    "[6] Excluir conta.\n" +
                    "[7] Listar usuários.\n" +
                    "[8] Sair do sistema.\n");

            if (option.charAt(0) == '1') {
                Pagar paga = new Pagar();
                Usuario user = new Usuario();
                user.cadastraUser();
                paga.setUser(user);
                instancia.add(paga);
                JOptionPane.showMessageDialog(null, "Cadastrado com sucesso.");
            }

            if (option.charAt(0) == '2') {
                String nomeUser = (JOptionPane.showInputDialog(null, "Cadastrar dividas de qual usuário?"));
                for (Pagar anInstancia : instancia) {
                    if (nomeUser.equals(anInstancia.getUser().getNome())) {
                        int mesDiv = Integer.parseInt(JOptionPane.showInputDialog(null, "mes da divida a cadastrar"));
                        Divida div = new Divida();
                        div.setMesVencimento(mesDiv);
                        Conta cont = new Conta();
                        cont.cadastraConta();
                        div.addConta(cont);
                        anInstancia.addDivida(div);
                        System.out.println("foi");
                        JOptionPane.showMessageDialog(null, "Dívida cadastrada com sucesso.");
                    }
                }
            }

            if (option.charAt(0) == '3') {
                String nomeUser = (JOptionPane.showInputDialog(null, "Adicionar Conta em qual usuário?"));
                for (Pagar anInstancia : instancia) {
                    if (nomeUser.equals(anInstancia.getUser().getNome())) {
                        int mesDiv = Integer.parseInt(JOptionPane.showInputDialog(null, "Em que mês voce quer adicionar uma conta" + "\n" + "Mês :" + "\n" + anInstancia.mostraDivida()));

                        for (int j = 0; j < anInstancia.getDivida().size(); j++) {

                            if (mesDiv == anInstancia.getDivida().get(j).getMesVencimento()) {
                                Conta cont = new Conta();
                                cont.cadastraConta();

                                anInstancia.getDivida().get(j).addConta(cont);
                                System.out.println("foi");

                                JOptionPane.showMessageDialog(null, "Adicionado com sucesso.");

                            }
                        }
                    }
                }
            }

            if (option.charAt(0) == '4') {
                String userMostra = JOptionPane.showInputDialog(null, "Mostrar conta de qual usuário?");

                for (Pagar anInstancia : instancia) {
                    if (userMostra.equals(anInstancia.getUser().getNome())) {
                        int mostraConta = Integer.parseInt(JOptionPane.showInputDialog(null, "Mostrar contas de qual mês " + "\n" + "Mês: " + anInstancia.mostraDivida()));
                        StringBuilder mostra = new StringBuilder();
                        for (int j = 0; j < anInstancia.getDivida().size(); j++) {
                            if (mostraConta == anInstancia.getDivida().get(j).getMesVencimento()) {
                                for (int k = 0; k < anInstancia.getDivida().get(j).getConta().size(); k++) {
                                    mostra.append(anInstancia.getDivida().get(j).getConta().get(k).mostraConta());
                                }
                            }
                        }
                        JOptionPane.showMessageDialog(null, mostra.toString());
                    }

                }

            }

            if (option.charAt(0) == '5') {

                float aux = 0;
                int cont = 0;
                String userMostra = JOptionPane.showInputDialog(null, "Nome do usuário?");
                for (Pagar anInstacia : instancia) {
                    if (userMostra.equals(anInstacia.getUser().getNome())) {
                        int mesDivida = Integer.parseInt(JOptionPane.showInputDialog(null, "Calcular total de contas do mês " + "\n" + anInstacia.mostraDivida()));
                        for (int j = 0; j < anInstacia.getDivida().size(); j++) {
                            if (anInstacia.getDivida().get(j).getMesVencimento() == mesDivida) {
                                for (int k = 0; k < anInstacia.getDivida().get(j).getConta().size(); k++) {
                                    aux += anInstacia.getDivida().get(j).getConta().get(k).getValorConta();
                                }
                            }
                        }
                        //cont = i;
                    }
                }

                if (instancia.get(cont).getUser().getSalario() > aux) {
                    JOptionPane.showMessageDialog(null, "Saldo devedor: positivo");
                } else {
                    JOptionPane.showMessageDialog(null, "Saldo devedor negativo: " + (aux - instancia.get(cont).getUser().getSalario()));
                }
                JOptionPane.showMessageDialog(null, "Total de contas a pagar: " + aux);

                System.out.println("totAL" + aux);
            }

            if (option.charAt(0) == '6') {

                String nomeUser = (JOptionPane.showInputDialog(null, "Remover conta para qual usuário?"));

                for (Pagar anInstancia : instancia) {
                    if (nomeUser.equals(anInstancia.getUser().getNome())) {
                        int mes = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe o mês da divida da conta a ser removido " + "\n" + "Mês: " + "\n" + anInstancia.mostraDivida()));
                        for (int j = 0; j < anInstancia.getDivida().size(); j++) {
                            if (mes == anInstancia.getDivida().get(j).getMesVencimento()) {
                                int cod = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe o código da conta a remover"));
                                for (int k = 0; k < anInstancia.getDivida().get(j).getConta().size(); k++) {
                                    if (cod == anInstancia.getDivida().get(j).getConta().get(k).getCodigoConta()) {
                                        anInstancia.getDivida().get(j).getConta().remove(k);
                                        System.out.println("removido");
                                    }
                                }
                            }
                        }
                    }
                }
            }

            if (option.charAt(0) == '7') {
                StringBuilder mostra = new StringBuilder(); //mostra = "";
                JOptionPane.showMessageDialog(null, "Lista de usuários cadastrados.");
                for (Pagar anInstancia : instancia) {
                    mostra.append(anInstancia.getUser().getNome()).append("\n");
                }
                JOptionPane.showMessageDialog(null, mostra);
            }
        } while (option.charAt(0) != '8') ;

        System.exit(0);
    }

}
