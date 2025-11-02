public interface OperacoresBancarias {
    public void transferir(Conta contaDestino, double valor) throws SaldoInsuficienteException;
    public void imprimirExtrato();
}
