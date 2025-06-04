import java.util.Scanner;

public class CodigoAccesoNivelPermiso {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int codigoAcceso = 2023;
        int nivelPermiso1 = 1;
        int nivelPermiso2 = 3;

        System.out.println("Ingrese el código de acceso: ");
        int codigo = scanner.nextInt();
        System.out.println(("Ingrese el nivel de permiso: "));
        int nivel = scanner.nextInt();

        boolean codigoCorrecto = codigoAcceso == codigo;
        boolean nivelCorrecto = nivel >= nivelPermiso1 && nivel <= nivelPermiso2;

        if (codigoCorrecto && nivelCorrecto) {
            System.out.println("Acceso permitido. ¡Bienvenido al sistema!");
        } else {
            System.out.println("Acceso denegado. Motivo(s):");
        }
        if (!codigoCorrecto) {
            System.out.println("- Código de acceso incorrecto");
        }
        if (!nivelCorrecto) {
            System.out.println("- Nivel de permiso inválido");
        }
    }
}
