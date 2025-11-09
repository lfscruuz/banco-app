public class BancoApp {
    public static void main(String[] args) {
        //cadastro das contas
        Conta conta1 = new ContaCorrente("123456-7", "luis", 0);
        Conta conta2 = new ContaPoupanca("890123-4", "Felipe", 0);

        //depósitos iniciais
        conta1.depositar(500);
        System.out.println("Saldo atual: " + conta1.getSaldo());

        conta2.depositar(500);
        System.out.println("Saldo atual: " + conta2.getSaldo());

        //tentativas de saques
        {
            try {
                conta1.sacar(100);
            } catch (SaldoInsuficienteException e) {
                System.out.println("Erro: " + e.getMessage());
            } finally {
                System.out.println("Saldo atual: " + conta1.getSaldo());
            }

            try {
                conta2.sacar(600);
            } catch (SaldoInsuficienteException e) {
                System.out.println("Erro: " + e.getMessage());
            } finally {
                System.out.println("Saldo atual: " + conta2.getSaldo());
            }
        }

        //transferencias
        {
            try {
                conta1.transferir(conta2, 150);
            } catch(SaldoInsuficienteException e) {
                System.out.println("Erro: " + e.getMessage());
            } finally {
                System.out.println("Saldo atual: " + conta1.getSaldo());
            }

            try {
                conta2.transferir(conta2, 600);
            } catch(SaldoInsuficienteException e) {
                System.out.println("Erro: " + e.getMessage());
            } finally {
                System.out.println("Saldo atual: " + conta2.getSaldo());
            }
        }

        //extratos
        {
            System.out.println("\n\nExtrato da conta 1:");
            conta1.imprimirExtrato();

            System.out.println("\n\nExtrato da conta 2:");
            conta2.imprimirExtrato();
        }
    }
}