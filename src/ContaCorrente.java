public class ContaCorrente extends Conta {
    @Override
    public void atualizarSaldo() {
        this.setSaldo(this.getSaldo() * 0.995);
    }
}