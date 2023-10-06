package punto5;

public class Test {
    public static void main(String[] args) {
        // Crear una billetera con saldo inicial y límite de giro en descubierto
        Billetera billetera = new Billetera(1500, 800);

        // Iniciar una inversión
        billetera.iniciarInversion(600);
        System.out.println("Saldo después de iniciar inversión: $" + billetera.getSaldo());

        // Realizar una compra a crédito sin cancelar la inversión automáticamente
        billetera.realizarCompraCredito(300);
        System.out.println("Saldo después de compra a crédito: $" + billetera.getSaldo());

        // Realizar una compra que cancelará automáticamente la inversión
        billetera.realizarCompraCredito(1000);
        System.out.println("Saldo después de compra que cancela inversión automáticamente: $" + billetera.getSaldo());

        // Cancelar la inversión manualmente
        billetera.cancelarInversion();
        System.out.println("Saldo después de cancelar inversión manualmente: $" + billetera.getSaldo());

        // Realizar una compra a crédito después de cancelar la inversión
        billetera.realizarCompraCredito(500);
        System.out.println("Saldo después de compra a crédito después de cancelar inversión: $" + billetera.getSaldo());

        // Calcular intereses devueltos de la inversión
        double intereses = billetera.calcularInteresesDeInversion();
        System.out.println("Intereses devueltos de la inversión: $" + intereses);

        // Realizar una compra a crédito dentro del límite
        billetera.realizarCompraCredito(500);
        System.out.println("Saldo después de compra a crédito dentro del límite: $" + billetera.getSaldo());
    }

}
