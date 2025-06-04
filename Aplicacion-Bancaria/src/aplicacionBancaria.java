import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class aplicacionBancaria {

    public static void main(String[] args) {

        String nombre = "Emiliano Castañeda";
        String tipoCuenta = "Ahorros";
        double saldo = 1800000.00;

        Scanner teclado = new Scanner(System.in);

        int opcion = 0;

        while (opcion != 9){

            NumberFormat formato = NumberFormat.getCurrencyInstance(new Locale("es", "CO"));
            String saldoEnPesos = formato.format(saldo);

            System.out.println("**********************************************");
            System.out.println("\nNombre Del Cliente: " + nombre);
            System.out.println("El Tipo De Cuenta: " + tipoCuenta);
            System.out.println("Su Saldo Disponible: " + saldoEnPesos);
            System.out.println("\n**********************************************");

            String menu = """
                \n*** Escriba el numero de la opción deseada ***
                \n1 - Consultar  saldo
                2 - Retirar
                3 - Depositar
                9 - Salir
                """;

            System.out.println(menu);
            opcion = teclado.nextInt();

            switch (opcion){
                case 1:
                    System.out.println("Saldo Disponible: " + saldoEnPesos);
                    break;
                case 2:
                    System.out.println("Ingrese el valor a retirar: $ " );
                    double retiro = teclado.nextDouble();
                    if (saldo >= retiro) {
                        saldo -= retiro;
                        System.out.println("¡Retiro Exitoso!");
                    }else {
                        System.out.println("¡Saldo Insuficiente!");
                    }
                    break;
                case 3:
                    System.out.println("Ingrese el valor a depositar: $");
                    double deposito = teclado.nextDouble();
                    saldo += deposito;
                    System.out.println("¡Deposito Exitoso!");
                    break;
                case 9:
                    System.out.println("Saliendo de la aplicación, ¡Gracias por utilizar nuestros servicios!");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, elige otra opción");
                    break;
            }
        }
    }
}