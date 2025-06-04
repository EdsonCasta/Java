import java.util.Scanner;

public class DescuentoEnCompras {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el valor de la compra: ");

        double valorCompra = scanner.nextDouble();
        double descuento = (valorCompra * 10) / 100;
        double valorTotal = valorCompra - descuento;

        if (valorCompra >= 100.0) {
            System.out.println("Descuento del 10% aplicado");
            System.out.println("Nuevo valor: $" + valorTotal);
        } else {
            System.out.println("Descuento no aplicado");
            System.out.println("Valor total: $" + valorCompra);
        }
        scanner.close();
    }
}
