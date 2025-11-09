public class ContaPoupanca extends Conta {
    public ContaPoupanca(String numero, String tituar, double saldo) {
        super(numero, tituar, saldo);
    }
    @Override
    public void atualizarSaldo() {
        this.setSaldo(this.getSaldo() * (1 + this.getRendimentoMensal()));
    }

    public double getRendimentoMensal() {
        return rendimentoMensal;
    }

    private final double rendimentoMensal = 0.003;
}
