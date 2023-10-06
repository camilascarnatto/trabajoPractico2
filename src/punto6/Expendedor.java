package punto6;

import java.util.ArrayList;
import java.util.List;

public class Expendedor {
    private Combustible combustible;

    public  Expendedor(Combustible tipoCombustible){
        this.combustible = tipoCombustible;
    }

    public Combustible getTipoCombustible() {
        return combustible;
    }


}
