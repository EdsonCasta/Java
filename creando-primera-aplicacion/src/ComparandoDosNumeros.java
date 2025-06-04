import java.util.Scanner;

public class ComparandoDosNumeros {

    public static void main(String[] args) {

        Scanner numeros = new Scanner(System.in);

        System.out.println("Ingrese el primer número: ");
        int num1 = numeros.nextInt();

        System.out.println("Ingrese el segundo número: ");
        int num2 = numeros.nextInt();

        if (num1 > num2) {
            System.out.println("El número mayor es " + num1);
        } else if (num2 > num1){
            System.out.println("El número mayor es " + num2);
        } else {
            System.out.println("Los dos numeros son Iguales!");
        }
        numeros.close();
    }
}
