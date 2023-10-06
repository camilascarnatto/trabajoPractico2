package punto1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Club {
    private List<Socio>  socios;
    private List<Actividad> actividades;

    public Club(){
        this.socios = new ArrayList<>();
        this.actividades = new ArrayList<>();
    }

    public void agregarSocio(Socio socio){
        socios.add(socio);
    }
    public void agregarActividad(Actividad actividad){
        actividades.add(actividad);
    }

    public List<Socio> reporteMensualSociosInscriptos(LocalDate fechaReporte){
        int mesReporte = fechaReporte.getMonthValue();
        List<Socio> sociosInscriptos = new ArrayList<>();
        for (Socio socio : socios){
            LocalDate fechaInscripcion = socio.getFechaInscripcion();
            int mesInscripcionSocio = fechaInscripcion.getMonthValue();
            if(mesInscripcionSocio == mesReporte){
                sociosInscriptos.add(socio);
            }
        }
        return sociosInscriptos;
    }

    public List<Actividad> listadoActividadesPorSuscripcion(TipoSuscripcion suscripcion){
        List<Actividad> actividadesIncluidas = new ArrayList<>();

        for (Actividad actividad : actividades){
            TipoSuscripcion tipoSuscripcionActividad = actividad.getSuscripcion();

            if (tipoSuscripcionActividad == suscripcion || (suscripcion == TipoSuscripcion.INTERMEDIA && tipoSuscripcionActividad == TipoSuscripcion.BASICA)) {
                actividadesIncluidas.add(actividad);
            }
        }
        return actividadesIncluidas;
    }

    public List<Socio> listadoSociosPorSuscripcion(TipoSuscripcion tipoSuscripcion){
        List<Socio> listadoSocios = new ArrayList<>();
        for (Socio socio : socios){
            if(socio.getTipoSuscripcion() == tipoSuscripcion){
                listadoSocios.add(socio);
            }
        }
        return listadoSocios;
    }


}
