import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Escribe el saldo de la tarjeta: ");
        double saldo = scanner.nextDouble();
        scanner.nextLine();

        TarjetaCredito tarjeta = new TarjetaCredito(saldo);

        while (true) {
            System.out.print("¿Deseas realizar una compra? (si/no): ");
            String respuesta = scanner.nextLine().toLowerCase();

            if (!respuesta.equals("si")) break;

            System.out.print("Descripción de la compra: ");
            String descripcion = scanner.nextLine();

            System.out.print("Valor de la compra: ");
            double monto = Double.parseDouble(scanner.nextLine());

            boolean exitosa = tarjeta.agregarCompra(new Compra(descripcion, monto));
            if (!exitosa) break;
        }
        tarjeta.mostrarResumen();
    }
}

