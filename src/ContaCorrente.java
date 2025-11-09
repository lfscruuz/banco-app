public class ContaCorrente extends Conta {
    public ContaCorrente(String numero, String tituar, double saldo) {
        super(numero, tituar, saldo);
    }
    @Override
    public void atualizarSaldo() {
        this.setSaldo(this.getSaldo() * (1 - this.getTaxaSaque()));
    }

    public double getTaxaSaque() {
        return taxaSaque;
    }

    private final double taxaSaque = 0.05;
}