import java.util.Scanner;

public class VerificadorParImpar {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        System.out.println("""
                Bienvenidos a nuestra aplicacion donde puedes 
                verificar si un numero es Par o Impar:
                """);

        while (opcion != 2) {

            System.out.println("""
                Escribe la opción deseada:
                
                1. Verificar
                2. Salir
                """);

            opcion = scanner.nextInt();

            if (opcion == 1) {
                System.out.println("Ingresa el numero a verificar: ");
                int numero = scanner.nextInt();

                if (numero % 2 == 0) {
                    System.out.println("El numero " + numero + " es Par!");
                } else {
                    System.out.println("El nuemro " + numero + " es Impar");
                }
                System.out.println();
            } else if (opcion != 2) {
                System.out.println("Opción no válida. Intenta de nuevo.");
            }
            System.out.println();
        }
        System.out.println("Gracias por preferirnos");
    }
}
