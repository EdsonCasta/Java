import java.util.Scanner;

public class VerificacionDiaHabil {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el día de la semana (en minúsculas): ");
        String diaSemana = scanner.nextLine();

        if (diaSemana.equals("lunes") || diaSemana.equals("martes") ||
                diaSemana.equals("miercoles") || diaSemana.equals("jueves") ||
                diaSemana.equals("viernes")) {
            System.out.println(diaSemana + " es un día hábil");
        } else {
            System.out.println(diaSemana + " no es un día hábil");
        }
        scanner.close();
    }
}