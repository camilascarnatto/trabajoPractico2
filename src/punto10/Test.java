package punto10;

import java.time.LocalDate;

public class Test {
    public static void main (String[] args){
        EmpleadoAsalariado asalariado = new EmpleadoAsalariado("Camila",  "000",
                "000", LocalDate.of(2000, 1, 1), 100000);

        EmpleadoPasante pasante = new EmpleadoPasante("Maria",  "000",
                "000", LocalDate.of(2001, 2, 2));

        EmpleadoPorHora porHora = new EmpleadoPorHora("Juan", "000",
                "0000", LocalDate.of(1999,3 , 3), 800, 160);

        EmpleadoPorComision porComision = new EmpleadoPorComision("Ignacio",  "0000",
                "000", LocalDate.of(1998, 4, 4), 30);
        porComision.agregarVentas(100000);

        EmpleadoConSalarioBase salarioBase = new EmpleadoConSalarioBase("Jose", "000",
                "000", LocalDate.of(1997, 5, 5), 20, 40000);
        salarioBase.agregarVentas(100000);

        System.out.println("EMPLEADO ASALARIADO: \nsueldo: " + asalariado.calcularSueldo() + "\nbono cumpleanos: "
                + asalariado.calcularBono() + "\n");

        System.out.println("EMPLEADO PASANTE: \nsueldo: " + pasante.calcularSueldo() + "\nbono cumpleanos: "
                + pasante.calcularBono() + "\n");

        System.out.println("EMPLEADO POR HORA: \nsueldo: " + porHora.calcularSueldo() + "\nbono cumpleanos: "
                + porHora.calcularBono() + "\n");

        System.out.println("EMPLEADO POR COMISION: \nsueldo: " + porComision.calcularSueldo() + "\nbono cumpleanos: "
                + porComision.calcularBono() + "\n");

        System.out.println("EMPLEADO SALARIO BASE: \nsueldo: " + salarioBase.calcularSueldo() + "\nbono cumpleanos: "
                +
                salarioBase.calcularBono() + "\n");
    }
}
