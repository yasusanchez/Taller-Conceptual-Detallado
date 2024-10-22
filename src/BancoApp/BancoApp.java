public class BancoApp {
    private double saldo;

    public BancoApp(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    // Metodo para retirar dinero
    public void retirar(double monto) throws Exception {
        if (monto > saldo) {
            throw new Exception("Saldo insuficiente para retirar " + monto);
        }
        saldo -= monto;
    }

    // Metodo para depositar dinero
    public void depositar(double monto) throws Exception {
        if (monto < 0) {
            throw new Exception("El monto a depositar no puede ser negativo");
        }
        saldo += monto;
    }

    // Metodo para transferir dinero entre cuentas
    public void transferir(BancoApp destino, double monto) throws Exception {
        this.retirar(monto);
        destino.depositar(monto);
    }

    // Metodo para obtener el saldo
    public double getSaldo() {
        return saldo;
    }

    public static void main(String[] args) {
        try {
            BancoApp cuenta1 = new BancoApp(1000);
            BancoApp cuenta2 = new BancoApp(500);

            // Demostración de las operaciones
            System.out.println("Saldo inicial cuenta1: " + cuenta1.getSaldo());
            System.out.println("Saldo inicial cuenta2: " + cuenta2.getSaldo());

            // Depositar dinero
            cuenta1.depositar(200);
            System.out.println("Saldo después de depositar 200 en cuenta1: " + cuenta1.getSaldo());

            // Retirar dinero
            cuenta1.retirar(300);
            System.out.println("Saldo después de retirar 300 de cuenta1: " + cuenta1.getSaldo());

            // Transferir dinero
            cuenta1.transferir(cuenta2, 200);
            System.out.println("Saldo después de transferir 200 de cuenta1 a cuenta2:");
            System.out.println("Saldo cuenta1: " + cuenta1.getSaldo());
            System.out.println("Saldo cuenta2: " + cuenta2.getSaldo());

            // Intentar retirar más de lo que hay en la cuenta
            cuenta1.retirar(1000);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
