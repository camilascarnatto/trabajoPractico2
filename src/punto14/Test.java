package punto14;

public class Test {
    public static void main(String[] args) {
        AgenciaDeTurismo agencia = new AgenciaDeTurismo();
        Transporte transporte = new Transporte("Transportes SA.", "22-34567989-7", "123456789", 2000);
        Hospedaje hospedaje = new Hospedaje("Hilton", "22-123456778-2", "123455433", 10000,10);
        Guia guia = new Guia("Excursiones SA.", "22-876543345-7", "9876543243", 1000);
        Destino destino1 = new Destino("Paris", "Francia");
        Destino destino2 = new Destino("Madrid", "España");

        //Defino dos paquetes con distintos destinos y los mismos proveedores
        Paquete paquete1 = new Paquete(destino1, 12);
        Paquete paquete2 = new Paquete(destino2, 8);
        paquete1.agregarProveedor(transporte);
        paquete1.agregarProveedor(hospedaje);
        paquete1.agregarProveedor(guia);
        paquete2.agregarProveedor(transporte);
        paquete2.agregarProveedor(hospedaje);
        paquete2.agregarProveedor(guia);

        //agrego los paquetes y proveedores a la agencia
        agencia.agregarPaquete(paquete1);
        agencia.agregarPaquete(paquete2);
        agencia.agregarProveedor(hospedaje);
        agencia.agregarProveedor(transporte);
        agencia.agregarProveedor(guia);

        //Defino varios clientes
        agencia.agregarCliente("Juan", "Lopez", "juan@gmail.com", "1111");
        agencia.agregarCliente("Jose", "Garcia", "jose@gmail.com", "2222");
        agencia.agregarCliente("Camila", "Rodriguez", "camila@gmail.com", "3333");
        agencia.agregarCliente("Agustina", "Perez", "agustina@gmail.com", "4444");

        //Creo ventas para los clientes
        agencia.realizarVenta("1111", paquete1);
        agencia.realizarVenta("2222", paquete1);
        agencia.realizarVenta("2222", paquete2);
        agencia.realizarVenta("3333", paquete1);
        agencia.realizarVenta("3333", paquete2);
        agencia.realizarVenta("4444", paquete2);
        agencia.realizarVenta("4444", paquete1);

        //Muestro el destino favorito
        System.out.println("El destino favorito es " + agencia.obtenerDestinoFavorito());

        //Lista de ventas por destino
        System.out.println(agencia.obtenerVentasPorDestino());

        //Lista de proveedores
        System.out.println(agencia.obtenerProveedores());
    }

}
