package punto4;

public class Test {
    public static void main(String[] args) {
        //Cliente con saldo inicial y límite de giro en descubierto válidos
        Cliente cliente1 = new Cliente("Juan", 1500, 800);
        System.out.println("Información inicial de la cuenta de " + cliente1.getNombre());
        cliente1.getBilletera().mostrarInformacion();
        System.out.println(" ----------- ");

        /*
        // Intentar realizar una inversión mayor al saldo
        try {
            cliente1.getBilletera().realizarInversion(2000);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println(" ----------- ");
        */

        // Realizar una inversión válida
        cliente1.getBilletera().realizarInversion(500);
        System.out.println("Información después de la inversión:");
        cliente1.getBilletera().mostrarInformacion();
        System.out.println(" ----------- ");

        // Realizar una compra a crédito válida
        cliente1.getBilletera().realizarCompraCredito(300);
        System.out.println("Información después de la compra a crédito:");
        cliente1.getBilletera().mostrarInformacion();
        System.out.println(" ----------- ");

        //Intentar realizar una compra a crédito que excede el límite
        try {
            cliente1.getBilletera().realizarCompraCredito(600);
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println(" ----------- ");

        // Realizar un pago a crédito
        cliente1.getBilletera().realizarPagoCredito(200);
        System.out.println("Información después del pago a crédito:");
        cliente1.getBilletera().mostrarInformacion();
        System.out.println(" ----------- ");

        // Cliente con saldo inicial negativo
        Cliente cliente2 = new Cliente("Ana", -500, 300);
        System.out.println("Información inicial de la cuenta de " + cliente2.getNombre());
        cliente2.getBilletera().mostrarInformacion();
        System.out.println(" ----------- ");

        // Intentar realizar una inversión con saldo negativo
        try {
            cliente2.getBilletera().realizarInversion(200);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println(" ----------- ");

        // Intentar realizar una compra a crédito con saldo negativo
        try {
            cliente2.getBilletera().realizarCompraCredito(300);
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
