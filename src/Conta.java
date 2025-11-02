import java.io.Serializable;

public abstract class Conta extends SaldoInsuficienteException implements OperacoresBancarias {
    public abstract void atualizarSaldo();
    public double depositar(double valor) {
        this.setSaldo(this.getSaldo() + valor);
        this.atualizarSaldo();
        return this.getSaldo();
    }

    public double sacar(double valor) throws SaldoInsuficienteException {
        if (this.getSaldo() < valor) {
            throw new SaldoInsuficienteException("Saldo insuficiente");
        }
        this.setSaldo(this.getSaldo() - valor);
        this.atualizarSaldo();
        return this.getSaldo();
    }

    @Override
    public void transferir(Conta contaDestino, double valor) throws SaldoInsuficienteException {
        if (this.getSaldo() < valor) {
            throw new SaldoInsuficienteException("Saldo insuficiente");
        }
        this.setSaldo(this.getSaldo() - valor);
        contaDestino.setSaldo(contaDestino.getSaldo() + valor);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("Saldo: " + this.getSaldo());
    }

    //getters e setters
    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTitular() {
        return titular;
    }
    public void setTitular(String titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    // atributos privados
    private String numero;
    private String titular;
    private double saldo;
}
