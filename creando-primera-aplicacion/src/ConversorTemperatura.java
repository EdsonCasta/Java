import java.util.Scanner;

public class ConversorTemperatura {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar la temperatura en grados Celsius
        System.out.print("Ingresa la temperatura en grados Celsius: ");
        double celsius = scanner.nextDouble();

        // Convertir a Fahrenheit con decimales
        double fahrenheit = (celsius * 1.8) + 32;
        System.out.println("Temperatura en Fahrenheit (con decimales): " + fahrenheit);

        // Mostrar la temperatura en Fahrenheit sin decimales
        int fahrenheitEntero = (int) fahrenheit;
        System.out.println("Temperatura en Fahrenheit (entero): " + fahrenheitEntero);
    }
}


