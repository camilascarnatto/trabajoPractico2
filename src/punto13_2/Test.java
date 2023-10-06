package punto13_2;

public class Test {
    public static void main(String[] args) {
        Vuelo vuelo = new Vuelo(1, "Buenos Aires", "San Pablo",
                "15:30");
        Vuelo vuelo1 = new Vuelo(2, "Buenos Aires", "San Pablo",
                "18:30");


        Persona persona = new Persona("Juan Lopez", "123456789", "San Martin 123");
        //Agrego a una persona a un vuelo como azafata
        vuelo.agregarMiembro(persona,"Azafata");
        //Agrego a la misma persona a un vuelo como pasajero
        vuelo1.agregarMiembro(persona);

        System.out.println("Rol de " + persona.getNombre() + " en el vuelo 1: " +
                persona.obtenerRol(1));

        System.out.println("Rol de " + persona.getNombre() + " en el vuelo 2: " +
                persona.obtenerRol(2));
    }

}
