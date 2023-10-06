package punto12;

public class Test {
    public static void main(String[] args) {
        //EJEMPLO DEL PUNTO 5 SIGUE FUNCIONANDO CORRECTAMENTE CON LOS CAMBIOS
        Usuario usuario = new Usuario(300,700,1000);
        System.out.println("ESTADO INICIAL:" + usuario.mostrarEstado());
        usuario.depositar(600);
        usuario.invertir(500);
        System.out.println("ESTADO LUEGO DE DEPOSITAR $600 E INVERTIR $500:" + usuario.mostrarEstado());
        System.out.println(usuario.realizarGasto(1000));
        usuario.activarPrecancelarInversion();
        usuario.realizarGastoYGirar(1000);
        System.out.println("ESTADO LUEGO DE ACTIVAR PRECANCELAR INVERSION Y REALIZAR UN GASTO CON GIRO EN DESCUBIERTO($1000):" + usuario.mostrarEstado());
        usuario.realizarCompra(800);

        //CREA USUARIO CON CAJA DE AHORRO
        Usuario usuario1 = new Usuario(500);
        System.out.println("ESTADO INICIAL:" + usuario1.mostrarEstado());
        usuario1.depositar(500);
        usuario1.realizarGasto(800);
        System.out.println("ESTADO DESPUES DE DEPOSITAR 500 Y GASTAR 800:" + usuario1.mostrarEstado());
    }

}
