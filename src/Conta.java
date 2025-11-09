import java.io.Serializable;

public abstract class Conta extends SaldoInsuficienteException implements OperacoresBancarias {
    public Conta(String numero, String tituar, double saldo) {
        this.setNumero(numero);
        this.setTitular(tituar);
        this.setSaldo(saldo);
    }

    public abstract void atualizarSaldo();
    public void depositar(double valor) {
        this.setSaldo(this.getSaldo() + valor);
        if (this instanceof ContaPoupanca){
            this.atualizarSaldo();
        }
        System.out.println("\nDepósito no valor de " + valor + " para a conta de" + this.getTitular() + " realizado com sucesso!");
    }

    public void sacar(double valor) throws SaldoInsuficienteException {
        System.out.println("\ntentando sacar da conta de " + this.getTitular() + " no valor de " + valor);
        if (this.getSaldo() < valor) {
            throw new SaldoInsuficienteException("\nSaldo insuficiente");
        }
        System.out.println("\nSucesso!");
        this.setSaldo(this.getSaldo() - valor);
        if (this instanceof ContaPoupanca){
            this.atualizarSaldo();
        }
    }

    @Override
    public void transferir(Conta contaDestino, double valor) throws SaldoInsuficienteException {
        System.out.println("\ntentando transferir da conta de " + this.getTitular() + " para a conta de " +  contaDestino.getTitular() + " no valor de " + valor);
        if (this.getSaldo() < valor) {
            throw new SaldoInsuficienteException("\nSaldo insuficiente");
        }
        System.out.println("\nSucesso!");
        this.setSaldo(this.getSaldo() - valor);
        contaDestino.setSaldo(contaDestino.getSaldo() + valor);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("\nNúmero da conta: " + this.getNumero());
        System.out.println("\nTitular: " + this.getTitular());
        System.out.println("\nSaldo: " + this.getSaldo());
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
        double arredondado = Math.round(saldo * 100.0) / 100.0;
        this.saldo = arredondado;
    }

    // atributos privados
    private String numero;
    private String titular;
    private double saldo;
}
