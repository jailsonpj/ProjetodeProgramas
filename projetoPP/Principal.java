package br.com.projeto.pp;
import javax.swing.*;

public class Principal {
    public static void main (String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {

        // To  force look and feel (LINUX)
        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
            if ("com.sun.java.swing.plaf.gtk.GTKLookAndFeel".equals(info.getClassName())) {
                javax.swing.UIManager.setLookAndFeel(info.getClassName());
                break;
            }
        }
        String option;

        do{
            option = JOptionPane.showInputDialog(null,"Informe a operação:\n" +
                            "[1] Cadastrar usuário\n" +
                            "[2] Adicionar conta\n" +
                            "[3] Listar contas a pagar\n" +
                            "[4] Contas do mês\n" +
                            "[5] fim\n");

            if (option.charAt(0) == 1) {

            }
            if (option.charAt(0) == 2) {

            }
            if (option.charAt(0) == 3) {

            }
            if (option.charAt(0) == 4) {

            }

        } while(option.charAt(0) != 5);

        System.exit(0);

    }
}
