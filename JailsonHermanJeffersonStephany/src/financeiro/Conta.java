package financeiro;

import javax.swing.JOptionPane;

public class Conta {
    private String tipoConta;
    private float valorConta;
    private int codigoConta;
    private String vencimentoConta;

    public Conta() {

    }

    public void setTipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
    }

    public String getTipoConta() {
        return tipoConta;
    }

    public float getValorConta() {
        return valorConta;
    }

    public void setValorConta(float valorConta) {
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

    public void cadastraConta() {
        this.codigoConta = Integer.parseInt(JOptionPane.showInputDialog(null, "Codigo da conta"));
        this.tipoConta = JOptionPane.showInputDialog(null, "Informe o tipo da conta");
        this.valorConta = Float.parseFloat(JOptionPane.showInputDialog(null, "Valor da conta"));
        this.vencimentoConta = JOptionPane.showInputDialog(null, "Data vencimento da conta (XX/XX/XXXX)");
    }

    public String mostraConta() {
        String mostra = "";
        return mostra += "Código: " + this.codigoConta + "\n" + "Tipo da Conta: " + this.tipoConta + "\n" + "Valor da Conta: " + this.valorConta + "\n" + "Data Vencimento: " + this.vencimentoConta + "\n\n";
    }
}
