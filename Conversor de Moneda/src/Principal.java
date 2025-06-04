import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        Scanner write = new Scanner(System.in);
        CurrencyConverter converter = new CurrencyConverter();

        int option = 0;

        while (option != 7){
            System.out.println("***********************************************************\n");
            System.out.println("¡BIENVENIDOS A SU APLICACIÓN DE CONVERSOR DE MONEDA!\n");
            System.out.println("""
                1) Peso colombiano => Dólar (COP => USD)
                2) Dólar => Peso colombiano (USD => COP)
                3) Peso colombiano => Peso mexicano (COP => MXN)
                4) Peso mexicano => Peso colombiano (MXN => COP)
                5) Peso colombiano => Peso argentino (COP => ARS)
                6) Peso argentino => Peso colombiano (ARS => COP)
                7) Salir\n
                Elija una opción válida:
               """);
            System.out.println("***********************************************************\n");

            option = write.nextInt();

            if (option >= 1 && option <= 6) {
                System.out.println("Ingresa el valor a convertir: ");
                double amount = write.nextDouble();

                switch (option){
                    case 1 -> converter.convert("COP", "USD", amount);
                    case 2 -> converter.convert("USD", "COP", amount);
                    case 3 -> converter.convert("COP", "MXN", amount);
                    case 4 -> converter.convert("MXN", "COP", amount);
                    case 5 -> converter.convert("COP", "ARS", amount);
                    case 6 -> converter.convert("ARS", "COP", amount);
                }
            } else if (option != 7) {
                System.out.println("Opción inválida. Intente nuevamente");
            }
        }
        System.out.println();
        System.out.println("¡Gracias por usar el conversor de moneda!");
        write.close();
    }
}
