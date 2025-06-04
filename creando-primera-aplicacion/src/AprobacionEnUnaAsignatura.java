public class AprobacionEnUnaAsignatura {

    public static void main(String[] args) {

        double promedio = 0;

        double nota1 = 5.5;
        double nota2 = 3;
        double nota3 = 6;
        
        promedio = (nota1 + nota2 + nota3) / 3;

        if (promedio >= 7.0) {
            System.out.println("El estudiante tuvo un promedio de " + promedio + " y fue aprobado.");
        } else if (promedio >= 5.0) {
            System.out.println("El estudiante tuvo un promedio de " + promedio + " y está en recuperación.");
        } else {
            System.out.println("El estudiante tuvo un promedio de " + promedio + " y fue reprobado.");
        }
    }
}
