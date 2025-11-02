public class ContaPoupanca extends Conta {
    @Override
    public void atualizarSaldo() {
        this.setSaldo(this.getSaldo() * 1.003);
    }
}
