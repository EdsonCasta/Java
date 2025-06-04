import java.util.Random;
import java.util.Scanner;

public class juegoDeAdivinanzas {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numAleatorio = new Random().nextInt(100);
        System.out.println(numAleatorio);

        int intentos = 0;

        while (intentos < 5){
            System.out.println("Ingresa el numero a adivinar:");
            int numero = scanner.nextInt();

            intentos++;

            if (numAleatorio == numero){
                System.out.println("Felicitaciones Acertaste!");
                break;
            }
        }
        System.out.println("No Acertaste en 5 Intentos");
    }
}
