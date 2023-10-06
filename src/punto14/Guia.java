package punto14;

public class Guia extends Proveedor {
    private static float SERVICIO = 90;
    public Guia(String razonSocial, String cuit, String telefono, float importeBase) {
        super(razonSocial, cuit, telefono, importeBase);
        setTipo(TipoProveedor.GUIA);
    }

    @Override
    public float dineroAPagar(int cantClientes){
        if (cantClientes > 200){
            return getImporteBase() + SERVICIO;
        }
        return getImporteBase();
    }

}
